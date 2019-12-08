package Aufgabe1;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class BenutzerVerwaltungAdminTest { //extends TestCase{

    private BenutzerVerwaltungAdmin verwaltung;
    //private BenutzerVerwaltungAdmin verwaltung2;
    private Benutzer b1, b2, b3, b4, b5;

    String datei = "test.txt";

    /**
     * b1 bis b5 sind testuser die für die Tests angelegt wurden
     * @throws Exception
     */

    @Before
    public void setUp() throws Exception {
        verwaltung = new BenutzerVerwaltungAdmin();



        b1 = new Benutzer("test","12345".toCharArray());
        b2 = new Benutzer("test2", "12345".toCharArray());
        b3 = new Benutzer("test", "12345".toCharArray());
        b4 = new Benutzer();
        b5 = new Benutzer("test", "54321".toCharArray());
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Testet on die Datei Inizialisiert werden kann.
     */
    @Test
    public void dbInitialisieren() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }
    }


    @Test
    public void dbinizialisierenWennAlteDateiExistiert() {
        try {
            verwaltung.dbInitialisieren(datei);
        } catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e) {
            e.printStackTrace();
            fail("DB should be initialized without problems");
        }

        File tempFile = new File(datei);
        boolean exists = tempFile.exists();
        Assert.assertTrue(exists);
    }

    @Test
    public void dbinizialisierenWennAlteDateiNichtExistiert() {
        File tempFile = new File(datei);
        boolean exists = tempFile.exists();
        if (exists && tempFile.delete()) {
            try {
                verwaltung.dbInitialisieren(datei);
            } catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e) {
                e.printStackTrace();
                Assert.fail("DB should be initialized without problems");
            }
        } else {
            Assert.fail("failed to delete old DB file");
        }

        exists = tempFile.exists();
        Assert.assertTrue(exists);
    }


    /**
     * Testet ob die erstellte Datei beschrieben werden kann
     */

    @Test
    public void serialize() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            verwaltung.serialize(datei);
        }
        catch(IOException | FalscherDateiNameExeption e) {
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme beschrieben werden können");
        }
    }

    /**
     * Testet was passiert wenn die Datei vorher nicht inizialisiert wurde und beschrieben werden soll
     */
    @Test
    public void serializeDateiExistiertNicht() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            verwaltung.serialize("test1.txt");
            Assert.fail("Dateiname stimmt nicht mit Datei überein");
        }
        catch(IOException | FalscherDateiNameExeption e) {
            e.printStackTrace();

        }
    }

    /**
     * Testet ob von der Inizialierten Datei gelesen werden kann
     */
    @Test
    public void deserialize() {

        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            verwaltung.deserialize(datei);
        }
        catch(ClassNotFoundException | IOException e){
            e.printStackTrace();
            Assert.fail("Datei sollte deserialiert werden können");
        }
    }

    /**
     * Testet was passiert wenn die Datei nicht inizialisiert wurde und gelesen werden soll
     */
    @Test
    public void deserializeDateiExistiertNicht() {


        try{
            String testdes = "testFunktioniertNicht.txt";
            verwaltung.deserialize(testdes);
            Assert.fail("Datei existiert nicht");
        }
        catch(IOException | ClassNotFoundException e){

        }

    }

    /**
     * Testet was passiert wenn ein Benutzer eingetragen werden soll udn die Datei nicht inizialisert wurde
     */
    @Test
    public void benutzerEintragenDateiNichtInizialisiert() {

        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray()));
            Assert.fail("Bneutzer kann nicht angelegt werden, Datei nicht inizialisiert");
        }catch(BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption | BenutzerIstLeerExeption
                | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();

        }
    }

    /**
     *
     */
    @Test
    public void benutzerEintragen() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray()));
        }catch(BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption | BenutzerIstLeerExeption
                | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Benutzer sollte angelegt werden können");
        }
    }

    /**
     * Testen des Falles, das ein leerer Benutzer hinzugefügt werden soll
     */
    @Test
    public void benutzerEintragenLeer() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer());
            Assert.fail("Benutzer kann nicht angelegt werden, ist leer");
        }
        catch(BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption | BenutzerIstLeerExeption
                | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
        }
    }

    /**
     * Testen des Falles, das ein Benutzer Doppelt hinzugefügt werden soll
     */
    @Test
    public void benutzerEintragenBenutzerDoppelt() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray()));
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray()));
            Assert.fail("Benutzer sind doppelt");
        }catch(BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption | BenutzerIstLeerExeption
                | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();

        }
    }

    /**
     * Testen des Falles, das ein Benutzer mit der einer schon vorhandenen ID eingetragen werden soll
     */
    @Test
    public void benutzerEintragenIDDoppelt() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            verwaltung.benutzerEintragen(new Benutzer("test", "123456".toCharArray()));
            verwaltung.benutzerEintragen(new Benutzer("test", "654321".toCharArray()));
            Assert.fail("Benutzer sind doppelt");
        }catch(BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption | BenutzerIstLeerExeption
                | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();

        }
    }

    /**
     * Testen der Methode benutzer ok
     */
    @Test
    public void benutzerOk() {
        try{
            verwaltung.dbInitialisieren(datei);
            verwaltung.benutzerEintragen(b1);
        }catch(DateiwurdeNichtGeloeschtExeption | BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption
                | BenutzerIstLeerExeption | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerOk(b1);
        }
        catch(ClassNotFoundException | IOException e) {
            e.printStackTrace();
            Assert.fail("Benutzer Vorhanden und korrekt");
        }
    }

    /**
     * Testen der Methode BenutzerOk wenn Benutzer nicht vorhanden ist.
     */
    @Test
    public void benutzerOkBenutzerNichtVorhanden() {
        try{
            verwaltung.dbInitialisieren(datei);
        }
        catch (IOException | DateiwurdeNichtGeloeschtExeption | FalscherDateiNameExeption e){
            e.printStackTrace();
            Assert.fail("Datei sollte ohne Probleme erstellt werden können");
        }

        try{
            Assert.assertFalse(verwaltung.benutzerOk(b1));
        }
        catch(ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testen der Methode BenutzerOK wenn die Datei nicht inizialisiert worden ist
     */
    @Test
    public void benutzerOkDateiNichtInizialisiert() {
        try{
            Assert.assertFalse(verwaltung.benutzerOk(b1));
        }
        catch(ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testen der Methode Benutzerlöschen
     */
    @Test
    public void benutzerLoeschen() {
        try{
            verwaltung.dbInitialisieren(datei);
            verwaltung.benutzerEintragen(b1);
        }catch(DateiwurdeNichtGeloeschtExeption | BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption
                | BenutzerIstLeerExeption | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerLoeschen(b1);
        }
        catch(ClassNotFoundException | IOException | BenutzerKonnteNIchtGeloeschtWerdenExeption
                | BenutzerNichtVorhandenExeption | FalscherDateiNameExeption e) {
            e.printStackTrace();
            Assert.fail("Benutzer sollte gelöscht sein");
        }
    }

    /**
     * Testen der Methode Benutzer löschen, wenn der Benutzer nicht vorhanden ist
     */
    @Test
    public void benutzerLoeschenDateiNichtInizialisiert() {

        try{
            verwaltung.benutzerLoeschen(b1);
            Assert.fail("Datei wurde nicht inizialisiert");
        }
        catch(ClassNotFoundException | IOException | BenutzerKonnteNIchtGeloeschtWerdenExeption
                | BenutzerNichtVorhandenExeption | FalscherDateiNameExeption e) {
            e.printStackTrace();
        }
    }

    /**
     * Testen der Methode Benutzerlöschen, wenn die Dtaei nicht inizialisiert worden ist
     */
    @Test
    public void benutzerLoeschenNichtVorhanden() {
        try{
            verwaltung.dbInitialisieren(datei);
            verwaltung.benutzerEintragen(b1);
        }catch(DateiwurdeNichtGeloeschtExeption | BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption
                | BenutzerIstLeerExeption | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.benutzerLoeschen(b2);
            Assert.fail("Benutzer sollte nicht vorhanden sein");
        }
        catch(ClassNotFoundException | IOException | BenutzerKonnteNIchtGeloeschtWerdenExeption
                 | FalscherDateiNameExeption | BenutzerNichtVorhandenExeption e) {
            e.printStackTrace();

        }

    }


    /**
     * Testen der Methode PrintUsers
     */
    @Test
    public void printUsers() {

        try{
            verwaltung.dbInitialisieren(datei);
            verwaltung.benutzerEintragen(b1);
        }catch(DateiwurdeNichtGeloeschtExeption | BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption
                | BenutzerIstLeerExeption | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.printUsers();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            Assert.fail("Benutzer in Datenstrucktur sollten asugegeben werden können");
        }
    }

    /**
     * Testen der Methode PrintUsers, wenn die Datei nicht inizialisiert worden ist
     */
    @Test
    public void printUsersDateiNichtInizialisiert() {

        try{
            verwaltung.printUsers();
            Assert.fail("Benutzer können nicht ausgegeben werden, da keine Datei inizialiesiert wurde");
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Testen der Methode serchUserID
     */
    @Test
    public void searchUserID() {
        try{
            verwaltung.dbInitialisieren(datei);
            verwaltung.benutzerEintragen(b1);
        }catch(DateiwurdeNichtGeloeschtExeption | BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption
                | BenutzerIstLeerExeption | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            verwaltung.searchUserID(b1);
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            Assert.fail("Benutzer in Datenstrucktur sollten gefunden werden");
        }
    }

    /**
     * Testen der Methode UserID, wenn die Datei vorher nicht inizialisiert worden ist
     */
    @Test
    public void searchUserIDDateiNichtInizialisiert() {

        try{
           Assert.assertFalse(verwaltung.searchUserID(b1));
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();

        }
    }

    @Test
    public void searchUserIDNichtGefunden() {
        try{
            verwaltung.dbInitialisieren(datei);
            verwaltung.benutzerEintragen(b1);
        }catch(DateiwurdeNichtGeloeschtExeption | BenutzerExistiertBereitsExeption | BenutzerIDIstSchonVergebenExeption
                | BenutzerIstLeerExeption | ClassNotFoundException | IOException | FalscherDateiNameExeption e){
            e.printStackTrace();
        }

        try{
            Assert.assertFalse(verwaltung.searchUserID(b2));
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}