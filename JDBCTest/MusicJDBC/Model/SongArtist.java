package JDBCTest.MusicJDBC.Model;

public class SongArtist {
    private String title;
    private String album;
    private int track;
    private String artist;

    public SongArtist(String artist, String album, int track, String title) {
        this.title = title;
        this.album = album;
        this.track = track;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
