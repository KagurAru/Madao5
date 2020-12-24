package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.FileWriter;
import java.io.IOException;

public class TechsupportWinForms {

    @FXML
    private TextArea Text;

    @FXML
    private Button send;

    @FXML
    private Button Back;

    @FXML
    void initialize() {
        Template template = new Template();
        template.Cursor(send);
        template.Cursor(Back);

        send.setOnAction(actionEvent -> {
            System.out.println(Text.getText());

            try(FileWriter writer = new FileWriter("Tech.txt", false))
            {
                writer.append(Text.getText());
                writer.flush();
                template.window("head",Back);
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        });
        Back.setOnAction(actionEvent -> {
            template.window("head",Back);
        });
    }
}
