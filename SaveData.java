import greenfoot.Greenfoot;
/**
 * Write a description of class SaveData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveData  
{
    static boolean loaded;
    static Letter[] Letters = new Letter[40];
    static String Name;
    static int TrainerID;
    static String RName;
    static int SecretID;
    static int Money;
    static boolean Male;
    static boolean Boulder;
    static boolean Cascade;
    static boolean Thunder;
    static boolean Rainbow;
    static boolean Soul;
    static boolean Marsh;
    static boolean Volcano;
    static boolean Earth;
    static java.awt.Color Color;
    static String ColorString;
    static long Time;
    static int[][] Party = new int[5][];
    /**
     * Constructor for objects of class SaveData
     * WARNING: THIS CONSTRUCTOR SHOULD NOT BE USED EXCEPT FOR INITIALIZING A NEW GAME
     * IT WILL OVERWRITE EVERYTHING IN SAVEDATA
     */
    public SaveData(boolean New)
    {
        if(New)
        {
            loaded = true;
            Name = "nullERRORplox";
            TrainerID = Greenfoot.getRandomNumber(65536);
            RName = "nullERRORplox";
            SecretID = Greenfoot.getRandomNumber(65536);
            Money = 0;
            Male = true;
            Boulder = false;
            Cascade = false;
            Thunder = false;
            Rainbow = false;
            Soul = false;
            Marsh = false;
            Volcano = false;
            Earth = false;
            Color = java.awt.Color.BLACK;
            Time = 0;
        }
    }
    /**
     * This constructor is used when accessing variables from SaveData
     */
    public SaveData()
    {
        
    }
}
