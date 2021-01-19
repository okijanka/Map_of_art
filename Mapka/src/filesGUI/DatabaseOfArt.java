package filesGUI;

import classesMap.TableDataArt;
import javax.swing.*;

public class DatabaseOfArt extends JFrame{
    private JTable table;
    private JPanel panel1;

    public DatabaseOfArt() {
        TableDataArt model = new TableDataArt();
        table.setModel(model);
        setContentPane(panel1);
    }
}

