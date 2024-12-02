package Task.Logic.classseperate;

import javax.swing.*;
import java.util.Random;

public class TaskLogic {
    private int cop_nub;
    private int count;

    public TaskLogic() {
        Random rd = new Random();
        cop_nub = rd.nextInt(10);  // 0~9 사이의 랜덤 숫자 생성
        count = 0;
    }

    public void logic(int ins_nub) {
        if (ins_nub < 0 || ins_nub > 9) {
            JOptionPane.showMessageDialog(null, "0~9 사이의 숫자를 입력하세요.");
            return;
        }

        count++;

        if (ins_nub == cop_nub) {
            JOptionPane.showMessageDialog(null, "정답입니다!\n총 입력 횟수: " + count);
            resetGame();  // 게임 초기화
        } else if (ins_nub < cop_nub) {
            JOptionPane.showMessageDialog(null, "더 큰 수를 입력하세요.\n현재 입력 횟수: " + count);
        } else {
            JOptionPane.showMessageDialog(null, "더 작은 수를 입력하세요.\n현재 입력 횟수: " + count);
        }

        if (count >= 5) {
            JOptionPane.showMessageDialog(null, "실패!! 정답은 " + cop_nub + "입니다. 총 입력 횟수: " + count);
            resetGame();
        }
    }

    private void resetGame() {
        cop_nub = new Random().nextInt(10);  // 새로운 숫자 생성
        count = 0;
    }
}
