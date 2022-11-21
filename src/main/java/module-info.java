module com.example.softmethproject4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.softmethproject4 to javafx.fxml;
    exports com.example.softmethproject4;
}