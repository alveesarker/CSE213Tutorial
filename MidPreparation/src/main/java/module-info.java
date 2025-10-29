module com.example.midpreparation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.midpreparation to javafx.fxml;
    exports com.example.midpreparation;
}