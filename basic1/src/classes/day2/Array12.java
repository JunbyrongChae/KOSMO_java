package classes.day2;

public class Array12 {
    public static void main(String[] args) {
        String[][] datas = new String[2][3];
        System.out.println(datas[1][2]);
        System.out.println(datas[0][1]);
        System.out.println(datas[1][0]);
        String[][] datas2 = {//선언 및 초기화를 한 번에 할 수 있다.
                {"a", "b", "c"},
                {"d", "e", "f"},
        };
        System.out.println(datas2[1][2]);
        System.out.println(datas2[0][1]);
        System.out.println(datas2[1][0]);
        String [][] city = {
                {"Seoul", "Busan", "Incheon"},
                {"Cheong-Ju", "Gwang-Ju", "Daejeon"},
        };
        System.out.println(city[1][0]);
        System.out.println(city[1][2]);
        //배열의 단점은 같은 타입만 담을 수 있다.
        //대입연산자 오른쪽에 더 작은 타입이 오는건 늘 합법
        //그러나 더 큰 타입이 오는건 에러
        //이럴경우 그 숫자가 계산식에 사용 될 경우 형전환해야 함.
        Object[][] obj = new Object[][]{
                {1,"a","Seoul"},
                {2,"b","Busan"},
                {3,"c","Incheon"},
        };


    }
}
