import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapGUI {

    private JLabel map;
    private JPanel panel;
    private JPanel left;
    private JPanel right;
    private JComboBox comboBoxCurrent;
    private JButton buttonCURRENT;
    private JButton searchCurrentButton;
    private Current current;

    public MapGUI() {
        buttonCURRENT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wczytywanie();
            }
        });
        comboBoxCurrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //current = (Current) comboBoxCurrent.getSelectedItem();
            }
        });

    }

    public void wczytywanie(){
        //ArrayList<Artist> ;
        File plik = new File("malarstwo_csv.csv");
        try {
            Scanner input = new Scanner(plik);
            while(input.hasNext()){
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mapa");
        frame.setContentPane(new MapGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
