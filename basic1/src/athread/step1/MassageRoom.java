package athread.step1;

import javax.swing.*;

public class MassageRoom extends JDialog {
    KiwiClient kc = null;
    public MassageRoom() {}
    public MassageRoom(KiwiClient kc) {
        this.kc = kc;
    }
}
