import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 */
public class AnwendungsController {
    /**
     *Der Button Abbrechen in der GUI aktiviert die abortButtonAction
     * diese gibt hallo, das ist ei test auf der Konsole aus
     * @param event
     */
    @FXML
    public void abortButtonAction(ActionEvent event) {
        String console = "Hallo, das ist ein Test";

        System.out.println(console);
        Platform.exit();
    }
}
