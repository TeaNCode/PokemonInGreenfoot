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
 * (but remember to import java.io.IOException;)
 * public void Print()
{
try
{
Save data = new Save("IOTest.txt");
data.writeToFile("Just another line of text/nBut this is a seperate line");
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
    private String toSave;
    /**
     * Save class requires a file path to be passed to it
     */
    public Save(String file_path)
    {
        path = file_path;
        toSave = null;
    }

    /**
     * Writes a String 'textLine' to a text document at 'path'
     */
    public void writeToFile(String textLine) throws IOException
    {
        FileWriter write = new FileWriter(path);
        PrintWriter print_line = new PrintWriter(write);
        print_line.printf("%s" + "%n",textLine);
        print_line.close();
    }

    /**
     * Assemble the variables in a string format for writing to text file
     */
    public void assembleSave()
    {
        SaveData savedata = new SaveData(false);
        toSave = savedata.Name + " " + String.valueOf(savedata.Female);
        try
        {
            writeToFile(toSave);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}