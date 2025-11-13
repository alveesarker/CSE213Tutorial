package com.example.sojra62;

import javafx.event.ActionEvent;

import java.io.IOException;

public class CandidateDashViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleJobButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "jobs-view.fxml", "Post Job");
    }

    @javafx.fxml.FXML
    public void handleLogOutButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "login-view.fxml", "Post Job");
    }
}