module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.view to javafx.fxml;
    opens org.openjfx.view.message to javafx.fxml;
    opens org.openjfx.view.messageOwner to javafx.fxml;
    opens org.openjfx.view.profile to javafx.fxml;
    opens org.openjfx.view.message.messageParts to javafx.fxml;

    exports org.openjfx;
}
