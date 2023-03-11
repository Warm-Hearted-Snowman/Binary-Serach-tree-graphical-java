import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main_Graphical extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main_Graphical.class.getResource("NewMenu.fxml")); // login page
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/dark-theme.css")).toExternalForm());
        stage.setTitle("Binary Search Tree");
        stage.setScene(scene);
        stage.setResizable(false);
//        stage.getIcons().add(new Image("/resources/icons/library-management.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}