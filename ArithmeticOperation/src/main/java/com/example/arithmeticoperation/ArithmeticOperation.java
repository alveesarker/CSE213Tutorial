package com.example.arithmeticoperation;

import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ArithmeticOperation
{

    @javafx.fxml.FXML
    private TextField numTwoTextFiled;
    @javafx.fxml.FXML
    private TableColumn<History, Integer> numOneCol;
    @javafx.fxml.FXML
    private TableColumn<History, Integer> numTwoCol;
    @javafx.fxml.FXML
    private TableColumn<History, Integer> sumCol;
    @javafx.fxml.FXML
    private TextField numOneTextFiled;
    @javafx.fxml.FXML
    private TableView<History> historyTableView;
    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    public void initialize() {
        numOneCol.setCellValueFactory(new PropertyValueFactory<>("numOne"));
        numTwoCol.setCellValueFactory(new PropertyValueFactory<>("numTwo"));
        sumCol.setCellValueFactory(new PropertyValueFactory<>("result"));
    }

    @javafx.fxml.FXML
    public void handleSumButtonClicked(Event event) {
        int numOne = Integer.parseInt(numOneTextFiled.getText());
        int numTwo = Integer.parseInt(numTwoTextFiled.getText());

        int sum = numOne + numTwo;

        resultLabel.setText(Integer.toString(sum));

        History history = new History(numOne, numTwo, sum);

        historyTableView.getItems().add(history);

    }
}