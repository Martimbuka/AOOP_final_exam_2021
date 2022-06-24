package com.view;

import java.net.URL;
import java.util.ResourceBundle;

import data.modul.InventoryManagement;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea inventoryTxtArea;

    private InventoryManagement inventoryManagement;

    @FXML
    void findAverageOnAction() {
        inventoryTxtArea.setText(String.format("%.2f", inventoryManagement.averagePrice()));
    }

    @FXML
    void groupOnAction() {
        inventoryTxtArea.setText(inventoryManagement.findLargestPricePerCategory());
    }

    @FXML
    void quitOnAction() {
        Platform.exit();

    }

    @FXML
    void showInventoryOnAction() {
        inventoryTxtArea.setText(inventoryManagement.showInventory());
    }

    @FXML
    void sortOnAction() {
        inventoryTxtArea.setText("");
        inventoryManagement.sortInventoryTypeAndID()
                .stream()
                .forEach(inventory -> inventoryTxtArea.appendText(String.valueOf(inventory) + "\n"));
    }

    @FXML
    void initialize() {
        assert inventoryTxtArea != null : "fx:id=\"inventoryTxtArea\" was not injected: check your FXML file 'viewV2.fxml'.";
        inventoryManagement = new InventoryManagement();

    }

}
