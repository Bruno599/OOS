public class ExceptionHandling extends Exception {

    public ExceptionHandling(){

    }

    public ExceptionHandling (String message){
        super(message);
    }

}

class BenutzerExistiertBereitsExeption extends Exception {
    public BenutzerExistiertBereitsExeption(String message){
        super(message);
    }

}

class BenutzerIDIstSchonVergebenExeption extends Exception {
    public BenutzerIDIstSchonVergebenExeption(String message){
        super(message);
    }
}

class BenutzerKonnteNIchtGeloeschtWerdenExeption extends Exception {
    public BenutzerKonnteNIchtGeloeschtWerdenExeption(String message){
        super(message);
    }
}

class BenutzerNichtVorhandenExeption extends Exception {
    public BenutzerNichtVorhandenExeption(String message){
        super(message);
    }
}

class BenutzerIstLeerExeption extends Exception {
    public BenutzerIstLeerExeption(String message) { super(message);}
}

class DateiwurdeNichtGeloeschtExeption extends Exception {
    public DateiwurdeNichtGeloeschtExeption(String message) { super(message);}
}

class FalscherDateiNameExeption extends Exception {
    public FalscherDateiNameExeption(String message) { super(message);}
}

