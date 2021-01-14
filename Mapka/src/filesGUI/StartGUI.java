package filesGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI {
    private JButton userButton;
    private JButton adminButton;
    private JPanel startWindow;
    private JPanel welcomeField;
    private JPanel user;
    private JPanel admin;

    public StartGUI() {
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new MapGUI();
                f.pack();
                f.setVisible(true);
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new AdminGUI();
                f.pack();
                f.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StartGUI");
        frame.setContentPane(new StartGUI().startWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
