package Aufgabe1;

public class Main {

    public static void main(String[] args){


            BenutzerVerwaltungAdmin verwaltung = new BenutzerVerwaltungAdmin();
        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray()));
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray())); //
        }
        catch (BenutzerExistiertBereits e){
            System.out.println("Benutzer anlegen fehlgeschlagen: Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergeben e) {
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("hallo", "54321".toCharArray()));
            verwaltung.benutzerLöschen(new Benutzer("hallo", "54321".toCharArray()));

        }
        catch (BenutzerExistiertBereits e){
            System.out.println("Benutzer anlegen fehlgeschlagen: Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergeben e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerNichtVorhanden e){
            System.out.println("Löschen fehlgeschlagen: Benutzer nicht vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerKonnteNIchtGelöschtWerden e){
            System.out.println("Löschen fehlgeschlagen: Benutzer konnte nicht gelöscht werden");
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "54321".toCharArray()));
        }
        catch (BenutzerExistiertBereits e){
            System.out.println("Benutzer anlegen fehlgeschlagen: Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergeben e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerLöschen(new Benutzer("helloo", "peter".toCharArray()));
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.benutzerLöschen(new Benutzer());
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.printUsers();
        }
        catch (BenutzerExistiertBereits e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergeben e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerNichtVorhanden e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer nicht vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerKonnteNIchtGelöschtWerden e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer konnte nicht gelöscht werden");
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.benutzerLöschen(new Benutzer());
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.printUsers();
        }
        catch (BenutzerExistiertBereits e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergeben e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerNichtVorhanden e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer nicht vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerKonnteNIchtGelöschtWerden e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer konnte nicht gelöscht werden");
            e.printStackTrace();
        }


    }

}
