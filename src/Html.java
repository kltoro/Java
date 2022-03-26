import java.io.PrintWriter;

public class Html
{
    protected static PrintWriter pw;

    protected static String RemoveExt(Tree t)
    {
        String[] pieces = t.FilePath.toString().split("\\.");
        return pieces[0];
    }

    private static String SplitDirectoryName(Tree t)
    {
        String[] pieces = t.FilePath.toString().split("/");
        return pieces[pieces.length-1];
    }
    private static String SplitFileName(Tree t)
    {
        //Visszaadja a fájlnevét kiterjesztés nélkül a kiíratáshoz
        String[] pieces = t.FilePath.toString().split("/");
        String[] filenamepieces = pieces[pieces.length-1].split("\\.");
        return filenamepieces[0];
    }
    private static String SplitToPicName(String s)
    {
        //visszaadja a fájlnevet kiterjesztéssel
        String[] pieces = s.split("/");
        return pieces[pieces.length-1];
    }
    private static String PlainName(String s)
    {
        String[] pieces = s.split("/");
        String[] finalpieces = pieces[pieces.length-1].split("\\.");
        return finalpieces[0];
    }
    protected static void AddHead()
    {
        pw.print("<!DOCTYPE html>\n" + "<html>\n");
    }
    private static int counter = 0;
    protected static void Browse(Tree inputTree, Tree prevTree)
    {
        pw.append("<a href=\"" + "index.html\">^^</a>\n");

        int imagecount = prevTree.FileChildren.size();
        String[] eleresiutak = new String[imagecount];

        for(int i = 0; i<imagecount;i++)
        {
            eleresiutak[i] = prevTree.FileChildren.toArray()[i].toString();
        }

        if(imagecount == 1)
        {
            pw.append("<h3>" + SplitFileName(inputTree) + "</h3>");
        }
        else
        {
            //ha elso
            if(counter==0)
            {
                pw.append("<h3>" + SplitFileName(inputTree) + "<a href=\"" + PlainName(eleresiutak[counter+1]) + 
                ".html\">&gt;&gt;</a></h3>");
                pw.append("<a href =\"" + PlainName(eleresiutak[counter+1]) + ".html\">");
                counter++;
            }
            //ha utolso
            else if(counter == imagecount-1)
            {
                pw.append("<h3><a href=\"" + PlainName(eleresiutak[counter-1]) + ".html\">&lt;&lt;</a>" + SplitFileName(inputTree) +
                 "</h3>");
                counter = 0;

            }
            //ha kozotte
            else
            {
                pw.append("<h3><a href=\"" + PlainName(eleresiutak[counter-1]) + ".html\">&lt;&lt;</a>" + SplitFileName(inputTree) + 
                "<a href=\"" + PlainName(eleresiutak[counter+1]) + ".html\"> &gt;&gt;</a></h3>");
                pw.append("<a href =\"" + PlainName(eleresiutak[counter+1]) + ".html\">");
                counter++;

            }

        }

    }
    protected static void AddImage(Tree inputTree)
    {
        pw.append("<img src=\"" + SplitToPicName(inputTree.FilePath.toString())+ "\" "+ "width=\"25%\" height=\"25%\""  +"></a>\n");
    }
    protected static void AddFooter()
    {
        pw.append("</body>\n" + "</html>\n");
    }

    protected static void AddStart(String mainpath)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<FolderLoop.howDeep;i++)
        {
            sb.append("../");
        }
        sb.append("index.html");

        pw.append("<a href=\"" + sb.toString() +"\"><h1> Start Page</h1></a>\n");
        pw.append("<hr>\n");
    }

    protected static void AddDirectories(Tree t)
    {
        pw.append("<h2>Directories</h2>");
        pw.append("<ul>\n");

        if(FolderLoop.isMainIndex == false)
        {
            pw.append("<li><a href=\"" + "../index.html\">^</a></li>");
        }
        for(Tree inTree : t.DirectoryChildren)
        {
            pw.append("<li>"+ "<a href=\"" + SplitDirectoryName(inTree) + "/index.html\">" + SplitDirectoryName(inTree)+ "</a></li>\n");
        }

        pw.append("</ul>\n");
        pw.append("<hr>\n");
    }
    protected static void AddListedImages(Tree t)
    {
        pw.append("<h2>Images</h2>");
        pw.append("<ul>\n");
        for(Tree inTree : t.FileChildren)
        {
            pw.append("<li>"+ "<a href=\"" + SplitFileName(inTree) +".html\">" + SplitFileName(inTree)+ "</a></li>\n");
        }

        pw.append("</ul>\n");
    }
}
