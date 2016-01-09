package SMW2;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Kaia on 8.01.2016.
 */
public class SettingsWindow {
    Text heading;
    ScrollPane top100;
    Label label2;
    TextField newWebPage;
    Button addPage;
    Button deletePage;
    Button backButton;
    Stage stage = new Stage();

    SettingsWindow(){
        SetupScene3();  //UI description
        SetupTop100();  // List of all web pages
        DeletePage();   // deletes chosen page
        AddPage();      // stores new page to database
        SetupBackToStart(); //back to GoWindow, closes SettingsWindow
    }

    private void SetupScene3() {
        stage.setTitle("Shuffle My Web");
        VBox vBox = new VBox(30);
        Scene scene = new Scene(vBox);
        vBox.setStyle("-fx-font: 22 arial");
        vBox.setPrefWidth(400);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        heading = new Text("Settings");
        top100 = new ScrollPane();
        label2 = new Label("Please copy FULL url here!");
        newWebPage = new TextField();
        newWebPage.setPrefSize(400, 60);
        addPage = new Button("Add Page");
        addPage.setPrefSize(400, 60);
        deletePage = new Button("Delete Page");
        deletePage.setPrefSize(400, 60);
        backButton = new Button("Back to Start");
        backButton.setPrefSize(400, 60);
        vBox.getChildren().addAll(heading, top100, label2, newWebPage, addPage,
                deletePage, backButton);

        stage.setScene(scene);
        stage.show();

    }

    private void SetupTop100() {
        Database database = new Database();
        //top100.setContent(database.getData());

    }

    private void DeletePage() { // meed to SetupTop100 first, TODO

    }

    private void AddPage() {    // saves new url to database
            addPage.setOnAction(event -> {
                String url = newWebPage.getText();
                Database database = new Database();
                database.registerNewURL(url);
                database.closeConnection();
            });

        }


    private void SetupBackToStart() {
        backButton.setOnAction(event -> {
            new GoWindow();
            stage.close(); // closes BrowserWindow
        });

    }

}
