import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataManager {

    private static ArrayList<Song> songs = new ArrayList<Song>();

    static {
        loadSongs();
    }

    public static void loadSongs() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("dataFiles/songs.txt"));

            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] components = line.split("-//-");
                String filePath = components[0];
                String name = components[1];
                String artist = components[2];
                String album = components[3];
                String coverImageFilePath = components[4];

                songs.add(new Song(filePath, name, artist, album, coverImageFilePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Song> getSongs() {
        return songs;
    }
}
