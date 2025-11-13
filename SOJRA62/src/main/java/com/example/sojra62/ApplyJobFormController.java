package com.example.sojra62;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class ApplyJobFormController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private Text companyNameText;
    @javafx.fxml.FXML
    private Text titleText;
    @javafx.fxml.FXML
    private Text salaryText;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "jobs-view.fxml", "Post Job");
    }

    @javafx.fxml.FXML
    public void handleApplyButton(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Your job application has been successful!");
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        for (Job j: HelperClass.jobArrayList){
            if (j.getJobTitle().equals(titleTextField.getText())){
                companyNameText.setText(j.getCompanyName());
                titleText.setText(j.getJobTitle());
                salaryText.setText(Double.toString(j.getSalary()));
            }
        }
    }
}