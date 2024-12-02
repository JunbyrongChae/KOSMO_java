package Quiz;

import java.util.ArrayList;
import java.util.List;

public class DeptMain2 {
    public static void main(String[] args) {
        List<DeptDTO> list = new ArrayList<>();
        System.out.println(list.size());//0
        DeptDTO dto2 = new DeptDTO();
        list.add(dto2);
        System.out.println(list.size());//1
        dto2 = new DeptDTO();
        list.add(dto2);
        System.out.println(list.size());//2
        dto2 = new DeptDTO();
        list.add(dto2);
        System.out.println(list.size());//3
        for (DeptDTO dto : list) {
            System.out.println(dto);//dto2@
        }
    }
}
