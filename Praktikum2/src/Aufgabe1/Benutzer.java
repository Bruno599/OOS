package Aufgabe1;

import java.util.Arrays;

public class Benutzer {

    //private
    String userID;      // BenutzerID des Benutzers
    //private
    char[] passWort;    // Passwort des Benutzers

    /**
     * Defaultconstuktor der Klasse Benutzer
     */

    public  Benutzer(){
        this.userID = "";
        this.passWort = new char[0];
    }

    /**
     * Überladener Konstuktor der Klasse Benutzer
     */

    public Benutzer(String id, char[] pw){
        this.userID = id;
        this.passWort = pw;
    }


    /**
     * Überlagerte methode equals der Klasse Benutzer
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
     * Überlagrte Funktion toString der Klasse Benutzer
     */
    @Override
    public String toString() {
        return "Benutzer{" +
                "userID='" + userID + '\'' +
                ", passWort=" + Arrays.toString(passWort) +
                '}';
    }
}
