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
    private String shortName;
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
        if(type.contains("Name"))setImage(new GreenfootImage(letter,50,Color.BLACK,new Color(0,0,0,0)));
        if(type.contains("Display")) setImage(new GreenfootImage("_",70,Color.BLACK,new Color(0,0,0,0)));
        SaveData savedata = new SaveData();
        if(type.contains("Name")) savedata.Letters[index] = this;
    }

    /**
     * This constructor is used for objects that aren't part of the keyboard or displaying what it is
     * typing, but associated with it (Usually by need of the charToWrite value).
     */
    public Letter(String typ)
    {
        type = typ;
        done = false;
        if(type.contains("Del")) setImage(new GreenfootImage("Backspace",45,Color.BLACK,
                    new Color(0,0,0,0)));
        else if(type.contains("Done"))
        {
            setImage(new GreenfootImage("Done",50,Color.BLACK,
                    new Color(0,0,0,0)));
            ObjectStorage objectstorage = new ObjectStorage();
            objectstorage.done = this;
        }
    }

    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SaveData savedata = new SaveData();
        if(type.contains("Name"))
        {
            if(Greenfoot.mouseClicked(this))updateName();
        }
        else if(type.contains("Del"))
        {
            if(Greenfoot.mouseClicked(this))delChar();
        }
        else if(type.contains("Done"))
        {
            if(Greenfoot.mouseClicked(this))done();
        }
        else if(type.contains("Display") && !done)updatePicture();
    }    

    public void updatePicture()
    {
        SaveData savedata = new SaveData();
        if(type.startsWith("P") && savedata.Name != "nullERRORplox")
            setImage(new GreenfootImage(savedata.Name.substring(index - 1, index),70,Color.BLACK,
                    new Color(0,0,0,0)));
        else if(type.startsWith("R") && savedata.RName != "nullERRORplox")
            setImage(new GreenfootImage(savedata.RName.substring(index - 1, index),70,Color.BLACK,
                    new Color(0,0,0,0)));
    }

    public void updateKeyboard()
    {
        if(type.contains("Name")) setImage(new GreenfootImage(letter,50,Color.BLACK,
                    new Color(0,0,0,0)));
    }

    public void updateName()
    {
        SaveData savedata = new SaveData();
        if(type.startsWith("P") && savedata.Name == "nullERRORplox") 
            savedata.Name = letter + "_________";
        else if(type.startsWith("R") && savedata.RName != "nullERROXplox")
            savedata.RName = letter + "_________";
        else
        {
            if(type.startsWith("P"))
                shortName = savedata.Name.substring(0,charToWrite);
            else if(type.startsWith("R"))
                shortName = savedata.RName.substring(0,charToWrite);
            if(shortName.length() < 10)
            {
                if(type.startsWith("P"))
                {
                    savedata.Name = savedata.Name.substring(0,charToWrite) + letter;
                    savedata.Name = savedata.Name + "__________";
                    if(savedata.Name.length() > 10) savedata.Name = savedata.Name.substring(0,10);
                }
                else if(type.startsWith("R"))
                {
                    savedata.RName = savedata.RName.substring(0,charToWrite) + letter;
                    savedata.RName = savedata.RName + "__________";
                    if(savedata.RName.length() > 10) savedata.RName = savedata.RName.substring(0,10);
                }
                charToWrite++;
            }
        }
        //System.out.println(savedata.Name); //For debugging
    }

    public void delChar()
    {
        SaveData savedata = new SaveData();
        if(type.startsWith("P") && savedata.Name != "nullERRORplox")
        {
            savedata.Name = savedata.Name.substring(0,charToWrite -  1);
            charToWrite--;
            savedata.Name = savedata.Name + "__________";
            if(savedata.Name.length() > 10) savedata.Name = savedata.Name.substring(0,10);
        }
        else if(type.startsWith("R") && savedata.RName != "nullERRORplox")
        {
            savedata.RName = savedata.RName.substring(0,charToWrite -  1);
            charToWrite--;
            savedata.RName = savedata.RName + "__________";
            if(savedata.RName.length() > 10) savedata.RName = savedata.RName.substring(0,10);
        }
    }

    public void done()
    {
        SaveData savedata = new SaveData();
        if(type.startsWith("P") && savedata.Name != "nullERRORplox")
        {
            savedata.Name = savedata.Name.substring(0,charToWrite);
            confirmPName();
        }
        else if(type.startsWith("R") && savedata.RName != "nullERRORplox")
        {
            savedata.RName = savedata.RName.substring(0,charToWrite);
            confirmRName();
        }
    }

    public void confirmPName()
    {
        done = true;
        ObjectStorage objectstorage = new ObjectStorage();
        SaveData savedata = new SaveData();
        objectstorage.theGame.addObject(new Textbox("So your name is " + savedata.Name + ".\n"
                + "BUTTON.CONFIRMATION" + "\nname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
    }

    public void confirmRName()
    {
        done = true;
        ObjectStorage objectstorage = new ObjectStorage();
        SaveData savedata = new SaveData();
        if(savedata.Male)
        objectstorage.theGame.addObject(new Textbox("So her name is " + savedata.RName + ".\n"
                + "BUTTON.CONFIRMATION" + "\nname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
        else 
        objectstorage.theGame.addObject(new Textbox("So his name is " + savedata.RName + ".\n"
                + "BUTTON.CONFIRMATION" + "\nname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
    }
    
    public void uncutName(String pre)
    {
        SaveData savedata = new SaveData();
        if(pre == "P")
        savedata.Name = savedata.Name.substring(0,charToWrite);
        else savedata.RName = savedata.RName.substring(0,charToWrite);
    }
}
