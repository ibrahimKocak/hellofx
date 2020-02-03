package org.openjfx.view.message.messageParts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class MessageOwnerPicture extends Circle {

    @FXML
    private Circle messageOwnerPicture;


    public void setMessageOwnerPicture(Image image) {
        messageOwnerPicture.setFill(new ImagePattern(image));
    }

    public MessageOwnerPicture() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("messageOwnerPicture.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
