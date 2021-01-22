package classesMap;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TableDataMus extends AbstractTableModel {
    private ArrayList<String[]> linesMus = new ArrayList<String[]>();
    private ArrayList<Museum> data;
    private final String[] columnNames = {"Painting", "Museum", "City", "Country"};

    public TableDataMus(){
        File plik = new File("databases/muzea.csv");
        try {
            Scanner input = new Scanner(plik);
            while(input.hasNext()){
                String wierszString = input.nextLine();
                String[] wierszStringPodzielony = wierszString.split(";");
                linesMus.add(wierszStringPodzielony);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        data = new ArrayList<Museum>();
        for (String[] mus : linesMus) {
            Museum museum = new Museum(mus[0], mus[1], mus[2], mus[3]);
            data.add(museum);
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Museum museum = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return museum.getPainting();
            case 1:
                return museum.getName();
            case 2:
                return museum.getCity();
            case 3:
                return museum.getCountry();
            default:
                return null;
        }
    }
}
