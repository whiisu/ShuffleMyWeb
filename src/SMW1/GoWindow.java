package SMW1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Kaia on 28.12.2015.
 */
public class GoWindow { // based on kristerv SQL_Login exercise
    Text intro;
    Button goButton;
    Button settingsButton;
    Stage stage = new Stage();

    GoWindow(){
        setupScene(); // UI description
        setupGo(); // door to next window, where you can chose your web page
        setupSettings(); // door to settings window, where you can add or delete web pages
    }

    private void setupScene() {
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);

        intro = new Text("This program suggests your favourite web pages in random order.");
        goButton = new Button("GO");
        settingsButton = new Button("Settings");
        vBox.getChildren().addAll(intro, goButton, settingsButton);

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
