package inheritance.step2;
/*****************************************************************************************************
 Java에서는 실행 중 타입정보를 확인하기 위해 instanceof와 클래스의 메타 정보를 제공하는 class객체를 사용
 1. instanceof
    객체가 특정 클래스나 인터페이스의 인스턴스인지 확인 할 수 있다
 2. class객체를 통한 타입확인
    Java에서는 모든 클래스가 런타임에 Class객체로 표현
    이를 통해 타입을 비교하거나 정보를 얻을 수 있음

 RTT(Run- Time Type)은 Java에서 객체의 런타임 타입에 대한 정보를 얻고 작업을 수행하는 기능
 RTT는 Java의 다형성을 이해하고 활용하는데 필요한 개념

 활용사례
 1. 객체 실제타입 확인
 2. 다운캐스팅
 3. 타입에 따른 다른 동작 수행

 ※주의 : 서버의 성능 저하 유발하므로 제한적 사용할것.

 RTT의 단점 : 성능저하, 디자인의 의존성 증가 유발하여 유지보수 저하 - 필요시 신중하게 사용

 Spring Framework를 모방하기 - 가능한 이유는 RTT와 리플렉션을 Java에서 지원하기 때문.
    - RTTI는 기본적으로 Java가 제공하는 컴파일된 클래스 정보를 런타임에 활용하는 방식
    - 컴파일시에 알려진 클래스만 처리 가능
    - 리플렉션을 사용하면 런타임에 동적으로 클래스의 구조(필드, 메서드)를 탐색/수정 가능
    - 프레임워크/라이브러리에서 객체타입을 기반으로 동적처리 가능
 **************************************************************************************************/
class Base{

}
class Drive extends Base{

}
public class InstanceMain {
    public static void main(String[] args) {
        /// 자바에서는 선언부 이름이 아닌 생성부 이름으로 객체가 생성된다
        Base b = new Drive();
        if(b instanceof Drive){
            System.out.println("b is an instanceof Drive");
        } else{
            System.out.println("b is not an instanceof Drive");
        }
        System.out.println(b.getClass().getName());
    }
}
