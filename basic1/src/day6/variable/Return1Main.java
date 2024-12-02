package day6.variable;
/*
포인트
리턴타입 다양한 확인 - int double String() + sub1
->더 나아가 this까지 도전
 */
class Sub1{
    //Deprecated = 앞으로 지원 안함. API빠질 수 있음.
    //static이 있으면 전역변수(global variable) - 하나, 공유
    // 멤버변수(member variable) = 인스턴스를 하고 사용
    int i = 1;//non-static변수=멤버변수
    void methodX(){//멤버베소드. 왜? 인스턴스.methodX()호출
        System.out.println(i);
    }///////// end of methodX
}///////////// end of Sub1
public class Return1Main {
    int methodA(){
        return 1; //타입 맞출것, 마지막 작성할 것.(return 뒤에는 아무것도 못씀)
        //if문에서도 사용됨.
    }
    double methodB(){
        return (double)2; //2가 2.0이래
        //return 2; double보다 작은 타입은 자동전환(합법)
        //타입 맞출것, 마지막 작성할 것.(return 뒤에는 아무것도 못씀)
    }
    String methodC(){
        return "hello";
    }
    Sub1 methodD(){
        return new Sub1();
    }
    Sub1 methodE(){
        Sub1 sub = new Sub1();
        return sub;
    }
    public static void main(String[] args) {
        Return1Main m = new Return1Main();
        System.out.println(m.methodA());
        System.out.println(m.methodB());
        System.out.println(m.methodC());
        System.out.println(m.methodD());
        //sub1과 sub2의 주소번지는? -
        Sub1 sub1 = m.methodD();
        System.out.println(sub1.i);
        System.out.println(m.methodE());
        Sub1 sub2 = m.methodE();
        sub2.i = 4;
        System.out.println(sub2.i);
        //같은 타입이지만 서로 다른 객체라서 똑같이 i를 출력하더라도
        //어떤때는 1을 어떤때는 4를 입력 할 수 있다.
        //다른 사람들의 주문을 구분할 수 있고 서로 다른 상태값을 유지
        if(sub1==sub2) System.out.println("같다");
        else System.out.println("다르다");
        if(sub1.equals(sub2)) System.out.println("같다");
        else System.out.println("다르다");//조건문에서 실행문이 한 줄이면 {}생략 가능.
        //깊은 복사 - 복제본 만들어졌다
        //복제본을 만들기 위해 클래스 선언을 한다.

    }///////// end of main
}///////////// end of class

/********************************************
 같은 타입 같은 주소 = 얕은 복사 = 복사본
 같은 타입 다른 주소 = 깊은 복사 = 새로운 원본
 //if(sub1==sub2) / if(sub1.ewuals(sub2))
 *******************************************/
