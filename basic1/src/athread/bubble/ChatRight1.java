package athread.bubble;

import java.awt.Color;
import java.awt.Font;
import java.net.MalformedURLException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;



public class ChatRight1 extends JPanel{
    JLabel jlb_left;
    JLabel jlb_right;
    JLabel jlb_leftimg;
    public JLabel jlb_rightimg;
    JPanel chat_left;
    JPanel chat_right;
    public JLabel jlb_time;
    JLabel jlb_check;
    String myprofile = "";
    String pic;
    public String yourprofile = "./image/profile/";
    Font f = new Font("맑은 고딕",Font.PLAIN,10);

    public ChatRight1(String id) {
        jlb_rightimg = new JLabel();
        chat_right = new ChatRightBubble1();
        jlb_right = new JLabel();
        jlb_time = new JLabel();//시간
        jlb_check = new JLabel();
        this.setBackground(new Color(254,231,134));
        this.setAlignmentX(SwingConstants.RIGHT);
        /////////////////RIGHT BUBBLE/////////////////////////////
        jlb_right.setIcon(new ImageIcon(myprofile));
        String msg = "빅데이터 분석은 비즈니스부터 과학 연구까지 다양한 분야에서 데이터 기반의 통찰력을 제공함으로써 보다 효율적이고 스마트한 의사결정을 가능하게 합니다.";
        jlb_rightimg.setText(getWrappedText(msg, 20));
        //jlb_rightimg.setText("I'm Good.");
        jlb_time.setText("13:00");
        jlb_check.setText("");
        jlb_check.setFont(f);
        jlb_check.setForeground(Color.red);
        GroupLayout chat_rightLayout = new GroupLayout(chat_right);
        chat_right.setLayout(chat_rightLayout);
        chat_rightLayout.setHorizontalGroup(
                chat_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, chat_rightLayout.createSequentialGroup()
                                .addGap(25, 25, 25)//말풍선 안에서 말풍선과 문장 시작부분 gap
                                .addComponent(jlb_rightimg)
                                .addGap(31, 31, 31))// .addGap(22, 22, 22))
        );
        chat_rightLayout.setVerticalGroup(
                chat_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(chat_rightLayout.createSequentialGroup()
                                .addGap(6, 6, 6) //말풍선 안에서 말풍선위쪽라인과 텍스트사이 gap
                                .addComponent(jlb_rightimg)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()
                                        .addComponent(jlb_check)
                                        .addGap(6,6,6)
                                        .addContainerGap()
                                        .addComponent(jlb_time)
                                        .addGap(15,15,15)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(chat_right, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jlb_right)
                                //.addGap(20,20,20)
                        )
                //  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jlb_check)
                                        .addComponent(jlb_time)
                                        .addComponent(jlb_right)
                                        .addComponent(chat_right, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()
                        )//.addContainerGap(22, Short.MAX_VALUE))
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