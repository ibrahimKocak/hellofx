package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openjfx.model.User;
import org.openjfx.view.FxMain;
import org.openjfx.view.bin.MyImage;

public class MainApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        FxMain.userLogged = new User("AntiLoop","ibrahim","Koçak", MyImage.getImage().profile);
        User.getUsers().put(FxMain.userLogged.getUserName(),FxMain.userLogged);

        Parent root = FXMLLoader.load(getClass().getResource("view/main.fxml"));

        Scene scene = new Scene(root,1000,700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.setMinHeight(400);
        stage.setMinWidth(800);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
