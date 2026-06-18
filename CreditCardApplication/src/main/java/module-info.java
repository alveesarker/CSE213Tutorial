module com.example.creditcardapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.creditcardapplication to javafx.fxml;
    exports com.example.creditcardapplication;
}