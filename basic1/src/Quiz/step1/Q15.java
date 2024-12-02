package Quiz.step1;
//swich문
public class Q15 {
    public enum Dogs{collie, harrier, shepherd};

    public static void main(String[] args) {
        Dogs mydog = Dogs.shepherd;
        switch (mydog){
            default :
            //case default: //case default: 가 아니고 default: 이다
                System.out.println("retriever");
            case harrier:
                System.out.println("harrier");
        }
    }
}

/*****************************************
 ‘What is the result?
 A. harrier
 B. shepherd
 C. retriever
 D. Compilation fails.(v)
 E. retriever harrier
 F. An exception is thrown at runtime.
 ********************************************/