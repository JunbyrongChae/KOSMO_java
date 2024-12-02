package classes.day2;
//배열은 한 번 선언하면 크기고정
//같은 타입만 담을 수 있어서 숫자와 문자열을 같은 로우에 담을 수 없다.
public class Array2Main {
    public static void main(String[] args) {
        int [][] is = new int[2][3];//2차배열 : 좌표값 2개 = for문 2개
        for(int i=0;i< is.length;i++){//i = 0,1일때 반복
            for(int j=0;j<is[i].length;j++){//j = 0,1,2일때 반복
                System.out.println("is{"+i+"]["+j+"]="+is[i][j]);
            }
        }
    }//////////////////end of main
}//////////////////end of Array2Main
