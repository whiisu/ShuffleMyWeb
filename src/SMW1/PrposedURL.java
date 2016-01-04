package SMW1;

import java.awt.*;
import java.net.URI;


/**
 * Created by Kaia on 4.01.2016.
 */

// Referring here to DevNami video in youtube

public class PrposedURL {
    public static void main(String[] args) throws Exception{
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://github.com/whiisu"));
    }
}
