package u28;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class JavaFXMLController {
  @FXML
  TextField nameTextField;

  @FXML
  PasswordField passwordField;

  @FXML
  CheckBox checkBox;

  @FXML
  public void handleRunButtonAction(ActionEvent event) {
    String name = nameTextField.getText();
    String password = passwordField.getText();

    System.out.println(name.equals(password));
  }

  @FXML
  public void handleCheckBoxAction(ActionEvent event) {
    boolean selected = checkBox.isSelected();

    nameTextField.setDisable(!selected);
    nameTextField.setEditable(selected);
    System.out.println(selected);
  }
}
