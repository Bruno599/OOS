package prak4gemklassen;

import java.io.Serializable;
import java.util.Arrays;

public class Benutzer implements Serializable {

    public
    String userID;      // BenutzerID des Benutzers
    public
    char[] passWort;    // Passwort des Benutzers

    /**
     * Defaultconstuktor der Klasse prak4gemklassen.Benutzer
     */

    public  Benutzer(){
        this.userID = "";
        this.passWort = new char[0];
    }

    /**
     * Überladener Konstuktor der Klasse prak4gemklassen.Benutzer
     */

    public Benutzer(String id, char[] pw){
        this.userID = id;
        this.passWort = pw;
    }

    public String getUserID() {
        return userID;
    }

    public char[] getPassWort() {
        return passWort;
    }

    /**
     * Überlagerte methode equals der Klasse prak4gemklassen.Benutzer
     * Hierbei habe ich nicht den in den Praktikumsunterlagen vorgeschalgenen
     * weg über die copyValueOf funktion von Strings genutzt sondern
     * mich den ArrayUtils bedient
     */

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Benutzer &&
                this.userID.equals(((Benutzer) obj).userID) &&
                Arrays.toString(this.passWort).equals(Arrays.toString(((Benutzer) obj).passWort)));

    }

    /**
     * Überlagrte Funktion toString der Klasse prak4gemklassen.Benutzer
     */
    @Override
    public String toString() {
        return "prak4gemklassen.Benutzer{" +
                "userID='" + userID + '\'' +
                ", passWort=" + Arrays.toString(passWort) +
                '}';
    }


}
