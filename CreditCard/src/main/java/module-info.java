module com.example.creditcard {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.creditcard to javafx.fxml;
    exports com.example.creditcard;
}