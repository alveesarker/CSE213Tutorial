module com.example.sojra62 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sojra62 to javafx.fxml;
    exports com.example.sojra62;
}