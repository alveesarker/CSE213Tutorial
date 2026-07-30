package com.example.demoproject;

import com.example.demoproject.utils.BinaryFileUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AddStudentController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn<Student, String> idCol;
    @javafx.fxml.FXML
    private TableView<Student> studentTableView;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        studentArrayList = BinaryFileUtil.readObjects("data/students.bin");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        studentTableView.getItems().clear();
        studentTableView.getItems().addAll(studentArrayList);
    }

    @javafx.fxml.FXML
    public void handleAddButton(ActionEvent actionEvent) {
        String studentID = idTextField.getText();
        String name = nameTextField.getText();
        String pass = passwordField.getText();

        if (studentID.length() != 7){
            showAlert("ID length must be 7");
            return;
        }

        for(Student s: studentArrayList){
            if (s.getId().equals(studentID)){
                showAlert("Duplicate id!");
                return;
            }
        }

        Student student = new Student(studentID, name, pass);
        BinaryFileUtil.appendObject("data/students.bin", student);
        showSuccessAlert("Added successfully.");
        initialize();
    }

    public void showAlert(String s){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText(s);
        a.showAndWait();
    }

    public void showSuccessAlert(String s){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(s);
        a.showAndWait();
    }
}