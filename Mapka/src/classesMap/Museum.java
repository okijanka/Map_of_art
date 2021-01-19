package classesMap;

public class Museum extends Info {

    private String painting;
    private int x;
    private int y;

    public Museum(String name, String city, String country, String painting) {
        super(name, city, country);
        this.painting = painting;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPainting() {
        return painting;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
