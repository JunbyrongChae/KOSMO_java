package classes.day4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer2 extends Thread {
    //선언부

    //생성자
    public void init() throws IOException {
        int port = 5000;
        //ServerSocket은 예외처리 필수
        try {//예외가 발생할 가능성이 있는 코드를 쓴다
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server Ready...\n");
            while (true) {//아래코드는 진행 안됨 - waiting for connection
                //다음코드가 진행을 안하고 있다면 new Socket(ip,port);
                Socket s = ss.accept();//client측의 소켓을 받아온다.
                //소켓을 이용해서 inputStream과 outputStream을 생성합니다.
                System.out.println("Accepted connection from " + s.getInetAddress());
            }
        }catch (IOException e) {

        }

    }

    //메인메소드
    public static void main(String[] args) throws IOException {
        TimeServer2 ts = new TimeServer2();
        ts.init();
        ts.start();//Thread동작
    }//////////////// end of main
}//////////////////// end of class
