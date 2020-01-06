package prak4serv;

import prak4gemklassen.*;

import java.io.IOException;

/**
 * Interface Benutzerverwaltung
 */

public interface BenutzerVerwaltung {

    /**
     * Die Funktion "benutzerEintragen" wird in der Classe "prak4client.BenutzerVerwaltungAdmin" implementiert
     */

    public void benutzerEintragen(Benutzer benutzer) throws BenutzerExistiertBereitsExeption, BenutzerIDIstSchonVergebenExeption, BenutzerIstLeerExeption, ClassNotFoundException, IOException, FalscherDateiNameExeption;

    /**
     * Die Funktion "benutzerOk" wird in der Classe "prak4client.BenutzerVerwaltungAdmin" implementiert
     */
    public boolean benutzerOk(Benutzer benutzer) throws Exception;
}
