package filesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IncorrectPasswordGUI extends JFrame {
    private JPanel panel;
    private JButton OKButton;

    public IncorrectPasswordGUI(JButton adminButton) {
        adminButton.setEnabled(false);
        setContentPane(panel);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                adminButton.setEnabled(true);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                adminButton.setEnabled(true);
            }
        });

    }

}
