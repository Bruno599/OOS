package aufgabe2;

    public class Main{

        public static void main(String[] args){

            Point punkt1 = new Point();
            Point punkt2 = new Point(5,7);
            Point punkt3 = new Point(punkt2);


            KreisVererb kreis1 = new KreisVererb();
            KreisVererb kreis2 = new KreisVererb(5,7,2);
            KreisVererb kreis3 = new KreisVererb(kreis2);



            kreis1.setLocation(5,7);
            kreis2.printkreis();
            kreis3.printkreis();

            if(kreis2.equals(kreis3)) {
                System.out.println("Die beiden Kreise sind gleich");
            } else {
                System.out.println("Die beiden Kreise sind ungleich");
            }

            if(kreis1.equals(kreis3)) {
                System.out.println("Die beiden Kreise sind gleich");
            } else {
                System.out.println("Die beiden Kreise sind ungleich");
            }

            System.out.print("Kreis 1 vor dem Move: ");
            System.out.println(kreis1.toString());

            kreis1.move(5,6);

            System.out.print("Kreis 1 nach dem Move: ");
            System.out.println(kreis1.toString());


        }




            }