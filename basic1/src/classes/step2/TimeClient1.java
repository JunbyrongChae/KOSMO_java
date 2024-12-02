package classes.step2;

// TimeClient.java: 서버에 접속해서 1초마다 시간 문자열을 받아서 출력하는 프로그램

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient1 extends Thread {

    private JLabel jlb_time = null;
    public TimeClient1(){}
    public TimeClient1(JLabel jlb_time) {
        this.jlb_time = jlb_time;
        //this.jlb_time = new JLabel("깊복");
    }

    // run() 시작
    public void run() {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String timeStr = null;

        try {
            socket = new Socket("localhost", 2008);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true) {
                System.out.println("while(true)");
                while((timeStr = in.readLine()) != null) {
                    System.out.println(timeStr);
                    jlb_time.setText(timeStr);

                }
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException i) {}
            }

        } catch(IOException i) {
            jlb_time.setText("타임서버에 접속할 수 없습니다.");
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {}
        }
    }
    // run() 종료
    public static void main(String args[]){
        TimeClient1 tc = new TimeClient1();
        tc.start();
    }

}

