package SMW1;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kaia on 28.12.2015.
 */
public class BrowserWindow {
    TextField webPage;
    Button browserButton;
    Button nextWebPageButton;
    Button backButton;
    Stage stage = new Stage();

    BrowserWindow(){
        SetupScene2(); // UI description
        SetupBrowser(); // opens a proposed web page
        SetupNextWebPage(); // goes to database and picks new random web page, which is shown in browserButton
        SetupBackToStart(); // goes back to start (Main)
    }
    private void SetupScene2() {
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);

        // Siin peaks interaktiivne veebiaadress olema, mis võetakse randomiga andmebaasist

        String firstURL = "http://www.github.com/whiisu";
        webPage = new TextField(firstURL);
        browserButton = new Button("Open the page"); //avab selle veebiaadressi, mis kuvatakse
        nextWebPageButton = new Button("Next page"); // See nupuvajutus annab uue väärtuse browserButtonile ja URL kuvaväljale, random Database
        backButton = new Button("Back to Start"); // läheb tagasi eelmisele lehele
        vBox.getChildren().addAll(webPage, browserButton, nextWebPageButton, backButton);

        stage.setScene(scene);
        stage.show();
    }
    private void SetupBrowser() {
        browserButton.setOnAction(event -> { //FirstURL
            new ProposeURL();  //opens current web page in browser

        });
    }

    private void SetupNextWebPage() {
        nextWebPageButton.setOnAction(event -> {
            String random = "";
            Database database;
            database = new Database();
            database.randomURL(random);
            webPage = new TextField(random);


            // goes to database and picks random page which will show in browserButton
        });
    }

    private void SetupBackToStart() {
        backButton.setOnAction(event -> {
            new GoWindow();
            stage.close(); // closes BrowserWindow
        });

    }

}
