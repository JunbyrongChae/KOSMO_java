package Quiz.step1;
//생성자와 this
public class Q14 {
    int bootch;
    String snootch;

    public Q14(){//1:처음 new한 순간 생성되는 생성자 메서드
        this("snootch"); //2:인자값이 (String형)인 자신의 생성자 메서드 호출
        System.out.println("first"); //10 : firstfmf cnffur gn ekedma
    }
    public Q14(String snootch){//3
        this(420, "snootch") ;//4:다시 인자값이 (int형, String형)인 자신의 생성자 메서드 호출
        System.out.println("second"); //9:second를 출력 후 닫음
    }
    public Q14(int bootch,String snootch){//5
        this.bootch = bootch;//6:인자값 int420을 주고
        this.snootch = snootch; //7:인자값 snooch를wnrh
        System.out.println("third"); //8: third를 출력 후 닫음
    }
    public static void main(String[] args) {
        Q14 q = new Q14();
        System.out.println(q.snootch+""+q.bootch); //11:값을 출력
    }
}

/*******************************************************
 What is the result?
 A. snootchy 420 third second first
 B. snootchy 420 first second third
 C. first second third snootchy 420
 D. third second first snootchy 420 (v)
 E. third first second snootchy 420
 F. first second first third snootchy 420
 ********************************************************/