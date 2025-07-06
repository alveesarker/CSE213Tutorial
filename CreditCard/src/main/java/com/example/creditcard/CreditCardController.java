package com.example.creditcard;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreditCardController
{
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> holderNameCol;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> cardTypeCol;
    @javafx.fxml.FXML
    private TextField creditLimitTextField;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> gatewayCol;
    @javafx.fxml.FXML
    private TextField holderNameTextField;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, Float> creditLimitCol;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, LocalDate> dateOfExpCol;
    @javafx.fxml.FXML
    private DatePicker dateExpDatePicker;
    @javafx.fxml.FXML
    private TableView<CreditCard> crditCardTableView;
    @javafx.fxml.FXML
    private ComboBox<String> cardTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> gatewayNameComboBox;
    @javafx.fxml.FXML
    private TextField cardNoTTextField;
    @javafx.fxml.FXML
    private TableColumn<CreditCard ,String> cardNoCol;
    ArrayList<CreditCard> cardList = new ArrayList<>();
    @javafx.fxml.FXML
    private Button addButton;

    @javafx.fxml.FXML
    public void initialize() {
        cardNoCol.setCellValueFactory(new PropertyValueFactory<>("cardNo"));
        holderNameCol.setCellValueFactory(new PropertyValueFactory<>("holderName"));
        cardTypeCol.setCellValueFactory(new PropertyValueFactory<>("cardType"));
        creditLimitCol.setCellValueFactory(new PropertyValueFactory<>("creditLimit"));
        dateOfExpCol.setCellValueFactory(new PropertyValueFactory<>("dateOfExpiry"));
        gatewayCol.setCellValueFactory(new PropertyValueFactory<>("gatewayName"));

        cardTypeComboBox.getItems().addAll("silver", "gold","platinum","titanium");
        gatewayNameComboBox.getItems().addAll("Visa", "MasterCard");
    }

    @javafx.fxml.FXML
    public void handleAddCreditCardButton(ActionEvent actionEvent) {
        if (cardNoTTextField.getText().length() != 16){
            showAlert("Card number length must be 16!");
            return;
        }

        if (gatewayNameComboBox.getValue().equals("Visa") && cardNoTTextField.getText().charAt(0) != '4'){
            showAlert("Invalid card number!");
            return;
        } else if (gatewayNameComboBox.getValue().equals("MasterCard") && cardNoTTextField.getText().charAt(0) != '5') {
            showAlert("Invalid card Number!");
            return;

        }

        CreditCard creditCard = new CreditCard(
                cardNoTTextField.getText(),
                holderNameTextField.getText(),
                dateExpDatePicker.getValue(),
                gatewayNameComboBox.getValue(),
                Float.parseFloat(creditLimitTextField.getText()),
                cardTypeComboBox.getValue()
        );

        cardList.add(creditCard);

        crditCardTableView.getItems().clear();
        crditCardTableView.getItems().addAll(cardList);

        addButton.setText("Successful");
    }

    public void showAlert(String message){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText(message);
        a.showAndWait();
    }


    @javafx.fxml.FXML
    public void handleCardNoOnChange(ActionEvent actionEvent) {
        addButton.setText("Validate & Add New Card to ArrayList");
    }
}