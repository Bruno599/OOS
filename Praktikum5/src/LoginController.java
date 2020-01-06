import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    private boolean neuAnmeldungcheck = false;
    private MainApplication MainAp;
    Benutzer User1 ;
    //Benutzer b1;

    @FXML
    Button LoginButton;

    @FXML
    TextField nameTextField;

    @FXML
    TextField passwordField;

    @FXML
    CheckBox checkBox;

    public void setMainApplication(MainApplication main){
        this.MainAp = main;
    };

    @FXML
    public void handleButtonAction(ActionEvent event) throws Exception {
        //String console = "test der konsole";
        String name = nameTextField.getText();
        String password = passwordField.getText();

        if (checkBox.isSelected())
        {
            this.MainAp.neuAnmeldung();
        }
        else
        {
            User1 = new Benutzer(name,password.toCharArray());
            try {
                this.MainAp.benutzerLogin(User1);
            }catch(BenutzerNichtVorhandenExeption e){
                nameTextField.setText("Fehler beim Login");
                passwordField.setText("");

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
