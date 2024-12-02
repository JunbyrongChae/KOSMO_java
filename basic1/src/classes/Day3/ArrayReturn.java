package classes.Day3;

public class ArrayReturn {
    String names[] = {"이순신","이성계","강감찬"};
    String[] methodA(){
        return names;
    }
    public static void main(String[] args) {
        ArrayReturn ar = new ArrayReturn();
        String[] names = ar.methodA();
        names[1] = "유관순";
        names[2] = null;
        for(int i=0;i<names.length;i++){
            System.out.println(names[i]);
        }

    }
}
