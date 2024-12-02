package ProjectCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UICustomActionListener extends Component implements ActionListener, MouseListener {
    private UIMessenger ui;
    private String nickname;
    private ClientProtocol op;
    public UIMain uiMain;
    private LoginApp loginApp;
    private JoinView joinView;

    ServerMain sm = new ServerMain();

    public UICustomActionListener(UIMessenger ui, UIMain uiMain, ClientProtocol op, LoginApp loginApp, JoinView joinView) {
        this.ui = ui;
        this.uiMain = uiMain;
        this.op = op;
        this.loginApp = loginApp;
        this.joinView = joinView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "login":
                handleLogin();
                break;
            case "create_room":
                handleCreateRoom();
                break;
            case "idconfirm":
                handleIdConfirm();
                break;
            case "sign_up":
                handleSignUp();
                break;
            case "info_missing":
                handleInfoMissing();
                break;
            case "send_message":
                handleSendMessage();
                break;
            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }

    private void handleSendMessage() {
        JTextField msgInsertField = ui.getMsgInsertField();
        JTextArea msg_display = ui.getMsgDisplay();
        String message = msgInsertField.getText();
        if (!message.trim().isEmpty()) {
            // 메시지 전송 전에 방 입장 여부 확인
            if (ui.getEnterRoom().getSelectedValue() == null) {
                JOptionPane.showMessageDialog(this, "메시지를 전송하기 전에 대화 가능한 방에 입장해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }
            op.sendMsg("MsgSend#" + nickname + " : " + message + " " + sm.setDays() + "\n");  // 메세지 보내기
            msgInsertField.setText("");
            msg_display.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "메시지 전송 실패. 네트워크를 확인하세요.", "전송 오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleCreateRoom() {
        String roomName = JOptionPane.showInputDialog("그룹명을 입력해주세요!");
        if (roomName != null && !roomName.isEmpty()) {
            System.out.println(roomName);
            op.sendMsg("Create#" + roomName);
        }
    }

    private void handleLogin() {
        TalkDao tDao = new TalkDao();
        String id = loginApp.getIdField().getText();
        String pw = loginApp.getPwField().getText();
        if (id.isEmpty() || pw.isEmpty()) {
            JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하세요.", "로그인 오류", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = tDao.log_in(id, pw);
        if (result != null) {
            nickname = result;
            op.sendMsg("LoginSuccess#" + nickname);
            ui.setTitle(nickname + "님의 대화창");
            ui.setVisible(true);
            ui.msg_insert.requestFocusInWindow();
            loginApp.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleIdConfirm() {
        TalkDao tDao = new TalkDao();
        String user_id = joinView.getIdField().getText();
        if (user_id.length() <= 0) {
            JOptionPane.showMessageDialog(this, "아이디를 입력하세요", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (user_id.length() > 3) {
            if (tDao.memIdCheck(user_id)) {
                joinView.jlb_idAvble.setVisible(false);
                joinView.jlb_idNotAvble.setVisible(true);
                joinView.isIdCheck = false;
            } else {
                joinView.jlb_idAvble.setVisible(true);
                joinView.jlb_idNotAvble.setVisible(false);
                joinView.isIdCheck = true;
                System.out.println("사용 가능");
            }
        } else {
            joinView.jlb_idAvble.setVisible(false);
            joinView.jlb_idNotAvble.setVisible(true);
            joinView.isIdCheck = false;
            JOptionPane.showMessageDialog(this, "4자 이하의 아이디는 사용 불가입니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleSignUp() {
        TalkDao tDao = new TalkDao();
        String user_id = joinView.getIdField().getText();
        String user_pw = joinView.getPwField().getText();
        String user_pw2 = joinView.getPw2Field().getText();
        String name = joinView.getNameField().getText();
        String birth = joinView.getBirthField().getText();
        String phone = joinView.getPhoneField().getText();
        String nickName = joinView.getNickNameField().getText();

        if (joinView.isIdCheck) {
            if (!user_pw.equals(user_pw2)) {
                JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (user_id.isEmpty() || user_pw.isEmpty() || name.isEmpty() || birth.isEmpty() || phone.isEmpty() || nickName.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "모든 정보를 입력했는지 확인해 주세요.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int result = tDao.memJoin(user_id, user_pw, nickName, name, birth, phone);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        joinView.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다. 다시 시도해 주세요.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "아이디 중복검사를 진행하세요.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleInfoMissing() {
        // Handle info missing logic here
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 2) {
            String roomSelect = ui.list_room.getSelectedValue();
            ui.msg_insert.setText("");
            if (roomSelect != null) {
                ui.msg_display.setText("");
                op.sendMsg("Join#" + roomSelect);
            } else {
                JOptionPane.showMessageDialog(this, "참여 가능한 그룹이 없습니다.");
            }
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
