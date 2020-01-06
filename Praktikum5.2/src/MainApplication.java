import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prak4client.BenutzerVerwaltungAdmin;
import prak4gemklassen.Benutzer;

/*

public class MainApplication extends Application {

    private BenutzerVerwaltungAdmin verwaltung;
    Stage primaryStage;




    public boolean ask(){
        boolean dbInitialisierenint = false;

        try {
            System.out.println("Möchten Sie eine neue Datenhaltung inizialisieren?");

            BufferedReader din = new BufferedReader(
                    new InputStreamReader(System.in));

                    if(Integer.parseInt(din.readLine()) > 0){
                        dbInitialisierenint = true;
                    };
        }
        catch (IOException e) {
            e.printStackTrace();
        };

        return dbInitialisierenint;
    };


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
                case "prak4serv/LoginController.fxml":
                    ((LoginController)fxmlLoader.getController()).setMainApplication(this);
                    primaryStage.setTitle("Login");
                    break;
                case "prak4serv/AnmeldungsController.fxml":
                    ((AnmeldungsController)fxmlLoader.getController()).setMainApplication(this);
                    primaryStage.setTitle("Anmeldung");
                    break;
                case "prak4serv/anwendung.fxml":
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

        this.setScene("prak4serv/LoginController.fxml");

    }

    public void neuAnmeldung(){

        setScene("prak4serv/AnmeldungsController.fxml");
    };

    public void neuerBenutzer(Benutzer benutzer){
        try {
            verwaltung.benutzerEintragen(benutzer);

            setScene("prak4serv/LoginController.fxml");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    };

    public void benutzerLogin (Benutzer benutzer){
        try{
            verwaltung.benutzerOk(benutzer);

            setScene("prak4serv/anwendung.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    };

    public static void main(String[] args){
        launch(args);

    }

}

        */