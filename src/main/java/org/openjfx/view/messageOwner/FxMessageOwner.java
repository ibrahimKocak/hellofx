package org.openjfx.view.messageOwner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class FxMessageOwner extends HBox {

    @FXML
    private Circle messageOwnerPicture;

    @FXML
    private Label messageOwner;

    @FXML
    private Circle messageOwnerStatus;

    @FXML
    private Label message;

    @FXML
    private Label messageTime;

    @FXML
    private Label messageCount;

    private static FxMessageOwner lastClicked;

    public FxMessageOwner(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MessageOwner.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        this.getStyleClass().add("nonSelection");

        try {
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
        buttonWork(true);
    }


    public void buttonWork(boolean isWork) {

        if(isWork)
            this.setOnMouseClicked(mouseEvent -> {

                if(mouseEvent.getButton() == MouseButton.PRIMARY){

                    lastClicked.getStyleClass().clear();
                    lastClicked.getStyleClass().add("nonSelection");
                    this.getStyleClass().clear();
                    this.getStyleClass().add("Selection");
                    lastClicked = this;
                }
            });
        else
            this.setOnMouseClicked(mouseEvent -> { });

    }

    public Circle getMessageOwnerPicture() {
        return messageOwnerPicture;
    }

    public void setMessageOwnerPicture(Image image) {
        this.messageOwnerPicture.setFill(new ImagePattern(image));
    }

    public Label getMessageOwner() {
        return messageOwner;
    }

    public void setMessageOwner(String text) {
        this.messageOwner.setText(text);
    }

    public Circle getMessageOwnerStatus() {
        return messageOwnerStatus;
    }

    public void setMessageOwnerStatus(boolean isOnline) {
        if(isOnline)
            this.messageOwnerStatus.setFill(Color.GREEN);
        else
            this.messageOwnerStatus.setFill(Color.GREY);
    }

    public Label getMessage() {
        return message;
    }

    public void setMessage(String text) {
        this.message.setText(text);
    }

    public Label getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String time) {
        this.messageTime.setText(time);
    }

    public Label getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount.setText(messageCount.toString());
    }

    public static FxMessageOwner getLastClicked() {
        return lastClicked;
    }

    public static void setLastClicked(FxMessageOwner lastClicked) {
        FxMessageOwner.lastClicked = lastClicked;
    }
}
