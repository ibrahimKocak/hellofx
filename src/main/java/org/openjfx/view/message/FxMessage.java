package org.openjfx.view.message;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import org.openjfx.model.Message;
import org.openjfx.model.User;
import org.openjfx.view.message.messageParts.MessageDetail;
import org.openjfx.view.message.messageParts.MessageOwnerPicture;
import org.openjfx.view.message.messageParts.MessageText;

import java.io.IOException;

public abstract class FxMessage extends HBox {

    private MessageDetail messageDetail;
    private MessageOwnerPicture messageOwnerPicture;
    private MessageText messageText;

    private Message message;
    private String messageSenderId;
    private String messageTakerId;

    protected abstract void setMessageTemplate();

    public void setMessage(String senderId, String takerId, Message message) {

        this.messageSenderId = senderId;

        User user = User.getUsers().get(senderId);

        messageOwnerPicture.setMessageOwnerPicture(User.getUsers().get(senderId).getPicture());

        this.messageTakerId = takerId;

        this.message = message;
        messageText.setMessageText(message.getText());
        messageDetail.setMessageTime(message.getTime());
        messageDetail.setMessageCheck(message.getStatus());
    }

    public MessageDetail getMessageDetail() {
        return messageDetail;
    }

    public MessageOwnerPicture getMessageOwnerPicture() {
        return messageOwnerPicture;
    }

    public MessageText getMessageText() {
        return messageText;
    }

    public FxMessage() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("message.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }

        setMessageTemplate();
    }

    @FXML
    private void initialize() {

        messageOwnerPicture = new MessageOwnerPicture();
        messageText = new MessageText();
        messageDetail = new MessageDetail();
    }

    public static FxMessage getMessage(EnumMessage type){

        switch (type){
            case GONE: return new FxMessageGone();
            case CAME: return new FxMessageCame();
            default: return null;
        }
    }

    public enum EnumMessage {
        GONE,
        CAME;
    }
}
