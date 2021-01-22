package filesGUI;

import classesMap.Artist;
import classesMap.Ticket;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class MuseumInfoGUI extends JFrame {
    private JPanel main;
    private JPanel information1;
    private JPanel ticket1;
    private JPanel information2;
    private JPanel ticket2;
    private JPanel picture;
    private JTextField email1;
    private JComboBox combo1;
    private JComboBox combo2;
    private JLabel info1;
    private JLabel info2;
    private JPanel first;
    private JLabel artname;
    private JLabel doggo;
    private JButton cancelButton;
    private JButton confirm1;
    private JPanel buy1;
    private JPanel buy2;
    private JTextField email2;
    private JButton confirm2;
    private String newData;
    private FileWriter fileWriter;
    private BufferedReader fileReader;

    public MuseumInfoGUI(Artist artist, JButton button) {

        button.setEnabled(false);
        setContentPane(main);

        artname.setText("<html>" + "<B>" + artist.getName() + "</B>" + " was born in " + artist.getNationality() + "." + "</html>");

        String[] paints = artist.getPaintings().split(",");
        info1.setText("<html>" + "You can find " + "<B>" + paints[0] + "</B>" + " in " + artist.getMuseum1().getName() + " located in " + artist.getMuseum1().getCity() + " in " + artist.getMuseum1().getCountry() + "." + "</html>");
        info2.setText("<html>" + "You can find " + "<B>" + paints[1] + "</B>" + " in " + artist.getMuseum2().getName() + " located in " + artist.getMuseum2().getCity() + " in " + artist.getMuseum2().getCountry() + "." + "</html>");

        combo1.addItem("Normal ticket");
        combo1.addItem("Student ticket");
        combo2.addItem("Normal ticket");
        combo2.addItem("Student ticket");


        confirm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (combo1.getSelectedItem() != null && email1.getText() != null) {
                    Ticket ticket = new Ticket((String) combo1.getSelectedItem(), email1.getText(), artist.getMuseum1().getName());
                    newData = "\n" + ticket.getEmail() + "," + ticket.getMuseum() + "," + ticket.getTicketType();
                    writingTickets(newData);
                    newData = null;
                }
            }
        });
        confirm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (combo2.getSelectedItem() != null && email2.getText() != null) {
                    Ticket ticket = new Ticket((String) combo2.getSelectedItem(), email2.getText(), artist.getMuseum2().getName());
                    newData = "\n" + ticket.getEmail() + "," + ticket.getMuseum() + "," + ticket.getTicketType();
                    writingTickets(newData);
                    newData = null;
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                button.setEnabled(true);
            }
        });
    }

    private void writingTickets(String newData) {
        try {
            fileWriter = new FileWriter("databases/tickets.txt", true);
            fileWriter.write(newData);
            fileWriter.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

}

