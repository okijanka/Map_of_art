import java.util.ArrayList;

public class Movement {

    private String name;
    private ArrayList<Artist> artists;

    public Movement(String name, ArrayList<Artist> artists) {
        this.name = name;
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void searchingCurrent(int time){
        //wyszukiwanie nurtu na podstawie zaznaczonego wieku czy lepiej robić to w innym miejscu?
        //jakaś ogólna metoda?
        //tu trzeba wczytać plik?
    }
}
