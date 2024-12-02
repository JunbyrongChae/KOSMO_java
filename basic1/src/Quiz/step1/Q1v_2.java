package Quiz.step1;

public class Q1v_2 {
    public static void main(String[] args) {
        int x =2;
        int y = ++x;///x=3
        if ((x++<y--)&(++x>=++y)){
            //x=2-3-4-5>5  y=3-2-3>3
            System.out.println("참일때 : x - "+x+" y - "+y);
        }else {
            System.out.println("거짓일때 : x - "+x+" y - "+y);
        }
        //거짓일때 : x - 5 y - 3
        x = 2;
        y = ++x;///y,x=3
        if ((x++<y--)&&(++x>=++y)){
            //x=2-3(비교후 결과값에 +1)>4  y=3(비교 후 -1,거짓이므로 정지)>2
            System.out.println("참일때 : x - "+x+" y - "+y);
        }else {
            System.out.println("거짓일때 : x - "+x+" y - "+y);
        }
        //거짓일때 : x - 3 y - 2
    }
}
