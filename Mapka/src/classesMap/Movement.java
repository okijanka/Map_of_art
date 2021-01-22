package classesMap;

public class Movement {

    private String name;
    private Artist artist1;
    private Artist artist2;

    public Movement(String name, Artist artist1, Artist artist2) {
        this.name = name;
        this.artist1 = artist1;
        this.artist2 = artist2;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist1() {
        return artist1;
    }

    public Artist getArtist2() {
        return artist2;
    }
}
