package day7.variable;

public class If2 {
    public static void main(String[] args) {
        int point = 55;

        if(point <= 100 && point >= 90){
            System.out.println("A");
        } else if (point <= 90 && point >= 80) {
            System.out.println("B");
        } else if (point <= 80 && point >= 70) {
            System.out.println("C");
        } else if (point <= 70 && point >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        System.out.println("여기로 온다.");
    }
}
