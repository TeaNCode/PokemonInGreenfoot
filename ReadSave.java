import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * Write a description of class ReadSave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Example usage:
 * try
        {
            ReadSave file = new ReadSave("D://FileToRead.txt);
            String[] aryLines = file.OpenFile();
        }
        catch(IOException e)System.out.println(e.getMessage());
 */
public class ReadSave 
{
    private String path;
    /**
     * Constructor for objects of class ReadSave
     */
    public ReadSave(String file_path)
    {
        path = file_path;
    }

    public void act()
    {
        
    }

    public String[] OpenFile() throws IOException
    {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];
        for(int i = 0; i < numberOfLines; i++) textData[i] = textReader.readLine();
        textReader.close();
        return textData;
    }

    public int readLines() throws IOException
    {
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);
        String aLine;
        int numberOfLines = 0;
        while ((aLine = bf.readLine()) != null) numberOfLines++;
        bf.close();
        return numberOfLines;
    }
}
