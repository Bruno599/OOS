package Aufgabe1a.Aufgabe1;

import java.util.Arrays;

public class Benutzer {

    String userID;
    char passWort[];

    public  Benutzer(){
        this.userID = "";
        this.passWort = new char[0];
    }

    public Benutzer(String id, char[] pw){
        this.userID = id;
        this.passWort = pw;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Benutzer &&
                this.userID.equals(((Benutzer) obj).userID) &&
                Arrays.toString(this.passWort).equals(Arrays.toString(((Benutzer) obj).passWort)));

    }

    @Override
    public String toString() {
        return "Benutzer{" +
                "userID='" + userID + '\'' +
                ", passWort=" + Arrays.toString(passWort) +
                '}';
    }
}
