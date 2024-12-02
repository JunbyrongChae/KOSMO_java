package classes.design;
class D1{

}
public class D1Main {
    void m(int i){ } //call by value - 초급
    void methodB(D1 d1){//call by reference - 중급
        System.out.println("this"+this); //@4e50df2e
        System.out.println("d1"+d1); //@7cc355be
    }
    public static void main(String[] args) {
        D1Main dm = new D1Main();
        System.out.println("dm"+dm); //@4e50df2e
        D1 d = new D1();
        System.out.println("d"+d); //@7cc355be
        dm.methodB(d);
    }
}
