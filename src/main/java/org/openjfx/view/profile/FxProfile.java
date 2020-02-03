package org.openjfx.view.profile;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.openjfx.view.bin.MyConfig;
import org.openjfx.view.bin.MyImage;

import java.io.IOException;

public class FxProfile extends AnchorPane {

    @FXML
    private Circle circle;

    public FxProfile() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }

    }

    @FXML
    private void initialize() {

        this.circle.setFill(new ImagePattern(MyImage.getImage().profile));
        MyConfig.AnchorPaneConst(this,0.0,0.0,0.0,0.0);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
