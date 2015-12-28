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
        setupScene();
        setupGo();
        setupSettings();
    }

    private void setupScene() {
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);

        intro = new Text("This program proposes your favourite web pages in random order.");
        goButton = new Button("GO");
        settingsButton = new Button("Settings");
        vBox.getChildren().addAll(intro, goButton, settingsButton);

        stage.setScene(scene);
        stage.show();
    }

    private void setupGo() {
        //goButton.setOnAction();

    }

    private void setupSettings() {

    }


}
