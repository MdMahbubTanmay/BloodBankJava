package com.mahbub.bloodbank.bloodbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.*;


public class HelloController {
    @FXML private TextField nameField, mobileField;
    @FXML private PasswordField passField;
    @FXML private ComboBox<String> bloodGroupCombo, districtCombo;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {

        bloodGroupCombo.getItems().addAll("A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-");


        districtCombo.getItems().addAll("Bagerhat", "Bandarban", "Barguna", "Barishal", "Bhola", "Bogra", "Brahmanbaria",
                "Chandpur", "Chapainawabganj", "Chattogram", "Chuadanga", "Cumilla", "Cox's Bazar",
                "Dhaka", "Dinajpur", "Faridpur", "Feni", "Gaibandha", "Gazipur", "Gopalganj",
                "Habiganj", "Jamalpur", "Jashore", "Jhalokathi", "Jhenaidah", "Joypurhat",
                "Khagrachari", "Khulna", "Kishoreganj", "Kurigram", "Kushtia", "Lakshmipur",
                "Lalmonirhat", "Madaripur", "Magura", "Manikganj", "Meherpur", "Moulvibazar",
                "Munshiganj", "Mymensingh", "Naogaon", "Narail", "Narayanganj", "Narsingdi",
                "Natore", "Netrokona", "Nilphamari", "Noakhali", "Pabna", "Panchagarh",
                "Patuakhali", "Pirojpur", "Rajbari", "Rajshahi", "Rangamati", "Rangpur",
                "Satkhira", "Shariatpur", "Sherpur", "Sirajganj", "Sunamganj", "Sylhet",
                "Tangail", "Thakurgaon");
    }

    @FXML
    protected void onSignupClick() {
        String sql = "INSERT INTO users (name, mobile, password, blood_group, district) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nameField.getText());
            pstmt.setString(2, mobileField.getText());
            pstmt.setString(3, passField.getText());
            pstmt.setString(4, bloodGroupCombo.getValue());
            pstmt.setString(5, districtCombo.getValue());

            pstmt.executeUpdate();
            statusLabel.setText("Success: Account Created!");
            statusLabel.setStyle("-fx-text-fill: #9ece6a;");

        } catch (SQLException e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    protected void onBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}