module com.example.creditcardm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.creditcardm to javafx.fxml;
    exports com.example.creditcardm;
}