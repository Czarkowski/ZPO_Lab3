module com.example.zpo_lab3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zpo_lab3 to javafx.fxml;
    exports com.example.zpo_lab3;
}