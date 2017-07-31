package models;

/**
 * Created by Guest on 7/31/17.
 */
public class CD {
    public String artist;
    public String album;
    public Integer year;
    public Double price;

    public CD(String artist, String album, Integer year, Double price){
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.price = price;
    }

    public boolean fromYear(Integer someYear){
        return year.equals(someYear);
    }

    public boolean inPriceRange(Double somePrice){
        return (price <= somePrice);
    }

    public boolean fromArtist(String someArtist){
        return artist.equals(someArtist);
    }
}
