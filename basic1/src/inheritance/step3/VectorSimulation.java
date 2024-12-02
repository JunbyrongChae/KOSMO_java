package inheritance.step3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VectorSimulation {
    public static void main(String[] args) {
        Vector vector = new Vector(2,3);
        System.out.println(vector.getX()+", "+vector.getY());
        vector = new Vector(5,5);
        System.out.println(vector.getX()+", "+vector.getY());
        vector.setX(10);
        vector.setY(20);
        System.out.println(vector.getX()+", "+vector.getY());

        Class cv = vector.getClass();
        System.out.println(cv.getPackageName());
        System.out.println(cv.getTypeName());
        //클래스 안에 선언된 메서드를 알고싶다
        Method[] methods = cv.getMethods();
        System.out.println(methods.length);//13 - Object의 메서드 + Vector의 메서드
        methods = cv.getDeclaredMethods();
        System.out.println(methods.length);//4 - Vector의 메서드만
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println(methods.length);
        Field[] fields = cv.getFields();
        fields = cv.getDeclaredFields();
        System.out.println(fields[0]+" "+fields[1]);
        Class objectclass = cv.getSuperclass();
        System.out.println(objectclass.getTypeName());
    }
}
