import java.util.ArrayList;

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

    public void searchingCurrent(int time){
        //wyszukiwanie nurtu na podstawie zaznaczonego wieku czy lepiej robić to w innym miejscu?
        //jakaś ogólna metoda?
        //tu trzeba wczytać plik?
    }
}
