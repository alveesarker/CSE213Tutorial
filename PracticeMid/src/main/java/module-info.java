module com.example.practicemid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicemid to javafx.fxml;
    exports com.example.practicemid;
}