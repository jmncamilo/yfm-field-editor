package models;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OpenSlus {
    public static File fileChooser(Stage stage) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open your SLUS_014.11 file"); // Title
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("SLUS_014", "*.11")); // Filter

        return fc.showOpenDialog(stage);
    }
}
