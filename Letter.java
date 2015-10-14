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
    private String letter;
    private String purpose;
    public Letter(String purrpose,String lttr)
    {
        setImage(new GreenfootImage(lttr,30,Color.BLACK,new Color(0,0,0,0)));
        letter = lttr;
        purpose = purrpose;
    }
    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SaveData savedata = new SaveData();
        if(purpose == "PName" && Greenfoot.mouseClicked(this))
        {
            if(savedata.Name == "nullERRORplox") savedata.Name = letter;
            else if(savedata.Name.length() < 10) savedata.Name = savedata.Name + letter;
        }
    }    
}
