package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AuthorizationWinForms {
    @FXML
    private Button RegisBut;

    @FXML
    private Button enterBut;

    @FXML
    private TextField loginTex;

    @FXML
    private PasswordField passTex;

    @FXML
    private Circle Lemp;

    @FXML
    void initialize() {
        Template template = new Template();
        template.Cursor(RegisBut);
        template.Cursor(enterBut);

        RegisBut.setOnAction(event -> {
            template.window("regist",RegisBut);
        });
        enterBut.setOnAction(event -> {
            User user = new User(loginTex.getText(),passTex.getText());
            if(user.getSurname().equals("root") && user.getPassword().equals("root")){
                template.window("head",enterBut);

            }
            else{
                if(!user.getSurname().equals("") && !user.getPassword().equals("")){
                    loginUser(user);
                }
                else{
                    template.error();
                }
            }
        });

        if(DB.test() == true) Lemp.setFill(Color.GREEN);
        else Lemp.setFill(Color.RED);
    }

        private void loginUser(User user) // метод ищет пользователя в базе данных если находит открывает другое око иначе окно ошибка
    {
        DB db = new DB();
        Template template = new Template();
         if(db.getUser(user)== true){
             template.window("head",enterBut);
         }
         else{
             template.error();
         }
    }
}
