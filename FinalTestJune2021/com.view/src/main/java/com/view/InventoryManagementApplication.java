package com.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class InventoryManagementApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL fxmlLocation = getClass().getResource("viewV2.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(loader.load());
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}