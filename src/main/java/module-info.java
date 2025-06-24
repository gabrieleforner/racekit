module com.racekit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires atlantafx.base;

    opens com.racekit to javafx.fxml;
    exports com.racekit;
    exports com.racekit.uicontrollers;
    opens com.racekit.uicontrollers to javafx.fxml;
}