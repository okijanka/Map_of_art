import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MapGUI {

    private JLabel map;
    private JPanel panel;
    private JPanel left;
   // private JComboBox comboBoxCurrent;
    private JButton buttonWczytywanie;
    private JRadioButton XVIICenturyRadioButton;
    private JRadioButton XVIIICenturyRadioButton;
    private JRadioButton XIXCenturyRadioButton;
    private JComboBox comboMovement;
    private JTextField textField1;
    private JTextField textField2;
    private JButton whereToSeeButton;
    private JButton whereToSeeButton1;
    private JButton showPaintingsButton;
    private JButton showPaintingsButton1;
    private JPanel centuries;
    private JPanel movements;
    private JPanel artist1;
    private JPanel artist2;
    private JLabel pin1;
    private JLabel pin4;
    private JLabel pin2;
    private JLabel pin3;
    private JButton searchCurrentButton;

    private Movement movement;
    private Museum museum1;
    private Museum museum2;

    private ArrayList<String[]> linesArt = new ArrayList<String[]>();
    private ArrayList<String[]> linesMus = new ArrayList<String[]>();


    public MapGUI() {

        insertArtists();
        insertMuseums();

        XVIIICenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboMovement.removeAllItems();
                if(XVIIICenturyRadioButton.isSelected()){
                    ArrayList<String> movementsXVIII = new ArrayList<>();
                    for(int i = 0; i < linesArt.size(); i+=2){
                        if(linesArt.get(i)[1].equals("XVIII")){
                                movementsXVIII.add(linesArt.get(i)[3]);
                                comboMovement.addItem(linesArt.get(i)[3]);
                        }
                    }
                }
            }
        });
        XIXCenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboMovement.removeAllItems();
                if(XIXCenturyRadioButton.isSelected()){
                    ArrayList<String> movementsXVII = new ArrayList<>();
                    for(int i = 0; i < linesArt.size(); i+=2){
                        if(linesArt.get(i)[1].equals("XIX")){
                            movementsXVII.add(linesArt.get(i)[3]);
                            comboMovement.addItem(linesArt.get(i)[3]);
                        }
                    }
                }
            }
        });
        XVIICenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboMovement.removeAllItems();
                if(XVIICenturyRadioButton.isSelected()){
                    ArrayList<String> movementsXVII = new ArrayList<>();
                    for(int i = 0; i < linesArt.size(); i+=2){
                        if(linesArt.get(i)[1].equals("XVII")){
                            movementsXVII.add(linesArt.get(i)[3]);
                            comboMovement.addItem(linesArt.get(i)[3]);
                        }
                    }
                }
            }
        });
        comboMovement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameOfMovement;
                nameOfMovement = (String) comboMovement.getSelectedItem();
                for(int i = 0; i < linesArt.size(); i++){
                    if(linesArt.get(i)[3].equals(nameOfMovement)){
                        System.out.println(linesArt.get(i)[0]);
                        for(int j = 0; j < linesMus.size(); j++){
                            String lineOfPaintings = linesArt.get(i)[4];
                            String[] paintings = lineOfPaintings.split(",");
                            System.out.println(paintings[1]);
                            if(linesMus.get(j)[0].equals(paintings[0])){
                                System.out.println(linesMus.get(j)[1]);
                                museum1 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3]);
                            }
                            if(linesMus.get(j)[0].equals(paintings[1])){
                                museum2 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3]);
                            }
                            Artist artist1 = new Artist(linesArt.get(i)[0], linesArt.get(i)[2], linesArt.get(i)[4], museum1, museum2);
                        }
                    }
                }
            }
        });
//        map.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//            }
//        });
    }

    public void insertArtists(){
        //ArrayList<Artist> ;
        File plik = new File("malarstwo_14_csv.csv");
        try {
            Scanner input = new Scanner(plik);
            while(input.hasNext()){
                String wierszString = input.nextLine();
                String[] wierszStringPodzielony = wierszString.split(";");
                linesArt.add(wierszStringPodzielony);
            }
//            System.out.println(wiersze);
//            System.out.println(wiersze.get(1)[4]);
//            if(wiersze.get(0)[0].equals("Name")){
//                System.out.println(wiersze.get(0)[0]);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertMuseums(){
        File plik = new File("muzea_14_csv.csv");
        try {
            Scanner input = new Scanner(plik);
            while(input.hasNext()){
                String wierszString = input.nextLine();
                String[] wierszStringPodzielony = wierszString.split(";");
                linesMus.add(wierszStringPodzielony);
            }
//            System.out.println(linesMus);
//            System.out.println(linesMus.get(1)[2]);
//            if(wiersze.get(0)[0].equals("Name")){
//                System.out.println(wiersze.get(0)[0]);
//            }
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
