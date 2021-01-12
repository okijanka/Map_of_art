import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private ArrayList<String[]> wiersze = new ArrayList<String[]>();

    public MapGUI() {
        buttonWczytywanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wczytywanie();
            }
        });
//        comboBoxCurrent.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //current = (Current) comboBoxCurrent.getSelectedItem();
//            }
//        });

        
        XVIICenturyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(XVIICenturyRadioButton.isSelected()){
                    ArrayList<String> artysciXVIIline = new ArrayList<>();
                    System.out.println(wiersze.get(1)[1]);
                    for(int i = 0; i < wiersze.size(); i++){
                        if(wiersze.get(i)[1].equals("XVII")){

                            artysciXVIIline.add(wiersze.get(i)[0]);

                        }
                    }
                    //System.out.println(artysciXVIIline.get(0));
                }
            }
        });
    }

    public void wczytywanie(){
        //ArrayList<Artist> ;
        File plik = new File("malarstwo_11.csv");
        try {
            Scanner input = new Scanner(plik);
            int i = 1;
            while(input.hasNext()){
                String wierszString = input.nextLine();
                //System.out.println(wierszString);
                String[] wierszStringPodzielony = wierszString.split(";");
                //System.out.println(wierszStringPodzielony[0]);
                wiersze.add(wierszStringPodzielony);
                i++;
                //System.out.println(input.nextLine());
            }
//            System.out.println(wiersze.get(0));
//             System.out.println(wiersze.get(0)[0]);
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
