import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FolderLoop
{
    public static void MapFiles(Tree tree)
    {
        File[] filesInFolder = tree.FilePath.listFiles();
        Arrays.sort(filesInFolder);

        for(File f : filesInFolder)
        {
            if(f.isDirectory())
            {
                Tree t = new Tree(f);
                tree.DirectoryChildren.add(t);
                System.out.println(t.FilePath.toString());
                MapFiles(t);
            }

            String[] pieces = f.toString().split("\\.");
            
            //itt lehet bővíteni egyéb kiterjesztésekre
            if(pieces[pieces.length-1].equals("jpg") || pieces[pieces.length-1].equals("png") || pieces[pieces.length-1].equals("gif"))
            {
                Tree t = new Tree(f);
                tree.FileChildren.add(t);
            }
        }

    }

    public static boolean isMainIndex = true;

    public static int howDeep = 0;

    public static void LoopAndGenerate(Tree t) throws IOException
    {
        howDeep++;
        if(isMainIndex == true)
        {
            HtmlSpecial.GenerateFolderIndex(t);
            isMainIndex = false;
        }
        else
        {
            HtmlSpecial.GenerateFolderIndex(t);
        }

        for(Tree inTree : t.FileChildren)
        {
            HtmlSpecial.GenerateImagePage(inTree,t);
        }

        for(Tree inTree : t.DirectoryChildren)
        {
            LoopAndGenerate(inTree);
            howDeep--;
        }
    }
}
