package SMW2;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Kaia on 8.01.2016.
 */
public class BrowserWindow {
    Text intro2;
    TextField webPage;
    Button browserButton;
    Button nextWebPageButton;
    Button backButton;
    Stage stage = new Stage();

    BrowserWindow(){
        SetupScene2(); // UI description
        SetupNextWebPage(); // goes to database and picks new random web page, which is shown in browserButton and webPage text
        SetupBrowser(); // opens a proposed web page
        SetupBackToStart(); // goes back to start (Main)
    }
    private void SetupScene2() {
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);

        intro2 = new Text("Suggested web page to open");
        // Siin peaks interaktiivne veebiaadress olema, mis võetakse randomiga andmebaasist
        String firstURL = "http://www.github.com/whiisu";
        webPage = new TextField(firstURL);
        browserButton = new Button("Open the page"); //avab selle veebiaadressi, mis kuvatakse
        nextWebPageButton = new Button("Next page"); // See nupuvajutus annab uue väärtuse browserButtonile ja URL kuvaväljale, random Database
        backButton = new Button("Back to Start"); // läheb tagasi eelmisele lehele
        vBox.getChildren().addAll(intro2, webPage, browserButton, nextWebPageButton, backButton);

        stage.setScene(scene);
        stage.show();
    }
    private void SetupBrowser() {
        browserButton.setOnAction(event -> { //takes url from webPage Text (firstURL)
            String url = webPage.getText();
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url)); //opens current web page in browser
                System.out.println("Opened web page: " + url);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

    private void SetupNextWebPage() {

        nextWebPageButton.setOnAction(event -> {
            String url = "";
            Database database = new Database();
            webPage = new TextField(database.randomURL(url));
            System.out.println("Active web page: " + url);
            //webPage = new Text(urldata);
            // goes to database and picks random page which will show in webPage field
        });
    }

    private void SetupBackToStart() {
        backButton.setOnAction(event -> {
            new GoWindow();
            stage.close(); // closes BrowserWindow
        });

    }

}

