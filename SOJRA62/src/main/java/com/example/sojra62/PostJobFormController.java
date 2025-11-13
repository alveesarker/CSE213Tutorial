package com.example.sojra62;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class PostJobFormController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TextField salaryTextField;
    @javafx.fxml.FXML
    private DatePicker deadlineDatePicker;
    @javafx.fxml.FXML
    private TextField companyNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> locationComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> empTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        locationComboBox.getItems().addAll("Dhaka", "Remote");
        empTypeComboBox.getItems().addAll("Full-Time", "Part-Time", "Contract", "Internship");
    }

    @javafx.fxml.FXML
    public void handlePostJobButton(ActionEvent actionEvent) throws IOException {
//        ring companyName,
//        double salary,
//        String location,
//        String employmentType,
//        LocalDate deadline,
//        LocalDate postedDate
//)
        Job job = new Job(
                titleTextField.getText(),
                companyNameTextField.getText(),
                Double.parseDouble(salaryTextField.getText()),
                locationComboBox.getValue(),
                empTypeComboBox.getValue(),
                deadlineDatePicker.getValue(),
                LocalDate.now()
        );

        HelperClass.jobArrayList.add(job);
        HelperClass.sceneSwitch(actionEvent, "job-manage-view.fxml", "Post Job");
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "job-manage-view.fxml", "Post Job");
    }
}