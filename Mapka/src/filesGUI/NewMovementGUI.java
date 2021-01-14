package filesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMovementGUI extends JFrame{
    private JPanel newMovementWindow;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton ADDButton;
    private JButton CANCELButton;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JTextField textField26;
    private JTextField textField27;
    private JTextField textField28;
    private JTextField textField29;
    private JTextField textField30;
    private JTextField textField31;
    private JTextField textField32;
    private JTextField textField33;
    private JTextField textField34;

    public NewMovementGUI(){
        setContentPane(newMovementWindow);
        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
