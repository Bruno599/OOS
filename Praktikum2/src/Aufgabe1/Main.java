package Aufgabe1;

public class Main {


    public static void main(String[] args){

        // test ob zwei benutzer identisch sind
        Benutzer User1 = new Benutzer("test","12345".toCharArray());
        Benutzer User2 = new Benutzer("test2", "12345".toCharArray());
        Benutzer User3 = new Benutzer("test", "12345".toCharArray());

       if(User1.equals(User2))
       {
           System.out.println("Bnutzer sind gleich");
       }
       else
       {
           System.out.println("Benutzer sind ungleich");
       }

        if(User1.equals(User3))
        {
            System.out.println("Bnutzer sind gleich");
        }
        else
        {
            System.out.println("Benutzer sind ungleich");
        }

        if(User1.equals("test"))
        {
            System.out.println("test nicht erfolgreich");
        }
        else
        {
            System.out.println("test erfolgreich");
        }



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
