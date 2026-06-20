package com.mahbub.bloodbank.bloodbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML private TextField loginMobileField;
    @FXML private PasswordField loginPassField;
    @FXML private Label loginStatusLabel;

    @FXML
    protected void onLoginClick(ActionEvent event) throws IOException {
        String sql = "SELECT * FROM users WHERE mobile = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, loginMobileField.getText());
            pstmt.setString(2, loginPassField.getText());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(loader.load()));
                stage.show();

            } else {
                loginStatusLabel.setText("Invalid credentials!");
            }
        } catch (SQLException e) {
            loginStatusLabel.setText("DB Error!");
        }
    }

    @FXML
    protected void goToSignup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}