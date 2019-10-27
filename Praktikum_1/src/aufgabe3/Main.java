package aufgabe3;

public class Main {

    public static void main(String[] args){

        Formen[] baukloetze = new Formen[4];

        baukloetze[0] = new Rechteck(3,4,7,8);
        baukloetze[1] = new Rechteck(12,6,9,18);
        baukloetze[2] = new KreisAgg(3,2,1); //meins
        baukloetze[3] = new KreisAgg(3,2,8);

        double gesamtfaeche = 0;
        for(int i = 0;i <= 3;i++) {
            gesamtfaeche += baukloetze[i].flaecheninhalt();
            System.out.println("Objekt" + i + ": "+ baukloetze[i].flaecheninhalt());
        }

        System.out.println("Gesamtflaeche: " + gesamtfaeche );

    }




}
