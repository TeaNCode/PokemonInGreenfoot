import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
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
     * Assemble the variables in a string format for writing to text file and then writes it,
     * with a backup created encase saving fails
     */
    public void assembleSave()
    {
        SaveData savedata = new SaveData(false);
        toSave = savedata.Name + " " + String.valueOf(savedata.TrainerID) + " " + 
        savedata.RName + " " + String.valueOf(savedata.SecretID) + " " + 
        String.valueOf(savedata.Money) + " " + savedata.Gender + " \n" + 
        String.valueOf(savedata.Boulder) + " " + String.valueOf(savedata.Cascade) + " " + 
        String.valueOf(savedata.Thunder) + " " + String.valueOf(savedata.Rainbow) + " " + 
        String.valueOf(savedata.Soul) + " " + String.valueOf(savedata.Marsh) + " \n" + 
        String.valueOf(savedata.Volcano) + " " + String.valueOf(savedata.Earth) + " ";
        try
        {
            File save = new File(path);
            File saveBackup = new File(path + ".backup");
            if(save.isFile()) 
            {
                if(save.canRead() && save.canWrite()) save.renameTo(saveBackup);
                else System.out.println("Fatal error: Save.txt exists but cannot be read/writen."
                +"\nPlease try running this project at a different file location");
            }
            writeToFile(toSave);
            saveBackup.delete();
        }
        catch (IOException e)
        {
            System.out.println(e + "\nSave file will be replaced from backup");
            File saveBackup = new File(path + ".backup");
            File save = new File(path);
            saveBackup.renameTo(save);
        }
    }
}