package day4.variable;

class Param{
    int i;
}

public class ParamMain {
    void effectParam(Param p){
        System.out.println("sub1 p : "+p); //@2f4d3709
        //p = new Param(); //아래 p.i값이 새롭게 정의됨 **
        p.i = 100; //위가 없으면 원본(얕은복사)이 됨 //있으면 복사본(깊은복사)이 변경**
        System.out.println("sub"+p.i);
        System.out.println("sub2 p : "+p); //@2f4d3709 원본 //@312b1dae 복사본**
    }
    public static void main(String[] args) {
        ParamMain pm = new ParamMain();
        Param p = new Param();
        System.out.println("main1 p : "+p); //@2f4d3709
        p.i = 500;//원본 정의
        pm.effectParam(p);//원본 재정의 //재인스턴스화**
        System.out.println("main"+p.i);

        System.out.println("main2 p : "+p); //@2f4d3709
    }
}

/*******************************************************

main i와 sub i가 같은 값을 출력
왜냐하면 19행에서 사용자 정의 메소드 effectParam()호출 할 때
16행의 인스턴스화된 주소번지(원본)를 파라미터로 넘겨주었다.
이 예제에서는 main메소드에서 500이었지만, main메소드 출력전에
effectParam()먼저 호출함
파라미터로 얕은 복사 즉 main에서 생성된 p의 주소를 넘김
그 메소드 내부에서 100을 받았다.

(참고용어 : 얕은복사, 깊은복사, 솔리드원칙)

 ******************************************************/
