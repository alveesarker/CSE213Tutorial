package com.example.creditcardapplication;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreditCardViewController
{
    @javafx.fxml.FXML
    private TextField cardNoTextField;
    @javafx.fxml.FXML
    private RadioButton visaRadioButton;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> holderNameCol;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> gatewayNameCol;
    @javafx.fxml.FXML
    private DatePicker dateOfExpiryDatePicker;
    @javafx.fxml.FXML
    private TextField creditLimitTextField;
    @javafx.fxml.FXML
    private ToggleGroup gateWayName;
    @javafx.fxml.FXML
    private TableView<CreditCard> creditCardTableView;
    @javafx.fxml.FXML
    private TextField holderNameTextField;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, Float> creditLimitCol;
    @javafx.fxml.FXML
    private TextField searchCreditLimitTextField;
    @javafx.fxml.FXML
    private RadioButton masterCardRadioButton;
    @javafx.fxml.FXML
    private Label showAvgLabel;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> cardNoCol;
    @javafx.fxml.FXML
    private ComboBox<String> searchGatewayNameComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> cardTypeComboBox;
    private ArrayList<CreditCard> cardList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        searchGatewayNameComboBox.getItems().addAll("Visa", "MasterCard");
        cardTypeComboBox.getItems().addAll("Silver", "Gold", "Platinum", "Titanium");

        cardNoCol.setCellValueFactory(new PropertyValueFactory<>("cardNo"));
        creditLimitCol.setCellValueFactory(new PropertyValueFactory<>("creditLimit"));
        gatewayNameCol.setCellValueFactory(new PropertyValueFactory<>("gatewayName"));
        holderNameCol.setCellValueFactory(new PropertyValueFactory<>("holderName"));
    }

    @javafx.fxml.FXML
    public void handleValidateAndAddNewCardToArrayList() {
//        validation
        if (cardNoTextField.getText().length() != 16){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Card No must be 16 digit long");
            a.showAndWait();
            return;
        }


//        create an instance
//
        String gatewayName = "Visa";
        if (visaRadioButton.isSelected()){
            gatewayName = "Visa";
        } else if(masterCardRadioButton.isSelected()){
            gatewayName = "MasterCard";
        }


        if (gatewayName.equals("Visa")){
            if(cardNoTextField.getText().charAt(0) != '4'){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("For Visa Card, Card No starts with 4");
                a.showAndWait();
                return;
            }
        } else if (gatewayName.equals("MasterCard")) {
            if(cardNoTextField.getText().charAt(0) != '5'){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("For MasterCard, Card No starts with 5");
                a.showAndWait();
                return;
            }
        }

        CreditCard cc = new CreditCard(
                cardNoTextField.getText(),
                holderNameTextField.getText(),
                gatewayName,
                cardTypeComboBox.getValue(),
                dateOfExpiryDatePicker.getValue(),
                Float.parseFloat(creditLimitTextField.getText())
        );

        cardList.add(cc);
//        creditCardTableView.getItems().clear();
//        creditCardTableView.getItems().addAll(cardList);
    }


    @javafx.fxml.FXML
    public void handleShowAverageCreditLimitfromLoadedTableView() {
        float sum = 0;
        for (CreditCard cc: creditCardTableView.getItems()){
            sum += cc.getCreditLimit();
        }

        float avgCreditLimit = sum / creditCardTableView.getItems().size();
        String strAvgCreditLimit = Float.toString(avgCreditLimit);

        showAvgLabel.setText("Average Credit Limit: " + strAvgCreditLimit);
    }

    @javafx.fxml.FXML
    public void handleSearchAndLoadTable() {
        creditCardTableView.getItems().clear();

        for (CreditCard creditCard: cardList){
            if (searchGatewayNameComboBox.getValue().equals(creditCard.getGatewayName()) && creditCard.getCreditLimit() >= Float.parseFloat(searchCreditLimitTextField.getText())){
                creditCardTableView.getItems().add(creditCard);
            }
        }
    }
}