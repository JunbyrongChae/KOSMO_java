package athread.bubble;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


public class ChatLeft1 extends JPanel{
    public JLabel jlb_left;
    JLabel jlb_right;
    public JLabel jlb_leftimg;
    ImageIcon imageIcon = null;
    JLabel jlb_rightimg;
    JPanel chat_left;
    JPanel chat_right;
    public JLabel jlb_time;
    JLabel jlb_check;
    public JLabel jlb_fid;
    public String pic;
    public String friend_id;
    public String yourprofile = "src/image/profile/agu.png";
    Font f = new Font("맑은 고딕",Font.PLAIN,10);
    public ImageIcon youricon;// = new ImageIcon(yourprofile+pic);
    public ChatLeft1(){
        jlb_left = new JLabel();
        jlb_time = new JLabel();//시간
        imageIcon = new ImageIcon(yourprofile);
        jlb_leftimg = new JLabel(imageIcon);
        jlb_check = new JLabel();
        /////////////////LEFT BUBBLE/////////////////////////////
        String msg ="빅데이터 분석(Big Data Analytics)은 대규모의 복잡하고 다양한 데이터를 처리하고 분석하여 의미 있는 정보를 도출하는 과정을 말합니다. 이 분석 과정은 다양한 데이터 소스로부터 얻어진 대량의 정형 데이터와 비정형 데이터를 포함하며, 데이터를 통해 통찰력 있는 패턴, 트렌드, 상관관계 등을 발견하는 것이 목표입니다.  ";
        jlb_left.setText(getWrappedText(msg, 20));
        jlb_time.setText("13:00");
        jlb_check.setText("");
        jlb_check.setFont(f);
        jlb_check.setForeground(Color.red);
        chat_left = new ChatLeftBubble1();
        jlb_fid=new JLabel();
        jlb_fid.setText(" "+"tomato");
        GroupLayout chat_leftLayout = new GroupLayout(chat_left);
        chat_left.setLayout(chat_leftLayout);
        chat_leftLayout.setHorizontalGroup(
                chat_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(chat_leftLayout.createSequentialGroup()
                                .addGap(31, 31, 31)//말풍선 안에서 말풍선과 문장 시작부분 gap
                                .addComponent(jlb_left)
                                .addGap(25, 25, 25)
                        )//말풍선 안에서 말풍선끝부분 gap

        );
        chat_leftLayout.setVerticalGroup(
                chat_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(chat_leftLayout.createSequentialGroup()
                                .addGap(6, 6, 6) //말풍선 안에서 말풍선위쪽라인과 텍스트사이 gap
                                .addComponent(jlb_left)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE+10, GroupLayout.DEFAULT_SIZE+10)
                                .addGap(6, 6, 6)
                        ) //말풍선 안에서 말풍선위쪽라인과 텍스트사이 gap )
                //.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

        );
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jlb_fid)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10,10,10)
                                .addComponent(jlb_leftimg)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(chat_left, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()
                                .addGap(10,10,10)
                                .addComponent(jlb_time)
                                .addContainerGap()
                                .addGap(6,6,6)
                                .addComponent(jlb_check))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jlb_fid)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20,20,20)
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jlb_leftimg)
                                        .addComponent(chat_left, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlb_time)
                                        .addComponent(jlb_check))
                                .addContainerGap()
                                .addGap(18, 18, 18))
        );
    }
    private static String getWrappedText(String text, int lineLength) {
        StringBuilder wrappedText = new StringBuilder("<html>");
        int length = text.length();

        for (int i = 0; i < length; i += lineLength) {
            if (i + lineLength < length) {
                wrappedText.append(text, i, i + lineLength).append("<br>");
            } else {
                wrappedText.append(text.substring(i));
            }
        }

        wrappedText.append("</html>");
        return wrappedText.toString();
    }
    public static void main(String[] args) {
    }
}


