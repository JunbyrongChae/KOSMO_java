package Quiz.step1;
//예외처리 try-catch-finally
public class Q3v {
    public static void parse(String str) {
        try {
            float f = Float.parseFloat(str); //f에 대해 try절에만 선언됨.  밖에서는 f를 참조불가
        } catch (NumberFormatException nfe) {
            //f = 0;
        }finally {
            //System.out.println(f);
        }
    }
    public static void main(String[] args) {
        parse("invaild");
    }
}

/***********************************************
 What is the result?
 A. 0.0
 B. Compilation fails.(v)
 C. A ParseException is thrown by the parse method at runtime.
 D. A NumberFormatException is thrown by the parse method at runtime.
 */