package Quiz.step1;
//static으로 선언된 메서드
public class Q8v {
}
/*
    private int counter = 0; //non-static

    public static int getInstanceCount(){
        return counter; //non-static에서 static으로 가져올 수 없음
    }

    public Q8(){
        counter++;
    }
    public static void main(String[] args) {
        Q8 q8 = new Q8();
        Q8 q82 = new Q8();
        Q8 q83 = new Q8();
        System.out.println(Q8.getInstanceCount());
    }
}

/**************************************************
 * What is the result?
 * A. Compilation of class Q8 fails. (v)
 * B. Line 18 prints the value 3 to System.out.
 * C. Line 18 prints the value 1 to System.out.
 * D. A runtime error occurs when line 15 executes.
 * E. Compilation fails because of an error on line 18
 *********************************************************/