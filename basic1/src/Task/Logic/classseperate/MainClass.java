package Task.Logic.classseperate;

public class MainClass {
    public static void main(String[] args) {
        // TaskLogic 인스턴스 생성
        TaskLogic logic = new TaskLogic();

        // TaskJFrame 인스턴스 생성 및 TaskLogic 전달
        new TaskJFrame(logic);
    }
}
