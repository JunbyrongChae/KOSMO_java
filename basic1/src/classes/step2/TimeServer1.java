package classes.step2;

// TimeServer.java: 1초간격으로 현재의 시간 문자열을 접속한 클라이언트에게 전송하는
//프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer1 extends Thread {

    private Socket socket;

    public TimeServer1(Socket s) {
        this.socket = s;
    }

    // run() 시작
    public void run() {
        System.out.println("run call....");
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while (true) {
                out.println(getTimeStr());
                try {
                    sleep(1000);
                } catch (InterruptedException i) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nClient disconnected...\n");
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
    // run() 종료

    // getTimeStr() 시작
    private String getTimeStr() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        return (hour < 10 ? "0" + hour : "" + hour) + ":" +
                (min < 10 ? "0" + min : "" + min) + ":" +
                (sec < 10 ? "0" + sec : "" + sec);
    }
    // getTimeStr() 종료

    // main() 시작
    public static void main(String args[]) {
        int port = 2008;
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Can't bind port: " + port);
            e.printStackTrace();
            try {
                server.close();
            } catch (IOException i) {
            }
            System.exit(1);
        }
        System.out.println("Time Server started successfully...");
        while (true) {
            try {
                client = server.accept();
                System.out.println("New Client connected...");
                TimeServer1 tServer = new TimeServer1(client);
                tServer.start();
                System.out.println("New Time Server Thread started...");
            } catch (IOException e) {
                System.out.println("Can't start server thread!!");
                e.printStackTrace();
                try {
                    client.close();
                } catch (IOException i) {
                }
            }
        }
    }
    // main() 종료
}

