module com.example.midexampractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.midexampractice to javafx.fxml;
    exports com.example.midexampractice;
}