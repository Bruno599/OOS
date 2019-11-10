package Aufgabe1a.Aufgabe1;

public class ExceptionHandling extends Exception {

    public ExceptionHandling(){

    }

    public ExceptionHandling (String message){
        super(message);
    }

}

class BenutzerExistiertBereits extends Exception{
    public BenutzerExistiertBereits (String message){
        super(message);
    }

}

class BenutzerIDIstSchonVergeben extends Exception{
    public BenutzerIDIstSchonVergeben (String message){
        super(message);
    }
}

class BenutzerKonnteNIchtGelöschtWerden extends Exception{
    public BenutzerKonnteNIchtGelöschtWerden (String message){
        super(message);
    }
}

class BenutzerNichtVorhanden extends Exception{
    public BenutzerNichtVorhanden (String message){
        super(message);
    }
}

