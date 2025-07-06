package com.example.midterm_5_2311249;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DataPackageController {
    @javafx.fxml.FXML
    private ComboBox<String> availabilityComboBox;
    @javafx.fxml.FXML
    private Text errorText;
    @javafx.fxml.FXML
    private TextField filterPriceComboBox;
    @javafx.fxml.FXML
    private TextField dataAmountTextField;
    @javafx.fxml.FXML
    private ComboBox<String> validityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> filterValidityComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField offerEndTextField;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TableView<DataPackage> packageTableView;
    @javafx.fxml.FXML
    private Text bestOfferText;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> validityCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> availabilityCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Integer> offerEndsCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Double> dataAmountCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Double> priceCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> nameCol;
    private ArrayList<DataPackage> dataPackages = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        validityCol.setCellValueFactory(new PropertyValueFactory<>("validity"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        dataAmountCol.setCellValueFactory(new PropertyValueFactory<>("dataAmount"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("packageName"));
        offerEndsCol.setCellValueFactory(new PropertyValueFactory<>("offerEnds"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        validityComboBox.getItems().addAll("3 Days", "7 Days", "15 Days", "30 Days", "Unlimited");
        filterValidityComboBox.getItems().addAll("3 Days", "7 Days", "15 Days", "30 Days", "Unlimited");
        availabilityComboBox.getItems().addAll("App Only", "Recharge Only", "App and recharge");

    }

    @javafx.fxml.FXML
    public void handleBestValueButton(ActionEvent actionEvent) {
        DataPackage bestPackage = dataPackages.getFirst();
        for (DataPackage dp : dataPackages) {
            if (dp.getPrice() / dp.getDataAmount() < bestPackage.getPrice() / bestPackage.getDataAmount()) {
                bestPackage = dp;
            }
        }

        bestOfferText.setText("Best package is " + bestPackage.getPackageName());
    }

    @javafx.fxml.FXML
    public void handleCreatePackage(ActionEvent actionEvent) {
        if (nameTextField.getText().isEmpty()) {
            errorText.setText("Enter Package Name!");
            return;
        }

        if (dataAmountTextField.getText().isEmpty()) {
            errorText.setText("Enter Data Amount!");
            return;
        }

        if (priceTextField.getText().isEmpty()) {
            errorText.setText("Enter Price!");
            return;
        }

        if (offerEndTextField.getText().isEmpty()) {
            errorText.setText("Enter Offer Ends!");
            return;
        }

        if (validityComboBox.getValue() == null) {
            errorText.setText("Select validity!");
            return;
        }

        if (availabilityComboBox.getValue() == null) {
            errorText.setText("Select availability!");
            return;
        }

        for (DataPackage dp : dataPackages) {
            if (dp.getPackageName().equals(nameTextField.getText())) {
                errorText.setText("Package Name must be unique!");
                return;
            }
        }

        DataPackage dataPackage = new DataPackage(
                nameTextField.getText(),
                Double.parseDouble(dataAmountTextField.getText()),
                validityComboBox.getValue(),
                Double.parseDouble(priceTextField.getText()),
                availabilityComboBox.getValue(),
                Integer.parseInt(offerEndTextField.getText())
        );


        for (DataPackage dp : dataPackages) {
            packageTableView.getItems().add(dp);

        }
    }

    @javafx.fxml.FXML
    public void handleResetFilterButton(ActionEvent actionEvent) {

        packageTableView.getItems().clear();
        packageTableView.getItems().addAll(dataPackages);
    }

    @javafx.fxml.FXML
    public void handleFilterButton(ActionEvent actionEvent) {
        packageTableView.getItems().clear();
        for (DataPackage dataPackage : dataPackages) {
            if (filterValidityComboBox.getValue().equals(dataPackage.getValidity()) && Double.parseDouble(filterPriceComboBox.getText()) >= dataPackage.getPrice()) {
                packageTableView.getItems().add(dataPackage);
            }
        }
    }
}