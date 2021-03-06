package SMW1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Kaia on 28.12.2015.
 */
public class SettingsWindow {
    Text heading;
    ScrollPane top100;
    TextField newWebPage;
    Button addPage;
    Button deletePage;
    Button backButton;
    Stage stage = new Stage();

    SettingsWindow(){
        SetupScene3(); //UI description
        SetupTop100(); // List of all web pages
        DeletePage(); // deletes chosen page
        AddPage(); // stores new page to database
        SetupBackToStart(); //back to GoWindow, closes SettingsWindow
    }

    private void SetupScene3() {
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);

        heading = new Text("Settings");
        Label label = new Label("My web pages, max 100");
        top100 = new ScrollPane();
        newWebPage = new TextField();
        addPage = new Button("Add Page");
        deletePage = new Button("Delete Page");
        backButton = new Button("Back to Start");
        vBox.getChildren().addAll(heading, label, top100, newWebPage, addPage,
                deletePage, backButton);

        stage.setScene(scene);
        stage.show();

    }

    private void SetupTop100() {
        Database database = new Database();
        top100.setContent(database.getData());




    }

    private void DeletePage() {

    }

    private void AddPage() {
        addPage.setOnAction(event -> {
            String url = newWebPage.getText();
            Database database = new Database();
            database.registerNewURL(url);
            database.closeConnection();
        });
        //võtab newWebPage väljalt ULR-i ja salvestab selle andmebaasi

    }

    private void SetupBackToStart() {
        backButton.setOnAction(event -> {
            new GoWindow();
            stage.close(); // closes BrowserWindow
        });

    }

}
