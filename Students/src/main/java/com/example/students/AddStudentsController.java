package com.example.students;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class AddStudentsController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField cgpaTextField;
    @javafx.fxml.FXML
    private TableColumn<Student, Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> deptCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<Student> studentsTableView;
    @javafx.fxml.FXML
    private TableColumn<Student, Float> cgpaCol;
    @javafx.fxml.FXML
    private ComboBox<String> deptComboBox;
    private final ArrayList<Student> students = new ArrayList<>();
    @javafx.fxml.FXML
    private ComboBox<String> deptComboBox1;
    @javafx.fxml.FXML
    private TextField cgpaTextField1;

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        deptCol.setCellValueFactory(new PropertyValueFactory<>("dept"));
        cgpaCol.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        deptComboBox.getItems().addAll("CSE", "MIS", "ENG", "PHY", "Bangla");
        deptComboBox1.getItems().addAll("CSE", "MIS", "ENG", "PHY", "Bangla");
    }

    @javafx.fxml.FXML
    public void handleOnaddButton(ActionEvent actionEvent) {
        Student s = new Student(
                nameTextField.getText(),
                Integer.parseInt(idTextField.getText()),
                Float.parseFloat(cgpaTextField.getText()),
                deptComboBox.getValue()
        );

        students.add(s);

        studentsTableView.getItems().clear();
        for(Student st: students){
            studentsTableView.getItems().add(st);
        }
        System.out.println(students);

    }

    @javafx.fxml.FXML
    public void handleFilterButton(ActionEvent actionEvent) {
        studentsTableView.getItems().clear();
        for(Student s: students){
            if(s.getDept().equals(deptComboBox1.getValue()) && s.getCgpa() >= Float.parseFloat(cgpaTextField1.getText())){
                studentsTableView.getItems().add(s);
            }
        }

    }
}