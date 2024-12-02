package Quiz.step1;

public class Q19 {
    public static void main(String[] args) {
        String str = "null";
        if (str==null){
        } else if (str.length()==0){ //else if가 맞음
            System.out.println("zero");
        } else{
            System.out.println("some");
        }
    }
}

/********************************************************
 * ‘What is the result?
 * A. null
 * B. zero
 * C. some
 * D. Compilation fails.
 * E. An exception is thrown at runtime.
 *******************************************************/