import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApplication extends Application {

    private BenutzerVerwaltungAdmin verwaltung;
    Stage primaryStage;
    int input = -1;
    boolean fehler = false;




    public boolean ask(){
        boolean dbInitialisierenint = false;

        while (input != 1 || input != 0) {
            try {
                System.out.println("Möchten Sie eine neue Datenhaltung inizialisieren?");

                BufferedReader din = new BufferedReader(
                        new InputStreamReader(System.in));

                input = Integer.parseInt(din.readLine());

                if (input == 1) {
                    dbInitialisierenint = true;
                    break;
                }

            if (input == 0){
                dbInitialisierenint = false;
                break;
            }

            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

        }
        return dbInitialisierenint;
    }


    public void setScene(String scene){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(scene));
        Parent root;
        System.out.println(scene);

        try {
            root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

            switch (scene) {
                case "LoginController.fxml":
                    ((LoginController)fxmlLoader.getController()).setMainApplication(this);
                    primaryStage.setTitle("Login");
                    break;
                case "AnmeldungsController.fxml":
                    ((AnmeldungsController)fxmlLoader.getController()).setMainApplication(this);
                    primaryStage.setTitle("Anmeldung");
                    break;
                case "anwendung.fxml":
                    ((AnwendungsController)fxmlLoader.getController()).setMainApplication(this);
                    primaryStage.setTitle("Anwendung");
                    break;
            }

            primaryStage.setScene(new Scene(root));

            primaryStage.show();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        verwaltung = new BenutzerVerwaltungAdmin();

        if (ask()){
            verwaltung.dbInitialisieren("test");
        }

        this.setScene("LoginController.fxml");

    }

    public void neuAnmeldung(){

        setScene("AnmeldungsController.fxml");
    };

    public void neuerBenutzer(Benutzer benutzer) throws Exception {

            verwaltung.benutzerEintragen(benutzer);

            setScene("LoginController.fxml");


    };

    public void benutzerLogin (Benutzer benutzer) throws Exception{

            if(verwaltung.benutzerOk(benutzer)) {
                setScene("anwendung.fxml");
            }else{
                throw new BenutzerNichtVorhandenExeption("Benutzer existiert nicht");
            }





    };

    public static void main(String[] args){
        launch(args);

    }
}
