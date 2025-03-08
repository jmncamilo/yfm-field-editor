package utilities;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class Filters {

    public static void  filterIncrease(TextField txtIncrease) {
        txtIncrease.setTextFormatter(new TextFormatter<>(change -> {
        String newText = change.getControlNewText();
        if(newText.isBlank()) {
            return null;
        }

        if(!newText.matches("\\d+")) {
            return null;
        }

        int newTextNumber = Integer.parseInt(newText);

        if (newTextNumber >= 10 && newTextNumber <=1270) {
            return change;
        }

        return null; // Reject change if it does not fit with the range
        }));
    }

    public static void  filterDecrease(TextField txtDecrease) {
        txtDecrease.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if(newText.isBlank()) {
                return null;
            }

            if(!newText.matches("\\d+")) {
                return null;
            }

            int newTextNumber = Integer.parseInt(newText);

            if (newTextNumber >= 10 && newTextNumber <=1280) {
                return change;
            }

            return null; // Reject change if it does not fit with the range
        }));
    }
}
