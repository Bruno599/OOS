package aufgabe2;

public class Point {
    int x;
    int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    ;

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    ;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point getLocation() {
        return this;
    }

    public void setLocation(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean equals(Point p) {
        return (this.x == p.x && this.y == p.y);
    }

    public String toString() {
        return ("X: " + this.x + " Y: " + this.y);
    }

    public void printpoint(){

        System.out.print("Kreiskoordinaten: \nHorizontan(X) = " + x + "\nVertikal(Y) = " + y + "\n");
    }


}
