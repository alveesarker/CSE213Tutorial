package com.example.sojra62;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class JobsViewController
{
    @javafx.fxml.FXML
    private TableColumn<Job, String> locationCol;
    @javafx.fxml.FXML
    private TableColumn<Job, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<Job, Double> salaryCol;
    @javafx.fxml.FXML
    private TableColumn<Job, String> jobTiltleCol;
    @javafx.fxml.FXML
    private TableColumn<Job, LocalDate> AppDeadlineCol;
    @javafx.fxml.FXML
    private TableView<Job> jobTableView;
    @javafx.fxml.FXML
    private TableColumn<Job, LocalDate> datePostedCol;
    @javafx.fxml.FXML
    private TableColumn<Job, String> compNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        compNameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        datePostedCol.setCellValueFactory(new PropertyValueFactory<>(""));
        jobTiltleCol.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        datePostedCol.setCellValueFactory(new PropertyValueFactory<>("postedDate"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("employmentType"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        AppDeadlineCol.setCellValueFactory(new PropertyValueFactory<>("deadline"));

        jobTableView.getItems().addAll(HelperClass.jobArrayList);
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "candidate-dash-view.fxml", "Post Job");
    }

    @javafx.fxml.FXML
    public void handleApplyForJobButton(ActionEvent actionEvent) throws IOException {
        HelperClass.sceneSwitch(actionEvent, "apply-job-form.fxml", "Post Job");
    }
}