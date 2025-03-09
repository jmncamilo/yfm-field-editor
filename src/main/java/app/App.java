package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utilities.CenterWindow;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/InitFrame.fxml"));
        Parent mainFrame = fxmlLoader.load(); // Load the view that will be the principal frame
        Scene mainScene = new Scene(mainFrame); // Creates scene with the root in this case it would be a Pane
        stage.setTitle("Field Editor byMystic");
        stage.getIcons().addAll( // Icons
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/IconFieldEditor256x.png"))),
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/IconFieldEditor128x.png"))),
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/IconFieldEditor64x.png")))
        );
        stage.setResizable(false);
        stage.setScene(mainScene);
        stage.show();
        CenterWindow.centering(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}