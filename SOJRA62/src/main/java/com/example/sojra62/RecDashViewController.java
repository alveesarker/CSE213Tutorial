package com.example.sojra62;


import javafx.event.ActionEvent;

import java.io.IOException;

public class RecDashViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handlePostJobButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "job-manage-view.fxml", "Job Manage");
    }

    @javafx.fxml.FXML
    public void handleLogOutButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "login-view.fxml", "Job Manage");
    }
}