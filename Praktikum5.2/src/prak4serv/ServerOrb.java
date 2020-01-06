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
            Socket socket = serverSocket.accept();
            is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(true) {
            try {

                int task = is.read();

                switch (task) {
                    case 2:
                        System.out.println("Neuer Benutzer: ");
                        Benutzer user = (Benutzer) is.readObject();
                        System.out.println(user.toString());

                        boolean result = true;

                        try {
                            verwaltungserv.benutzerEintragen(user);
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
