package filesGUI;

import classesMap.TableDataMus;
import classesMap.TableDataTickets;

import javax.swing.*;

public class DatabaseOfTickets extends JFrame{
    private JTable table1;
    private JPanel panel1;

    public DatabaseOfTickets() {
        TableDataTickets model = new TableDataTickets();
        table1.setModel(model);
        setContentPane(panel1);
    }
}
