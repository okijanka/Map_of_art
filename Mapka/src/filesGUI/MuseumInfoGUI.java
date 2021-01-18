package filesGUI;

import classesMap.Artist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField email2;
    private JLabel info1;
    private JLabel info2;
    private JPanel first;
    private JLabel artname;
    private JLabel doggo;

    public MuseumInfoGUI(Artist artist) {

        setContentPane(main);

        artname.setText("<html>" + "<B>" + artist.getName() + "</B>" + " was born in " + artist.getNationality() + "." + "</html>");

        String[] paints = artist.getPaintings().split(",");
        info1.setText("<html>" + "You can find " + "<B>" + paints[0] + "</B>" + " in " + artist.getMuseum1().getName() + " located in " + artist.getMuseum1().getCity() + " in " + artist.getMuseum1().getCountry() + "." + "</html>");
        info2.setText("<html>" + "You can find " + "<B>" + paints[1] + "</B>" + " in " + artist.getMuseum2().getName() + " located in " + artist.getMuseum2().getCity() + " in " + artist.getMuseum2().getCountry() + "." + "</html>");

        combo1.addItem("Normal ticket");
        combo1.addItem("Student ticket");
        combo2.addItem("Normal ticket");
        combo2.addItem("Student ticket");

    }
}

