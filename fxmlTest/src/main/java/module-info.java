module com.example.fxmltest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.fxmltest to javafx.fxml;
    exports com.example.fxmltest;
}