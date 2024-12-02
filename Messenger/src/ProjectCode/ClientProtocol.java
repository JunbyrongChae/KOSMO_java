package ProjectCode;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientProtocol implements Runnable {
    // 클라이언트 소켓, 입출력 스트림 선언
    private Socket clientSocket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private UIMain cui = null;
    private String nickname = null;
    String msg = null;

    // 프로토콜 상수 선언
    private static final String MSG_SEND = "MsgSend";
    private static final String ROOM_LIST = "RoomList";
    private static final String JOIN = "Join";
    private static final String LOGIN_SUCCESS = "LoginSuccess";

    // 생성자 생성
    public ClientProtocol(UIMain cui) {
        this.cui = cui;
        connectToServer();
    }

    // 서버 연결
    public void connectToServer() {
        try {
            clientSocket = new Socket("localhost", 3000);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.flush(); // 반드시 flush 호출
            in = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Connected to server.");

            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "서버 연결에 실패했습니다.", "연결 오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 프로토콜에 따른 입력스트림 처리
    @Override
    public void run() {
        try {
            while ((msg = (String) in.readObject()) != null) {
                System.out.println("Received message: " + msg); // 수신 메시지 로그 추가

                String[] strArray = msg.split("#", 2);
                if (strArray.length < 2) {
                    System.out.println("잘못된 메시지 형식: " + msg);
                    continue;
                }
                String protocol = strArray[0];
                String content = strArray[1];

                SwingUtilities.invokeLater(() -> processProtocol(protocol, content)); // UI 업데이트를 EDT에서 수행
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "서버와의 연결이 끊어졌습니다.", "연결 끊김", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 프로토콜 처리 분리 메서드
    private void processProtocol(String protocol, String content) {
        System.out.println("Received protocol: " + protocol + ", content: " + content); // 프로토콜 로그 추가
        switch (protocol) {
            case MSG_SEND:
                System.out.println("Processing MSG_SEND protocol with content: " + content); // MSG_SEND 로그 추가
                cui.ui.displayMsg(content);
                break;
            case ROOM_LIST:
                cui.ui.updateRoomList(content.split(","));
                break;
            case JOIN:
                cui.ui.displayMsg(content);
                break;
            case LOGIN_SUCCESS:
                nickname = content;
                cui.ui.setTitle(nickname + "님의 대화창");
                System.out.println("로그인 성공 - 닉네임: " + nickname);
                break;
            default:
                System.out.println("알 수 없는 프로토콜: " + protocol);
                break;
        }
    }

    // 클라이언트-서버 출력스트림 메서드
    public void sendMsg(String msg) {
        try {
            // 메시지 전송 전에 방 입장 여부 확인
            if (cui.ui.getEnterRoom().getSelectedValue() == null) {
                JOptionPane.showMessageDialog(null, "메시지를 전송하기 전에 대화 가능한 방에 입장해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }
            out.writeObject(msg);
            out.flush();
            System.out.println("Message sent to server: " + msg); // 메시지 전송 로그 추가
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "메시지 전송 실패. 네트워크를 확인하세요.", "전송 오류", JOptionPane.ERROR_MESSAGE);
        }
    }
}