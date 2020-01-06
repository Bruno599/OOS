
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("resources/anwendung.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("resources/registration.fxml"));

            primaryStage.setTitle("Benutzerverwaltung");
            primaryStage.setScene(new Scene(root));

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);

    }

}
