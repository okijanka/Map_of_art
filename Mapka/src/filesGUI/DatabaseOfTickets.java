package filesGUI;

import classesMap.TableDataTickets;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DatabaseOfTickets extends JFrame {
    private JTable table1;
    private JPanel panel1;

    public DatabaseOfTickets(JButton button) {
        button.setEnabled(false);
        TableDataTickets model = new TableDataTickets();
        table1.setModel(model);
        setContentPane(panel1);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                button.setEnabled(true);
            }
        });
    }
}
