package athread.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Room {
    List<KiwiServerThread> userList = new Vector<>();
    List<String> nameList = new ArrayList<>();
    String title;//방이름
    String state;//방상태
    int Max;//최대원
    int current;//현재원
    public Room(){}
    public Room(String title, String state, int max) {
        this.title = title;
        this.state = state;
        this.Max = max;
    }
}
