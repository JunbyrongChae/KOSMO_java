package athread.step1;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//서버에서 전송한 문자열을 청취
class KiwiClientThread extends Thread{
    public void run() {
        System.out.println("run()호출 성공");
    }
}
public class KiwiClient extends JFrame {
    LoginApp loginApp = null;
    JTabbedPane tp = new JTabbedPane();
    MassageRoom mr = new MassageRoom(this);
    WaitRoom wr = new WaitRoom(this);
    Socket mySocket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String ip = "localhost";
    int port = 3000;
    public KiwiClient(LoginApp loginApp) {
        this.loginApp = loginApp;
        initDisplay();
        //connect_process();
    }
    //이 메서드는 반드시 initDisplay()호출 뒤 해야 함 - 지연발생하니까
    public void connect_process() {
        this.setTitle(loginApp.nickname+"님의 대화창");
        try {
            mySocket = new Socket(ip, port);
            oos = new ObjectOutputStream(mySocket.getOutputStream());
            ois = new ObjectInputStream(mySocket.getInputStream());
            Room room = new Room();
            room.state = "wait";
            oos.writeObject(Protocol.WAIT+Protocol.seperator+loginApp.nickname+Protocol.seperator+room.state);
            oos.flush();
            String msg = (String) ois.readObject();
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initDisplay() {
        //tp.addTab("대기실",wr);
        //tp.addTab("단톡방",mr);

        this.setSize(650, 580);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        KiwiClientThread kct = new KiwiClientThread();
        kct.start();
    }
}
