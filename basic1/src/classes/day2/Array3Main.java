package classes.day2;

public class Array3Main {
    public static void main(String[] args) {
        int [][] a = new int[3][4];//ArrayIndexOutOfBoundsException
        System.out.println(a.length);//로우값 반환
        int row = a.length;//3
        int col = a[0].length;//4
        int col2 = a[1].length;//4
        int col3 = a[2].length;//4
        int col4 = a[3].length;//ArrayIndexOutOfBoundsException
    }
}
