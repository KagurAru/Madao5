package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MapWinForms {

    @FXML
    private Button map1;

    @FXML
    private ImageView image;

    @FXML
    private Button map2;

    @FXML
    private Button map3;

    @FXML
    private Button back;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    void initialize() {
    Template template = new Template();
        template.Cursor(map1);
        template.Cursor(back);
        template.Cursor(map2);
        template.Cursor(map3);

        map1.setOnAction(actionEvent -> {
            image.setOpacity(1);
            image2.setOpacity(0);
            image3.setOpacity(0);
        });
        map2.setOnAction(actionEvent -> {
            image.setOpacity(0);
            image2.setOpacity(1);
            image3.setOpacity(0);
        });
        map3.setOnAction(actionEvent -> {
            image.setOpacity(0);
            image2.setOpacity(0);
            image3.setOpacity(1);
        });

        back.setOnAction(actionEvent -> {
            template.window("head",back);
        });
    }
}
