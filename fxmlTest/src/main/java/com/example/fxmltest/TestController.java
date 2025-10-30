package com.example.fxmltest;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;

public class TestController
{

    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn<Student ,Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<Student ,String> deptCol;
    @javafx.fxml.FXML
    private TableView<Student> studentTableView;
    @javafx.fxml.FXML
    private ComboBox<String> deptComboBox;
    ArrayList<Student> students = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
//        set combobox items
        deptComboBox.getItems().addAll("CSE", "EEE", "MB", "BC", "MIS");

//        map column with corresponding field
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        deptCol.setCellValueFactory(new PropertyValueFactory<>("dept"));


    }

    @javafx.fxml.FXML
    public void handleOnClick(Event event) {
        System.out.println("Hello");
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Course Type");
        a.setHeaderText("Course classification");
        a.setContentText("This is a Lab course");
        a.showAndWait();
    }


//    @javafx.fxml.FXML
//    public void handleOnClick() {
//        String text = inputTextField1.getText();
//        outputText.setText(text);
//        String text = inputComboBox.getValue();
//        outputText.setText(text);
//        boolean isSelected = checkBox.isSelected();
//        System.out.println(isSelected);
//        String gender = "";
//        if (femaleRadioButton.isSelected()){
//            gender = "Female";
//        } else if (maleRadioButton.isSelected()){
//            gender = "Male";
//        } else if(otherRadioButton.isSelected()){
//            gender = "Other";
//        }
//
//        outputLabel.setText(gender);
////
//        outputText.setText(gender);


//        LocalDate date = datePicker.getValue();
//        System.out.println(date.toString());

//        Student s = new Student(Integer.parseInt(idTextField.getText()), deptComboBox.getValue());
//        students.add(s);
//
//        studentTableView.getItems().clear();
//        for (Student std: students){
//            studentTableView.getItems().add(std);
//        }

//        System.out.println("Hello");

//    }
}
//[1, 2, 3] arraylist

//[1, 2, 3] tableview list