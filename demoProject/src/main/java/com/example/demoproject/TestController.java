package com.example.demoproject;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TestController
{

    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn<Student, Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<Student> studentTable;

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("id"));

    }

    @javafx.fxml.FXML
    public void handleAddButton(ActionEvent actionEvent) {

        Student s = new Student(nameTextField.getText(), Integer.parseInt(idTextField.getText()));
        studentTable.getItems().add(s);
    }
}