package Quiz.step1;
// 배열
public class Q5v {
    public static void main(String[] args) {
        int []x = {1,2,3,4,5}; //0=1번째 데이터
        int y[] = x; //얕은복사 = 같은 주소
        System.out.println(y[2]);
    }
}

/********************************************************
 which is true?
 A. Line 7 will print the value 2.
 B. Line 7 will print the value 3. (v)
 C. Compilation will fail because of an error in line 5.
 D. Compilation will fail because of an error in line 6.
 ********************************************************/