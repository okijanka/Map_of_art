package classesMap;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;

public class TableDataTickets extends AbstractTableModel {
    private ArrayList<String[]> linesTickets = new ArrayList<String[]>();
    private ArrayList<Ticket> data;
    private String[] columnNames = {"E-mail", "Museum", "Ticket Type"};
    private BufferedReader fileReader = null;

    public TableDataTickets(){
        try {
            fileReader = new BufferedReader(new FileReader("databases/tickets.txt"));
            String linia = "";
            try {
                while((linia = fileReader.readLine()) != null){
                    String[] wierszStringPodzielony = linia.split(",");
                    linesTickets.add(wierszStringPodzielony);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        data = new ArrayList<Ticket>();
        for (String[] strings : linesTickets) {
            Ticket ticket = new Ticket(strings[0], strings[1], strings[2]);
            data.add(ticket);
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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ticket ticket = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ticket.getEmail();
            case 1:
                return ticket.getTicketType();
            case 2:
                return ticket.getMuseum();
            default:
                return null;
        }
    }
}