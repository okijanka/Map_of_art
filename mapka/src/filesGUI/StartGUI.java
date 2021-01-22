package filesGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class StartGUI {
    private JButton userButton;
    private JButton adminButton;
    private JPanel startWindow;
    private JPanel welcomeField;
    private JPanel user;
    private JPanel admin;
    private JPasswordField passwordField;

    public StartGUI() {
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userButton.setEnabled(true);
                JFrame f = new MapGUI(userButton);
                f.pack();
                f.setVisible(true);
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkingPassword();
            }
        });
    }

    private void checkingPassword(){
        char[] password = passwordField.getPassword();
        char[] correctPass = new char[] {'c', 'i', 's', 'c', 'o'};
        if (Arrays.equals(password, correctPass)) {
            JFrame f = new AdminGUI(adminButton);
            f.pack();
            f.setVisible(true);
        } else {
            JFrame f = new IncorrectPasswordGUI(adminButton);
            f.pack();
            f.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StartGUI");
        frame.setContentPane(new StartGUI().startWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
