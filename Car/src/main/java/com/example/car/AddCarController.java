package com.example.car;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AddCarController
{
    @javafx.fxml.FXML
    private TableView<Car> carTableView;
    @javafx.fxml.FXML
    private TableColumn<Car, String> brandCol;
    @javafx.fxml.FXML
    private TableColumn<Car, String> colorCol;
    @javafx.fxml.FXML
    private ComboBox<String> colorComboBox;
    @javafx.fxml.FXML
    private TextField brandTextField;
    private ArrayList<Car> cars = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        colorComboBox.getItems().addAll("Red", "Black", "Green", "Blue");

        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));

    }

    @javafx.fxml.FXML
    public void handleAddButton(ActionEvent actionEvent) {
        Car car = new Car(
                brandTextField.getText(),
                colorComboBox.getValue()
        );

        cars.add(car);
        System.out.println(this.cars);
    }

    @javafx.fxml.FXML
    public void handleShowButton(ActionEvent actionEvent) {
        carTableView.getItems().clear();
        for (Car c: cars){
            carTableView.getItems().add(c);
        }
    }
}