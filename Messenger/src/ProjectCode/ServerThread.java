package ProjectCode;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerThread implements Runnable {
    // 선언부
    public ServerMain sm = null;
    Socket clientSocket;
    ObjectOutputStream outStream;
    ObjectInputStream inStream;
    ServerDataMng sdm;
    String nickname = null; // 서버에 입장한 클라이언트 스레드 닉네임 저장하는 코드

    // 생성자 | 서버 소켓
    public ServerThread() {}
    public ServerThread(Socket socket, ServerDataMng sdm, ServerMain sm) {
        this.sm = sm;
        this.clientSocket = socket;
        this.sdm = sdm;
    }

    // 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
    public void broadCasting(String msg) {
        System.out.println("Broadcasting message: " + msg);
        for (ServerThread st : sm.stl) {
            try {
                st.send(msg);
                System.out.println("Message sent to client: " + st.nickname); // 전송 성공 로그 추가
            } catch (Exception e) {
                System.out.println("Failed to send message to client: " + st.nickname + " | Error: " + e.getMessage()); // 전송 실패 로그 추가
            }
        }
    }


    // 클라이언트에게 말하기 구현
    public void send(String msg) {
        try {
            if (outStream != null) {
                System.out.println("Sending message to client: " + msg);
                outStream.writeObject(msg);
                outStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // 입출력 스트림 객체 생성
            outStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outStream.flush(); // 스트림을 즉시 플러시하여 deadlock 방지
            inStream = new ObjectInputStream(clientSocket.getInputStream());

            String msg = (String) inStream.readObject();
            if (msg != null) {
                sm.jta_log.append(msg + "\n"); // 메시지를 로그에 보이기
                System.out.println("Received message: " + msg);
                StringTokenizer stz = new StringTokenizer(msg, "#");
                if (stz.hasMoreTokens()) {
                    stz.nextToken(); // 미정, 사용자 대화 받아오기
                    if (stz.hasMoreTokens()) {
                        nickname = stz.nextToken(); // 닉네임 받아오기
                        sm.jta_log.append(nickname + " 입장\n"); // 입장 시 나오는 문구
                    }
                }

                for (ServerThread st : sm.stl) {
                    this.send("수신정보" + "#" + st.nickname);
                }
                sm.stl.add(this);
                this.broadCasting(msg);
                System.out.println("입출력 Stream 객체 생성 | " + clientSocket);

                // RoomMap에 클라이언트 추가
                sdm.addClientToRoom(outStream, "NULL");
                sdm.broadcastRoomList();
            }

            // 스레드 동작 처리
            while (true) {
                msg = (String) inStream.readObject();
                if (msg == null) break;
                sm.jta_log.append(msg + "\n");
                sm.jta_log.setCaretPosition(sm.jta_log.getDocument().getLength()); // 대화 내용 전부 가져오는 코드
                System.out.println("Processing message: " + msg);
                StringTokenizer stz2 = new StringTokenizer(msg, "#");
                System.out.println("스레드 동작 | " + msg);

                String[] strArray = msg.split("#", 2);
                if (strArray.length == 2) {
                    String command = strArray[0];
                    String content = strArray[1];
                    processCommand(command, content);
                } else {
                    System.out.println("잘못된 메시지 형식: " + msg);
                }
            }
        } catch (IOException e) {
            System.out.println("입출력 오류 발생 | " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("클래스 찾기 오류 발생 | " + e.getMessage());
        } finally {
            cleanup();
        }
    }

    private void processCommand(String command, String content) {
        String roomName;
        ServerRoomMsg roomMsg;
        switch (command) {
            case "MsgSend":     /// 메세지 발송
                System.out.println("Processing MsgSend command with content: " + content);
                roomName = sdm.getRoomName(outStream);
                roomMsg = sdm.getRoomMsg(roomName);
                roomMsg.msgSave(content);
                roomMsg.broadcastMessage(roomName);
                break;
            case "Create":      /// 그룹창 생성
                System.out.println("Processing Create command for room: " + content);
                sm.jta_log.append(sm.setDays() + "\n");
                sdm.createRoom(content);
                break;
            case "Join":
                System.out.println("Processing Join command for room: " + content);
                sm.jta_log.append(sm.setDays() + "\n");
                sdm.addClientToRoom(outStream, content);
                roomMsg = sdm.getRoomMsg(content);
                roomMsg.addClient(outStream, content);
                roomName = sdm.getRoomName(outStream);
                roomMsg.broadcastMessage(roomName);
                break;
            default:
                System.out.println("알 수 없는 명령: " + command);
                break;
        }
    }

    private void cleanup() {
        try {
            if (inStream != null) inStream.close();
            if (outStream != null) outStream.close();
            if (clientSocket != null && !clientSocket.isClosed()) clientSocket.close();
        } catch (IOException e) {
            System.out.println("자원 정리 중 오류 발생 | " + e.getMessage());
        }
    }
}
