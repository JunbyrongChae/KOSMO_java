package Task.Logic;

import javax.swing.*;
import java.util.Random;

public class TaskLogic {
    int cop_nub;
    int count=0;

    public TaskLogic(){
        Random rd = new Random();
        cop_nub = rd.nextInt(10);
    }
    public void logic(int ins_nub){
        if(ins_nub < 0 || ins_nub > 9){
            JOptionPane.showMessageDialog(null, "9이상은 입력 할 수 없습니다.");
            return;
        }
        count++;
        if (ins_nub == cop_nub){
            JOptionPane.showMessageDialog(null, "정답입니다!"+"\n"+"총 입력 횟수 : "+count+"\n"+"게임을 리셋합니다.");
            resetGame();
        }else if(ins_nub < cop_nub){
            JOptionPane.showMessageDialog(null, "더 큰 수를 입력하세요."+"\n"+"현재 입력 횟수 : "+count);
        }else {
            JOptionPane.showMessageDialog(null, "더 작은 수를 입력하세요."+"\n"+"현재 입력 횟수 : "+count);
        }
        if (count >= 5){
            JOptionPane.showMessageDialog(null, "실패!!"+"\n"+"정답은 "+cop_nub+" 입력 횟수 : "+count+"\n"+"게임을 리셋합니다.");
            resetGame();
        }
    }
    public void resetGame() {
        cop_nub = new Random().nextInt(10);  // 새로운 숫자 생성
        count = 0;
    }
}



