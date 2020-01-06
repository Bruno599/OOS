package prak4client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import prak4gemklassen.*;

public class ClientOrb {

    public Socket socket;

    public ObjectOutputStream os;

    public ObjectInputStream is;

    private String address;

    private int port = 6666;


    public ClientOrb (String address) {
        this.address = address;
        //Connect();
    }


    private void Connect() {
        try {
            socket = new Socket("127.0.0.1", 6666);
            System.out.println("verbindung hergestellt");
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Disconnect() {
        try {
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean sendReceive(int task, Object value) {
        boolean result = false;
        try {
            Connect();

            os.writeInt(task);
            os.writeObject(value);
            os.flush();

            result = is.readBoolean();
        } catch (Exception e) {
            return false;
        }

        Disconnect();

        return result;
    }

    public void benutzerEintragen(Benutzer user) throws BenutzerExistiertBereitsExeption {
        if (!sendReceive(2, user)) {
            throw new BenutzerExistiertBereitsExeption("User already exists");
        }
    }

    public void benutzerOK(Benutzer user) {

        sendReceive(3, user);
    }

    /*
        try {
            // Verbindung aufbauen:
            System.out
                    .println("Client: Verbindungsaufbau auf Port 9876 zu Host address!");
            socket = new Socket(address, 6666);
            System.out.println("Verbindung hergestellt!");

            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());
            System.out.println("Streams initialisiert!");

        } catch (IOException e) {
            System.err.println(e.toString());
            // System.exit(1);

        }
*/
}
