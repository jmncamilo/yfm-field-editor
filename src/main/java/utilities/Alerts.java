package utilities;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.Objects;

public class Alerts {
    private static final Image warning = new Image(Objects.requireNonNull(Alerts.class.getResourceAsStream("/icons/WarningIcon.png")));
    private static final Image done = new Image(Objects.requireNonNull(Alerts.class.getResourceAsStream("/icons/DoneIcon.png")));
    private static final Image error = new Image(Objects.requireNonNull(Alerts.class.getResourceAsStream("/icons/ErrorIcon.png")));

    public static void formatAlert(String title, String header, String content, Image image) {
        // Creates an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        // Get alert Stage and set the icon
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(Objects.requireNonNull(Alerts.class.getResourceAsStream("/icons/IconFieldEditor64x.png"))));
        alertStage.getIcons().add(new Image(Objects.requireNonNull(Alerts.class.getResourceAsStream("/icons/IconFieldEditor128x.png"))));
        alertStage.getIcons().add(new Image(Objects.requireNonNull(Alerts.class.getResourceAsStream("/icons/IconFieldEditor256x.png"))));

        // Set image to alert
        ImageView imageView = new ImageView(image);
        alert.setGraphic(imageView);

        // Add custom button "OK"
        ButtonType btnOk = new ButtonType("OK");
        alert.getButtonTypes().setAll(btnOk);

        // Apply CSS style
        alert.getDialogPane().getStyleClass().add("custom-alert"); // Style class assignation
        Scene scene = alert.getDialogPane().getScene();
        scene.getStylesheets().add(Objects.requireNonNull(Alerts.class.getResource("/css/style.css")).toExternalForm());

        // show alert
        alert.showAndWait();
    }

    public static void alertErrorSlus() {
        formatAlert("Error", "File Not Opened", "SLUS_014.11 file must be opened before editing...", error);
    }

    public static void alertInvalidWrite() {
        formatAlert("Error", "File Write Error", "The file could not be written.", error);
    }

    public static void alertDoneWrite() {
        formatAlert("Success", "File Saved", "Data has been saved successfully!", done);
    }

    public static void alertIncreaseOrDecrease() {
        formatAlert("Warning", "Huh?", "Do you want to increase or decrease?", warning);
    }

    public static void alertType() {
        formatAlert("Warning", "Caution", "You must select a field card and a type!", warning);
    }

    public static void alertEmptyField() {
        formatAlert("Warning", "Important!", "Please enter a valid value.", warning);
    }

}





/*
package utilities;




public class CustomAlerts {

    private static final Image rejectFile = new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/RejectFile.png")));
    private static final Image validWrite = new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/ValidWrite.png")));
    private static final Image invalidWrite = new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/InvalidWrite.png")));

    public static void formatAlert(String title, String header, String content, Image image) {
        // Creates an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        // Get alert Stage and set the icon
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/icon256x.png"))));
        alertStage.getIcons().add(new Image(Objects.requireNonNull(CustomAlerts.class.getResourceAsStream("/icons/icon128x.png"))));

        // Set image to alert
        ImageView imageView = new ImageView(image);
        alert.setGraphic(imageView);

        // Add custom button "OK"
        ButtonType btnOk = new ButtonType("OK");
        alert.getButtonTypes().setAll(btnOk);

        // Apply CSS style
        alert.getDialogPane().getStyleClass().add("custom-alert"); // Style class assignation
        Scene scene = alert.getDialogPane().getScene();
        scene.getStylesheets().add(Objects.requireNonNull(CustomAlerts.class.getResource("/css/styles.css")).toExternalForm());

        // show alert
        alert.showAndWait();
    }

    public static void setRejectFile() {
        formatAlert("Error", "Error!", "Invalid file. Please try again.", rejectFile);
    }

    public static void setValidWrite() {
        formatAlert("Success", "File Saved!", "The data has been successfully saved to the file.", validWrite);
    }

    public static void setInvalidWrite() {
        formatAlert("Error", "Something Went Wrong", "The file could not be modified. " +
                   "Please check if all required fields are completed.", invalidWrite);
    }

}

*/
