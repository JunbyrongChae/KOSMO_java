package Quiz.step1;
//swich문
public class Q16 {
    public enum Dogs{collie, harrier};

    public static void main(String[] args) {
        Dogs myDogs = Dogs.collie;
        switch (myDogs){
            case collie:
                System.out.println("collie");
            case harrier:
                System.out.println("harrier");
        }
    }
}

/*********************************
 What is the result?
 A. collie  //System.out.print(“collie “); break; 이라면…
 B. harrier
 C. Compilation fails.
 D. collie harrier  //break;문이 없었기 때문에 20번행도 출력했다. (v)
 E. An exception is thrown at runtime.
 **********************************/