package filesGUI;

import classesMap.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MapGUI extends JFrame{

    private JLabel map;
    private JPanel panel;
    private JPanel left;
    private JRadioButton XVIICenturyRadioButton;
    private JRadioButton XVIIICenturyRadioButton;
    private JRadioButton XIXCenturyRadioButton;
    private JComboBox comboMovement;
    private JTextField art1Text;
    private JTextField art2Text;
    private JButton whereToSeeButton1;
    private JButton whereToSeeButton2;
    private JButton showPaintingsButton;
    private JButton showPaintingsButton1;
    private JPanel centuries;
    private JPanel movements;
    private JPanel art1;
    private JPanel art2;
    private JLabel pin1;
    private JLabel pin2;
    private JPanel obrazek;
    private JButton searchCurrentButton;

    private Movement movement;
    private Museum museum1;
    private Museum museum2;
    private Museum museum3;
    private Museum museum4;
    private Artist artist1;
    private Artist artist2;

    private ArrayList<String[]> linesArt = new ArrayList<String[]>();
    private ArrayList<String[]> linesMus = new ArrayList<String[]>();
    private HashMap<String, String> MovementCentury = new HashMap<>();

    public MapGUI() {

        setContentPane(panel);
        insertArtists();
        insertMuseums();

        XVIICenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboMovement.removeAllItems();
                MovementCentury.clear();
                makingNull();
                if(XVIICenturyRadioButton.isSelected()){
                    for(int i = 0; i < linesArt.size(); i+=2){
                        if(linesArt.get(i)[1].equals("XVII")){
                            comboMovement.addItem(linesArt.get(i)[3]);
                            MovementCentury.put(linesArt.get(i)[3], "XVII");
                        }
                    }
                }
                refresh();
            }
        });
        XVIIICenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboMovement.removeAllItems();
                MovementCentury.clear();
                makingNull();
                if(XVIIICenturyRadioButton.isSelected()){
                    for(int i = 0; i < linesArt.size(); i+=2){
                        if(linesArt.get(i)[1].equals("XVIII")){
                            comboMovement.addItem(linesArt.get(i)[3]);
                            MovementCentury.put(linesArt.get(i)[3], "XVIII");
                        }
                    }
                }
                refresh();
            }
        });
        XIXCenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboMovement.removeAllItems();
                MovementCentury.clear();
                makingNull();
                if(XIXCenturyRadioButton.isSelected()){
                    for(int i = 0; i < linesArt.size(); i+=2){
                        if(linesArt.get(i)[1].equals("XIX")){
                            comboMovement.addItem(linesArt.get(i)[3]);
                            MovementCentury.put(linesArt.get(i)[3], "XIX");
                        }
                    }
                }
                refresh();
            }
        });

       comboMovement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboMovement.getItemCount() != 0 && comboMovement.getItemCount() != 1) {
                    String nameOfMovement;
                    nameOfMovement = (String) comboMovement.getSelectedItem();
                    makingNull();
                    int i = 1;
                    while (artist1 == null) {
                        if (linesArt.get(i)[3].equals(nameOfMovement) && MovementCentury.get(linesArt.get(i)[3]).equals(linesArt.get(i)[1])) {
                            int j = 0;
                            while (artist1 == null) {
                                String lineOfPaintings = linesArt.get(i)[4];
                                String[] paintings = lineOfPaintings.split(",");
                                if (linesMus.get(j)[0].equals(paintings[0])) {
                                    museum1 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3]);
                                }
                                if (linesMus.get(j)[0].equals(paintings[1])) {
                                    museum2 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3]);
                                }
                                if (museum1 != null && museum2 != null) {
                                    artist1 = new Artist(linesArt.get(i)[0], linesArt.get(i)[2], linesArt.get(i)[4], museum1, museum2);
                                }
                                j++;
                            }
                        }
                        i++;
                    }
                    while (artist2 == null) {
                        if (linesArt.get(i)[3].equals(nameOfMovement) && MovementCentury.get(linesArt.get(i)[3]).equals(linesArt.get(i)[1])) {
                            int j = 0;
                            while (artist2 == null) {
                                String lineOfPaintings = linesArt.get(i)[4];
                                String[] paintings = lineOfPaintings.split(",");
                                if (linesMus.get(j)[0].equals(paintings[0])) {
                                    museum3 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3]);
                                }
                                if (linesMus.get(j)[0].equals(paintings[1])) {
                                    museum4 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3]);
                                }
                                if (museum3 != null && museum4 != null) {
                                    artist2 = new Artist(linesArt.get(i)[0], linesArt.get(i)[2], linesArt.get(i)[4], museum3, museum4);
                                }
                                j++;
                            }
                        }
                        i++;
                    }
                    movement = new Movement(nameOfMovement, artist1, artist2);
                    refresh();
                }
            }
        });
        showPaintingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pin1.setVisible(true);
                watchingPictures(artist1);
            }
        });
        showPaintingsButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pin2.setVisible(true);
                watchingPictures(artist2);
            }
        });

//        map.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//                System.out.println("x");
//                System.out.println(e.getX());
//                System.out.println("y");
//                System.out.println(e.getY());
//            }
//
//        });

        whereToSeeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(artist1!=null){
                    whereOnMap(artist1);
                    museumInfo(artist1);
                }

            }
        });
        whereToSeeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(artist2!=null){
                    whereOnMap(artist2);
                    museumInfo(artist2);
                }

            }
        });
    }

    public void insertArtists(){
        //ArrayList<classesMap.Artist> ;
        File plik = new File("malarstwo_15_csv.csv");
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
    }

    public void insertMuseums(){
        File plik = new File("muzea_15_csv.csv");
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
    }

    private void whereOnMap(Artist artist){

        pin2.setVisible(true);
        String[] paintings = artist.getPaintings().split(",");
        String paint1 = paintings[0];
        String paint2 = paintings[1];
        String[] P1 = new String[0];
        String[] P2 = new String[0];
        for (String[] mus : linesMus) {
            if (mus[0].equals(paint1)) {
                P1 = mus[4].split(",");
            }
            if (mus[0].equals(paint2)) {
                P2 = mus[4].split(",");
            }
        }

        if(!P1[0].equals(P2[0]) && !P1[1].equals(P2[1])){
            pin1.setLocation(Integer.parseInt(P1[0]),Integer.parseInt(P1[1]));
            map.setLayout(null);
            map.add(pin1);

            pin2.setLocation(Integer.parseInt(P2[0]),Integer.parseInt(P2[1]));
            map.setLayout(null);
            map.add(pin2);
        }
        else {
            pin1.setLocation(Integer.parseInt(P1[0]),Integer.parseInt(P1[1]));
            map.setLayout(null);
            map.add(pin1);
            pin2.setVisible(false);
        }

    }

    private void museumInfo(Artist artist){
        JFrame f = new MuseumInfoGUI();
        f.pack();
        f.setVisible(true);
    }

    private void watchingPictures(Artist artist){
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                String nameFile = artist.getPaintings();
                String[] paintings = nameFile.split(",");
                String obraz1 = paintings[0] + ".png";
                String obraz2 = paintings[1] + ".png";

                JFrame editorFrame1 = new JFrame(paintings[0]);
                //editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                BufferedImage image1 = null;
                try
                {
                    image1 = ImageIO.read(new File(obraz1));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                ImageIcon imageIcon1 = new ImageIcon(image1);
                JLabel jLabel1 = new JLabel();
                jLabel1.setIcon(imageIcon1);
                editorFrame1.getContentPane().add(jLabel1, BorderLayout.CENTER);
                editorFrame1.pack();
                editorFrame1.setLocationRelativeTo(null);
                editorFrame1.setVisible(true);

                JFrame editorFrame2 = new JFrame(paintings[1]);
                //editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                BufferedImage image2 = null;
                try
                {
                    image2 = ImageIO.read(new File(obraz2));
                }
                catch (Exception es)
                {
                    es.printStackTrace();
                    System.exit(1);
                }
                ImageIcon imageIcon2 = new ImageIcon(image2);
                JLabel jLabel2 = new JLabel();
                jLabel2.setIcon(imageIcon2);
                editorFrame2.getContentPane().add(jLabel2, BorderLayout.CENTER);
                editorFrame2.pack();
                editorFrame2.setLocationRelativeTo(null);
                editorFrame2.setVisible(true);
            }
        });
    }

    private void refresh(){
        if(movement != null) {
            art1Text.setText(artist1.getName());
            art2Text.setText(artist2.getName());
        }else {
            art1Text.setText(" ");
            art2Text.setText(" ");
        }
    }

    private void makingNull(){
        artist1 = null;
        artist2 = null;
        museum1 = null;
        museum2 = null;
        museum3 = null;
        museum4 = null;
        movement = null;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mapa");
        frame.setContentPane(new MapGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
