package jdbc.book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

/*****************
 BookDialog에서 수정이나 입력일 때 insert가 1이거나 또는 update도 1이면 성공
 이때 BookApp의 도서 목록 페이지를 새로고침 한다.-요구사하잉 있다면...
 BookApp의 메서드를 BookDialog에서 호출해야 한다,
 이 때 부모창의 주소원본을 가져야 한다.
 ***************/
public class BookApp extends JFrame implements ActionListener, ItemListener {
    BookDialog bd = new BookDialog(this);
    BookNaverSearch bns = new BookNaverSearch(this);
    BookDao bDao = new BookDao();
    JMenuBar mb = new JMenuBar();
    JMenu jm_file = new JMenu("File");
    JMenuItem jmi_exit = new JMenuItem("Exit");
    JMenuItem jmi_dbcon = new JMenuItem("DB연결");
    JSeparator se_file = new JSeparator();
    JMenu jm_edit = new JMenu("Edit");
    JMenuItem jmi_all = new JMenuItem("전체조회");
    JMenuItem jmi_det = new JMenuItem("상세조회");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_del = new JMenuItem("삭제");
    String imgPath = "src\\image\\book\\";
    JToolBar jtBar = new JToolBar();
    JPanel jp_center = new JPanel();
    JPanel jp_center_north = new JPanel();
    String[] gubuns = {"도서명","저자","출판사"};
    String[] cgubuns = {"b_name","b_author","b_publish"};
    JComboBox jcb_gubun = new JComboBox(gubuns);
    JTextField jtf_keyword = new JTextField(20);
    JButton jbtn_search = new JButton(" 검색");
    JButton btn_ins = new JButton("입력",new ImageIcon(imgPath+"new.gif"));
    JButton btn_upd = new JButton("수정",new ImageIcon(imgPath+"update.gif"));
    JButton btn_del = new JButton("삭제",new ImageIcon(imgPath+"delete.gif"));
    JButton btn_all = new JButton("전체조회");
    JButton btn_det= new JButton("상세조회",new ImageIcon(imgPath+"detail.gif"));
    String[] cols = {"도서번호","도서명","저자","출판사"};
    String[][] data = new String[0][4];
    DefaultTableModel dtm_book = new DefaultTableModel(data,cols);
    JTable jtb_book = new JTable(dtm_book);
    JScrollPane jsp_book = new JScrollPane(jtb_book,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String gubun = null;
    JButton btn_naver = new JButton("네이버 도서 검색");
    public BookApp() {
        initDisplay();
    }
    public void refreshData(BookVO pbvo) {
        System.out.println("새로고침 호출"+pbvo.getKeyword()+","+pbvo.getGubun());
        List<BookVO> bList = bDao.getBookList(pbvo);
        //UI초기화작업
        //전체 조회를 누르면 버튼이 비활성화 되지 않아서 계속 반복적으로 누를 수 있다.
        //그래서 기존에 출력된 정보를 가지고 뒤에 추가되고 있다.
        while (dtm_book.getRowCount()>0) {
            //0번째를 계속해서 삭제 - 첫번째가 삭제되고 나면
            //dtm_book의 index값이 1씩 줄어들게 된다.
            dtm_book.removeRow(0);
        }
        for (int i=0;i<bList.size();i++) {
            BookVO bvo = bList.get(i);
            Vector<Object> v = new Vector<>();
            v.add(bvo.getB_no());
            v.add(bvo.getB_name());
            v.add(bvo.getB_author());
            v.add(bvo.getB_publish());
            dtm_book.addRow(v);
        }
    }
    //입력
    //BookDialog(getBookList(b_no)-1건-select문-BookDialog(저장)-BookDao(bookUpdate-update문)-BookApp(새로고침-refeshData-select문)
    public void insertActionPerformed() {
        System.out.println("입력버튼|입력메뉴");
        bd.set("입력",true,null,true);
    }
    public void detailActionPerformed() {
        System.out.println("상세버튼|상세메뉴");
        int one = -1;
        one = jtb_book.getSelectedRow();
        one += 1;
        if(one < 0) {
            JOptionPane.showMessageDialog(this,
                    "상세보기할 로우를 선택하세요",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        BookVO pbvo = new BookVO();
        pbvo.setB_no(one);
        List<BookVO> bList = bDao.getBookList(pbvo);
        if (bList.size()==1) {
            BookVO bvo = bList.get(0);
            bd.set("상세보기",true,bvo,false);
        }else{
            JOptionPane.showMessageDialog(this,
                    "조회 결과가 없습니다.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }
    //수정
    //BookDao(getBookList(b_no)-1건-select문-BookDialog(저장)-BookDao(bookUpdate-update문)-BookApp(새로고침-refeshData-select문)
    public void updateActionPerformed() {
        System.out.println("수정버튼|수정메뉴");
        int one = -1;
        one = jtb_book.getSelectedRow();
        one += 1;
        if(one < 0) {
            JOptionPane.showMessageDialog(this,
                    "상세보기할 로우를 선택하세요",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        BookVO pbvo = new BookVO();
        pbvo.setB_no(one);
        List<BookVO> bList = bDao.getBookList(pbvo);
        if (bList.size()==1) {
            BookVO bvo = bList.get(0);
            bd.set("수정",true, bvo, true);
        }else{
            JOptionPane.showMessageDialog(this,
                    "조회 결과가 없습니다.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }
    //삭제
    //BookApp - b_no - BookDao(delete문) - BookApp(refreshData호출) - delete from book152 where b_no = ?
    public void deleteActionPerformed() {
        System.out.println("삭제버튼|삭제메뉴");
        //선택한 로우는 얼마인가?
        int one = jtb_book.getSelectedRow();
        int index[] = jtb_book.getSelectedRows();
        if(index.length==0) {
            JOptionPane.showMessageDialog(this, "삭제할 로우를 선택하세요",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            //bDao.bookDelete((int)dtm_book.getValueAt(one,0));
            int b_no = 0;
            b_no = (int)dtm_book.getValueAt(one,0);
            int result = bDao.bookDelete(b_no);
            if(result==1) {
                BookVO pbvo = new BookVO();
                pbvo.setB_no(0);
                pbvo.setGubun("전체");
                pbvo.setKeyword("");
                refreshData(pbvo);
            }
        }
    }
    public void searchActionPerformed(){
        BookVO pbvo = new BookVO();
        pbvo.setGubun(gubun);
        pbvo.setKeyword(jtf_keyword.getText());
        jtf_keyword.setText("");
        refreshData(pbvo);
    }
    //전체조회
    //BookApp - BookDao(SELECT문)
    //조건검색 고려해본다
    /*********************
     SELECT * FROM book152
      WHERE b_name = ?
     ********************/
    public void allActionPerformed() {
        System.out.println("전체조회버튼|전체조회메뉴");
    }
    public void initDisplay() {
        jp_center.setLayout(new BorderLayout());
        jp_center.add("North", jp_center_north);
        jp_center.add("Center", jsp_book);
        jp_center_north.setLayout(new BorderLayout());
        jp_center_north.add("West", jcb_gubun);
        jp_center_north.add("Center", jtf_keyword);
        jp_center_north.add("East", jbtn_search);


        jm_file.add(jmi_dbcon);
        jm_file.add(se_file);
        jm_file.add(jmi_exit);
        jm_edit.add(jmi_all);
        jm_edit.add(jmi_det);
        jm_edit.add(jmi_ins);
        jm_edit.add(jmi_upd);
        jm_edit.add(jmi_del);

        mb.add(jm_file);
        mb.add(jm_edit);
        this.setJMenuBar(mb);

        btn_ins.addActionListener(this);
        jmi_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        jmi_upd.addActionListener(this);
        btn_del.addActionListener(this);
        jmi_del.addActionListener(this);
        btn_all.addActionListener(this);
        jmi_all.addActionListener(this);
        btn_det.addActionListener(this);
        jmi_det.addActionListener(this);
        jmi_dbcon.addActionListener(this);
        jmi_exit.addActionListener(this);
        jbtn_search.addActionListener(this);
        jtf_keyword.addActionListener(this);
        jcb_gubun.addItemListener(this);
        btn_naver.addActionListener(this);

        jtBar.add(btn_all);
        jtBar.add(btn_det);
        jtBar.add(btn_ins);
        jtBar.add(btn_upd);
        jtBar.add(btn_del);
        jtBar.add(btn_naver);

        this.add("North", jtBar);
        //this.add("Center", jsp_book);
        this.add("Center", jp_center);

        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        //14번의 멤버는 언제 생성되는가? 내 자신이 객체를 생성 할 때 초기화 및 생성
        BookApp ba = new BookApp();
        //14번에서 this는 23번 ba주소와 같은 값
        //디폴트 생성자는 없을 때 자동으로 생성 해 주지만
        //파라미터를 갖는 생성자는 파라미터를 예측 할 수 없어서 반드시 생성자 선언 해야 함.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //서로 같은 역할을 하는 메뉴아이템과 버튼에 대해서 하나의 메소드로 설계해본다.
        if (obj == btn_all||obj == jmi_all) {
            BookVO pbvo = new BookVO();
            pbvo.setB_no(0);
            pbvo.setGubun("전체");
            pbvo.setKeyword("");
            refreshData(pbvo);
        } else if (obj == btn_upd||obj == jmi_upd) {
            updateActionPerformed();
        } else if (obj == btn_del||obj == jmi_del) {
            deleteActionPerformed();
        } else if(obj == btn_ins||obj == jmi_ins) {
            insertActionPerformed();
        } else if (obj == btn_det||obj == jmi_det) {
            detailActionPerformed();
        } else if (jtf_keyword == obj||obj == jbtn_search) {
            searchActionPerformed();
        } else if (obj == btn_naver) {
            bns.setVisible(true);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();
        if (obj == jcb_gubun) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                //gubuns에서 가져오면 도서명,저자,출판사로 한글 이름이어서 선택한 컬럼명에 대한 영문명이 필요.
                gubun = cgubuns[jcb_gubun.getSelectedIndex()];
                System.out.println(gubun+"선택");
            }/////// 콤보박스 변경시 인터셉트
        }/////////// end of if
    }/////////////// end of itemStateChanged
}/////////////////// end of class

/*
메뉴바 추가하기
같은 메뉴를 메뉴바와 툴바에 모두 추가하여 메소드를 재사용성 구현 실습
이벤트처리를 담당하는 클래스로 설계하기 -ActionListener

삭제는 BookApp.java에서 처리
상세조회, 수정, 입력은 BoolDialog.java에서 처리한다.
이중에서 수정하기와 상세조회는 오라클서버를 경유 해야 한다. - 기존에 있는 정보를 수정/상세조회 하는것이므로 조회 결과를 화면에 표시한다.
입력은 오라클 서버를 경유하지 않고 BookDialog화면에서 새로 입력받은 정보를 오라클 서버에 입력하는 것이다.(INSERT문)
BookDialog.java BoookDao의 메세지를 호출할 때 사용자가 입력한 값을 파람;터로 넘겨야 하는데 컬럼의 갯수만큼 넘기는 것 보다는 BookVO주소번지를 하나 넘겨서
그 안에 선언된 멤버변수갖ㅅ을 INSERT문에 넣는 것이 더 나은 방법이다.
BookDialog에서는
*/