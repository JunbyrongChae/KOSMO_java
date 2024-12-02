package classes.Day3;

public class String1 {
    public static void main(String[] args) {
        String mem_id1 = "abc123";
        String mem_id2 = "abc123";
        String mem_id3 = new String("abc123");
        String mem_id4 = new String("def456");
        System.out.println(mem_id1 == mem_id2);//true new가 없고 값이 같으면 주소번지 같다
        System.out.println(mem_id1 == mem_id3);//false
        System.out.println(mem_id2 == mem_id3);//false
        System.out.println(mem_id3 == mem_id4);//false
        System.out.println(mem_id1.equals(mem_id2));//true //문자열비교
        System.out.println(mem_id1.equals(mem_id3));//true
        System.out.println(mem_id2.equals(mem_id3));//true
        System.out.println(mem_id3.equals(mem_id4));//false
    }
}
