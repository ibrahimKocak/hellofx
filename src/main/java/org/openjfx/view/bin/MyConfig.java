package org.openjfx.view.bin;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class MyConfig {

    public static void AnchorPaneConst(Region region, double top, double right, double bottom, double left){

        AnchorPane.setTopAnchor(region, top);
        AnchorPane.setRightAnchor(region, right);
        AnchorPane.setBottomAnchor(region, bottom);
        AnchorPane.setLeftAnchor(region, left);
    }

    public static void makeCircleImage(Circle circle, Image image){

        circle.setFill(new ImagePattern(image));
    }

    public static void makeWithShadow(Circle circle, String path){

        Image image = new Image(path);
        circle.setFill(new ImagePattern(image));
        circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
    }
}
