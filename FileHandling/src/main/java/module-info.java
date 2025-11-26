module com.example.filehandling {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.filehandling to javafx.fxml;
    exports com.example.filehandling;
}