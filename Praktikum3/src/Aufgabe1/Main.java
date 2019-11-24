package Aufgabe1;

import java.io.IOException;

public class Main {


    public static void main(String[] args){

        String datei = "test.txt";

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
            verwaltung.dbInitialisieren(datei);
        }
        catch(DateiwurdeNichtGeloeschtExeption e){
            System.out.println("Datei konnte nicht gelöscht werden, bitte Datei aus dem Zugriff nehmen");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer());
        }
        catch (BenutzerExistiertBereitsExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergebenExeption e) {
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerIstLeerExeption e){
            System.out.println("Eingegebener Benutzer ist leer, bitte BenutzerID und Passwort angeben");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray()));
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray())); //
        }
        catch (BenutzerExistiertBereitsExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergebenExeption e) {
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerIstLeerExeption e){
            System.out.println("Eingegebener Benutzer ist leer, bitte BenutzerID und Passwort angeben");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("hallo", "54321".toCharArray()));
            verwaltung.benutzerLoeschen(new Benutzer("hallo", "54321".toCharArray()));

        }
        catch (BenutzerExistiertBereitsExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergebenExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerNichtVorhandenExeption e){
            System.out.println("Löschen fehlgeschlagen: Benutzer nicht vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerKonnteNIchtGeloeschtWerdenExeption e){
            System.out.println("Löschen fehlgeschlagen: Benutzer konnte nicht gelöscht werden");
            e.printStackTrace();
        }
        catch (BenutzerIstLeerExeption e){
            System.out.println("Eingegebener Benutzer ist leer, bitte BenutzerID und Passwort angeben");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "54321".toCharArray()));
        }
        catch (BenutzerExistiertBereitsExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergebenExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerIstLeerExeption e){
            System.out.println("Eingegebener Benutzer ist leer, bitte BenutzerID und Passwort angeben");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerLoeschen(new Benutzer("helloo", "peter".toCharArray()));
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.benutzerLoeschen(new Benutzer());
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.printUsers();
        }
        catch (BenutzerExistiertBereitsExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergebenExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerNichtVorhandenExeption e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer nicht vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerKonnteNIchtGeloeschtWerdenExeption e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer konnte nicht gelöscht werden");
            e.printStackTrace();
        }
        catch (BenutzerIstLeerExeption e){
            System.out.println("Eingegebener Benutzer ist leer, bitte BenutzerID und Passwort angeben");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.benutzerLoeschen(new Benutzer());
            verwaltung.benutzerEintragen(new Benutzer());
            verwaltung.printUsers();
        }
        catch (BenutzerExistiertBereitsExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "Benutzer ist schon vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerIDIstSchonVergebenExeption e){
            System.out.println("Benutzer anlegen fehlgeschlagen: " +
                    "BenutzerID ist schon vorhanden, wählen Sie eine andere BenutzerID");
            e.printStackTrace();
        }
        catch (BenutzerNichtVorhandenExeption e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer nicht vorhanden");
            e.printStackTrace();
        }
        catch (BenutzerKonnteNIchtGeloeschtWerdenExeption e){
            System.out.println("Löschen fehlgeschlagen: " +
                    "Benutzer konnte nicht gelöscht werden");
            e.printStackTrace();
        }
        catch (BenutzerIstLeerExeption e){
            System.out.println("Eingegebener Benutzer ist leer, bitte BenutzerID und Passwort angeben");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(FalscherDateiNameExeption e){
            e.printStackTrace();
        }


    }

}
