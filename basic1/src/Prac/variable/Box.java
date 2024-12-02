package Prac.variable;

import java.util.Scanner;

public class Box {
    double width;
    double height;
    double depth;


    public double calculateVolume() {
        return width * height * depth;
    }

    public double calculateSurfaceArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box box = new Box();
        System.out.println("가로 길이를 입력하세요: ");
        box.width = scanner.nextDouble();
        System.out.println("세로 길이를 입력하세요: ");
        box.depth = scanner.nextDouble();
        System.out.println("높이를 입력하세요: ");
        box.height = scanner.nextDouble();
        System.out.println("직육면체의 부피는 "+box.calculateVolume()+"입니다");
        System.out.println("직육면체의 겉넓이는 "+box.calculateSurfaceArea()+"입니다");

    }
}
