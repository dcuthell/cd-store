import models.CD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Guest on 7/31/17.
 */
public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the CD Store!");

        ArrayList<CD> allCDs = new ArrayList<CD>();
        boolean programRunning = true;
        while(programRunning){
            System.out.println("Please make your selection from the following choices: Show All, Search Year, Search Price, Search Artist, Add CD, Exit");
            try{

                String navChoice = bufferedReader.readLine();

                if(navChoice.equals("Show All")){
                    for( CD oneCD : allCDs ){
                        System.out.println("--------------------");
                        System.out.println(oneCD.artist);
                        System.out.println(oneCD.album);
                        System.out.println(oneCD.year);
                        System.out.println(oneCD.price);
                    }
                }else if(navChoice.equals("Search Year")){
                    System.out.println("Please enter a year:");
                    Integer someYear = Integer.parseInt(bufferedReader.readLine());
                    for( CD oneCD : allCDs ){
                        if(oneCD.fromYear(someYear)){
                            System.out.println("--------------------");
                            System.out.println(oneCD.artist);
                            System.out.println(oneCD.album);
                            System.out.println(oneCD.year);
                            System.out.println(oneCD.price);
                        }
                    }
                }else if(navChoice.equals("Search Price")){
                    System.out.println("Please enter a price");
                    Double somePrice = Double.parseDouble(bufferedReader.readLine());
                    for( CD oneCD : allCDs ) {
                        if (oneCD.inPriceRange(somePrice)) {
                            System.out.println("--------------------");
                            System.out.println(oneCD.artist);
                            System.out.println(oneCD.album);
                            System.out.println(oneCD.year);
                            System.out.println(oneCD.price);
                        }
                    }
                }else if(navChoice.equals("Search Artist")) {
                    System.out.println("Please enter an Artist");
                    String someArtist = bufferedReader.readLine();
                    for (CD oneCD : allCDs) {
                        if (oneCD.fromArtist(someArtist)) {
                            System.out.println("--------------------");
                            System.out.println(oneCD.artist);
                            System.out.println(oneCD.album);
                            System.out.println(oneCD.year);
                            System.out.println(oneCD.price);
                        }
                    }
                }else if(navChoice.equals("Add CD")){
                    System.out.println("Please enter an artist name");
                    String artist = bufferedReader.readLine();
                    System.out.println("Please enter an album name");
                    String album = bufferedReader.readLine();
                    System.out.println("Please enter a release year");
                    Integer year = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Please enter a CD price");
                    Double price = Double.parseDouble(bufferedReader.readLine());
                    CD someCD = new CD(artist, album, year, price);
                    allCDs.add(someCD);
                }else if(navChoice.equals("Exit")){
                    System.out.println("Byyyyeeeeeeeee");
                    programRunning = false;
                }else{
                    System.out.println("Invalid input, try again");
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
