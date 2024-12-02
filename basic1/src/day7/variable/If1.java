package day7.variable;

public class If1 {
    public static void main(String[] args) {
        int point = 85;

        if(point <= 100 && point >= 90){
            System.out.println("A");
        } else if (point <= 90 && point >= 80) {
            System.out.println("B");
        } else if (point <= 80 && point >= 70) {
            System.out.println("C");
        } else if (point <= 70 && point >= 60) {
            System.out.println("D");
        } else if(point <= 60 && point >= 0){
            System.out.println("F");
        }
        if(point <=100&& point >= 90){
            System.out.println("A");
        }
        if(point <= 90 && point >= 80) {
            System.out.println("B");
        }
        if(point <= 80 && point >= 70) {
            System.out.println("C");
        }
        if(point <= 70 && point >= 60) {
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }
}
