package classesMap;

public class Museum extends Info {

    private String painting;
    private int x;
    private int y;

    public Museum(String name, String city, String country, String painting, int x, int y) {
        super(name, city, country);
        this.painting = painting;
        this.x = x;
        this.y = y;
    }
}
