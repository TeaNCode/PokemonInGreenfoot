import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Write a description of class Save here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Example usage:
 * public void Print()
{
try
{
Save data = new Save("D:\\IOTest.txt");
data.writeToFile("Just another line of text");
}
catch(IOException e)
{
System.out.println(e);
}
}
 */
public class Save
{
    private String path;
    /**
     * Save class requires a file path to be passed to it
     */
    public Save(String file_path)
    {
        path = file_path;
    }

    public void writeToFile(String textLine) throws IOException
    {
        FileWriter write = new FileWriter(path);
        PrintWriter print_line = new PrintWriter(write);
        print_line.printf("%s" + "%n",textLine);
        print_line.close();
    }
}
