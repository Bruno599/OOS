import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class LoginController {

    private boolean neuAnmeldung = false;

    @FXML
    Button closeButton;

    @FXML
    TextField nameTextField;

    @FXML
    TextField passwordField;

    @FXML
    CheckBox checkBox;

    @FXML
    public void handleButtonAction(ActionEvent event) {
        //String console = "test der konsole";
        String name = nameTextField.getText();
        String password = passwordField.getText();

        Benutzer bn = new Benutzer(name,password.toCharArray());


        //System.out.println(name.equals(password));
        //System.out.println(console);
        System.out.println("Neuer Benutzer");
        System.out.println(bn.toString());

        Platform.exit();

    }

    @FXML
    public void handleCheckboxAction(ActionEvent event) {
        neuAnmeldung = checkBox.isSelected();
        //System.out.println(name.equals(password));
        System.out.println(neuAnmeldung);
    }




}
