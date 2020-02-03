package org.openjfx.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.openjfx.model.Message;
import org.openjfx.model.User;
import org.openjfx.view.bin.MyImage;
import org.openjfx.view.message.FxMessage;
import org.openjfx.view.message.FxMessageCame;
import org.openjfx.view.message.FxMessageGone;
import org.openjfx.view.messageOwner.FxMessageOwner;
import org.openjfx.view.profile.FxProfile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FxMain {

    public Button buttonMessageSend;
    public AnchorPane anchorProfile;
    public TextField textFieldMessage;
    public VBox vBoxMessages;
    public VBox vBoxMessageOwner;

    public static User userLogged;


    public void initialize() {

        User.addUsers(new User("Antiloop1","ibrahim1","Koçak1", MyImage.getImage().profile));
        User.addUsers(new User("Antiloop2","ibrahim2","Koçak2", MyImage.getImage().profile));

        Message message1 = new Message("Selam", getLocalDate(), Message.Status.DELIVERED);
        Message message2 = new Message("as", getLocalDate(), Message.Status.UNDELIVERED);

        FxMessage fxMessage = new FxMessageCame();
        fxMessage.setMessage("Antiloop2", "Antiloop1", message1);
        vBoxMessages.getChildren().add(fxMessage);

        fxMessage = new FxMessageGone();
        fxMessage.setMessage("Antiloop1", "Antiloop2",message2);
        vBoxMessages.getChildren().add(fxMessage);




        FxProfile profile = new FxProfile();
        anchorProfile.getChildren().add(profile);


        for (int i = 0; i < 100; i++) {
            FxMessageOwner messageOwner = new FxMessageOwner();
            messageOwner.setMessageOwnerPicture(MyImage.getImage().profile);

            if(i==0) {
                FxMessageOwner.setLastClicked(messageOwner);
                messageOwner.getStyleClass().add("Selection");
            }

            messageOwner.buttonWork(true);
            vBoxMessageOwner.getChildren().add(messageOwner);
        }
/*
        for (int i = 0; i < 50; i++) {

            FxMessage fxMessage = FxMessage.getMessage(FxMessage.EnumMessage.CAME);
            messagesVBox.getChildren().add(fxMessage);
            fxMessage.getMessageText().setMessageText("Merhaba Nasılsın ?");
            fxMessage.setIsCheck(Message.Status.DELIVERED);
            fxMessage.setPicture(MyImages.getImage().profile);

            fxMessage = FxMessage.getMessage(FxMessage.EnumMessage.GONE);
            messagesVBox.getChildren().add(fxMessage);
            fxMessage.getMessageText().setMessageText("Merhaba Nasılsın ?");
            fxMessage.setIsCheck(false);
            fxMessage.setPicture(MyImages.getImage().profile);
        }
*/
        buttonWork(true);

    }


    private void buttonWork(boolean isWork) {

        if(isWork)
            textFieldMessage.setOnKeyPressed(keyEvent -> {

                if(keyEvent.getCode().equals(KeyCode.ENTER))
                    onActionMessageSendButton();
            });
        else
            textFieldMessage.setOnKeyPressed(keyEvent -> { });

    }

    @FXML
    private void onActionMessageSendButton(){
        printMessage();
    }

    private void printMessage(){

        if(!textFieldMessage.getText().equals("")){

            FxMessage fxMessage = new FxMessageGone();
            fxMessage.setMessage(userLogged.getUserName(), "Antiloop2", new Message(textFieldMessage.getText(), getLocalDate(), Message.Status.UNDELIVERED));
            vBoxMessages.getChildren().add(fxMessage);
            textFieldMessage.setText("");
        }
    }

    private String getLocalDate(){
        //return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
    }

    public AnchorPane getAnchorProfile() {
        return anchorProfile;
    }

    public void setAnchorProfile(AnchorPane anchorProfile) {
        anchorProfile = anchorProfile;
    }

    public VBox getVBoxMessageOwner() {
        return vBoxMessageOwner;
    }

    public void setVBoxMessageOwner(VBox messageOwnerVBox) {
        this.vBoxMessageOwner = messageOwnerVBox;
    }

    public VBox getVBoxMessages() {
        return vBoxMessages;
    }

    public void setMessagesVBox(VBox messagesVBox) {
        this.vBoxMessages = messagesVBox;
    }
}
