package day1.variable;

public class ㅁ1 {
    public static void main(String[] args) {
        String address;
        address = "서울시 종로구 공덕동"; //-> 초기화
        System.out.println(address);// 지변인데 초기화 하지않아 에러
        // 그럴경우 ㅁ1.java는 존재하지만 ㅁ1.class는 생성되지 않음.
        // variable폴더에 없음
        // ㅁ1.class가 보이지 않는다? -> 컴파일 실패
        // 실패원인은 지변 초기화 안함.
    }
}
