package ProjectCode;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerRoomMsg {
    // 선언부
    private String roomName;
    CopyOnWriteArrayList<ObjectOutputStream> joinClients;  // 방의 클라이언트 리스트
    CopyOnWriteArrayList<String> msgArray;                 // 방의 메시지 리스트
    ServerMain sm = new ServerMain();

    // 생성자
    public ServerRoomMsg(String roomName) {
        this.roomName = roomName;
        this.joinClients = new CopyOnWriteArrayList<>();
        this.msgArray = new CopyOnWriteArrayList<>();
    }

    // Join 클라이언트를 리스트에 추가
    public void addClient(ObjectOutputStream outStream, String content) {
        joinClients.addIfAbsent(outStream);
    }

    // Join 클라이언트 삭제
    public void removeClient(ObjectOutputStream outStream) {
        joinClients.remove(outStream);
    }

    // 메시지 저장
    public void msgSave(String msg) {
        msgArray.add(msg);
    }

    // 클라이언트들에게 입장 메시지 전송
    public void broadcastJoinMessage() {
        for (ObjectOutputStream outStream : joinClients) {
            try {
                outStream.writeObject("MsgSend#>>[" + roomName + "]에 입장하였습니다." + " " + sm.setDays());
            } catch (IOException e) {
                System.out.println("roomNameMsg 오류 | " + e.getMessage());
            }
        }
    }

    // 저장된 메시지와 함께 일반 메시지 전송
    public void broadcastStoredMessages() {
        for (ObjectOutputStream outStream : joinClients) {
            for (String msg : msgArray) {
                try {
                    outStream.writeObject("MsgSend#" + msg);
                } catch (IOException e) {
                    System.out.println("RoomMsg 오류 | " + e.getMessage());
                }
            }
        }
    }

    // 일반 메시지 전송
    public void broadcastMessage(String message) {
        for (ObjectOutputStream outStream : joinClients) {
            try {
                outStream.writeObject("MsgSend#" + message);
            } catch (IOException e) {
                System.out.println("broadcastMessage 오류 | " + e.getMessage());
            }
        }
    }
}
