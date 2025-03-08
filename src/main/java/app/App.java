package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InitFrame.fxml"));
        Parent mainFrame = fxmlLoader.load(); // Load the view that will be the principal frame
        Scene mainScene = new Scene(mainFrame); // Creates scene with the root in this case it would be a Pane
        stage.setTitle("Field Editor byMystic");
        stage.setResizable(false);
        stage.setScene(mainScene);
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}