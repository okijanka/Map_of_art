import java.util.ArrayList;

public class Artist{

    private String name;
    private String nationality;
    private String paintings;
    private int birth;
    private int death;
    private Museum museum;

    public Artist(String name, String nationality, String paintings, int birth, int death, Museum museum) {
        this.name = name;
        this.nationality = nationality;
        this.paintings = paintings;
        this.birth = birth;
        this.death = death;
        this.museum = museum;
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

    public int getBirth() {
        return birth;
    }

    public int getDeath() {
        return death;
    }

    public Museum getMuseum() {
        return museum;
    }
}
