package org.openjfx.view.message;

import javafx.geometry.Pos;
import org.openjfx.view.message.FxMessage;

public class FxMessageGone extends FxMessage {

    @Override
    protected void setMessageTemplate() {

        this.getChildren().add(this.getMessageDetail());
        this.getChildren().add(this.getMessageText());
        this.getChildren().add(this.getMessageOwnerPicture());
        this.setAlignment(Pos.CENTER_RIGHT);
    }
}
