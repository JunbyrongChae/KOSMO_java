package athread.step1;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

class KiwiServerThread extends Thread {
    KiwiServer ks = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String nickName = null;
    KiwiServerThread(){}
    //아래생성자는 언제 호출 되는 가? - 사용자가 서버에 접속 하면 클라이언트 소켓을 얻어낸다.
    KiwiServerThread(KiwiServer ks){
        this.ks = ks;
        try {
            oos = new ObjectOutputStream(ks.client.getOutputStream());
            ois = new ObjectInputStream(ks.client.getInputStream());
            String msg = (String) ois.readObject();
            System.out.println(msg);
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
    }
}
public class KiwiServer extends JFrame implements Runnable {
    ServerSocket ss = null;
    Socket client = null;
    List<KiwiServerThread> globalList = null;
    List<Room> localList = null;
    public KiwiServer(){
        localList = new Vector<Room>();
        globalList = new Vector<KiwiServerThread>();
    }
    @Override
    public void run() {
        System.out.println("run()호출성공");
        try {
            ss = new ServerSocket(3000);
            System.out.println("Server Ready...");
            ///waiting for connection
        while (true) {
            client = ss.accept();
            System.out.println("client info:" + client.getInetAddress());
            KiwiServerThread t = new KiwiServerThread(this);
            //t.start();
            }
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
    }

    public static void main(String[] args) {
        KiwiServer ks = new KiwiServer();
        Thread t = new Thread(ks);
        t.start();
    }
}
