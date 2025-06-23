package com.racekit.uicontrollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StartupController {
    /**
     * @brief Controller for handling buttons
     * that shows up in the startup view (Start, UDP/IP Settings)
     */

    @FXML
    protected void onEditConnParams() throws IOException {
        Stage cpSubStage = new Stage();
        FXMLLoader viewLoader = new FXMLLoader(getClass().getResource("/com/racekit/ConnectionSettings.fxml"));
        Parent viewRoot = viewLoader.load();
        cpSubStage.initModality(Modality.APPLICATION_MODAL);
        cpSubStage.setTitle("RaceKit | UDP/IP Settings");
        cpSubStage.setScene(new Scene(viewRoot));
        cpSubStage.show();
    }
}