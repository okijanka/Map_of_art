package filesGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminGUI extends JFrame {
    private JPanel adminWindow;
    private JButton showDatabaseOfArtistsButton;
    private JButton showSoldTicketsButton;
    private JButton showDatabaseOfMuseumButton;
    private ArrayList<String[]> linesArt = new ArrayList<String[]>();

    public AdminGUI(JButton adminButton) {
        adminButton.setEnabled(false);
        setContentPane(adminWindow);

        showDatabaseOfArtistsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new DatabaseOfArt(showDatabaseOfArtistsButton);
                f.pack();
                f.setVisible(true);
            }
        });

        showDatabaseOfMuseumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new DatabaseOfMus(showDatabaseOfMuseumButton);
                f.pack();
                f.setVisible(true);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                adminButton.setEnabled(true);
            }
        });

        showSoldTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new DatabaseOfTickets(showSoldTicketsButton);
                f.pack();
                f.setVisible(true);
            }
        });
    }

}