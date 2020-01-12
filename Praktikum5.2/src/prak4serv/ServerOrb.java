package prak4serv;

import java.net.*;
import java.io.*;
import prak4gemklassen.*;


public class ServerOrb {

    private ServerSocket serverSocket;
    //private BenutzerVerwaltungAdmin verwaltungserv;
    private ObjectInputStream is;
    private ObjectOutputStream os;


    public ServerOrb(BenutzerVerwaltungAdmin verwaltungserv) {


        try {
            serverSocket = new ServerSocket(6666);

        } catch (Exception e) {
            e.printStackTrace();
        }

        while(true) {

            try {
                Socket client = serverSocket.accept();
                is = new ObjectInputStream(client.getInputStream());
                os = new ObjectOutputStream(client.getOutputStream());
                int task = is.readInt();
                System.out.println(task);
                switch (task) {
                    case 2:
                        System.out.println("Neuer Benutzer: ");
                        Benutzer user = (Benutzer) is.readObject();
                        System.out.println(user.toString());

                        boolean result = true;

                        try {
                            verwaltungserv.benutzerEintragen(user);
                        } catch (BenutzerIDIstSchonVergebenExeption e) {
                            result = false;
                        } catch (BenutzerExistiertBereitsExeption e) {
                            result = false;
                        }

                        os.writeBoolean(result);
                        os.flush();
                        break;
                    case 3:
                        System.out.println("User checken: ");
                        Benutzer user2 = (Benutzer) is.readObject();

                        System.out.println(user2.toString());

                        os.writeBoolean(verwaltungserv.benutzerOk(user2));
                        os.flush();
                        break;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
