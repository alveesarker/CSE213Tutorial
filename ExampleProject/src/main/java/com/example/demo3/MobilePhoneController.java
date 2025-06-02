package com.example.demo3;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MobilePhoneController
{
    @javafx.fxml.FXML
    private TableColumn<Mobile, String> brandCol;
    @javafx.fxml.FXML
    private TableColumn<Mobile, String> nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TableView<Mobile> mobileTableView;
    @javafx.fxml.FXML
    private TextField brandTextFiled;
    @javafx.fxml.FXML
    private TableColumn<Mobile, Float> priceCol;

    @javafx.fxml.FXML
    public void initialize() {
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @javafx.fxml.FXML
    public void handleOnAddButton() {
        Mobile mobile = new Mobile(
                nameTextField.getText(),
                brandTextFiled.getText(),
                Float.parseFloat(priceTextField.getText())
        );

        mobileTableView.getItems().add(mobile);
    }
}