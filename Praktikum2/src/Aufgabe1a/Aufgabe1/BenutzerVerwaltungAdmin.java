package Aufgabe1a.Aufgabe1;

import java.util.ArrayList;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {


     private ArrayList<Benutzer> Users;

     public BenutzerVerwaltungAdmin(){

      this.Users = new ArrayList<Benutzer>();
     }

    public void benutzerEintragen (Benutzer benutzer){
        try {
            if (benutzerOk(benutzer) == true) {
                throw new BenutzerExistiertBereits("Benutzer schon Vorhanden");
            }
            if (getUserID(benutzer)) {
                throw new BenutzerIDIstSchonVergeben("BenutzerID ist schon Vergeben");
            } else {
                Users.add(benutzer);
                System.out.println("Benutzer wurde Angelegt");
            }
        }
        catch (Exception i){
            i.printStackTrace();
        }
    };

    public boolean benutzerOk(Benutzer benutzer){
        return (Users.contains(benutzer));
    };

    public void benutzerLöschen(Benutzer benutzer) {
            try {
                if (benutzerOk(benutzer)) {
                    Users.remove(benutzer);
                    if (benutzerOk(benutzer)) {
                        throw new BenutzerKonnteNIchtGelöschtWerden("Benutzer konnte nicht gelöscht werden");
                    } else {
                        System.out.println("Benutzer wurde erfolgreich gelöscht");
                    }
                } else {
                    throw new BenutzerNichtVorhanden("Benutzer nicht vorhanden!");
                }
            }
            catch (Exception i){
                i.printStackTrace();
            }
    }

    public int getAnzahlUser(){
        return Users.size();
    }

    public void printUsers (){
        int anzahl = getAnzahlUser();

        System.out.println(anzahl);

        for (int i = 0; i < anzahl; i++)
        {
            System.out.print(i+1+ " ");
            System.out.println(Users.get(i).toString());
        }
    }

    public boolean getUserID(Benutzer benutzer) {

        int anzahl = getAnzahlUser();

        for (int i = 0; i < anzahl; i++)
        {
            if(Users.get(i).userID.equals(benutzer.userID)){
                return true;
            }
        }
        return false;
    }

}
