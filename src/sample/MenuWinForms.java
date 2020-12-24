package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MenuWinForms {

    @FXML
    private ListView<String> ListBreakfast;

    @FXML
    private Button Back;

    @FXML
    private ListView<String> ListDinner;

    @FXML
    private ListView<String> ListLunch;

    @FXML
    void initialize() {
        Template template = new Template();
        template.Cursor(Back);
        DB db = new DB();
        ListBreakfast.setItems(db.getEat("Breakfast"));
        ListDinner.setItems(db.getEat("Dinner"));
        ListLunch.setItems(db.getEat("Lunch"));

        Back.setOnAction(actionEvent -> {
            template.window("head",Back);
        });
    }
}
