//1. beolvasunk egy elérési utat , ellenőrizzük , hogy jó-e
//2. végig iterálunk az összes mappán
//3. generate html

import java.io.File;
import java.io.IOException;

class Main
{
    public static File path;
    public static void main(String[] args) throws IOException
    {
        //String[] teszttomb = {"/home/kltoro/Java/Projects/Projektmunka/Tesztmappa/"};

        ArgsCheck.Beolvas(args);
        Tree mytree = new Tree(path);
        FolderLoop.MapFiles(mytree);
        FolderLoop.LoopAndGenerate(mytree);

        System.out.println("done");
    }
}
