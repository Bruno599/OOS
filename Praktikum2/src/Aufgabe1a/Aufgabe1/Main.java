package Aufgabe1a.Aufgabe1;

public class Main {

    public static void main(String[] args){


            BenutzerVerwaltungAdmin verwaltung = new BenutzerVerwaltungAdmin();


            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray())); //Benutzer anlegen
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray())); //test: gleichen benutzer nochmal anlegen
            verwaltung.benutzerEintragen(new Benutzer("hallo", "54321".toCharArray())); //2. Benutzer Anlegen
            verwaltung.benutzerEintragen(new Benutzer("hallo", "4321".toCharArray()));  //test: benutzer anlegen mit gleicher ID
            verwaltung.benutzerLöschen(new Benutzer("hallo", "54321".toCharArray()));   //benutzer Löschen
            verwaltung.benutzerLöschen(new Benutzer("helloo", "peter".toCharArray()));  //test: benuzer löschen der nicht existiert
            verwaltung.benutzerEintragen(new Benutzer());   //
            verwaltung.benutzerLöschen(new Benutzer());     // test: benutzer anlegen, löschen und dann wieder anlegen
            verwaltung.benutzerEintragen(new Benutzer());   //

            verwaltung.printUsers();    // gibt alle vorhandenen User in der Datenhaltung aus



    }

}
