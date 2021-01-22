package filesGUI;

import classesMap.TableDataMus;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DatabaseOfMus extends JFrame {
    private JTable table;
    private JPanel panel1;

    public DatabaseOfMus(JButton button) {
        button.setEnabled(false);
        TableDataMus model = new TableDataMus();
        table.setModel(model);
        setContentPane(panel1);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                button.setEnabled(true);
            }
        });
    }
}

