package classes.day7;

import java.util.Scanner;

class B1{
    int hap(int first, int second,String operation){
        switch (operation) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second != 0) {
                    return first / second;
                } else {
                    System.out.println("Can't divide by 0");
                    return 0; // 적절한 기본값 반환
                }
            default:
                System.out.println("Impossible Operation");
                return 0; // 적절한 기본값 반환
        }
    }
}
public class B1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Insert Two Different Numbers");
            System.out.print("Insert First Number: ");
            int num1 = sc.nextInt();

            System.out.print("Insert Operation (+, -, *, /): ");
            String operation = sc.next();

            System.out.print("Insert Second Number: ");
            int num2 = sc.nextInt();

            System.out.println("First Number: " + num1);
            System.out.println("Second Number: " + num2);

            B1 b1 = new B1();
            int result = b1.hap(num1, num2, operation);
            System.out.println("Result: " + result);
        }
    }
}
