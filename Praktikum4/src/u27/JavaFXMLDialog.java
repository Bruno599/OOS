package u27;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXMLDialog extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));

      primaryStage.setTitle("AnmeldungFrame");
      primaryStage.setScene(new Scene(root));

      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
