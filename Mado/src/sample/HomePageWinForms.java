package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomePageWinForms {

    @FXML
    private Button Back;

    @FXML
    private Button Techsupport;

    @FXML
    private Button Schedule;

    @FXML
    private Button Menu;

    @FXML
    private Button Map;

    @FXML
    void initialize() {
        Template template = new Template();
        template.Cursor(Techsupport);
        template.Cursor(Schedule);
        template.Cursor(Menu);
        template.Cursor(Map);
        template.Cursor(Back);

        Back.setOnAction(event -> {
            template.window("sample",Back);
        });
        Techsupport.setOnAction(event -> {
            template.window("techsupport",Techsupport);
        });
        Schedule.setOnAction(event -> {
            template.window("schedules",Schedule);
        });
        Menu.setOnAction(event -> {
            template.window("menu",Menu);
        });
        Map.setOnAction(event -> {
            template.window("map",Map);
        });
    }
}
