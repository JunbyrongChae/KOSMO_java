package Quiz.step1;
class M {
    This this1 = null;
    //This this2 = new This();
    public M(This this1) {
        System.out.println("M1 : 멤버"+this.this1+"지역 : "+this1);//M1 : 멤버null지역 : Quiz.step1.This@1d81eb93
        this.this1 = this1;
        System.out.println("M2 : 멤버"+this.this1+"지역 : "+this1);//M2 : 멤버Quiz.step1.This@1d81eb93지역 : Quiz.step1.This@1d81eb93
    }

}

public class This {
    M m = new M(this);
    public static void main(String[] args) {
        This t1 = new This();
        System.out.println("main 1 : "+t1);
        t1 = new This();
        System.out.println("main 2 : "+t1);
    }
}
