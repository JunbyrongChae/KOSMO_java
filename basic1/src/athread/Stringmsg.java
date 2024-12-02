package athread;

import java.util.StringTokenizer;

public class Stringmsg {
    //글자색 변경
    //대화명 변경
    //모든 요청은 반드시 서버를 경유
    //단 오라클서버 사용시 직접 클래스를 연결해도 괜찮
    public static void main(String[] args) {
        String msg = "200#키위#사과#스터디할래?";
        StringTokenizer st = new StringTokenizer(msg, "#");
        String protocol = st.nextToken();
        String me = st.nextToken();//키위
        String you = st.nextToken();//사과
        String message = st.nextToken();//스터디할래
        System.out.println("protocol = " + protocol);
        System.out.println("me = " + me);
        System.out.println("nickName = " + you);
        System.out.println("message = " + message);
    }
}
