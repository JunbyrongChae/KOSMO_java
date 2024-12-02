package classes.day1;
class ThisSub{
    ThisSub() {
    }
    ThisSub(ThisMain thisMain) {
        System.out.println(thisMain);
    }
}
//자기 자신에 대한 인스턴스화는 main메소드에서 디폴트 생성자가 호출될 때 this주소번지도 결정
//인스턴스화 안하하면 this도 없다.
public class ThisMain {
    ThisSub thisSub = new ThisSub(this);
    public static void main(String[] args) {
        new ThisMain();
        System.out.println("main");
    }
}
