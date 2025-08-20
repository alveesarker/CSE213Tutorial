package com.example.test;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TestContrller
{
    @javafx.fxml.FXML
    private ToggleGroup gender;
    @javafx.fxml.FXML
    private ToggleGroup payment;
    @javafx.fxml.FXML
    private RadioButton other;
    @javafx.fxml.FXML
    private RadioButton femaleRadio;
    @javafx.fxml.FXML
    private RadioButton maleRadio;
    @javafx.fxml.FXML
    private Label showLabel;
    @javafx.fxml.FXML
    private TableView<Student> tableView;
    @javafx.fxml.FXML
    private TableColumn<Student, String> c1;
    @javafx.fxml.FXML
    private TableColumn<Student, String> c2;

    @javafx.fxml.FXML
    public void initialize() {
        c1.setCellValueFactory(new PropertyValueFactory<>("dept"));
        c2.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
    }

    @javafx.fxml.FXML
    public void handleShowButton(ActionEvent actionEvent) {

    }
}