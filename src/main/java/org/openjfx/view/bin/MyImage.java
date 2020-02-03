package org.openjfx.view.bin;

import javafx.scene.image.Image;
import org.openjfx.MainApp;

public class MyImage {

    final static MyImage MYIMAGES = new MyImage();
    public Image success;
    public Image unSuccess;
    public Image unknownSuccess;
    public Image profile;;

    private MyImage() {
        success = new Image(MainApp.class.getResourceAsStream("images/icon/success32.png"));
        unSuccess = new Image(MainApp.class.getResourceAsStream("images/icon/unSuccess32.png"));
        unknownSuccess = new Image(MainApp.class.getResourceAsStream("images/icon/unknownSuccess32.png"));
        profile = new Image(MainApp.class.getResourceAsStream("images/image/profile.png"));
    }

    public static MyImage getImage() {
        return MYIMAGES;
    }
}
