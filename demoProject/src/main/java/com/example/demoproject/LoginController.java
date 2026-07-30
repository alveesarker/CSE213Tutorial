package com.example.demoproject;

import com.example.demoproject.utils.BinaryFileUtil;
import com.example.demoproject.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField userIDTextField;
    @javafx.fxml.FXML
    private PasswordField passTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleLogInButton(ActionEvent actionEvent) {
        String userID = userIDTextField.getText();
        String pass = passTextField.getText();
        if (userID.length() == 4){
            if (userID.equals("1234") && pass.equals("abc")){
                SceneSwitcher.switchScene(actionEvent, "/com/example/demoproject/admin-dashboard.fxml", "Admin Dashboard");
            } else{
                showAlert("Wrong id or pass!");
            }
        } else if (userID.length() == 7) {
            ArrayList<Student> studentArrayList = BinaryFileUtil.readObjects("data/students.bin");
            for(Student s: studentArrayList){
                if (s.getId().equals(userID) && s.getPass().equals(pass)){
                    SessionManager.student = s;
                    SceneSwitcher.switchScene(actionEvent, "/com/example/demoproject/student-dashboard.fxml", "Student Dashboard");
                    return;
                }
            }
            showAlert("Wrong id or pass");

        } else {
            showAlert("Wrong id or pass");
        }
    }

    public void showAlert(String s){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText(s);
        a.showAndWait();
    }
}