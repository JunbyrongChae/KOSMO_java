package classes.levelup.GPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NoticeMain_G extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    JButton btn_del = new JButton("삭제");
    //NoticeSub ns = new NoticeSub();
    NoticeSubUI_G ns = new NoticeSubUI_G();

    private List<NoticePost> postList;

    public void NoticeMain() {
        postList = new ArrayList<>();
    }

    // 게시글 추가 메서드
    public void addPost(NoticePost post) {
        postList.add(post);
    }

    // 모든 게시글을 반환하는 메서드
    public List<NoticePost> getAllPosts() {
        return postList;
    }

    // 인덱스로 게시글을 가져오는 메서드
    public NoticePost getPost(int index) {
        if (index >= 0 && index < postList.size()) {
            return postList.get(index);
        }
        return null;
    }

    public void initDisplay(){
        this.setTitle("공지사항-Main");
        this.setLayout(new BorderLayout());

        panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        panel.add(btn_ins);
        panel.add(btn_upd);
        panel.add(btn_det);
        panel.add(btn_del);
        this.add("North",panel);

        this.setSize(600,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        btn_del.addActionListener(this);
        //콜백메소드의 파라미터 자리에 오는 클래스는 절대 개발자가 인스턴스하지 않습니다.
    }/////////////// end of initDisplay

    public static void main(String[] args) {
        NoticeMain_G nm = new NoticeMain_G();
        new NoticeSubUI_G();
    }/////////////// end of main

    @Override
    public void actionPerformed(ActionEvent e) {
        //call-back메서드에서 e = new ActionEvent(); 안됨
        JButton btn = (JButton)e.getSource();
        //NoticeSub ns = new NoticeSub(); 버튼 누를 때 마다 인스턴스화
        if (btn==btn_ins){
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (btn==btn_upd) {
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (btn==btn_det) {
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (btn==btn_del) {
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }/////////// end of if
    }/////////////// end of actionPerformed
}/////////////////// end of NoticeMain
