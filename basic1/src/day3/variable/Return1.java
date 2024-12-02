package day3.variable;

public class Return1 {
    //void인 메소드 결과를 출력하려면?
    //리턴타입이 void이니까 메인메소드(hap메소드) 밖에서 셜과 출력 불가
    //
    void hap(int i,int j){
        int result = i+j;
        System.out.println("void내부에서"+result);//void내부에 출력, (i,j)값은 인스턴스화 한 메인메소드에
    }
    int hap1(int i,int j){
        return i+j;
    }
    String hap2(int i,int j){
        return i+j+"";
    }
    String hap3(int i,int j){
        return i+j+"";
    }
    public static void main(String[] args) {
        Return1 a = new Return1();
        a.hap(1,2);
        System.out.println();//빈칸
        System.out.println(a.hap1(1,2));
        int d = a.hap1(2,2);
        System.out.println(d);
        System.out.print("  ");//ln없으면 파라미터 필요
        //메소드 파라미터 안에서 다른 메소드 호출 가능, 하지만 void는 불가.
        System.out.println(a.hap2(1,2));
        String g = a.hap2(2,2);
        System.out.println(g);
        System.out.print("     ");
        System.out.println(a.hap3(1,2));

    }
}
