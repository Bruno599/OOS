import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunFXMLAnmeldungsController extends Application {


    /**
     * Testklasse für GUI Anmedlungscontroller
     *
     * die Classe start erstellt einen neue Stage mit der bezeichnung primaryStage
     * in Primaristage wird ein neuer Parent angelegt root mit dem design aus registration.fxml
     * die Parimaristage bekommt den Namen Benutzerverwaltung
     * in der Primarystage wird eine neue Scene erstellt basierend auf root
     * diese wird dann dargestllt
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("resources/registration.fxml"));

            primaryStage.setTitle("Benutzerverwaltung");
            primaryStage.setScene(new Scene(root));

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *launch zeigt die erstellte stage
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}