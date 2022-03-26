import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tree
{
    File FilePath;
    List<Tree> FileChildren;
    List<Tree> DirectoryChildren;

    public Tree(File aFilePath)
    {
        this.FilePath = aFilePath;
        FileChildren = new ArrayList<>();
        DirectoryChildren = new ArrayList<>();
    }

    // @Override
    // public String toString()
    // {
    //     return FilePath.toString();
    // }
}