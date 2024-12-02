package inheritance.step3;

public class Vector {
    private int x; //0
    private int y; //0
    //생성자 호출로 멤버변수 초기화 가능
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
