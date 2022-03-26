//Speciális esetek
//1. Main index
//2. almappa index
//3. első kép
//4. utolsó kép

//Feltérképeztük
/*
    Végig megyünk a saját fán
    először generáljuk a mainindexet
    utána generáljuk a file children htmljét
    utána tovább megyünk az almappába és geneáljuk a mappa indexát majd file html then repeat
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class HtmlSpecial extends Html
{

    public static void GenerateMainIndex(Tree inputTree)
    {
        try
        {    
            pw = new PrintWriter(inputTree.FilePath.toString() + "/index.html");
            AddHead();
            AddStart(inputTree.FilePath.toString());
            AddDirectories(inputTree);
            AddListedImages(inputTree);
            AddFooter();
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("hiba a foindex generalasa kozben");
        }
    }

    public static void GenerateFolderIndex(Tree inputTree)
    {
        try
        {
            pw = new PrintWriter(RemoveExt(inputTree) +"/index.html");
            AddHead();
            AddStart(Main.path.toString());
            AddDirectories(inputTree);
            AddListedImages(inputTree);
            AddFooter();
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("hiba a normal index generalas kozben");
        }
    }
    
    int imagecounter = 1;

    public static void GenerateImagePage(Tree inputTree, File[] eleresiutak)
    {
        try
        {
            pw = new PrintWriter(RemoveExt(inputTree) +".html");
            AddHead();
            AddStart(Main.path.toString());
            Browse(inputTree, eleresiutak);
            AddImage(inputTree);
            AddFooter();
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("hiba a kep generalas kozben");
        }

    }
}
