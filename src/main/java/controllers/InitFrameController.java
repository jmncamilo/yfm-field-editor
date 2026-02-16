package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.*;
import utilities.Alerts;
import utilities.Filters;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InitFrameController implements Initializable {
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnOpen;

    @FXML
    private ComboBox<String> cbId;

    @FXML
    private ComboBox<String> cbType;

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgMystic;

    @FXML
    private Label lblDeveloped;

    @FXML
    private Label lblEditValues;

    @FXML
    private Label lblId;

    @FXML
    private Label lblTitleOpen;

    @FXML
    private Label lblType;

    @FXML
    private Label lblValue;

    @FXML
    private RadioButton rdDecrease;

    @FXML
    private RadioButton rdIncrease;

    @FXML
    private Separator sep1;

    @FXML
    private Separator sep2;

    @FXML
    private Separator sep3;

    @FXML
    private TextField txtValue;

    private CardOffsets cardBase;

    private TypeIncrement typeIncrement;

    private File slus014;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Se ejecuta después de que el archivo FXML ha sido cargado
        cardBase = new CardOffsets(); // Creates new instance of class with the offsets
        cbId.setItems(FXCollections.observableArrayList(cardBase.getCardBaseOffset().keySet())); //Sets keys in the CB

        typeIncrement = new TypeIncrement(); // New instance of that types
        cbType.setItems(FXCollections.observableArrayList(typeIncrement.getTypeIncrement().keySet())); //Sets types in the CB

        ToggleGroup radioGroup = new ToggleGroup(); // Grouping radio buttons
        rdIncrease.setToggleGroup(radioGroup);
        rdDecrease.setToggleGroup(radioGroup);

        // Initializes slus014 file
        slus014 = null;
    }

    @FXML
    void clickOpen(ActionEvent event) {
        slus014 = OpenSlus.fileChooser((Stage) btnOpen.getScene().getWindow());
        if(slus014 != null){
            btnOpen.setDisable(true);
            System.out.println("File path: " + slus014); // TESTING
        } else {
            System.out.println("You must select the SLUS file...");
        }
    }

    @FXML
    void clickEdit(ActionEvent event) {
        // Guard clauses
        if(slus014 == null) {
            Alerts.alertErrorSlus();
            System.out.println("SLUS_014.11 file must be opened before editing..."); // TESTING CJ
            return;
        }

        if(!rdIncrease.isSelected() && !rdDecrease.isSelected()) {
            Alerts.alertIncreaseOrDecrease();
            System.out.println("Do you want to increase or decrease?"); // TESTING CJ
            return;
        }

        if(cbId.getValue() == null || cbType.getValue() == null) {
            Alerts.alertType();
            System.out.println("You must select a card and a type!");
            return;
        }

        if(txtValue.getText().isBlank()) {
            System.out.println("The value field cannot be empty!");
            return;
        }

        // Get the value to write
        String textValue = txtValue.getText();
        byte valueToWrite;

        try {
            valueToWrite = (rdIncrease.isSelected())
                    ? ConvertValues.convertIncrease(textValue)
                    : ConvertValues.convertDecrease(textValue);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("El valor byte es: " + valueToWrite); // TESTING
        System.out.println("El valor hex es: " + String.format("0x%02X", valueToWrite)); // TESTING

        // Get the current offset to write
        long currentOffset = cardBase.getCardBaseOffset().get(cbId.getValue());

        // Calling function to write SLUS file and DONE
        WritingSlus.write(valueToWrite, currentOffset, slus014);
    }

    @FXML
    void clickDelete(ActionEvent event) {
        // Guard clauses
        if(slus014 == null) {
            Alerts.alertErrorSlus();
            System.out.println("SLUS_014.11 file must be opened before editing..."); // TESTING CJ
            return;
        }

        if(cbId.getValue() == null || cbType.getValue() == null) {
            Alerts.alertType();
            System.out.println("You must select a card and a type!");
            return;
        }

        // Finding first value in the LinkedHashMap
        long firstMapValue = cardBase.getCardBaseOffset().values().iterator().next();

        // Writing and finding others offsets
        for (long i = 0; i < 6; i++) {
            WritingSlus.write((byte) 0, firstMapValue + i, slus014);
        }
    }

    @FXML
    void clickId(ActionEvent event) {
        System.out.println("Offset: " + cardBase.getCardBaseOffset().get(cbId.getValue())); // TESTING
        // Change the background image
        String currentSelection = cbId.getValue();
        switch (currentSelection) {
            case "Forest":
                imgBackground.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/forest.png"))));
                break;
            case "Wasteland":
                imgBackground.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/wasteland.png"))));
                break;
            case "Mountain":
                imgBackground.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/mountain.png"))));
                break;
            case "Sogen":
                imgBackground.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sogen.png"))));
                break;
            case "Umi":
                imgBackground.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/umi.png"))));
                break;
            case "Yami":
                imgBackground.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/yami.png"))));
                break;
            default:
                imgBackground.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/normal.png"))));
        }
    }

    @FXML
    void clickType(ActionEvent event) {
        long currentIncrese = typeIncrement.getTypeIncrement().get(cbType.getValue()); //Saves current boost
        cardBase.setCardIncrement(currentIncrese); //Sets the current boost
        System.out.println("Offset after type change: " + cardBase.getCardBaseOffset().get(cbId.getValue())); // TESTING
    }

    @FXML
    void clickIncrease(ActionEvent event) {
        txtValue.setText("500");
        Filters.filterIncrease(txtValue); // Filter to increase values
    }

    @FXML
    void clickDecrease(ActionEvent event) {
        txtValue.setText("500");
        Filters.filterDecrease(txtValue); // Filter to decrease values
    }

    @FXML
    void clickLogo(MouseEvent event) {
        if(Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.paypal.com/donate/?hosted_button_id=8DZU725MLQKRL"));
                Desktop.getDesktop().browse(new URI("https://buymeacoffee.com/jmncamilo"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

}