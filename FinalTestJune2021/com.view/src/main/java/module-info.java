module com.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires data.modul;

    opens com.view to javafx.fxml;
    exports com.view;
}