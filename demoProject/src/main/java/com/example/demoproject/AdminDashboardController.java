package com.example.demoproject;

import com.example.demoproject.utils.SceneSwitcher;
import javafx.event.ActionEvent;

public class AdminDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleAddStudentButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/com/example/demoproject/add-student.fxml", "Add Student");
    }

    @javafx.fxml.FXML
    public void handleLogoutButtonn(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/com/example/demoproject/login.fxml", "Login");
    }
}