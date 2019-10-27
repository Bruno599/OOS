package aufgabe1;

public class Pascdreieck {

            int tiefe = 0;
            int [][] dreieck;

        public Pascdreieck(int t) {

            tiefe = t;
            dreieck = new int[t][];

            int i;
            int j;

            for (i=0;i<tiefe;i++)
            {
                dreieck[i] = new int[i+1];
                dreieck[i][0] = 1;

                for(j=1;j<i;j++)
                {
                    dreieck[i][j] = dreieck[i-1][j-1]+dreieck[i-1][j];
                }

                dreieck[i][i] = 1;
            }

        };

        public void print_pascdreieck(){

            int t = this.tiefe;
            int i;
            int j;

            for(i = 0; i<t; i++){

                for(j = 0; j <= i;j++){

                    System.out.print(dreieck[i][j] + " ");
                }
                System.out.print("\n");
            }
        }

       /** public void print_pascdreieck()
        {

            int j = 5;
            //Hauptschleife:
            for(int i = 1; i < j; i++)
            {
                int l = 1;
                for( ; l <= i; l++)
                {
                    System.out.print( ((i-1) + (l-1) + l) + " ");

                    if (l == i)
                    {
                        l -= 1;
                        break;
                    }
                }


                for( ; l > 0; l--)
                {
                    System.out.print(l + " ");
                }


                System.out.println();
                //continue Hauptschleife;

            }
        }

        public void bprintp(String[] out)
        {
            System.out.print(out);
        }

        **/

}
