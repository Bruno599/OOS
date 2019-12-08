package Prak4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Window extends Application{

    private Stage primaryStage;
    private GridPane gridPane;

    private Label titleLabel = new Label("Sie können das System nun verwenden");
    private Button abortButton = new Button("Abbrechen");
    private Label nameLabel = new Label("UseriD");
    private TextField nameTextField = new TextField();
    private Label passwordLabel = new Label("Passwort");
    private PasswordField passwordField = new PasswordField();
    private Label checkboxLabel = new Label("Neu-Anmeldung");
    private CheckBox checkBox = new CheckBox("CheckBox");
    private Button runButton = new Button("Ausführen");

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        gridPane = new GridPane();

        setupStageContents();
        addStageContentsToStage();
        setupScene();
    }

    private void setupScene() {
        gridPane.setHgap(10.0);
        gridPane.setVgap(10.0);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(new Scene(gridPane, 450, 200));
        primaryStage.show();
    }

    // Erstellen des Inhalts der Stage
    private void setupStageContents() {
        Color labelColor = Color.rgb(102, 102, 153);

        titleLabel.setFont(new Font("Serif", 20));
        titleLabel.setTextFill(labelColor);

/*
        nameLabel.setTextFill(labelColor);

        nameTextField.setDisable(true);
        nameTextField.setEditable(false);

        checkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean selected = checkBox.isSelected();

                nameTextField.setDisable(!selected);
                nameTextField.setEditable(selected);
                System.out.println(checkBox.isSelected());
            }
        });

        passwordLabel.setTextFill(labelColor);
*/
        abortButton.setOnAction(new abortButtonHandler());
    }

    // Hinzufügen der Inhalte der Stage
    private void addStageContentsToStage() {
        gridPane.add(titleLabel, 1, 0);
        gridPane.add(abortButton, 1, 7);
    }

    public static void main(String[] args) {
        launch(args);
    }

    class abortButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String console = "test der konsole";
            //String name = nameTextField.getText();
            //String password = passwordField.getText();

            //System.out.println(name.equals(password));
            System.out.println(console);
            primaryStage.close();
        }
    }

    class handleButtonAction implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String name = nameTextField.getText();
            String password = passwordField.getText();

            //System.out.println(name.equals(password));
            //System.out.println(console);

        }
    }
}
