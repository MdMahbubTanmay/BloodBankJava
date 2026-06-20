package com.mahbub.bloodbank.bloodbank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class DashboardController {
    @FXML private ComboBox<String> searchBloodGroup, searchDistrict;
    @FXML private TableView<User> donorTable;
    @FXML private TableColumn<User, String> colName, colGroup, colDistrict, colMobile;

    @FXML
    public void initialize() {

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGroup.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        colDistrict.setCellValueFactory(new PropertyValueFactory<>("district"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));


        searchBloodGroup.getItems().addAll("A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-");
        searchDistrict.getItems().addAll("Bagerhat", "Bandarban", "Barguna", "Barishal", "Bhola", "Bogra", "Brahmanbaria",
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
    protected void onSearchClick() {
        ObservableList<User> donorList = FXCollections.observableArrayList();
        String group = searchBloodGroup.getValue();
        String district = searchDistrict.getValue();

        if (group == null || district == null) {
            System.out.println("Please select both fields.");
            return;
        }

        String sql = "SELECT name, blood_group, district, mobile FROM users WHERE blood_group = ? AND district = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, group);
            pstmt.setString(2, district);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                donorList.add(new User(
                        rs.getString("name"),
                        rs.getString("blood_group"),
                        rs.getString("district"),
                        rs.getString("mobile")
                ));
            }
            donorTable.setItems(donorList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onLogoutClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}