package ProjectCode;

public class UIMain {
    ClientProtocol op = new ClientProtocol(this);
    UIMessenger ui = new UIMessenger();
    LoginApp loginApp = new LoginApp();
    JoinView joinView = new JoinView();
    UICustomActionListener actionListener = new UICustomActionListener(ui, this, op, loginApp, joinView);

    private void setupActionListeners() { //액션리스너 중계 - 꼬이지 않게 메인경유
        ui.setActionListener(actionListener);
        loginApp.setActionListener(actionListener);
        joinView.setActionListener(actionListener);
    }

    public static void main(String[] args) {
        UIMain uiMain = new UIMain();
        uiMain.setupActionListeners();
        //입장화면 띄움
        uiMain.loginApp.setVisible(true);
    }
}