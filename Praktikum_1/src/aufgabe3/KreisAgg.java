package aufgabe3;

public class KreisAgg implements Formen{

    Point punkt;
    int radius;

    public KreisAgg() {

        this.punkt = new Point();
        this.radius = 1;
    }

    public KreisAgg(Point p, int r) {

        this.punkt = new Point(p);
        this.radius = r;
    }

    public KreisAgg(int x, int y, int r) {

        this.punkt = new Point(x,y);
        this.radius = r;
    }

    public double flaecheninhalt(){

        double flaeche = Math.PI * (radius * radius); // A=PI*r^2
        return flaeche;
    }

    public boolean equals(KreisAgg kagg){

        return (this.punkt.equals(kagg.punkt) && this.radius == kagg.radius);
    }

    @Override
    public KreisAgg clone() {
        return new KreisAgg(this.punkt, this.radius);
    }

    @Override
    public String toString(){
        return (this.punkt.toString() + "Radius: " + this.radius);
    }




}
