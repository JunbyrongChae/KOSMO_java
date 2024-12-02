package classes.day2;
class Array1{
    //원시형 타입의 1차배열
    //is.length : 배열의 길이 반환-3출력//
    //초기값은 : is[0]=0, is[1]=0, is[2]=0
    int is[] = new int[3];
}
public class Array1Main {
    Array1 a = new Array1();
    void print1(){
        for(int i=0;i<a.is.length;i++){
            System.out.println(a.is[i]);//0 0 0
        }
    }
    public static void main(String[] args) {
        Array1Main a1m = new Array1Main();
        a1m.print1();
    }
}
