package com.example.demoproject;

import com.example.demoproject.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class StudentDashboardController
{
    @javafx.fxml.FXML
    private Text nameText;
    @javafx.fxml.FXML
    private Text studentIDText;

    @javafx.fxml.FXML
    public void initialize() {
        nameText.setText(SessionManager.student.getName());
        studentIDText.setText(SessionManager.student.getId());
    }

    @javafx.fxml.FXML
    public void handleRegisterCourseButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/com/example/demoproject/register-course.fxml", "Register Course");
    }

    @javafx.fxml.FXML
    public void handleLogoutButton(ActionEvent actionEvent) {
        SessionManager.student = null;
        SceneSwitcher.switchScene(actionEvent, "/com/example/demoproject/login.fxml", "Login");
    }
}