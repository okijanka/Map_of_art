package filesGUI;

import classesMap.TableDataMus;
import javax.swing.*;

public class DatabaseOfMus extends JFrame{
    private JTable table;
    private JPanel panel1;

    public DatabaseOfMus() {
        TableDataMus model = new TableDataMus();
        table.setModel(model);
        setContentPane(panel1);
    }
}

