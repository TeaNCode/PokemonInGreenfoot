import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.awt.Color;
import java.util.Map;
import java.util.HashMap;
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
    private Map<Color, String> colorMap = new HashMap<Color, String>();
    /**
     * Save class requires a file path to be passed to it
     */
    public Save(String file_path)
    {
        path = file_path;
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
        getColorString();
        String toSave = SaveData.Name + " " + String.valueOf(SaveData.TrainerID) + " " + 
        SaveData.RName + " " + String.valueOf(SaveData.SecretID) + " " + 
        String.valueOf(SaveData.Money) + " " + String.valueOf(SaveData.Male) + " \n" + 
        String.valueOf(SaveData.Boulder) + " " + String.valueOf(SaveData.Cascade) + " " + 
        String.valueOf(SaveData.Thunder) + " " + String.valueOf(SaveData.Rainbow) + " " + 
        String.valueOf(SaveData.Soul) + " " + String.valueOf(SaveData.Marsh) + " \n" + 
        String.valueOf(SaveData.Volcano) + " " + String.valueOf(SaveData.Earth) + " " +
        SaveData.ColorString + " " + String.valueOf(SaveData.Time) + " ";
        writeSave(toSave);
    }
    
    /**
     * Writes the Stringified save data. Writes 'toWrite' to 'path'.
     */
    public void writeSave(String toWrite)
    {
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
            writeToFile(toWrite);
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
    
    /**
     * Loads the colorMap HashMap and then sets SaveData.ColorString
     */
    public void getColorString()
    {
        colorMap.put(Color.BLACK,"Black");
        colorMap.put(Color.BLUE,"Blue");
        colorMap.put(Color.CYAN,"Cyan");
        colorMap.put(Color.DARK_GRAY,"Dark_Gray");
        colorMap.put(Color.GRAY,"Gray");
        colorMap.put(Color.GREEN,"Green");
        colorMap.put(Color.LIGHT_GRAY,"Light_Gray");
        colorMap.put(Color.MAGENTA,"Magenta");
        colorMap.put(Color.ORANGE,"Orange");
        colorMap.put(Color.PINK,"Pink");
        colorMap.put(Color.RED,"Red");
        colorMap.put(Color.WHITE,"White");
        colorMap.put(Color.YELLOW,"Yellow");
        SaveData SaveData = new SaveData();
        SaveData.ColorString = colorMap.get(SaveData.Color);
    }
}