package org.openjfx.view.message.messageParts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.openjfx.model.Message;
import org.openjfx.view.bin.MyImage;

import java.io.IOException;

public class MessageDetail extends VBox {

    @FXML
    private Label messageTime;

    @FXML
    private ImageView messageCheck;

    public void setMessageTime(String time) {
        this.messageTime.setText(time);
    }

    public void setMessageCheck(Message.Status status) {

        switch (status){

            case DELIVERED:
                this.messageCheck.setImage(MyImage.getImage().success); break;
            case UNDELIVERED:
                this.messageCheck.setImage(MyImage.getImage().unSuccess); break;
        }
    }

    public MessageDetail() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "messageDetail.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
