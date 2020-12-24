package sample;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class ErrorWinForms {

    @FXML
    private Button but;

    @FXML
    void initialize() {
        but.setOnAction(event -> {
            but.getScene().getWindow().hide();
        });
        but.setOnMouseEntered(event -> {but.setCursor(Cursor.HAND);});
        but.setOnMouseExited(event -> {but.setCursor(Cursor.DEFAULT);});
    }
}
