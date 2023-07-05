package JDBCTest;

import java.sql.*;

public class TestConnect {
    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/nguyenhoangtien/Documents/ChallangeJava/src/JDBCTest/" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        System.out.println("Test change git");
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
//            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                "(" + COLUMN_NAME + " TEXT, " +
                                    COLUMN_PHONE + " INTEGER," +
                                    COLUMN_EMAIL + " TEXT)");
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                            "VALUES('Tien', 0123457, 'tien@gmail.com')");
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Thuong', 0123458, 'thuong@gmail.com')");
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Son', 0123457, 'son@gmail.com')");
//            statement.execute("INSERT INTO contacts(name, phone, email) " +
//                    "VALUES('Nam', 0123457, 'nam@gmail.com')");
//            statement.execute("UPDATE contacts SET email = 'tienthuong@gmail.com' WHERE name = 'Tien'");
//            statement.execute("DELETE FROM contacts WHERE name = 'Nam'");
//            statement.execute("SELECT * FROM contacts");
            insertContact(statement, "Tung", 0123455, "tung@gmail.com");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            System.out.println(resultSet);
            while (resultSet.next()){
                System.out.printf("Name: %-15s Phone Number: %-20d Email: %s\n", resultSet.getString("name"),
                                    resultSet.getInt("phone"), resultSet.getString("email"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (SQLException e){
            System.out.println("Something went thing: " + e.getMessage());
        }
    }
    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS + "("+
                            COLUMN_NAME+ ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL +") VALUES('" +
                            name + "', '" + phone + "', '" + email +"')" );
    }
}
