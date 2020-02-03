package org.openjfx.view.message.messageParts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.IOException;

public class MessageText extends Label {

    @FXML
    private Label messageText;

    public void setMessageText(String text) {
        this.messageText.setText(text);
    }

    public MessageText(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("messageText.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
