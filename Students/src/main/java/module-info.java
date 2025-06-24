module com.example.students {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.students to javafx.fxml;
    exports com.example.students;
}