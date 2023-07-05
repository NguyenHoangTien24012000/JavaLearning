package JDBCTest.MusicJDBC.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/nguyenhoangtien/Documents/ChallangeJava/src/JDBCTest/MusicJDBC/" + DB_NAME;
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    public static final String COLUMN_ARTIST_NAME_1= "artists";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;
    public static final String TABLE_ARTISTS_SONG_VIEW = "artists_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTISTS_SONG_VIEW +
            " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS album, " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " FROM " +
            TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM +
            " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS +
            "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID;

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME_1 + ", " + COLUMN_SONG_ALBUM + ", " +
            COLUMN_SONG_TRACK + " FROM " + TABLE_ARTISTS_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = \"";
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME_1 + ", " + COLUMN_SONG_ALBUM + ", " +
            COLUMN_SONG_TRACK + " FROM " + TABLE_ARTISTS_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = ?";
    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTIST_NAME + ") VALUES (?)";
    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS + "(" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST +
            ") VALUES(?, ?)";
    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS + "(" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " +
            COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";
    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS +
            " WHERE " + COLUMN_ARTIST_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_NAME + " = ?";
    public static final String QUERY_SONG = "SELECT " + COLUMN_SONG_ID + " FROM " + TABLE_SONGS + " WHERE " + COLUMN_SONG_TRACK +
            " = ? AND " + COLUMN_SONG_TITLE + " = ? AND " + COLUMN_SONG_ALBUM + " = ?";
    public enum Order {
        ORDER_BY_NONE,
        ORDER_BY_ASC,
        ORDER_BY_DESC
    }

    private Connection connection;
    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtist;
    private PreparedStatement insertIntoAlbum;
    private PreparedStatement insertIntoSong;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement querySong;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = connection.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtist = connection.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbum = connection.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSong = connection.prepareStatement(INSERT_SONG, Statement.RETURN_GENERATED_KEYS);
            queryArtist = connection.prepareStatement(QUERY_ARTIST);
            queryAlbum = connection.prepareStatement(QUERY_ALBUM);
            querySong = connection.prepareStatement(QUERY_SONG);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(querySongInfoView != null){
                querySongInfoView.close();
            }
            if(insertIntoArtist != null){
                insertIntoArtist.close();
            }
            if(insertIntoAlbum != null){
                insertIntoAlbum.close();
            }
            if(insertIntoSong != null){
                insertIntoSong.close();
            }
            if(queryArtist != null){
                queryArtist.close();
            }
            if(queryAlbum != null){
                queryAlbum.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    //    public ResultSet queryBase(Statement statement, String column);
    public List<Artist> queryArtist(Order order) {
        StringBuilder strQuery = new StringBuilder("SELECT * FROM ");
        strQuery.append(TABLE_ARTISTS);
        if (order != Order.ORDER_BY_NONE) {
            strQuery.append(" ORDER BY ");
            strQuery.append(COLUMN_ARTIST_NAME);
            strQuery.append(" COLLATE NOCASE ");
            if (order == Order.ORDER_BY_ASC) {
                strQuery.append("ASC");
            } else {
                strQuery.append("DESC");
            }
        }
        List<Artist> artistList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(strQuery.toString())) {
            while (resultSet.next()) {
                artistList.add(new Artist(resultSet.getInt(INDEX_ARTIST_ID), resultSet.getString(INDEX_ARTIST_NAME)));
            }
            return artistList;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
//        finally {
//            try {
//                if(resultSet != null){
//                    resultSet.close();
//                }
//            } catch (SQLException e){
//                System.out.println("Error closing resultSet: " + e.getMessage());
//            }
//            try {
//                if(statement != null){
//                    statement.close();
//                }
//                return artistList;
//            }catch (SQLException e){
//                System.out.println("Error closing Statement: " e.getMessage());
//            }
//        }
    }

    public List<String> getSongsInAlbumArtist(Artist artist, Order order) {
//        SELECT albums.name, songs.title FROM artists INNER JOIN albums ON artists._id = albums.artist
//        INNER JOIN songs ON songs.album = albums._id WHERE artists.name = 'Jakatta' ORDER BY songs.title COLLATE NOCASE DESC;
        StringBuilder queryStr = new StringBuilder("SELECT ");
        queryStr.append(TABLE_ALBUMS)
                .append(".")
                .append(COLUMN_ALBUM_NAME)
                .append(", ")
                .append(TABLE_SONGS)
                .append(".")
                .append(COLUMN_SONG_TITLE)
                .append(" FROM ")
                .append(TABLE_ARTISTS)
                .append(" INNER JOIN ")
                .append(TABLE_ALBUMS)
                .append(" ON ")
                .append(TABLE_ARTISTS)
                .append(".")
                .append(COLUMN_ARTIST_ID)
                .append(" = ")
                .append(TABLE_ALBUMS)
                .append(".")
                .append(COLUMN_ALBUM_ARTIST)
                .append(" INNER JOIN ")
                .append(TABLE_SONGS)
                .append(" ON ")
                .append(TABLE_SONGS)
                .append(".")
                .append(COLUMN_SONG_ALBUM)
                .append(" = ")
                .append(TABLE_ALBUMS)
                .append(".")
                .append(COLUMN_ALBUM_ID)
                .append(" WHERE ")
                .append(TABLE_ARTISTS)
                .append(".")
                .append(COLUMN_ARTIST_NAME)
                .append(" = '")
                .append(artist.getName())
                .append("'");
        if (order != Order.ORDER_BY_NONE) {
            queryStr.append(" ORDER BY ")
                    .append(TABLE_ARTISTS)
                    .append(".")
                    .append(COLUMN_ARTIST_NAME)
                    .append(" COLLATE NOCASE ");
            if (order == Order.ORDER_BY_ASC) {
                queryStr.append("ASC");
            } else {
                queryStr.append("DESC");
            }
        }

        System.out.println("Query string: " + queryStr.toString());
        List<String> songList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(queryStr.toString())) {
            while (resultSet.next()) {
                songList.add(resultSet.getString(COLUMN_SONG_TITLE));
            }
            return songList;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public void querySongMetaData() {
        String strQuery = "SELECT * FROM " + TABLE_SONGS;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(strQuery)) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                System.out.printf("Colum %d in the song table is name: %-10s%n", i, resultSetMetaData.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    public int getCount(String table) {
        String strQuery = "SELECT COUNT(*), MIN(_id) FROM " + table;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(strQuery)) {
            int result = resultSet.getInt(1);
            int min = resultSet.getInt(2);
            System.out.println("count: " + result + " min id: " + min);
            return result;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }
    public boolean createViewArtistSong(){
        try {
            Statement statement = connection.createStatement();
            System.out.println(CREATE_ARTIST_FOR_SONG_VIEW);
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            System.out.println("Create view artist_list success");
            statement.close();
            return true;
        }catch (SQLException e){
            System.out.println("Create view failed: " + e.getMessage());
            return false;
        }
    }
    public List<SongArtist> queryViewSongArtist(String titleSong){
//        StringBuilder stringQuery = new StringBuilder(QUERY_VIEW_SONG_INFO);
//        stringQuery.append(titleSong)
//                .append("\"");
        try {
            querySongInfoView.setString(1, titleSong);
            ResultSet resultSet = querySongInfoView.executeQuery();
            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()){
                songArtists.add(new SongArtist(resultSet.getString(COLUMN_ARTIST_NAME_1), resultSet.getString(COLUMN_SONG_ALBUM),
                        resultSet.getInt(COLUMN_SONG_TRACK), titleSong));
            }
            return songArtists;
        }catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
    private int insertArtist(String name) throws SQLException{
        queryArtist.setString(1, name);
        ResultSet resultSet = queryArtist.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        }else {
            insertIntoArtist.setString(1, name);
            int affectedRows = insertIntoArtist.executeUpdate();
            if(affectedRows != 1){
                throw new SQLException("Couldn't insert artist!");
            }
            ResultSet generatedKeys = insertIntoArtist.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }else {
                throw new SQLException("Can't get _id for artist");
            }
        }
    }
    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet resultSet = queryAlbum.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        }else{
            insertIntoAlbum.setString(1,name);
            insertIntoAlbum.setInt(2, artistId);
            int affectedRows = insertIntoAlbum.executeUpdate();
            if(affectedRows != 1){
                throw new SQLException("Couldn't insert album");
            }
            ResultSet generateKeys = insertIntoAlbum.getGeneratedKeys();
            if(generateKeys.next()){
                return generateKeys.getInt(1);
            }else {
                throw new SQLException("Couldn't get _id for album");
            }
        }

    }
    public void insertSong(int track, String album, String artist, String title){
        try {
            connection.setAutoCommit(false);
            int idArtist = insertArtist(artist);
            int idAlbum = insertAlbum(album, idArtist);
            querySong.setInt(1, track);
            querySong.setString(2, title);
            querySong.setInt(3, idAlbum);
            ResultSet resultSet = querySong.executeQuery();
            if(resultSet.next()){
                throw new SQLException("The song exits!");
            }
            insertIntoSong.setInt(1, track);
            insertIntoSong.setString(2,title);
            insertIntoSong.setInt(3, idAlbum);
            int affectedRows = insertIntoSong.executeUpdate();
            if(affectedRows == 1){
                connection.commit();
                System.out.println("Insert success!!!");
            }else {
                throw new SQLException("The song insert failed!");
            }
        }catch (Exception e){
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                connection.rollback();
            }catch (SQLException e2){
                System.out.println("Things are really bad! " + e.getMessage());
            }
        }finally {
            try {
                System.out.println("Resetting default commit behavior");
                connection.setAutoCommit(true);
            } catch (SQLException e){
                System.out.println("Couldn't reset auto commit " + e.getMessage());
            }
        }
    }
}
