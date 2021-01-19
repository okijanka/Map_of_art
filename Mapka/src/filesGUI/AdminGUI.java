package filesGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminGUI extends JFrame{
    private JPanel adminWindow;
    private JButton showDatabaseOfArtistsButton;
    private JButton showSoldTicketsButton;
    private JButton deleteTransactionButton;
    private JButton showDatabaseOfMuseumButton;
    private JTable j;
    private ArrayList<String[]> linesArt = new ArrayList<String[]>();

    public AdminGUI(){
        setContentPane(adminWindow);
        showDatabaseOfArtistsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Desktop desktop = Desktop.getDesktop();
//                try {
//                    desktop.open(new File("malarstwo_14_csv.csv"));
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
                JFrame f = new DatabaseOfArt();
                f.pack();
                f.setVisible(true);
            }
        });
        showDatabaseOfMuseumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new DatabaseOfMus();
                f.pack();
                f.setVisible(true);
            }
        });
    }
}