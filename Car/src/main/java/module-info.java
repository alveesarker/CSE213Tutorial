module com.example.car {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.car to javafx.fxml;
    exports com.example.car;
}