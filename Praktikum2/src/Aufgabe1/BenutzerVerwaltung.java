package Aufgabe1;

/**
 * Interface Benutzerverwaltung
 */

public interface BenutzerVerwaltung {

    /**
     * Die Funktion "benutzerEintragen" wird in der Classe "BenutzerVerwaltungAdmin" implementiert
     */

    public void benutzerEintragen (Benutzer benutzer) throws BenutzerExistiertBereits, BenutzerIDIstSchonVergeben;

    /**
     * Die Funktion "benutzerOk" wird in der Classe "BenutzerVerwaltungAdmin" implementiert
     */
    public boolean benutzerOk (Benutzer benutzer) throws Exception;
}
