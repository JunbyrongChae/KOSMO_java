package Quiz.step1;
//if문
public class Q20v {
    public static void main(String[] args) {
        //Float pi = new Float(3.14f); //구식 지원안함.
        Float pi = 3.14f;
        if(pi>3){
            System.out.println("pi is bigger than3.");
        } else {
            System.out.println("pi is not bigger than 3.");
        }
        /*finally{
            System.out.println("Have a nice day");
        }*/ //finally는 조건문 직접사용 불가, try-catch와 함께 사용
    }
}

/*******************************************************
 ‘What is the result?
 A. Compilation fails.(v)
 B. pi is bigger than 3.
 C. An exception occurs at runtime.
 D. pi is bigger than 3. Have a nice day.
 E. pi is not bigger than 3. Have a nice day.
 ******************************************************/
