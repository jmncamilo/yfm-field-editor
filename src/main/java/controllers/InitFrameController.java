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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import models.CardOffsets;
import models.TypeIncrement;
import utilities.Filters;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

    }

    @FXML
    void clickDelete(ActionEvent event) {

    }

    @FXML
    void clickEdit(ActionEvent event) {

    }

    @FXML
    void clickId(ActionEvent event) {
        System.out.println("Offset: " + cardBase.getCardBaseOffset().get(cbId.getValue())); // TESTING
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

    @FXML
    void clickOpen(ActionEvent event) {
        
    }

}