package athread.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class JTableView1 extends JFrame {
    DefaultTableModel model = null;
    JTable friend = null;
    JScrollPane jsp_friend = null;
    String path = "src\\image\\profile\\";
    public JTableView1() {initDisplay();}
    public void initDisplay(){
        model = new DefaultTableModel(new Object[]{"Image", "Text"},0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Icon.class; // 이미지가 있는 열은 Icon 타입으로 지정
                } else {
                    return String.class; // 텍스트가 있는 열은 String 타입으로 지정
                }
            }
        };
        friend = new JTable(model);
        friend.setRowHeight(95);

        jsp_friend = new JScrollPane(friend);

        setSize(500,500);

        model.addRow(new Object[]{createImageIcon(path + "profileicon1.jpg", 95, 95), new JLabel("Label1")});
        model.addRow(new Object[]{createImageIcon(path + "profileicon2.jpg", 95, 95), new JLabel( "Label2")});
        model.addRow(new Object[]{createImageIcon(path + "profileicon3.jpg", 95, 95), new JLabel( "Label3")});
        model.addRow(new Object[]{createImageIcon(path + "agu.png", 95, 95), new JLabel( "Label4")});
        model.addRow(new Object[]{createImageIcon(path + "agu1.png", 95, 95), new JLabel( "Label5")});
        model.addRow(new Object[]{createImageIcon(path + "btnicon.jpg", 95, 95), new JLabel( "Label6")});

        friend.getColumnModel().getColumn(1).setCellRenderer(new JLabelCellRenderer());

        add("Center", jsp_friend);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private ImageIcon createImageIcon(String path, int width, int height) {
        File file = new File(path);
        if (file.exists()) {
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } else {
            System.out.println("파일을 찾을 수 없습니다: " + path);
            return null;
        }
    }

    private static class JLabelCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JLabel) {
                JLabel label = (JLabel) value;
                if (isSelected) {
                    label.setBackground(table.getSelectionBackground());
                    label.setOpaque(true);
                } else {
                    label.setOpaque(false);
                }
                return label;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    public static void main(String[] args) {
        new JTableView1();
    }
}
