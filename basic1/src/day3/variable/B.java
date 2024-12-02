package day3.variable;

public class B {
    public static void main(String[] args) {
        int i =1;//정수
        double avg = 0.5;//실수
        i = (int)avg;//대입안됨. (int)avg가능 ->그럴경우 0이 출력
        System.out.println(i);
        avg = i;//대입가능
        System.out.println(avg);

    }
}
