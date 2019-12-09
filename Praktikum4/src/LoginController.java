import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    private boolean neuAnmeldung = false;
    //Benutzer b1;

    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    TextField nameTextField;

    @FXML
    PasswordField passwordField;

    @FXML
    CheckBox checkBox;

    @FXML
    public void handleButtonAction(ActionEvent event) {
        //String console = "test der konsole";
        String name = nameTextField.getText();
        String password = passwordField.getText();

        //b1 = new Benutzer(name,password.toCharArray());

        Stage stage = (Stage) closeButton.getScene().getWindow();
        //System.out.println(name.equals(password));
        //System.out.println(console);
        //System.out.println(b1.toString());
        stage.close();

    }

    @FXML
    public void handleCheckboxAction(ActionEvent event) {
        neuAnmeldung = checkBox.isSelected();
        //System.out.println(name.equals(password));
        System.out.println(neuAnmeldung);
    }




}
