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
    public String letter;
    private String type;
    private int index;
    static int charToWrite;
    static boolean done;
    /**
     * This constructor is primarily used when making a key of a keyboard, or when displaying the
     * values of what you're typing. For other Letter uses please refer to the other constructor.
     */
    public Letter(String typ,String lttr,int indx)
    {
        index = indx;
        letter = lttr;
        type = typ;
        charToWrite = 1;
        setImage(new GreenfootImage(letter,50,Color.BLACK,new Color(0,0,0,0)));
        if(type. setImage(new GreenfootImage("_",70,Color.BLACK,new Color(0,0,0,0)));
        SaveData savedata = new SaveData();
        if(type == "PName" || type == "RName") savedata.Letters[index] = this;
    }
    /**
     * This constructor is used for objects that aren't part of the keyboard or displaying what it is
     * typing, but associated with it (Usually by need of the charToWrite value).
     */
    public Letter(String typ)
    {
        type = typ;
        done = false;
        if(type == "PDel") setImage(new GreenfootImage("Backspace",45,Color.BLACK,
                    new Color(0,0,0,0)));
        else if(type == "PDone") setImage(new GreenfootImage("Done",50,Color.BLACK,
                    new Color(0,0,0,0)));
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
            if(Greenfoot.mouseClicked(this))updateName();
        }
        else if(type == "PDel")
        {
            if(Greenfoot.mouseClicked(this))delChar();
        }
        else if(type == "PDone")
        {
            if(Greenfoot.mouseClicked(this))done();
        }
        else if(savedata.Name != "nullERRORplox" && !done)updatePicture();
    }    

    public void updatePicture()
    {
        SaveData savedata = new SaveData();
        setImage(new GreenfootImage(savedata.Name.substring(index - 1, index),70,Color.BLACK,
        new Color(0,0,0,0)));
        //System.out.println(savedata.Name);
    }

    public void updateKeyboard()
    {
        if(type == "PName") setImage(new GreenfootImage(letter,50,Color.BLACK,new Color(0,0,0,0)));
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
                savedata.Name = savedata.Name + "__________";
                if(savedata.Name.length() > 10) savedata.Name = savedata.Name.substring(0,10);
                charToWrite++;
            }
        }
        //System.out.println(savedata.Name); //For debugging
    }

    public void delChar()
    {
        SaveData savedata = new SaveData();
        if(savedata.Name != "nullERRORplox")
        {
            savedata.Name = savedata.Name.substring(0,charToWrite -  1);
            charToWrite--;
            savedata.Name = savedata.Name + "__________";
            if(savedata.Name.length() > 10) savedata.Name = savedata.Name.substring(0,10);
        }
    }
    
    public void done()
    {
        done = true;
        SaveData savedata = new SaveData();
        if(savedata.Name != "nullERRORplox")
        {
            savedata.Name = savedata.Name.substring(0,charToWrite);
            confirmName();
        }
    }
    
    public void confirmName()
    {
        ObjectStorage objectstorage = new ObjectStorage();
        SaveData savedata = new SaveData();
        objectstorage.theGame.addObject(new Textbox("So your name is " + savedata.Name + ".\n"
        + "BUTTON.CONFIRMATION" + "\nname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
    }
}
