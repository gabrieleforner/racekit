package com.racekit.uicontrollers;

import atlantafx.base.theme.*;
import com.racekit.core.SettingsSingleton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.File;


public class ConnectionController {

    @FXML
    private TextField udpAddressField;
    @FXML
    private TextField udpPortField;
    @FXML
    private ChoiceBox<String> gameFormatField;
    @FXML
    private ChoiceBox<String> appThemePicker;

    @FXML
    public void initialize() {
        if(SettingsSingleton.getInstance().getPort() != null) {
            udpPortField.setText(SettingsSingleton.getInstance().getPort().toString());
        }
        if(SettingsSingleton.getInstance().getHost() != null) {
            udpAddressField.setText(SettingsSingleton.getInstance().getHost());
        }
        if(SettingsSingleton.getInstance().getDataFormat() != null) {
            gameFormatField.setValue(SettingsSingleton.getInstance().getDataFormat());
        }
    }
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
    @FXML
    public void applySettings(ActionEvent event) {
        String host = udpAddressField.getText();
        String portText = udpPortField.getText();
        String format = gameFormatField.getValue();
        String theme = appThemePicker.getValue();

        boolean isPortValid = false;

        try {
            if (host != null && !host.isBlank()) { SettingsSingleton.getInstance().setHost(host.trim()); }
            if (portText != null && !portText.isBlank()) {
                int port = Integer.parseInt(portText.trim());
                SettingsSingleton.getInstance().setPort(port);
            }

            if (format != null) { SettingsSingleton.getInstance().setDataFormat(format); }
            if (theme != null) {
                switch (theme) {
                    case "Primer Light" -> Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
                    case "Primer Dark" -> Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
                    case "Cupertino Light" -> Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
                    case "Cupertino Dark" -> Application.setUserAgentStylesheet(new CupertinoDark().getUserAgentStylesheet());
                    case "Nord Light" -> Application.setUserAgentStylesheet(new NordLight().getUserAgentStylesheet());
                    case "Nord Dark" -> Application.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());
                }
            }
            isPortValid = true;
        } catch (NumberFormatException e) {
            Stage cpSubStage = new Stage();
            cpSubStage.initModality(Modality.APPLICATION_MODAL);
            cpSubStage.setTitle("RaceKit | UDP/IP Settings");

            Text message = new Text("Invalid port number: " + portText);
            VBox layout = new VBox(10, message);
            layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

            Scene scene = new Scene(layout, 300, 100);
            cpSubStage.setScene(scene);
            cpSubStage.showAndWait();
        }
        if (isPortValid) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}
