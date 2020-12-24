package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Template {

    // запускает новое окно и закрывает старое
    public void window (String string, Node node){
        node.getScene().getWindow().hide();
        String link = String.format("Fxml/%s.fxml",string);
        try {
            Parent root = FXMLLoader.load(getClass().getResource(link));
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // открывает окно с ошибкой
    public void error(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Fxml/error.fxml"));
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ошибка");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // меняет стиль курсора при наведении мыши на кнопку
    public void Cursor(Node node){
        node.setOnMouseEntered(event -> {node.setCursor(Cursor.HAND);});
        node.setOnMouseExited(event -> {node.setCursor(Cursor.DEFAULT);});
    }
}
