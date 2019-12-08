package Prak4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    private boolean neuAnmeldung = false;

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

        //System.out.println(name.equals(password));
        //System.out.println(console);
    }

    @FXML
    public void handleCheckboxAction(ActionEvent event) {
        neuAnmeldung = checkBox.isSelected();
        //System.out.println(name.equals(password));
        System.out.println(neuAnmeldung);
    }




}
