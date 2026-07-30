package com.example.demoproject;

import com.example.demoproject.utils.BinaryFileUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class RegisterCourseController
{
    @javafx.fxml.FXML
    private ComboBox<String> courseComboBox;
    private Student loggedInStudent;

    @javafx.fxml.FXML
    public void initialize() {
        courseComboBox.getItems().addAll("OOP", "DS", "Algo", "DBMS");
        loggedInStudent = SessionManager.student;
    }

    @javafx.fxml.FXML
    public void handleRegisterButton(ActionEvent actionEvent) {
        RegCourse regCourse = new RegCourse(
                loggedInStudent.getId(),
                courseComboBox.getValue()
        );

        BinaryFileUtil.appendObject("data/gm1/regCourses.bin", regCourse);
        showSuccessAlert("Added successfully");

    }

    public void showSuccessAlert(String s){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(s);
        a.showAndWait();
    }
}