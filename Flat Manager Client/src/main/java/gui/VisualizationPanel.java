package gui;

import javax.swing.*;

public class VisualizationPanel extends JPanel implements Runnable {

    public VisualizationPanel() {
        (new Thread(this)).start();
    }

    @Override
    public void run() {

    }
}
