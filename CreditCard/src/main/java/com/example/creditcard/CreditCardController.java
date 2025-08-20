package com.example.creditcard;

public class CreditCardController
{
    @javafx.fxml.FXML
    private TableColumn holderNameCol;
    @javafx.fxml.FXML
    private TableColumn cardTypeCol;
    @javafx.fxml.FXML
    private Button addButton;
    @javafx.fxml.FXML
    private TextField creditLimitTextField;
    @javafx.fxml.FXML
    private TableColumn gatewayCol;
    @javafx.fxml.FXML
    private TextField holderNameTextField;
    @javafx.fxml.FXML
    private TableColumn creditLimitCol;
    @javafx.fxml.FXML
    private TableColumn dateOfExpCol;
    @javafx.fxml.FXML
    private DatePicker dateExpDatePicker;
    @javafx.fxml.FXML
    private TableView crditCardTableView;
    @javafx.fxml.FXML
    private ComboBox cardTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox gatewayNameComboBox;
    @javafx.fxml.FXML
    private TextField cardNoTTextField;
    @javafx.fxml.FXML
    private TableColumn cardNoCol;

    public CreditCardController(TextField creditLimitTextField) {
        this.creditLimitTextField = creditLimitTextField;
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCardNoOnCange(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddCreditCardButton(ActionEvent actionEvent) {
    }
}