import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BruttoRechner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BruttoRechner.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass()
                .getResource("BruttoRechner.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Brutto-Rechner");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}