package classesMap;

public class Artist{

    private String name;
    private String nationality;
    private String century;
    private String movement;
    private String paintings;
    private Museum museum1;
    private Museum museum2;

    public Artist(String name, String nationality, String paintings) {
        this.name = name;
        this.nationality = nationality;
        this.paintings = paintings;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public void setCentury(String century) {
        this.century = century;
    }

    public void setMuseum1(Museum museum1) {
        this.museum1 = museum1;
    }

    public void setMuseum2(Museum museum2) {
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

    public String getMovement() {
        return movement;
    }

    public String getCentury() {
        return century;
    }

    public Museum getMuseum2() {
        return museum2;
    }

    public Museum getMuseum1() {
        return museum1;
    }
}
