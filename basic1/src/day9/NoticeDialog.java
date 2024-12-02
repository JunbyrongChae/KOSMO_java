package day9;

import javax.swing.*;

public class NoticeDialog extends JDialog {
    NoticeMain nm = null;//꼭 null로 함
    public NoticeDialog() {
    }
    public NoticeDialog(NoticeMain nm){
        this.nm = nm;//이게 없으면 다른 메소드에서 nm사용시 nullpoint exception발생
    }
    public void initDisplay() {
        this.setSize(400,500);
        this.setVisible(true);
    }
/*
    public static void main(String[] args) {
        NoticeDialog nd = new NoticeDialog();
        nd.initDisplay();//메인에서 화면호출하지 않는다.
    }
    그렇다면 (main에서 initDisplay를 호출하지 않으면)어디서?=생성자 안에서 .
 */
}
