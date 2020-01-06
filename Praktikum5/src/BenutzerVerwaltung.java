
import java.io.IOException;

/**
 * Interface Benutzerverwaltung
 */

public interface BenutzerVerwaltung {

    /**
     * Die Funktion "benutzerEintragen" wird in der Classe "BenutzerVerwaltungAdmin" implementiert
     */

    public void benutzerEintragen (Benutzer benutzer) throws BenutzerExistiertBereitsExeption, BenutzerIDIstSchonVergebenExeption, BenutzerIstLeerExeption, ClassNotFoundException, IOException, FalscherDateiNameExeption;

    /**
     * Die Funktion "benutzerOk" wird in der Classe "BenutzerVerwaltungAdmin" implementiert
     */
    public boolean benutzerOk (Benutzer benutzer) throws Exception;
}
