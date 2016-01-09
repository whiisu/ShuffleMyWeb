package SMW2;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Kaia on 8.01.2016.
 * based on kristerv SQL_Login exercise
 */
public class GoWindow {

    Text intro;
    Text intro2;
    Button goButton;
    Button settingsButton;
    Stage stage = new Stage();

    GoWindow(){
        setupScene(); // UI description
        setupGo(); // door to next window, where you can chose your web page
        setupSettings(); // door to settings window, where you can add or delete web pages
    }

    private void setupScene() {
        stage.setTitle("Shuffle My Web");

        VBox vBox = new VBox(30); // space between objects
        Scene scene = new Scene(vBox, 450, 450); // window size

        vBox.setStyle("-fx-font: 22 arial"); // font and size
        vBox.setPrefSize(400, 400); //objects area size
        vBox.setPadding(new Insets(20, 20, 20, 20));

        intro = new Text("This program suggests you web pages");
        intro2 = new Text("First time start with Settings");
        goButton = new Button("GO");
        goButton.setPrefSize(400, 60);
        settingsButton = new Button("Settings");
        settingsButton.setPrefSize(400, 60);
        vBox.getChildren().addAll(intro, goButton, intro2, settingsButton);

        stage.setScene(scene);
        stage.show();
    }

    private void setupGo() {
        goButton.setOnAction(event -> {
            new BrowserWindow();
            stage.close(); //closes GoWindow
        });
    }
    private void setupSettings() {
        settingsButton.setOnAction(event -> {
            new SettingsWindow();
            stage.close(); //closes GoWindow
        });

    }


}
