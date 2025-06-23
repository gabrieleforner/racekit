package com.racekit.uicontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.File;


public class ConnectionController {
    @FXML
    public void selectSettingsFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter formatFilter = new FileChooser.ExtensionFilter("XML File (*.xml)", "*.xml");    /* Filter only XML files */

        fileChooser.setTitle("RaceKit | Load settings file");
        fileChooser.getExtensionFilters().add(formatFilter);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            System.out.println("Loading settings from file: "+file.getName());
        }
    }
}
