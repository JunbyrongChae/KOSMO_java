package classes.Day3;

public class ArrayParam1 {
    void methodA(String[] names){
        int i = 0;
        for(i=0;i<names.length;i++){
            System.out.println(names[i]);
        }
    }
    public static void main(String[] args) {
        ArrayParam1 ap1 = new ArrayParam1();
        String[] names = {"홍길동", "이순신", "강감찬","김유신","유관순"};
        ap1.methodA(names);
        System.out.println("methodA()처리 완료");
    }
}
