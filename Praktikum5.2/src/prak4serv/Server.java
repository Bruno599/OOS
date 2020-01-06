package prak4serv;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import prak4gemklassen.*;

public class Server {

    BenutzerVerwaltungAdmin verwaltungserv;
    ServerOrb serverOrb;


    public Server() {

        verwaltungserv = new BenutzerVerwaltungAdmin();


        try {
            verwaltungserv.dbInitialisieren("remotedb");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(Exception e){e.printStackTrace();}

        serverOrb = new ServerOrb(verwaltungserv);
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
