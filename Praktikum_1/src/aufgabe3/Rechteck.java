package aufgabe3;

public class Rechteck implements Formen{

    Point punkt1;
    Point punkt2;

    public Rechteck(){

        this.punkt1 = new Point();
        this.punkt2 = new Point();
    }

    public Rechteck(int a1, int a2,int b1,int b2){

        this.punkt1 = new Point(a1,a2);
        this.punkt2 = new Point(b1,b2);
    }

    public Rechteck(Point punkt1, Point punkt2) {

        this.punkt1 = punkt1;
        this.punkt2 = punkt2;
    }

    public double flaecheninhalt(){
        int seiteA = Math.abs(this.punkt2.x - this.punkt1.x);
        int seiteB = Math.abs(this.punkt2.y - this.punkt1.y);

        return seiteA * seiteB;
    }

    @Override
    public String toString() {
        return ("ObenLinks: " + this.punkt1.toString() + "UntenRechts: " + this.punkt2.toString());
    }

    public boolean equals(Rechteck re) {
        return (this.punkt1.equals(re.punkt1)&&this.punkt2.equals(re.punkt2)
                || this.punkt1.equals(re.punkt2)&&this.punkt2.equals(re.punkt1));
    }

    @Override
    public Rechteck clone(){
        return new Rechteck(this.punkt1, this.punkt2);
    }
}
