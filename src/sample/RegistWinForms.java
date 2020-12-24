package sample;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class RegistWinForms {

    @FXML
    private Button registerBut;

    @FXML
    private TextField SurnameTex;

    @FXML
    private PasswordField passTex;

    @FXML
    private TextField NameTex;

    @FXML
    private PasswordField passTex1;

    @FXML
    private Button backBut;

    @FXML
    private Circle LAmp;

    @FXML
    void initialize() {
        Template template = new Template();
        backBut.setOnAction(event -> {
            template.window("sample",backBut);
        });
        registerBut.setOnAction(actionEvent -> {
            if(SurnameTex.getText().equals("") || NameTex.getText().equals("") || passTex.getText().equals(""))
            {
                template.error();
            }
            else if(!passTex.getText().equals(passTex1.getText())){
               LAmp.setOpacity(1);
            }
            else {
                template.window("sample",registerBut);
                CreateUser();
            }
        });
        backBut.setOnMouseEntered(event -> {backBut.setCursor(Cursor.HAND);});
        backBut.setOnMouseExited(event -> {backBut.setCursor(Cursor.DEFAULT);});
        registerBut.setOnMouseEntered(event -> {registerBut.setCursor(Cursor.HAND);});
        registerBut.setOnMouseExited(event -> {registerBut.setCursor(Cursor.DEFAULT);});
    }
    // заносит пользователя в базу данных
    private void CreateUser(){
        DB db = new DB();
        User user = new User(SurnameTex.getText(),NameTex.getText(),passTex.getText());
        db.registration(user);
    }
}

