package aufgabe2;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class KreisVererb extends Point {

    int radius;

    public KreisVererb() {

        super();
        this.radius = 0;
    }

    public KreisVererb(int x, int y, int r) {

        super(x,y);
        radius = r;
    }

    public KreisVererb(Point p, int r) {

        super(p);
        radius = r;
    }

    public KreisVererb(KreisVererb kv) {

        super(kv.x, kv.y);
        this.radius = kv.radius;
    }

    public void setRadius(int r) {

        radius = r;
    }

    public int getRadius() {

        return radius;
    }

    public boolean equals(KreisVererb kv) {

        return(this.getLocation().equals(kv.getLocation()) && this.getRadius() == kv.getRadius());
    }

    @Override
    public String toString() {

        return super.toString() + " Radius: " + this.radius;
    }

    public void printkreis(){

        printpoint();
        System.out.print("Radius = " + radius + "\n");
    }

}
