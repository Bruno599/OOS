import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class AnmeldungsController {
    /**
     *
     */
    @FXML
    Button runButton;
    /**
     *
     */
    @FXML
    TextField nameTextField;
    /**
     *
     */
    @FXML
    TextField passwordField;
    /**
     *
     */
    @FXML
    TextField passwordFieldVerify;
    /**
     *
     */
    @FXML
    Label errorLabel;

    MainApplication MainAp;

    public void setMainApplication(MainApplication main){
        this.MainAp = main;
    };

    /**
     *
     * @param event
     */
    @FXML
    public void handleButtonAction(ActionEvent event) {
        //String console = "test der konsole";
        String name = nameTextField.getText();
        String password = passwordField.getText();


        if(!passwordField.getText().equals(passwordFieldVerify.getText())){
            errorLabel.setText("Fehler: Passwort ungleich!");
            return;
        }

        Benutzer bn = new Benutzer(name,password.toCharArray());

        this.MainAp.neuerBenutzer(bn);


        //System.out.println(name.equals(password));
        //System.out.println(console);
        System.out.println("Neuer Benutzer");
        System.out.println(bn.toString());

        //Platform.exit();

    }
}
