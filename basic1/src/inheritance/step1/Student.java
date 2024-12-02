package inheritance.step1;

public class Student extends Person {
    private Major major;
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public Major getMajorOrNull() {
        return this.major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
}
