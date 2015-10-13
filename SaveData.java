/**
 * Write a description of class SaveData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveData  
{
    static String Name;
    static boolean Female;
    static boolean Boulder;
    static boolean Cascade;
    static boolean Thunder;
    static boolean Rainbow;
    static boolean Soul;
    static boolean Marsh;
    static boolean Volcano;
    static boolean Earth;
    static int[][] Party = new int[5][];
    /**
     * Constructor for objects of class SaveData
     */
    public SaveData(boolean New)
    {
        if(New)
        {
            Name = null;
            Female = false;
            Boulder = false;
            Cascade = false;
            Thunder = false;
            Rainbow = false;
            Soul = false;
            Marsh = false;
            Volcano = false;
            Earth = false;
        }
    }
}
