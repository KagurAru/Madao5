package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.Scanner;

public class SchedulesWinForms {

    private int selectedIndex = -1;
    @FXML
    private ListView<String> List;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private Button cleat;

    @FXML
    private TextField Text;

    @FXML
    void initialize() {
        Template template = new Template();

        template.Cursor(add);
        template.Cursor(update);
        template.Cursor(delete);
        template.Cursor(cleat);

        ObservableList<String> x = Reader();
        List.setItems(x);
        System.out.println("Sas");

        List.setOnMouseClicked(event -> {
            String selectedItem = List.getSelectionModel().getSelectedItem();
            selectedIndex = List.getSelectionModel().getSelectedIndex();
            Text.setText(selectedItem);

        });
        add.setOnAction(actionEvent -> {
            x.add(Text.getText());
            Text.clear();
        });

        update.setOnAction(event -> {
            if (!Text.getText().equals(""))
                x.set(selectedIndex, Text.getText());
            else{
                x.remove(selectedIndex);
            }
        });

        delete.setOnAction(event -> {
            x.remove(selectedIndex);
        });

        cleat.setOnAction(event -> {
            Writer(x);
            template.window("head", cleat);
        });


    }
    // создает и записывает txt файл
    private static void Writer(ObservableList<String> x){

        try(FileWriter writer = new FileWriter("notes.txt", false))
        {
            for(int i = 0; i < x.size(); i++)
            {
                writer.append(x.get(i));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    // читает txt файл и создает список
    private static ObservableList<String> Reader(){
        ObservableList<String> x = FXCollections.observableArrayList();
        FileReader reader = null;
        try {
            reader = new FileReader("notes.txt");
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                x.add(scan.nextLine());
            }
            return x;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return x;
    }
}
