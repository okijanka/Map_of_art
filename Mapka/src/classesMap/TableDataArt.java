package classesMap;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TableDataArt extends AbstractTableModel {
    private ArrayList<String[]> linesArt = new ArrayList<String[]>();
    private ArrayList<Artist> data;
    private String[] columnNames = {"Name", "Century", "Nationality", "Movement", "Paintings"};

    public TableDataArt(){
        File plik = new File("databases/malarstwo.csv");
        try {
            Scanner input = new Scanner(plik);
            while(input.hasNext()){
                String wierszString = input.nextLine();
                String[] wierszStringPodzielony = wierszString.split(";");
                linesArt.add(wierszStringPodzielony);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        data = new ArrayList<Artist>();
        for (String[] strings : linesArt) {
            Artist artist = new Artist(strings[0], strings[2], strings[4]);
            artist.setMovement(strings[3]);
            artist.setCentury(strings[1]);
            data.add(artist);
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Artist artist = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return artist.getName();
            case 1:
                return artist.getCentury();
            case 2:
                return artist.getNationality();
            case 3:
                return artist.getMovement();
            case 4:
                return artist.getPaintings();
            default:
                return null;
        }
    }
}
