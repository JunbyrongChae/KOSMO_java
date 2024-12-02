package classes.design;
//this는 사용 위치에 따라 다른 타입이며 다른 주소번지를 갖는다.
//UI담당 -> LoginForm.java(View계층) -> LoginDao.java(backend):DB연동(서버)
//      - TalkClient(actionPerformed) - TalkClientThread(소켓통신)
class C1 {
    C1(){
        System.out.println("C1 : "+this);
    }
}
public class C1Main {
    public C1Main() {
        System.out.println("C1Main : "+this);
    }
    public static void main(String[] args) {
        new C1Main();
        new C1();
    }
}
