package Aufgabe1;

import java.util.ArrayList;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

    /**
     * Arrayliste in der alle Objekte des Typen Benutzer gespeichert werden
     */

     private ArrayList<Benutzer> users;

    /**
     * Defaultkonstruktor der die Instanz der Arrayliste anlegt
     */

     public BenutzerVerwaltungAdmin(){

      this.users = new ArrayList<Benutzer>();
     }

    /**
     *
     * @param benutzer
     * @throws BenutzerExistiertBereits
     * @throws BenutzerIDIstSchonVergeben
     */
    public void benutzerEintragen (Benutzer benutzer)
            throws BenutzerExistiertBereits, BenutzerIDIstSchonVergeben{

        if(benutzerOk(benutzer) == true) {
            throw new BenutzerExistiertBereits("Benutzer schon Vorhanden");
        }
        if(getUserID(benutzer)){
            throw new BenutzerIDIstSchonVergeben("BenutzerID ist schon Vergeben");
        }
        else{
            users.add(benutzer);
            System.out.println("Benutzer wurde Angelegt");
        }

    };

    /**
     *
     * @param benutzer
     * @return
     */
    public boolean benutzerOk(Benutzer benutzer){
        return (users.contains(benutzer));
    };

    /**
     * Loescht einen Benutzer aus der Datenhaltung
     * @param benutzer
     * @throws BenutzerKonnteNIchtGeloeschtWerden wird ausgelöst wenn benutzer nach löschvorgang in der Datenhaltung ist
     * @throws BenutzerNichtVorhanden wird ausgelöst wenn der zu löschende Benutzer nicht vorhanden ist.
     */

    public void benutzerLoeschen(Benutzer benutzer)
            throws BenutzerKonnteNIchtGeloeschtWerden, BenutzerNichtVorhanden {
            if ( benutzerOk(benutzer) ) {

                users.remove(benutzer);
                if (benutzerOk(benutzer)) {

                   throw new BenutzerKonnteNIchtGeloeschtWerden
                           ("Benutzer konnte nicht gelöscht werden");
                }
                else {
                    System.out.println("Benutzer wurde erfolgreich gelöscht");
                }
            }
            else{
                throw new BenutzerNichtVorhanden("Benutzer nicht vorhanden!");
            }
    }

    /**
     * Ermittelt die Anzahl der in der Datenhaltung gespeicherten Benutzer
     * @return gibt die Anzahl als int zurück.
     */
    public int getAnzahlUser(){           // ließt die Anzahl der in der Datenstruktur gespeicherten Einträge aus
        return users.size();
    }

    /**
     *  Gibt alle Benutzer in der Datenhaltung aus
     */
    public void printUsers (){          //gibt alle, in der Bdatenstrucktur geseicherten Benutzer aus
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
    public boolean getUserID(Benutzer benutzer) {

        int anzahl = getAnzahlUser();   //anzahl speichert die Anzahl der Einträge

        for (int i = 0; i < anzahl; i++)
        {
            if(users.get(i).userID.equals(benutzer.userID)){
                return true;
            }
        }
        return false;
    }

}
