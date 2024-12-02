package classes.UI.refresh;

import javax.swing.*;
import java.awt.*;
//JPanel은 JFrame처럼 윈도우창을 제공하지 않음.(=속지)
public class JPanel1 extends JPanel {
    public JPanel1(){
        initDisplay();
    }
    public void initDisplay(){
        this.setSize(350,500);
        this.setBackground(Color.GREEN);
        this.setVisible(true);
    }
}
