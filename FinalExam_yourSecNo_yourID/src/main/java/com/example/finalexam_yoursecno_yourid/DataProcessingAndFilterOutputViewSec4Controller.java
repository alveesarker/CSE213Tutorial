package com.example.finalexam_yoursecno_yourid;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class DataProcessingAndFilterOutputViewSec4Controller
{
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML
    private TableColumn<JobApplicationToString, String> toStringOfjobAppInsCol;
    @javafx.fxml.FXML
    private TableView<JobApplicationToString> jobApplicationTableView;
    @javafx.fxml.FXML
    private ComboBox<Integer> minYearOfExpComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("Software Engineer", "Python developer", "Java developer", "ML Engineer");
        minYearOfExpComboBox.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7);

        toStringOfjobAppInsCol.setCellValueFactory(new PropertyValueFactory<>("toString"));
    }

    @javafx.fxml.FXML
    public void handleLoadMatchedInstancesButton(ActionEvent actionEvent) {
        jobApplicationTableView.getItems().clear();
        File file = new File("JobApplication.bin");
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                try{
                    JobApplication ja = (JobApplication) ois.readObject();
                    if (designationComboBox.getValue().equals(ja.getDesignationAppliedFor()) && ja.getYearOfExperience() >= minYearOfExpComboBox.getValue()){
                        String jobAppToString = ja.toString();
                        JobApplicationToString jatoString = new JobApplicationToString(jobAppToString);
                        jobApplicationTableView.getItems().add(jatoString);
                    }
                } catch (EOFException e){
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}