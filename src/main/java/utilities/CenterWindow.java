package utilities;

import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;

public class CenterWindow {
    public static void centering (Stage stage) {
        // Getting user's primary screen
        Screen primaryScreen = Screen.getPrimary();
        Rectangle2D dimensions = primaryScreen.getVisualBounds();

        // Getting screen dimensions
        double widthScreen = dimensions.getWidth();
        double heightScreen = dimensions.getHeight();

        // Getting the stage's dimensions
        double widthStage = stage.getWidth();
        double heightStage = stage.getHeight();

        // Calculating x and y
        double xPos = (widthScreen - widthStage) / 2;
        double yPos = (heightScreen - heightStage) / 2;

        // Setting x and y
        stage.setX(xPos);
        stage.setY(yPos);
    }
}
