package filesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AdminGUI extends JFrame{
    private JPanel adminWindow;
    private JButton showDatabaseOfArtistsButton;
    private JButton showSoldTicketsButton;
    private JButton showDatabaseOfMuseumsButton;
    private JButton addAMovementButton;
    private JButton deleteTransactionButton;
    private JButton deleteMovementButton;

    public AdminGUI(){
        setContentPane(adminWindow);
        addAMovementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NewMovementGUI();
                f.pack();
                f.setVisible(true);
            }
        });
        showDatabaseOfArtistsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(new File("malarstwo_14_csv.csv"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        showDatabaseOfMuseumsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(new File("muzea_14_csv.csv"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
