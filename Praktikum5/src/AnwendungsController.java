import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AnwendungsController {

    MainApplication MainAp;

    public void setMainApplication(MainApplication main){
        this.MainAp = main;
    };

    @FXML
    public void abortButtonAction(ActionEvent event) {
        String console = "Hallo, das ist ein Test";

        System.out.println(console);
    }
}
