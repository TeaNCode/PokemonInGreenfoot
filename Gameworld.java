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
    static Letter[] Letters = new Letter[42];
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
            pickName();
        }
        else if(typ == "continuegame")
        {

        }
        else System.out.println("Fatal Error: invalid save-handling type");
    }
    public void Save()
    {
        Save save = new Save("Save.txt");
        save.assembleSave();
    }
    public void pickName()
    {
        setBackground("White.png");
        for(int i = 1; i < 11;  i++) addObject(new Letter("PDisplay" + i,"a",0),75 + (i * 25),75);
        addObject(new Letter("PName","a",0),100,150);
    }
}
