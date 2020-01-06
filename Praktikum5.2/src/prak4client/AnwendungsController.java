package prak4client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AnwendungsController {

    Client MainAp;

    public void setMainApplication(Client main){
        this.MainAp = main;
    };

    @FXML
    public void abortButtonAction(ActionEvent event) {
        String console = "Hallo, das ist ein Test";

        System.out.println(console);
    }
}
