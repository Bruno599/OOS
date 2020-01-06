import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 *
 */
public class LoginController {
    /**
     * boolean ob anmedlung gesetzt ist
     */
    private boolean neuAnmeldung = false;
    /**
     * aggregiertes Objekt
     * Button attribute mit id close Button
     */
    @FXML
    Button closeButton;
    /**
     *
     * Textfielöd attribut
     */
    @FXML
    TextField nameTextField;
    /**
     *
     */
    @FXML
    PasswordField passwordbox;
    /**
     *
     */
    @FXML
    CheckBox checkBox;

    /**
     * Wenn der Button Gedrückt wird
     * Übernimmt nameTextField und passwordField auf der GUI un dspeichert Sie in name und Passwort
     * Legt neues Objekt Bnutzer an
     * Gibt objektt bn mittels methode tostring aus
     * @param event
     */
    @FXML
    public void handleButtonAction(ActionEvent event) {
        //String console = "test der konsole";
        String name = nameTextField.getText();
        String password = passwordbox.getText();
        /**
         * bn ist ein neues Objekt vom Typ Benutzer
         */
        Benutzer bn = new Benutzer(name,password.toCharArray());


        //System.out.println(name.equals(password));
        //System.out.println(console);
        System.out.println("Neuer Benutzer");
        System.out.println(bn.toString());

        Platform.exit();

    }

    /**
     * wenn die chekcbox aktiviert oder deaktiviert wird wird wird neuAnmedlung auf true oder false gesetzt
     * @param event
     */
    @FXML
    public void handleCheckboxAction(ActionEvent event) {
        neuAnmeldung = checkBox.isSelected();
        //System.out.println(name.equals(password));
        System.out.println(neuAnmeldung);
    }




}
