package com.example.myproject;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Arithmetic
{
    @javafx.fxml.FXML
    private TextField a;
    @javafx.fxml.FXML
    private TextField b;
    @javafx.fxml.FXML
    private Text result;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void add() {
        String a_value = a.getText();
        String b_value = b.getText();
        float a_int = Float.parseFloat(a_value);
        float b_int = Float.parseFloat(b_value);
        float res = a_int + b_int;
        result.setText(Float.toString(res));
    }

    @javafx.fxml.FXML
    public void mult() {

        String a_value = a.getText();
        String b_value = b.getText();
        int a_int = Integer.parseInt(a_value);
        int b_int = Integer.parseInt(b_value);
        float res = a_int * b_int;
        result.setText(Float.toString(res));
    }
}

