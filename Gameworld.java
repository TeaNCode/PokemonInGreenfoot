import greenfoot.*;
import java.io.File;
/**
 * Write a description of class Gameworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameworld extends World
{
    static Letter[] letters = new Letter[42];
    /**
     * Constructor for objects of class Gameworld.
     * 
     */
    public Gameworld(String typ)
    {    
        super(600, 400, 1,false); 
        if(typ == "newgame")
        {
            SaveData savedata = new SaveData(true);
            setBackground("White.png");
        }
        else if(typ == "continuegame")
        {

        }
        else System.out.println("Error: invalid save-handling type");
    }
    public void Save()
    {
        Save save = new Save("Save.txt");
        save.assembleSave();
    }
}
