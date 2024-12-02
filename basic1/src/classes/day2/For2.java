package classes.day2;

public class For2{
    public static void main(String[] args) {
        int i, hap = 0;
        for(i=1;i<=5;i++){
            System.out.printf("i:%d hap:%d%n",i,hap);
            hap = hap + i;
        }
        System.out.println("1부터 5까지의 합 : "+hap);//15

        hap = 0;//hap = 15 -> 0(초기화)
        for (i=1;i<=5;i++){
            if(i%2==0){
                hap = hap + i;
            }
        }
        System.out.println("1부터 5까지의 짝수의 합 : "+hap);//6

        hap = 0;//hap = 6 -> 0(초기화)
        for (i=1;i<=5;i++){
            if(i%2==1){
                hap = hap + i;
            }
        }
        System.out.println("1부터 5까지의 홀수의 합 : "+hap);//9
    }
}
