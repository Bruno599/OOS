package Aufgabe1;

import java.util.ArrayList;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {


     private ArrayList<Benutzer> Users;

     public BenutzerVerwaltungAdmin(){

      this.Users = new ArrayList<Benutzer>();
     }

    public void benutzerEintragen (Benutzer benutzer)
            throws BenutzerExistiertBereits, BenutzerIDIstSchonVergeben{

        if(benutzerOk(benutzer) == true) {
            throw new BenutzerExistiertBereits("Benutzer schon Vorhanden");
        }
        if(getUserID(benutzer)){
            throw new BenutzerIDIstSchonVergeben("BenutzerID ist schon Vergeben");
        }
        else{
            Users.add(benutzer);
            System.out.println("Benutzer wurde Angelegt");
        }

    };

    public boolean benutzerOk(Benutzer benutzer){
        return (Users.contains(benutzer));
    };

    public void benutzerLöschen(Benutzer benutzer)
            throws BenutzerKonnteNIchtGelöschtWerden, BenutzerNichtVorhanden {
            if ( benutzerOk(benutzer) ) {

                Users.remove(benutzer);
                if (benutzerOk(benutzer)) {

                   throw new BenutzerKonnteNIchtGelöschtWerden
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

    public int getAnzahlUser(){           // ließt die Anzahl der in der Datenstruktur gespeicherten Einträge aus
        return Users.size();
    }

    public void printUsers (){          //gibt alle, in der Bdatenstrucktur geseicherten Benutzer aus
        int anzahl = getAnzahlUser();

        System.out.println(anzahl);

        for (int i = 0; i < anzahl; i++)
        {
            System.out.print(i+1+ " ");
            System.out.println(Users.get(i).toString());
        }
    }

    public boolean getUserID(Benutzer benutzer) {

        int anzahl = getAnzahlUser();   //anzahl speichert die Anzahl der Einträge

        for (int i = 0; i < anzahl; i++)
        {
            if(Users.get(i).userID.equals(benutzer.userID)){
                return true;
            }
        }
        return false;
    }

}
