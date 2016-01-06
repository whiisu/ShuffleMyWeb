package SMW1;

import javafx.scene.Node;

import java.sql.*;

/**
 * Created by Kaia on 5.01.2016.
 */
public class Database {
    Connection connection = null;
    Statement statement = null;
    private Node data;

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
    public void randomURL() {
        String randomURL;
        try {
            createConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT URL FROM DATABASE ORDER BY RANDOM() LIMIT 1;");

            while (resultSet.next()){
                String url = resultSet.getString("url");
                randomURL = url;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    public void closeConnection() { //sulgen andmebaasiühenduse
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Node getData() {

        return data;
    }


}
