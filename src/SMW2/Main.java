package SMW2;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Kaia on 8.01.2016.
 * Based on Krister Viirsaar:
 * https://github.com/KristerV/javaHarjutused/tree/lahendused/src/teema3/SQL_Login
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new GoWindow();

        // this class is to start the program, it moves on to GoWindow class
    }

}