package day4.variable;
class G{
    //선언부-변수선언
    int i;//전변(위치-클래스)
    void methodA(){
        //i는 전역변수 이므로 클래스 내부 어디든지 호출이 가능
        System.out.println(i); //0->1
        /***********************************
         main메서드에 호출 전까지 콘솔에 안보임.
         ***********************************/
    }
    static int j;
    static void methodB(){
        System.out.println(j);//0->2
    }
}
public class GMain {
    public static void main(String[] args) {
        G g = new G(); //인스턴스화
        g.methodA();//호출 //0
        g.i = 1; //초기화
        System.out.println(g.i);
//      System.out.println(g.methodA()); //void 호출 불가.
        g.methodA();//호출 //1

        System.out.println();
        G.methodB();//0
        G.j = 2;
        System.out.println(G.j);//2
        G.methodB();//2

        System.out.println();
        System.out.println(g.i+G.j+Integer.parseInt("3")); //6

    }
}
