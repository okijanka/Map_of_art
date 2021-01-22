package filesGUI;

import classesMap.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MapGUI extends JFrame {

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
    private JPanel right;
    private JButton searchCurrentButton;

    private Movement movement;
    private Museum museum1;
    private Museum museum2;
    private Museum museum3;
    private Museum museum4;
    private Artist artist1;
    private Artist artist2;
    private Coloring image;

    private ArrayList<String[]> linesArt = new ArrayList<String[]>();
    private ArrayList<String[]> linesMus = new ArrayList<String[]>();
    private HashMap<String, String> MovementCentury = new HashMap<>();

    public MapGUI(JButton userButton) {

        userButton.setEnabled(false);
//        //right = new ImagePanel(new ImageIcon("falki.gif").getImage());
        //ImagePanel map123 = new ImagePanel(new ImageIcon("falki.gif").getImage());
        Image background = Toolkit.getDefaultToolkit().createImage("falki.gif");
//        //right.drawImage(background, 0, 0, null);
//        right.add(map123);

        image = new Coloring(background);
        //right.add(image);
        right.add(image, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        int i = 0;

//        JLabel background;
//        ImageIcon img = new ImageIcon("falki.gif");
//        background = new JLabel("",img,JLabel.CENTER);
//        background.setBounds(0,0,1200,700);
//        add(background);

        setContentPane(panel);
        //left.setSize(50, 200);
//        pin1.setVisible(false);
//        pin2.setVisible(false);
        refresh();
        insertArtists();
        insertMuseums();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                userButton.setEnabled(true);
            }
        });

        XVIICenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickingCentury(XVIICenturyRadioButton, "XVII");
                refresh();
            }
        });
        XVIIICenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickingCentury(XVIIICenturyRadioButton, "XVIII");
                refresh();
            }
        });
        XIXCenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickingCentury(XIXCenturyRadioButton, "XIX");
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
                                    String[] position = linesMus.get(j)[4].split(",");
                                    museum1 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3], linesMus.get(j)[0]);
                                    museum1.setX(Integer.parseInt(position[0]));
                                    museum1.setY(Integer.parseInt(position[1]));
                                }
                                if (linesMus.get(j)[0].equals(paintings[1])) {
                                    String[] position = linesMus.get(j)[4].split(",");
                                    museum2 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3], linesMus.get(j)[0]);
                                    museum2.setX(Integer.parseInt(position[0]));
                                    museum2.setY(Integer.parseInt(position[1]));

                                }
                                if (museum1 != null && museum2 != null) {
                                    artist1 = new Artist(linesArt.get(i)[0], linesArt.get(i)[2], linesArt.get(i)[4]/*, museum1, museum2*/);
                                    artist1.setMuseum1(museum1);
                                    artist1.setMuseum2(museum2);
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
                                    String[] position = linesMus.get(j)[4].split(",");
                                    museum3 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3], linesMus.get(j)[0]);
                                    museum3.setX(Integer.parseInt(position[0]));
                                    museum3.setY(Integer.parseInt(position[1]));
                                }
                                if (linesMus.get(j)[0].equals(paintings[1])) {
                                    String[] position = linesMus.get(j)[4].split(",");
                                    museum4 = new Museum(linesMus.get(j)[1], linesMus.get(j)[2], linesMus.get(j)[3], linesMus.get(j)[0]);
                                    museum4.setX(Integer.parseInt(position[0]));
                                    museum4.setY(Integer.parseInt(position[1]));
                                }
                                if (museum3 != null && museum4 != null) {
                                    artist2 = new Artist(linesArt.get(i)[0], linesArt.get(i)[2], linesArt.get(i)[4]);
                                    artist2.setMuseum1(museum3);
                                    artist2.setMuseum2(museum4);
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
                String nameFile = artist1.getPaintings();
                String[] paintings = nameFile.split(",");
                String obraz1 = "paintings/" + paintings[0] + ".png";
                String obraz2 = "paintings/" + paintings[1] + ".png";
                watchingPictures(obraz1, paintings[0]);
                watchingPictures(obraz2, paintings[1]);
            }
        });
        showPaintingsButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pin2.setVisible(true);
                String nameFile = artist2.getPaintings();
                String[] paintings = nameFile.split(",");
                String obraz1 = "paintings/" + paintings[0] + ".png";
                String obraz2 = "paintings/" + paintings[1] + ".png";
                watchingPictures(obraz1, paintings[0]);
                watchingPictures(obraz2, paintings[1]);
            }
        });

//        mapka.addMouseListener(new MouseAdapter() {
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
                if (artist1 != null) {
                    //whereOnMap(artist1);
                    museumInfo(artist1);
                }
            }
        });
        whereToSeeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (artist2 != null) {
                    //whereOnMap(artist2);
                    museumInfo(artist2);
                }
            }
        });
    }

    public void insertArtists() {
        File plik = new File("databases/malarstwo.csv");
        try {
            Scanner input = new Scanner(plik);
            while (input.hasNext()) {
                String wierszString = input.nextLine();
                String[] wierszStringPodzielony = wierszString.split(";");
                linesArt.add(wierszStringPodzielony);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertMuseums() {
        File plik = new File("databases/muzea.csv");
        try {
            Scanner input = new Scanner(plik);
            while (input.hasNext()) {
                String wierszString = input.nextLine();
                String[] wierszStringPodzielony = wierszString.split(";");
                linesMus.add(wierszStringPodzielony);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void pickingCentury(JRadioButton button, String century) {
        comboMovement.removeAllItems();
        MovementCentury.clear();
        makingNull();
        if (button.isSelected()) {
            for (int i = 0; i < linesArt.size(); i += 2) {
                if (linesArt.get(i)[1].equals(century)) {
                    comboMovement.addItem(linesArt.get(i)[3]);
                    MovementCentury.put(linesArt.get(i)[3], century);
                }
            }
        }
    }

//    private void whereOnMap(Artist artist){
//
//        pin2.setVisible(true);
//        String[] paintings = artist.getPaintings().split(",");
//        String paint1 = paintings[0];
//        String paint2 = paintings[1];
//        String[] P1 = new String[0];
//        String[] P2 = new String[0];
//        for (String[] mus : linesMus) {
//            if (mus[0].equals(paint1)) {
//                P1 = mus[4].split(",");
//            }
//            if (mus[0].equals(paint2)) {
//                P2 = mus[4].split(",");
//            }
//        }
//
//        if(!P1[0].equals(P2[0]) && !P1[1].equals(P2[1])){
//            pin1.setLocation(Integer.parseInt(P1[0]),Integer.parseInt(P1[1]));
//            //mapka.setLayout(null);
//            //mapka.add(pin1);
//
//            pin2.setLocation(Integer.parseInt(P2[0]),Integer.parseInt(P2[1]));
//            //mapka.setLayout(null);
//            //mapka.add(pin2);
//        }
//        else {
//            pin1.setLocation(Integer.parseInt(P1[0]),Integer.parseInt(P1[1]));
//            //mapka.setLayout(null);
//            //mapka.add(pin1);
//            pin2.setVisible(false);
//        }
//
//    }

    private void museumInfo(Artist artist) {
        JFrame f = new MuseumInfoGUI(artist);
        f.pack();
        f.setVisible(true);
    }

    private void watchingPictures(String obraz1, String name) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame editorFrame1 = new JFrame(name);
                //editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                BufferedImage image1 = null;
                try {
                    image1 = ImageIO.read(new File(obraz1));
                } catch (Exception e) {
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
            }
        });
    }

    private void refresh() {
        if (movement != null) {
            art1Text.setText(artist1.getName());
            art2Text.setText(artist2.getName());
        } else {
            art1Text.setText(" ");
            art2Text.setText(" ");
        }
    }

    private void makingNull() {
        artist1 = null;
        artist2 = null;
        museum1 = null;
        museum2 = null;
        museum3 = null;
        museum4 = null;
        movement = null;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBorder(BorderFactory.createTitledBorder(null, "MAP OF ART", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        left = new JPanel();
        left.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(left, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        art1 = new JPanel();
        art1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        art1.setBackground(new Color(-1842988));
        left.add(art1, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        art1.setBorder(BorderFactory.createTitledBorder(null, "Artist 1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        art1Text = new JTextField();
        art1Text.setText("");
        art1.add(art1Text, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        whereToSeeButton1 = new JButton();
        whereToSeeButton1.setText("where to see");
        art1.add(whereToSeeButton1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showPaintingsButton = new JButton();
        showPaintingsButton.setText("show paintings");
        art1.add(showPaintingsButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        art2 = new JPanel();
        art2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        art2.setBackground(new Color(-2174302));
        left.add(art2, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        art2.setBorder(BorderFactory.createTitledBorder(null, "Artist 2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        art2Text = new JTextField();
        art2.add(art2Text, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        whereToSeeButton2 = new JButton();
        whereToSeeButton2.setText("where to see");
        art2.add(whereToSeeButton2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showPaintingsButton1 = new JButton();
        showPaintingsButton1.setText("show paintings");
        art2.add(showPaintingsButton1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centuries = new JPanel();
        centuries.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        centuries.setBackground(new Color(-9794173));
        left.add(centuries, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        centuries.setBorder(BorderFactory.createTitledBorder(null, "Choose century", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        XVIICenturyRadioButton = new JRadioButton();
        XVIICenturyRadioButton.setBackground(new Color(-9794173));
        XVIICenturyRadioButton.setText("XVII century");
        centuries.add(XVIICenturyRadioButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        XVIIICenturyRadioButton = new JRadioButton();
        XVIIICenturyRadioButton.setBackground(new Color(-9794173));
        XVIIICenturyRadioButton.setText("XVIII century");
        centuries.add(XVIIICenturyRadioButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        XIXCenturyRadioButton = new JRadioButton();
        XIXCenturyRadioButton.setBackground(new Color(-9794173));
        XIXCenturyRadioButton.setText("XIX century");
        centuries.add(XIXCenturyRadioButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        movements = new JPanel();
        movements.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        movements.setBackground(new Color(-7297358));
        left.add(movements, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        movements.setBorder(BorderFactory.createTitledBorder(null, "Choose movement", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        comboMovement = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        comboMovement.setModel(defaultComboBoxModel1);
        movements.add(comboMovement, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        obrazek = new JPanel();
        obrazek.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(20, 20, 20, 20), -1, -1));
        obrazek.setBackground(new Color(-3370106));
        left.add(obrazek, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon(getClass().getResource("/sztaluga.png")));
        label1.setText("");
        obrazek.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        right = new JPanel();
        right.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(right, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(XVIIICenturyRadioButton);
        buttonGroup.add(XIXCenturyRadioButton);
        buttonGroup.add(XVIICenturyRadioButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
