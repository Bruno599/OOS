package prak4client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import prak4gemklassen.Benutzer;

public class LoginController {

    private boolean neuAnmeldungcheck = false;
    private Client MainAp;
    Benutzer User1 ;
    //prak4gemklassen.Benutzer b1;

    @FXML
    Button LoginButton;

    @FXML
    TextField nameTextField;

    @FXML
    TextField passwordField;

    @FXML
    CheckBox checkBox;

    @FXML
    CheckBox remoteAnmeldung;

    public void setMainApplication(Client main){
        this.MainAp = main;
    };

    @FXML
    public void handleButtonAction(ActionEvent event) {
        //String console = "test der konsole";
        String name = nameTextField.getText();
        String password = passwordField.getText();


        if (checkBox.isSelected()) {
            if(remoteAnmeldung.isSelected()) {
                this.MainAp.neuAnmeldungRem();
                this.MainAp.remote = true;
            }else{
                this.MainAp.neuAnmeldung();
            }
        }
        else
        {
            User1 = new Benutzer(name,password.toCharArray());
            if(remoteAnmeldung.isSelected()) {
                this.MainAp.benutzerLoginrem(User1);
            }else{
                this.MainAp.benutzerLogin(User1);
            }

        }

        //Stage stage = (Stage) closeButton.getScene().getWindow();
        //System.out.println(name.equals(password));
        //System.out.println(console);
        //System.out.println(b1.toString());
        //stage.close();

    }

    @FXML
    public void handleCheckboxAction(ActionEvent event) {
        neuAnmeldungcheck = checkBox.isSelected();
        //System.out.println(name.equals(password));
        System.out.println(neuAnmeldungcheck);


    }




}
