

import java.util.ArrayList;
import java.io.*;


public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung, Serializable {

    /**
     * Arrayliste in der alle Objekte des Typen Benutzer gespeichert werden
     */
    private ArrayList<Benutzer> users;
    private String dateiname = "";

    /**
     *
     * @param fn
     * @throws DateiwurdeNichtGeloeschtExeption
     * @throws IOException
     * @throws FalscherDateiNameExeption
     */
    void dbInitialisieren(String fn) throws DateiwurdeNichtGeloeschtExeption, IOException, FalscherDateiNameExeption{

        //filename = "test.txt";
        dateiname = fn;

        File file = new File(fn);
        boolean exists = file.exists();

        if(exists && !file.delete()) {
            throw new DateiwurdeNichtGeloeschtExeption("Die alte Datei konnte nicht gelöscht werden");
        }
        //BenutzerVerwaltungAdmin verwaltung = new BenutzerVerwaltungAdmin();
        users.clear();

        serialize(fn);
    }


    /**
     * Schreibt Daten in die Datei
     * @param fn
     * @throws IOException
     * @throws FalscherDateiNameExeption
     */
    public void serialize(String fn) throws IOException, FalscherDateiNameExeption {

            if (fn.equals(dateiname)){
                FileOutputStream fs = new FileOutputStream(fn);
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(users);
                os.close();
            }
            else {
                throw new FalscherDateiNameExeption("Dateiname stimmt nicht überein");
            }

    }

    /**
     * List Daten aus der Datei
     * @param fn
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void deserialize(String fn) throws ClassNotFoundException, IOException{
            FileInputStream fs = new FileInputStream(fn);
            ObjectInputStream is = new ObjectInputStream(fs);
            this.users = (ArrayList<Benutzer>) is.readObject();
            //System.out.println(zeit);
            is.close();
    }


    /**
     * Defaultkonstruktor der die Instanz der Arrayliste anlegt
     */

     public BenutzerVerwaltungAdmin(){

      this.users = new ArrayList<Benutzer>();
     }

    /**
     *
     * @param benutzer
     * @throws BenutzerExistiertBereitsExeption
     * @throws BenutzerIDIstSchonVergebenExeption
     */
    public void benutzerEintragen (Benutzer benutzer)
            throws BenutzerExistiertBereitsExeption, BenutzerIDIstSchonVergebenExeption, BenutzerIstLeerExeption, ClassNotFoundException, IOException, FalscherDateiNameExeption {
        if(benutzer.getUserID().isEmpty()){
            throw new BenutzerIstLeerExeption("Der eingegebene Benutzer ist leer");
        }
        if(benutzerOk(benutzer) == true) {
            throw new BenutzerExistiertBereitsExeption("Benutzer schon Vorhanden");
        }
        if(searchUserID(benutzer)){
            throw new BenutzerIDIstSchonVergebenExeption("BenutzerID ist schon Vergeben");
        }
        else{
            deserialize(dateiname);
            users.add(benutzer);
            System.out.println("Benutzer wurde Angelegt");
            serialize(dateiname);
        }

    };

    /**
     * List aus Datei und überprüft ob der Benutzer angelegt wurde.
     * @param benutzer
     * @return
     */
    public boolean benutzerOk(Benutzer benutzer)throws ClassNotFoundException, IOException{
        deserialize(dateiname);
        return (users.contains(benutzer));
    };

    /**
     * Loescht einen Benutzer aus der Datenhaltung
     * @param benutzer
     * @throws BenutzerKonnteNIchtGeloeschtWerdenExeption wird ausgelöst wenn benutzer nach löschvorgang in der Datenhaltung ist
     * @throws BenutzerNichtVorhandenExeption wird ausgelöst wenn der zu löschende Benutzer nicht vorhanden ist.
     */

    public void benutzerLoeschen(Benutzer benutzer)
            throws BenutzerKonnteNIchtGeloeschtWerdenExeption, BenutzerNichtVorhandenExeption, ClassNotFoundException, IOException, FalscherDateiNameExeption {
            deserialize(dateiname);
            if ( benutzerOk(benutzer) ) {

                users.remove(benutzer);
                serialize(dateiname);
                if (benutzerOk(benutzer)) {

                   throw new BenutzerKonnteNIchtGeloeschtWerdenExeption
                           ("Benutzer konnte nicht gelöscht werden");
                }
                else {
                    System.out.println("Benutzer wurde erfolgreich gelöscht");

                }
            }
            else{
                throw new BenutzerNichtVorhandenExeption("Benutzer nicht vorhanden!");
            }
    }

    /**
     * Ermittelt die Anzahl der in der Datenhaltung gespeicherten Benutzer
     * @return gibt die Anzahl als int zurück.
     */
    public int getAnzahlUser() throws ClassNotFoundException, IOException{
        deserialize(dateiname);              // ließt die Anzahl der in der Datenstruktur gespeicherten Einträge aus
        return users.size();
    }

    /**
     *  Gibt alle Benutzer in der Datenhaltung aus
     */
    public void printUsers () throws ClassNotFoundException, IOException{
        deserialize(dateiname);              //gibt alle, in der Bdatenstrucktur geseicherten Benutzer aus
        int anzahl = getAnzahlUser();

        System.out.println(anzahl);

        for (int i = 0; i < anzahl; i++)
        {
            System.out.print(i+1+ " ");
            System.out.println(users.get(i).toString());
        }
    }

    /**
     * Funktion zum ermitteln ob ed die Userid in der Benutzerverwaltung schon gibt
     * @param benutzer zum vergleichen ob es die USerid schon gibt
     * @return gibt ein true zurück wenn die BenutzerID vorhanden ist
     */
    public boolean searchUserID(Benutzer benutzer) throws ClassNotFoundException, IOException{

        deserialize(dateiname);

        int anzahl = getAnzahlUser();   //anzahl speichert die Anzahl der Einträge

        for (int i = 0; i < anzahl; i++)
        {
            if(users.get(i).getUserID().equals(benutzer.getUserID())){
                return true;
            }
        }
        return false;
    }

}
