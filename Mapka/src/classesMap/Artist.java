package classesMap;

import java.util.ArrayList;

public class Artist{

    private String name;
    private String nationality;
    private String paintings;
    private Museum museum1;
    private Museum museum2;

    public Artist(String name, String nationality, String paintings, Museum museum1, Museum museum2) {
        this.name = name;
        this.nationality = nationality;
        this.paintings = paintings;
        this.museum1 = museum1;
        this.museum2 = museum2;
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

    public Museum getMuseum2() {
        return museum2;
    }

    public Museum getMuseum1() {
        return museum1;
    }
}
