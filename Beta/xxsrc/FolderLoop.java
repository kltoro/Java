import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FolderLoop
{
    public static boolean isMainIndex = true;

    public static int howDeep = 0;

    private static List<File> getFilesInFolder(File[] aFiles)
    {
        List<File> fajlok = new ArrayList<>();
        for(File f : aFiles)
        {
            if(!f.isDirectory())
            {
                fajlok.add(f);
            }
        }
        return fajlok;

    }
    
    public static void MapFiles(File inputPath)
    {
        File[] filesInFolder = inputPath.listFiles();
        Arrays.sort(filesInFolder);
        
        for(File f : filesInFolder)
        {
            if(f.isDirectory())
            {
                if(isMainIndex == true)
                {
                    HtmlSpecial.GenerateMainIndex(f);
                }
                else
                {
                    HtmlSpecial.GenerateFolderIndex(f);
                }
                System.out.println(f.toString());
                MapFiles(f);
            }

            String[] pieces = f.toString().split("\\.");

            File[] fajlok = getFilesInFolder(filesInFolder).toArray();
            
            //itt lehet bővíteni egyéb kiterjesztésekre
            if(pieces[pieces.length-1].equals("jpg") || pieces[pieces.length-1].equals("png") || pieces[pieces.length-1].equals("gif"))
            {
                HtmlSpecial.GenerateImagePage(t,);
            }
        }

    }



    // public static void LoopAndGenerate(Tree t) throws IOException
    // {
    //     howDeep++;
    //     if(isMainIndex == true)
    //     {
    //         HtmlSpecial.GenerateMainIndex(t);
    //         isMainIndex = false;
    //     }
    //     else
    //     {
    //         HtmlSpecial.GenerateFolderIndex(t);
    //     }

    //     for(Tree inTree : t.FileChildren)
    //     {
    //         //HtmlSpecial.GenerateImagePage(inTree,t);
    //     }

    //     for(Tree inTree : t.DirectoryChildren)
    //     {
    //         LoopAndGenerate(inTree);
    //         howDeep--;
    //     }
    // }
}
