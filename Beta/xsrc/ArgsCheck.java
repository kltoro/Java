import java.io.File;

public class ArgsCheck
{
    private static void HibaEleresiUt()
    {
        System.err.println("Hiba : Nem jó a megadott elérési út");
        System.exit(1);
    }
    public static void Beolvas(String[] args)
    {
        if(args.length == 1)
        {
            Main.path = new File(args[0]);
            if(!Main.path.isDirectory())
            {
                HibaEleresiUt();
            }
        }
        else
        {
            HibaEleresiUt();
        }
    }
}
