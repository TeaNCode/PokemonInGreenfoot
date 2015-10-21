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
    private String type;
    private int index;
    public Letter(String typ,String lttr,int indx)
    {
        index = indx;
        letter = lttr;
        type = typ;
       if(type == "PName") setImage(new GreenfootImage(letter,30,Color.BLACK,new Color(0,0,0,0)));
       else setImage(new GreenfootImage("_",30,Color.BLACK,new Color(0,0,0,0)));
    }
    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SaveData savedata = new SaveData();
        if(type == "PName" && Greenfoot.mouseClicked(this))
        {
            if(savedata.Name == "nullERRORplox") savedata.Name = letter;
            else if(savedata.Name.length() < 10) savedata.Name = savedata.Name + letter;
        }
        else if(type == "PDisplay1")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(0)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay2")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(1)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay3")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(2)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay4")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(3)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay5")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(4)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay6")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(5)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay7")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(6)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay8")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(7)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay9")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(8)),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type == "PDisplay10")
        {
            if(savedata.Name != "nullERRORplox") 
            setImage(new GreenfootImage(Character.toString(savedata.Name.charAt(9)),30,Color.BLACK,new Color(0,0,0,0)));
        }
    }    
}
