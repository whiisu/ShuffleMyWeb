package EsimeneKatse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kaia on 23.11.2015.
 */

//loo kast nuppudega: "GO", "Settings", "Exit"

public class Algus extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // ** kasutatud allikas KristerV/javaHarjutused/logisisse
        VBox avaAken = new VBox();
        Scene lava = new Scene(avaAken, 400, 300);
        primaryStage.setScene(lava);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        Button go = new Button("GO");
        // go.setOnAction(event -> {});
        Button settings = new Button("Settings");
        // settings.setOnAction(event -> {});

        avaAken.getChildren().addAll(go, settings);

        // vajutades Settings, lähed andmebaasi, mida saab muuta. Edaspidi Objekt2
        // Vajutades Go, avad uue akna, Ojekt3 eelmise asemel, kus on valikud:
        // 1. pakutakse ühte suvalist kodulehte andmebaasist
        // vajutades sellele kodulehele avatakse veebibrowser, mida saad lehitseda.
        // 2. kui koduleht ei sobi, saad vajutada ka nuppu "paku veel"
        // siis asendatakse eelmine koduleht uue kodulehega massiivist
        // kordustegevus, kuni oled rahul kodulehega ja edasi toimid nagu 1.
        // 3. kui soovid muuta seadeid saad vajutada nuppu "Algusesse", mis avab eelmise akna
        // liigud algusesse, kus on esimene kast
        // 4. Kui soovid programmist väljuda, siis vajutad Exit nuppu
        // väljud programmist
    }
}
