import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Letter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letter extends Actor
{
    private int index;
    private String letter;
    private String type;
    public Letter(String typ,String lttr,int indx)
    {
        index = indx;
        letter = lttr;
        type = typ;
       if(type == "PName") setImage(new GreenfootImage(letter,30,Color.BLACK,new Color(0,0,0,0)));
    }
    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(type == "PName" && Greenfoot.mouseClicked(this))
        {
            SaveData savedata = new SaveData();
            if(savedata.Name == "nullERRORplox") savedata.Name = letter;
            else if(savedata.Name.length() < 10) savedata.Name = savedata.Name + letter;
        }
        else if(type == "PDisplay")
        {
            
        }
    }    
}
