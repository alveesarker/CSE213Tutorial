package com.example.finalexam_yoursecno_yourid;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataCreationToFileViewSec4Controller
{
    @javafx.fxml.FXML
    private CheckBox freshGradChcekBox;
    @javafx.fxml.FXML
    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML
    private TextField JobAppTextField;
    @javafx.fxml.FXML
    private TextField expertiseTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<Integer> expComboBox;
    @javafx.fxml.FXML
    private DatePicker dateOfApplicationDatePicker;
    private ArrayList<String> expertiseArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        designationComboBox.getItems().addAll("Software Engineer", "Python developer", "Java developer", "ML Engineer");
        expComboBox.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7);
    }

    @javafx.fxml.FXML
    public void ValidateandAppendNewJabApplicationInstance(ActionEvent actionEvent) {
        LocalDate applicationDate = dateOfApplicationDatePicker.getValue();
        LocalDate today = LocalDate.now();
        if(applicationDate.isAfter(today)){
            showAlert("Application date cannot be future date!");
            return;
        }

        if(freshGradChcekBox.isSelected()){
            if(expComboBox.getValue() != 0){
                showAlert("years of experience will be 0 for fresh graduate.");
                return;
            }
        }
//        int applicationNo, int yearOfExperience, String name, String designationAppliedFor, LocalDate dateOfApplication, boolean isFreshGraduate, ArrayList<String> expertiseList
        JobApplication ja = new JobApplication(
                Integer.parseInt(JobAppTextField.getText()),
                expComboBox.getValue(),
                nameTextField.getText(),
                designationComboBox.getValue(),
                dateOfApplicationDatePicker.getValue(),
                freshGradChcekBox.isSelected(),
                expertiseArrayList
        );
        expertiseArrayList.clear();
        File file = new File("JobApplication.bin");
        boolean exists = file.exists();
        try{
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = exists ? new AppendableObjectOutputStream(fos): new ObjectOutputStream(fos);
            oos.writeObject(ja);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        showConfirmationAlert("Job application has been added to the bin file...");
    }

    @javafx.fxml.FXML
    public void handleNextButton(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DataProcessingAndFilterOutputViewSec4.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void handleAddExpertiseButton(ActionEvent actionEvent) {
        expertiseArrayList.add(expertiseTextField.getText());
        expertiseTextField.setText("");
        showConfirmationAlert("Added successfully");

    }

    public void showAlert(String alertText){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(alertText);
        a.showAndWait();
    }

    public void showConfirmationAlert(String message){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(message);
        a.showAndWait();
    }
}