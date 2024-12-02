package jdbc.book;
/*
BookApp과 BookDialog사이에 관계가 있다
static이 아니라 생성자의 파라미터에 this를 넘겨서 두 클래스 관계를 맺는다
-입력에서 저장을 누르거나 수정에서 저장을 눌렀을떄
INSERT INTO book152 VALUES(1,'자바의 정석','도우출판사','도서설명','1.png');
-반환값이 int이다. 1입력이면 성공,0이면 입력실패
-입력성공일때 화면흐름도(Flow Chart) BookApp화면을 열어서 추가된 건이 반영 되도록
부모창의 새로고침 메서드를 호출.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BookDialog extends JDialog implements ActionListener {
    BookApp ba = null;
    BookVO bvo = null;
    BookDao bDao = new BookDao();
    JLabel 		jlb_title = new JLabel("책제목");
    JTextField 	jtf_title = new JTextField(30);
    JLabel 		jlb_author = new JLabel("저자");
    JTextField 	jtf_author = new JTextField(40);
    JLabel 		jlb_publish = new JLabel("출판사");
    JTextField 	jtf_publish = new JTextField();
    JLabel 		jlb_info = new JLabel("도서소개");
    JTextArea 	jta_info = new JTextArea(8,25);
    JButton		jbtn_file = new JButton("파일찾기");
    JTextField 	jtf_file = new JTextField(35);
    JLabel		jlb_img	 = new JLabel("이미지");
    JPanel jp_center = new JPanel();
    JPanel jp_south  = new JPanel();
    JButton jbtn_save 	= new JButton("저장");
    JButton jbtn_close 	= new JButton("닫기");
    JScrollPane jsp = new JScrollPane(jp_center);
    JScrollPane jsp_info = new JScrollPane(jta_info, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String path = "src\\image\\book\\";
    //파일 첨부와 관련된 객체 생성하기
    JFileChooser chooser = new JFileChooser();
    Container cont = getContentPane();
    BookDialog(BookApp ba) {
        System.out.println(ba);
        this.ba = ba;
        initDisplay();
    }
    public void set(String title, boolean isView, BookVO bVO, boolean editable) {
        this.bvo = bVO;
        this.setTitle(title);//입력 or 수정 or 상세보기
        this.setVisible(isView);
        //입력, 수정, 상세보기를 선택하는건 BookApp에서 함
        //수정, 상세보기는 SELECT문을 요청하고 그 결과로 BookVO를 받는다.
        //이벤트 발생시 BookApp에서 BookDialog의 set메서드를 호출
        //파라미터로 받은 BookVO의 주소번지를 setValue호출할때 파라미터로 넘김.
        //수정하기와 상세보기는 오라클서버를 경유
        //결과는 BookApp에서 생성한다.
        //set메서드를 호출할 때 파라미터로 주소번지 원본을 넘긴다.
        setValue(bVO);//입력 - null, 상세보기&수정-new BookVO
        setEditable(editable);
    }
    //입력/수정 시 - 컬럼수정가능
    //상세보기시에는 수정 불가능
    public void setEditable(boolean editable) {
        jtf_title.setEditable(editable);
        jtf_author.setEditable(editable);
        jtf_publish.setEditable(editable);
        jta_info.setEditable(editable);
        jtf_file.setEditable(editable);

    }
    public void setValue(BookVO bookVO) {
        //입력화면설정
        if (bookVO == null) {
            setB_title("");
            setAuthor("");
            setPublish("");
            setInfo("");
            setImg("");
        }
        //상세조회, 수정시 파라미터값 세팅
        else {
            setB_title(bookVO.getB_name());
            setAuthor(bookVO.getB_author());
            setPublish(bookVO.getB_publish());
            setInfo(bookVO.getB_info());
            setImg(bookVO.getB_img());
        }
    }
    public void initDisplay() {
        jp_center.setLayout(null);
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        jbtn_save.addActionListener(this);
        jbtn_close.addActionListener(this);
        jbtn_file.addActionListener(this);
        jp_south.add(jbtn_save);
        jp_south.add(jbtn_close);

        jlb_title.setBounds(20, 20, 100, 20);
        jtf_title.setBounds(120, 20, 300, 20);
        jlb_author.setBounds(20, 45, 100, 20);
        jtf_author.setBounds(120, 45, 150, 20);
        jlb_publish.setBounds(20, 70, 100, 20);
        jtf_publish.setBounds(120, 70, 200, 20);
        jlb_info.setBounds(20, 95, 100, 20);
        jsp_info.setBounds(120, 95, 300, 120);
        jbtn_file.setBounds(20, 220, 90, 20);
        jtf_file.setBounds(120, 220, 300, 20);
        jlb_img.setBorder(BorderFactory.createEtchedBorder());
        jlb_img.setBounds(120, 245, 300, 380);
        //jlb_img.setIcon(new ImageIcon(path+"1.jpg"));
        jp_center.add(jlb_title);
        jp_center.add(jtf_title);
        jp_center.add(jlb_author);
        jp_center.add(jtf_author);
        jp_center.add(jlb_publish);
        jp_center.add(jtf_publish);
        jp_center.add(jlb_info);
        jp_center.add(jsp_info);
        jp_center.add(jbtn_file);
        jp_center.add(jtf_file);
        jp_center.add(jlb_img);

        jta_info.setLineWrap(true);
        jta_info.setWrapStyleWord(true);

        this.add("South", jp_south);
        this.add("Center", jsp);

        this.setSize(500, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn_save) {
            if(bvo == null) {
                BookVO pbvo = new BookVO();
                pbvo.setB_name(getB_title());
                pbvo.setB_author(getAuthor());
                pbvo.setB_publish(getPublish());
                pbvo.setB_info(getInfo());
                pbvo.setB_img(getImg());
                int result = bDao.bookInsert(pbvo);
                if(result == 1) {
                    ba.refreshData(pbvo);
                    this.dispose();
                }
            } else if (bvo != null) {
                System.out.println("수정");
                BookVO pbvo = new BookVO();
                pbvo.setB_no(bvo.getB_no());
                pbvo.setB_name(getB_title());
                pbvo.setB_author(getAuthor());
                pbvo.setB_publish(getPublish());
                pbvo.setB_info(getInfo());
                pbvo.setB_img(getImg());
                int result = bDao.bookUpdate(pbvo);
                if(result == 1) {
                    BookVO bvo = new BookVO();
                    bvo.setB_no(0);
                    bvo.setGubun("전체");
                    bvo.setKeyword("");
                    ba.refreshData(pbvo);
                    this.dispose();
                }
            }
        } else if (obj == jbtn_close) {
            this.dispose();
        }else if (obj == jbtn_file) {
            //[열기]대화상자 오픈
            //경로를 줄 때 상대경로와 절대경로
            //정대경로 - 처음부터 끝까지 다 주는 것 : 경로 일일이 바꾼다.
            chooser.setCurrentDirectory(new File(".\\src"));
            int intRet = chooser.showOpenDialog(this);
            if (intRet == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = chooser.getSelectedFile();
                    BufferedReader myReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                    System.out.println(file.getAbsoluteFile());
                    String cpath = file.getAbsolutePath();
                    jtf_file.setText(file.getAbsolutePath());
                    //이미지 미리보기
                    ImageIcon icon = new ImageIcon(cpath);
                    Image originalImg = icon.getImage();
                    Image changeImg = originalImg.getScaledInstance(jlb_img.getWidth(), jlb_img.getHeight(), Image.SCALE_SMOOTH);
                    jlb_img.setIcon(new ImageIcon(changeImg));
                    cont.revalidate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        new BookDialog(null);
    }
    public String getB_title() {return jtf_title.getText();}
    public void setB_title(String title) { jtf_title.setText(title);}
    public String getAuthor() {	return jtf_author.getText();}
    public void setAuthor(String author) { jtf_author.setText(author);}
    public String getPublish() {return jtf_publish.getText();}
    public void setPublish(String publish) { jtf_publish.setText(publish);}
    public String getInfo() {return jta_info.getText();}
    public void setInfo(String info) { jta_info.setText(info);}
    public String getImg(){
        Path path = Paths.get(jtf_file.getText());
        String fileName = path.getFileName().toString();
        System.out.println("fileName : " + fileName);
        return fileName;
    }
    public void setImg(String img){
        ImageIcon icon = new ImageIcon(path+img);
        Image originalImg = icon.getImage();
        Image changeImg = originalImg.getScaledInstance(jlb_img.getWidth(), jlb_img.getHeight(), Image.SCALE_SMOOTH);
        jlb_img.setIcon(new ImageIcon(changeImg));
    }
}