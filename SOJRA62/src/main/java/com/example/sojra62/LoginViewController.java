package com.example.sojra62;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController {
    @javafx.fxml.FXML
    private TextField idTextfield;
    @javafx.fxml.FXML
    private PasswordField passTextField;

    @javafx.fxml.FXML
    public void initialize() {
        HelperClass.candidate = new Candidate("123", "abc", "abc@example.com", "abc123", "+8808888", "Dhaka", "BSC", "APP DEV", 3);
        HelperClass.hrManager = new HRManager("456", "def", "def@example.com", "def456", "+8805555", "XYZ", "hr");
    }

    @javafx.fxml.FXML
    public void handleLogInButton(ActionEvent actionEvent) throws IOException {
        if (idTextfield.getText().equals(HelperClass.hrManager.getId()) && passTextField.getText().equals(HelperClass.hrManager.getPassword())) {
            HelperClass.sceneSwitch(actionEvent, "rec-dash-view.fxml", "Dashboard");
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Your id or password was wrong!");
            a.showAndWait();
        }
    }
}