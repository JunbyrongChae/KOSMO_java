package inheritance.step1;

public class Teacher extends Person {
    private Department department;
    public Teacher(String firstName, String lastName, Department department) {
        super(firstName, lastName);
        this.department = department;
    }
    public Department getDepartmentOrNull() {
        return this.department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
