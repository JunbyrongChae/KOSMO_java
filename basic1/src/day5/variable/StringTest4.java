package day5.variable;

import java.util.ArrayList;
import java.util.Scanner;

class Member{
    ArrayList<String> mem_ids = new ArrayList<>();{
        mem_ids.add("tomato");
        mem_ids.add("apple");
        mem_ids.add("banana");
        mem_ids.add("pineapple");
    }
    String user_id = null;
}

public class StringTest4 {
    public static void main(String[] args) {
        Member member = new Member();
        //파라미터에 System.in은 PC에서 입력값을 기다리게 됨
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("아이디를 입력하세요.");//힌트문
            member.user_id = sc.nextLine();
            System.out.println("사용자가 입력한 아이디는 : " + "[" + member.user_id + "] 입니다.");
            /*
            문자열 변수에 저장돼 있는건 값이 아니라 메모리 주소이다.
            따라서 ==가 비교하는 대상은 주소,
            실제 문자열을 비교하는게 아님
             */
            if (member.mem_ids.contains(member.user_id)) { //(user_id==mem_id)와 같음.
                //실행문이라고 하면 조건을 만족하지 않으면 단 한번도 실행이 안됨
                //조건을 실행문 보다 먼저 따지므로 조건이 false면 한번도 실행 안됨
                //참일때만 if문 괄호에 문장이 실행.
                System.out.println("아이디가 일치합니다.");
                break;
            } else {//if문의 조건을 수렴하지 않으면 실행
                System.out.println("아이디가 일치하지 않습니다. 확인해주세요.");
            }
        }
        sc.close();//스캔 종료

    }
}
