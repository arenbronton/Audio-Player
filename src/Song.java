import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Song {

    private String filePath, name, artist, album;
    private BufferedImage albumCover;

    public Song(String filePath, String name, String artist, String album, String coverImageFilePath) {
        this.filePath = filePath;
        this.name = name;
        this.artist = artist;
        this.album = album;

        try {
            if (!coverImageFilePath.equals("none")) {
                albumCover = ImageIO.read(new File(coverImageFilePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public BufferedImage getAlbumCover() {
        return albumCover;
    }
}
