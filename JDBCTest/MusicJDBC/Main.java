package JDBCTest.MusicJDBC;

import JDBCTest.MusicJDBC.Model.Artist;
import JDBCTest.MusicJDBC.Model.DataSource;
import JDBCTest.MusicJDBC.Model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String helloWorld = new String("Test");
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Can't open datasource");
            return;
        }
        System.out.println("Open datasource success!");
        List<Artist> artistList = dataSource.queryArtist(DataSource.Order.ORDER_BY_DESC);
        if (artistList == null){
            System.out.println("No artist!");
            return;
        }
        for (Artist artist : artistList){
            System.out.printf("Id: %-5d Name: %-15s%n", artist.getId(), artist.getName());
        }

        List<String> songList = dataSource.getSongsInAlbumArtist(artistList.get(3), DataSource.Order.ORDER_BY_DESC);
        for (String song : songList){
            System.out.printf("Song: %s%n", song);
        }
        dataSource.querySongMetaData();
        int countSongs = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs list: " + countSongs);
//        System.out.println(dataSource.createViewArtistSong());
//        queryViewSongArtists(dataSource);
        dataSource.insertSong(101, "tien tao 1", "NguyenTien1", "Bai hat hay vl1");

        dataSource.close();

    }
    public static void queryViewSongArtists(DataSource dataSource){
        System.out.println("Enter title song: ");
        String titleSong = scanner.nextLine();
        List<SongArtist> songArtists = dataSource.queryViewSongArtist(titleSong);
        if(songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song!");
            return;
        }
        for (SongArtist songArtist : songArtists){
            System.out.printf("Artist: %-15s Album: %-20s Track: %-5d Title: %-15s%n", songArtist.getArtist(), songArtist.getAlbum(), songArtist.getTrack(), songArtist.getTitle());
        }
    }
}
