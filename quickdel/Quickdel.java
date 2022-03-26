import java.io.File;

class Quickdel
{
    public static void LoopThrough(File p)
    {
        if(p.listFiles() != null)
        {
            for (File f : p.listFiles())
            {
                LoopThrough(f);
                //System.out.println(f.getPath());
                if(!f.isDirectory())
                {
                    String[] pieces = f.toString().split("\\.");
                    
                    if(pieces[pieces.length-1].equals("html"))
                    {
                        System.out.println("deleted : " + f.toString());
                        f.delete();
                    }    
                }
            }
        }
    }
    public static void main(String[] args)
    {
        File argFile = new File(args[0]);
        LoopThrough(argFile);
    }
}