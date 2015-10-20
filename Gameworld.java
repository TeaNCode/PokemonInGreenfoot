import greenfoot.*;
import java.io.File;
import java.awt.*;
/**
 * Write a description of class Gameworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameworld extends World
{
    static Letter[] letters = new Letter[42];
    private TextBox input;
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
            newProfile("Name",10);
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
    public void newProfile(String prompt, int max)
    {
        addObject(new loader(),300,200);
        addObject(new TextBox(),250,250);
        GreenfootImage chat = getBackground();
        chat.setColor(Color.BLACK);
        chat.drawString("Hello, I am Anthony, your profiles soul. What is your name?", 200, 250);
        input = new TextBox();
        
        //input.acceptOnly(TextBox.LETTERS + TextBox.NUMBERS);
        //input.setMaxLength(max);
    }
}
