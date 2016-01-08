package SMW1;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 // Referring here to DevNami video in youtube
 */
public class ProposeURL {
    public ProposeURL(){
        findURL();
    }

    private void findURL() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("https://github.com/whiisu"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


}
