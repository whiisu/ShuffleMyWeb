package SMW1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kaia on 5.01.2016.
 */
public class Database {
    Connection connection = null;

    public Database(){  // konstruktor
        createConnection(); //andmebaasiga ühenduse loomiseks
        createTable(); //andmetabeli loomine
    }

    private void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");       // Lae draiver sqlite.jar failist
            connection = DriverManager.getConnection("jdbc:sqlite:test.db"); // loo ühendus andmebaasi failiga
        }catch (Exception e){                       // püüa kinni võimalikud errorid
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private void createTable() { //loon tabeli kahe tulbaga, kus hoitakse ID numbrit ja URL aadressi
        String sql = "CREATE TABLE IF NOT EXISTS USERS (ID INT AUTO_INCREMENT, URL TEXT);";
        updateDatabase(sql);
    }
    private void updateDatabase(String sql) {
        try {
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void registerNewURL(String newURL) {
        String sql = "INSERT INTO USERS(URL) VALUES ('\"+url+\\')";
        updateDatabase(sql);
    }
    public void closeConnection() { //sulgen andmebaasiühenduse
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
