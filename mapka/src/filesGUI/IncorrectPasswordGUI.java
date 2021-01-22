package filesGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncorrectPasswordGUI extends JFrame{
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
    }
}
