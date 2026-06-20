module com.mahbub.bloodbank.bloodbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.mahbub.bloodbank.bloodbank to javafx.fxml;
    exports com.mahbub.bloodbank.bloodbank;
}