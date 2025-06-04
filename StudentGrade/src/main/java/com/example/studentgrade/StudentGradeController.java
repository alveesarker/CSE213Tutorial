package com.example.studentgrade;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class StudentGradeController
{
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label showGradeTextField;
    @javafx.fxml.FXML
    private TextField marksTextField;


    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCalculate(ActionEvent actionEvent) {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("a");
        lists.add("b");
        lists.add("c");
        lists.add("d");
        lists.get(0);
        lists.set(1, "u");
        String name = nameTextField.getText();
        float marks = Float.parseFloat(marksTextField.getText());

        String grade = calculateGrade(marks);
        showGradeTextField.setText("Hello " + name + ", your grade is " + grade);
    }

    private String calculateGrade(float marks){
        String grade = "F";
        if (marks >= 90 && marks<= 100){
            grade = "A";
        } else if (marks >= 80 && marks< 90) {
            grade = "B";
        } else if (marks >= 70 && marks< 80) {
            grade = "C";
        } else if (marks >= 60 && marks< 70) {
            grade = "D";
        } else {
            grade = "F";
        }

        return grade;
    }


}