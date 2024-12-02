package Quiz.step1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

//collection
public class Q25 {
    public static Collection get(){
        Collection sorted = new LinkedList();
        sorted.add("B");
        sorted.add("C");
        sorted.add("A");
        return sorted;
    }
    public static void main(String[] args) {
        for(Object obj: get()){
            System.out.println(obj+",");
        }
    }
}

/****************************************
 What is the result?
 A. A, B, C,
 B. B, C, A,
 C. Compilation fails.
 D. The code runs with no output.
 E. An exception is thrown at runtime.
*****************************************/