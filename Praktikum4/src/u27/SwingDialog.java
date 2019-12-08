package u27;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingDialog extends JFrame {
  private JLabel titleLabel = new JLabel("Mein erster Frame");
  private JLabel nameLabel = new JLabel("Name");
  private JTextField nameTextField = new JTextField("");
  private JLabel passwordLabel = new JLabel("Passwort");
  private JPasswordField passwordField = new JPasswordField();
  private Checkbox checkBox = new Checkbox("CheckBox");
  private JButton runButton = new JButton("Ausführen");

  public SwingDialog() throws HeadlessException {
    setupFrameContents();
    addFrameContentsToFrame();
    setupFrame();
  }

  // Erstellen & Konfigurieren des Frames
  private void setupFrame() {
    setSize(400, 310);
    setTitle("AnmeldungFrame");
    setLayout(null);
    setVisible(true);
  }

  // Erstellen des Inhalts des Frames
  private void setupFrameContents() {
    Color labelColor = new Color(102, 102, 153);

    titleLabel.setBounds(40, 10, 320, 40);
    titleLabel.setFont(new Font("Serif", 1, 20));
    titleLabel.setForeground(labelColor);

    nameLabel.setBounds(20, 70, 60, 35);
    nameLabel.setForeground(labelColor);

    nameTextField.setBounds(90, 70, 250, 35);
//    nameTextField.setText("Heinz");

    passwordLabel.setBounds(20, 110, 55, 35);
    passwordLabel.setForeground(labelColor);

    passwordField.setBounds(90, 110, 250, 35);
//    passwordField.setText("Passwort");
    passwordField.setEchoChar('*');

    checkBox.setBounds(90, 160, 90, 35);
//    checkBox.setState(true);

    runButton.setBounds(270, 210, 100, 35);
  }

  // Hinzufügen der Inhalte des Frames
  private void addFrameContentsToFrame() {
    add(titleLabel);
    add(nameLabel);
    add(nameTextField);
    add(passwordLabel);
    add(passwordField);
    add(checkBox);
    add(runButton);
  }

  public static void main(String[] args) {
    SwingDialog swingDialog = new SwingDialog();
  }
}
