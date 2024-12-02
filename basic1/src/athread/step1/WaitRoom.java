package athread.step1;

import javax.swing.*;

public class WaitRoom extends JDialog {
    KiwiClient kc = null;
    public WaitRoom(KiwiClient kc) {
        this.kc = kc;
    }
}
