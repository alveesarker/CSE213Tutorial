module com.example.autumn24sol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.autumn24sol to javafx.fxml;
    exports com.example.autumn24sol;
}