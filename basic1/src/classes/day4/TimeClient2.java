package classes.day4;

import java.net.Socket;

public class TimeClient2 {
    public void init() {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server...");
        }catch (Exception e) {
            System.out.println("예외발생"+e.toString());
        }
    }///////// end of init
    //메인스레드
    public static void main(String[] args) {
        TimeClient2 tc = new TimeClient2();
        tc.init();
    }//////// end of main
}//////////// end of class
