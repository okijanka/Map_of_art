package classesMap;

import javax.swing.*;
import java.awt.*;

public class Coloring extends JPanel {

    private Image image;

    public Coloring(Image image){
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
