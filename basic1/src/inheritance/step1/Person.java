package inheritance.step1;
//확장성 - email을 관리하기 원할때?어떡하지?
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFullname() {
        return firstName + " " + lastName;
    }
    public void changeName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
