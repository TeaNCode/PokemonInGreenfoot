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
    static int charToWrite;
    public Letter(String typ,String lttr,int indx)
    {
        index = indx;
        letter = lttr;
        type = typ;
        charToWrite = 1;
        if(type == "PName") setImage(new GreenfootImage(letter,50,Color.BLACK,new Color(0,0,0,0)));
        else setImage(new GreenfootImage("_",70,Color.BLACK,new Color(0,0,0,0)));
    }

    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SaveData savedata = new SaveData();
        if(type == "PName")
        {
            if(Greenfoot.mouseClicked(this))
            {
                updateName();
            }
        }
        else if(savedata.Name != "nullERRORplox")updatePicture();
    }    

    public void updatePicture()
    {
        SaveData savedata = new SaveData();
        setImage(new GreenfootImage(savedata.Name.substring(index - 1, index),70,Color.BLACK,new Color(0,0,0,0)));
        //System.out.println(savedata.Name);
    }

    public void updateName()
    {
        SaveData savedata = new SaveData();
        if(savedata.Name == "nullERRORplox") savedata.Name = letter + "_________";
        else
        {
            String shortName = savedata.Name.substring(0,charToWrite);
            if(shortName.length() < 10)
            {
                savedata.Name = savedata.Name.substring(0,charToWrite) + letter;
                //savedata.Name.concat("_________");
                savedata.Name = savedata.Name + "__________";
                if(savedata.Name.length() > 10) savedata.Name = savedata.Name.substring(0,10);
                //System.out.println("Printing parts of name: \n" //For debugging
                //    + savedata.Name.substring(0,charToWrite) + " " + letter); //For debugging
                charToWrite++;
            }
        }
        //System.out.println(savedata.Name); //For debugging
    }
}
