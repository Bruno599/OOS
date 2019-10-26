package aufgabe1;

public class pascdreieck
{
    public static void main(String[] args)
    {
        int j = 5;
       //Hauptschleife:
       for(int i = 1; i < j; i++)
        {
            int l = 1;
            for( ; l <= i; l++)
            {
                System.out.print( l + " ");

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

}
