package Quiz.step1;
//배열,형변환,확장for문
public class Q6v {
    public static void main(String[] args) {
        Object obj = new int[]{1,2,3};
        int[] someArray = (int[])obj; //someArray는 obj의 값을 int[] 타입으로 형변환하여 저장한 변수
        for (int i : someArray) System.out.println(i+""); //someArray 배열의 각 요소를 i에 할당하며 반복, 각 배열을 입력
        // for(초기화; 조건; 증감){}
        // 초기화 : 시작할때 한번만. 반복변수의 초기값 설정.
        // 조건 : 조건이 true인동안 반복실행. false일때 종료
        // 증감 : 반복이 끝날때마다 실행. 반복변수의 증감.
    }
}

/********************************************
  What is the result?
 A. 1 2 3 (v)
 B. Compilation fails because of an error in line 12.
 C. Compilation fails because of an error in line 13.
 D. Compilation fails because of an error in line 14.
 E. A ClassCastException is thrown at runtime.
 */