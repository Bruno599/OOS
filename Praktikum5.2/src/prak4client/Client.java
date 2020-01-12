package prak4client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prak4gemklassen.Benutzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static javafx.application.Application.launch;

public class Client extends Application {

    private BenutzerVerwaltungAdmin verwaltung;
    Stage primaryStage;
    private String address = "127.0.0.1";
    private ClientOrb clientOrb = new ClientOrb(address);
    boolean remote = false;

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
            case "LoginController.fxml":
                ((LoginController)fxmlLoader.getController()).setMainApplication(this);
                System.out.println("Bla");
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
    public void neuAnmeldungRem(){

        setScene("AnmeldungsController.fxml");
    };

    public void neuerBenutzer(Benutzer benutzer) {
        try {
            verwaltung.benutzerEintragen(benutzer);

            setScene("LoginController.fxml");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    };
    public void neuerBenutzerrem(Benutzer benutzer){
        try {
            clientOrb.benutzerEintragen(benutzer);

            setScene("LoginController.fxml");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    };

    public void benutzerLogin (Benutzer benutzer) throws Exception{
        remote = false;

        if(verwaltung.benutzerOk(benutzer)) {
            setScene("anwendung.fxml");
        }else{
            throw new prak4gemklassen.BenutzerNichtVorhandenExeption("Benutzer existiert nicht");
        }

    };

    public void benutzerLoginrem (Benutzer benutzer) throws Exception{
        remote = true;
        if(clientOrb.benutzerOK(benutzer))
        {setScene("anwendung.fxml");}
        else{
            //setScene("LoginController.fxml");
            throw new prak4gemklassen.BenutzerNichtVorhandenExeption("Benutzer nicht vorhanden");
        }

        /*
        if(clientOrb.benutzerOK(benutzer)) {
            setScene("anwendung.fxml");
        }else{
            throw new prak4gemklassen.BenutzerExistiertBereitsExeption("Benutzer existiert nicht");
        }
        */
    };

    public static void main(String[] args){
        launch(args);
        Client steuerung = new Client();

    }
}

