package classes.day4;

public class TryCatch {
    public static void main(String[] args) {
        int is[] = new int[3];
        try {
            System.out.println(is[2]);
        } catch (Exception e) {
            System.out.println("예외발생"+e.toString());
        }

        System.out.println("실행기회 없음");
    }
}
