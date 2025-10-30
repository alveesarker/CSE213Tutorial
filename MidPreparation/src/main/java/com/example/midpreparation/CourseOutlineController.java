package com.example.midpreparation;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CourseOutlineController {
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> titleCol;
    @javafx.fxml.FXML
    private ComboBox<String> preq_1ComboBox;
    @javafx.fxml.FXML
    private TextField yearTextField;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> courseIdCol;
    @javafx.fxml.FXML
    private ComboBox<String> filteredSemesterComboBox;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> semComboBox;
    @javafx.fxml.FXML
    private TextField noOfCreditTextField;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, Integer> yearCol;
    @javafx.fxml.FXML
    private ComboBox<String> preq_3ComboBox;
    @javafx.fxml.FXML
    private TextField filteredNumOfCreditTextField;
    @javafx.fxml.FXML
    private Label processLabel;
    @javafx.fxml.FXML
    private ComboBox<String> preq_2ComboBox;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> semCol;
    @javafx.fxml.FXML
    private TableView<CourseOutline> courseTableView;
    @javafx.fxml.FXML
    private TextField courseIdTextField;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, Integer> noOfCreditCol;
    private final ArrayList<CourseOutline> outlineList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        semComboBox.getItems().addAll("Spring", "Summer", "Autumn");
        filteredSemesterComboBox.getItems().addAll("Spring", "Summer", "Autumn");
        preq_1ComboBox.getItems().addAll("None", "CSC101", "CSE203", "CSE211", "CSE213");
        preq_2ComboBox.getItems().addAll("None", "CSC101", "CSE203", "CSE211", "CSE213");
        preq_3ComboBox.getItems().addAll("None", "CSC101", "CSE203", "CSE211", "CSE213");

        courseIdCol.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        noOfCreditCol.setCellValueFactory(new PropertyValueFactory<>("noOfCredits"));
        semCol.setCellValueFactory(new PropertyValueFactory<>("semester"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
    }

    @javafx.fxml.FXML
    public void handleAddButton(ActionEvent actionEvent) {
//        String courseId, String courseTitle, String prReq1, String preReq2,
//                String preReq3, String semester, String description, int noOfCredits, int year

        if (!preq_3ComboBox.getValue().equals("None")){
            if (preq_1ComboBox.getValue().equals("None") || preq_2ComboBox.getValue().equals("None")){
                errorAlert("Preq 1 and 2 cannot be None");
                return;
            }
        }

        if (preq_1ComboBox.getValue().equals("None")){
            if (!preq_3ComboBox.getValue().equals("None") || !preq_2ComboBox.getValue().equals("None")){
                errorAlert("preq 2 and 3 must be None");
                return;
            }
        }

//        LocalDate today = new LocalDa
        if (Integer.parseInt(yearTextField.getText()) > LocalDate.now().getYear()){
            errorAlert("Year cannot be future year!");
            return;
        }

        CourseOutline co = new CourseOutline(
                courseIdTextField.getText(),
                titleTextField.getText(),
                preq_1ComboBox.getValue(),
                preq_2ComboBox.getValue(),
                preq_3ComboBox.getValue(),
                semComboBox.getValue(),
                descriptionTextArea.getText(),
                Integer.parseInt(noOfCreditTextField.getText()),
                Integer.parseInt(yearTextField.getText())
        );

        outlineList.add(co);
        errorAlert("successfully added to the arraylist");
        System.out.println(outlineList);

    }

    @javafx.fxml.FXML
    public void handleShowSemButton(ActionEvent actionEvent) {
        int count = courseTableView.getItems().size();
        processLabel.setText(Integer.toString(count));
    }

    @javafx.fxml.FXML
    public void handleFilterButton(ActionEvent actionEvent) {
        courseTableView.getItems().clear();
        for(CourseOutline co: outlineList){
            if(Integer.parseInt(filteredNumOfCreditTextField.getText()) == co.getNoOfCredits() && filteredSemesterComboBox.getValue().equals(co.getSemester())){
                courseTableView.getItems().add(co);
            }
        }
    }

    public void errorAlert(String s){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(s);
        a.showAndWait();
    }
}