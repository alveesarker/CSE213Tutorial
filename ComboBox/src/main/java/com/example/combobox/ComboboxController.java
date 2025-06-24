package com.example.combobox;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

public class ComboboxController
{
    @javafx.fxml.FXML
    private ComboBox<String> valueComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        valueComboBox.getItems().addAll("a", "b", "c");
    }

    @javafx.fxml.FXML
    public void handlePrintButton(ActionEvent actionEvent) {
        String s = valueComboBox.getValue();
        System.out.println(s);
    }
}