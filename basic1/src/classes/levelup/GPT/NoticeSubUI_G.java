package classes.levelup.GPT;

import classes.day1.levelup.NoticeMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NoticePost {//게시글의 제목과 내용을 저장
    private String title;
    private String content;

    public NoticePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    private java.awt.List<NoticePost> postList;

    public NoticeMain() {
        postList = new ArrayList<>();
    }
    // 게시글 추가 메서드
    public void addPost(NoticePost post) {
        postList.add(post);
    }

    // 모든 게시글을 반환하는 메서드
    public java.awt.List<NoticePost> getAllPosts() {
        return postList;
    }

    // 인덱스로 게시글을 가져오는 메서드
    public NoticePost getPost(int index) {
        if (index >= 0 && index < postList.size()) {
            return postList.get(index);
        }
        return null;
    }
}

public class NoticeSubUI_G extends JFrame implements ActionListener {
    JPanel jp_south = new JPanel();
    JPanel jp_center = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");
    private NoticeMain noticeMain;
    private JList<String> postList;
    private JTextArea postContentArea;

    public NoticeSubUI_G() {
    } ////////// end of NoticeSub 생성자

    public NoticeSubUI_G(NoticeMain noticeMain) {
        this.noticeMain = noticeMain;
    }

    // UI 구성요소 생성
    postList = new JList<>();
    postContentArea = new JTextArea(NoticeMain_G nm);
    JButton addPostButton = new JButton("Add Post");

    public void initDisplay() {
        this.setLayout(new BorderLayout());
        this.setSize(400, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.add(jp_center, BorderLayout.CENTER);
        jp_center.setBackground(new Color(227, 179, 64));

        this.add(jp_south, BorderLayout.SOUTH);
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jp_south.add(btn_save);
        jp_south.add(btn_close);

        btn_save.addActionListener(this);
        btn_close.addActionListener(this);
    } ////////// end of initDisplay

    // 게시글 제목으로 JList 갱신
    updatePostList();

    // 게시글 선택 시 내용을 표시하는 리스너 추가
    postList.addListSelectionListener(e -> {
        int selectedIndex = postList.getSelectedIndex();
        if (selectedIndex != -1) {
            NoticePost post = noticeMain.getPost(selectedIndex);
            postContentArea.setText(post.getContent());
        }
    }

    // "Add Post" 버튼 리스너 추가
    addPostButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = JOptionPane.showInputDialog("Enter post title:");
            String content = JOptionPane.showInputDialog("Enter post content:");
            if (title != null && content != null) {
                NoticePost post = new NoticePost(title, content);
                noticeMain.addPost(post);
                updatePostList();  // UI에서 게시글 목록 갱신
            }
        }
        // JFrame 레이아웃 구성
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    add(new JScrollPane(postList));
    add(new JScrollPane(postContentArea));
    add(addPostButton);

    setTitle("Bulletin Board");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }

    // 게시글 목록을 갱신하는 메서드
    private void updatePostList() {
        List<NoticePost> posts = noticeMain.getAllPosts();
        String[] postTitles = posts.stream().map(NoticePost::getTitle).toArray(String[]::new);
        postList.setListData(postTitles);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn == btn_save) {
            int result = JOptionPane.showConfirmDialog(//버튼에 따라 정수값이 저장
                this,
                "저장하시겠습니까?",
                "저장",
                JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {//정수값이 0일때
                // 즉 Yes를 선택했을 때 실행할 코드 작성
                System.out.println("저장되었습니다."); // 실제 저장 로직 대신 간단한 출력문 사용
                this.dispose();
            }
        } else if (btn == btn_close) {
            int result = JOptionPane.showConfirmDialog(
                this,
                "종료하시겠습니까?",
                "종료",
                JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                // Yes를 선택했을 때 실행할 코드 작성
                System.out.println("종료되었습니다."); // 실제 종료 로직 대신 간단한 출력문 사용
                this.dispose();
            }
        }
    }
} ///////////// end of NoticeSub class