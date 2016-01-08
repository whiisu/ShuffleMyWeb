package SMW2;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by Kaia on 8.01.2016.
 */
public class Database {
    Connection connection = null;
    Statement statement = null;

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
        String sql = "CREATE TABLE IF NOT EXISTS DATABASE (ID INT AUTO_INCREMENT, URL TEXT);";
        updateDatabase(sql);
    }
    public void registerNewURL(String url) {
        // esmalt kontrolli, kas sellist aadressi pole juba ees! TODO
        String sql = "INSERT INTO DATABASE (URL) VALUES ('"+url+"');";
        updateDatabase(sql);
        System.out.println("New url successfully added!");
    }
    private void updateDatabase(String sql) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public String randomURL(String urldata) {
        try {
            createConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sql = "SELECT URL FROM DATABASE ORDER BY RANDOM() LIMIT 1;";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                urldata = resultSet.getString("url");
            }
            resultSet.close();
            statement.close();
            connection.close();
            return urldata;
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return urldata;
    }
    public int rowNumber (){
        // based on http://stackoverflow.com/questions/13103067/correct-way-to-find-rowcount-in-java-jdbc
        try{
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT COUNT (*) AS rowcount FROM DATABASE");
            r.next();
            int num = r.getInt("rowcount");
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowNumber();
    }


    public void closeConnection() { //closing database connection
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("database connection closed");
    }

    public HashMap<String, String> getURL(String url) {
        HashMap<String, String> urldata = new HashMap<String, String>();
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT URL FROM DATABASE ORDER BY RANDOM() LIMIT 1;";
            ResultSet resultSet = statement.executeQuery(sql);
            urldata.put("url", resultSet.getString("url"));
            resultSet.close();
            statement.close();
            return urldata;
        }catch (SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
        return urldata;
    }
}