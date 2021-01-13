import java.util.ArrayList;

public class Artist{

    private String name;
    private String nationality;
    private String paintings;
    private ArrayList<Museum> museums = new ArrayList<>();

    public Artist(String name, String nationality, String paintings) {
        this.name = name;
        this.nationality = nationality;
        this.paintings = paintings;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPaintings() {
        return paintings;
    }
}
