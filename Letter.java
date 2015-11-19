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
        charToWrite = 0;
        if(type.contains("Name"))updateKeyboard();
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
     * Checks what type this letter is, then checks if it has been clicked on. If it is a display
     * letter then it will refresh itself.
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
        else if(type.contains("Display") && !done)
        {
            updatePicture();
        }
    }    

    /**
     * Called by Display type letters. Refreshes the display to make sure it is current.
     */
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

    /**
     * Called by the actual letters that you click on to display the name. Shows what letter it stands
     * for.
     */
    public void updateKeyboard()
    {
        setImage(new GreenfootImage(letter,50,Color.BLACK,new Color(0,0,0,0)));
    }

    /**
     * This is how the legit letters that you click on update the name. It updates the name then fills it with
     * underscores.
     */
    public void updateName()
    {
        SaveData savedata = new SaveData();
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

    /**
     * This deletes a character from a name. It also lowers charToWrite. It doesn't check if it is making
     * charToWrite negative, which would throw an error.
     */
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

    /**
     * Asks if the player is done inputting the name.
     */
    public void done()
    {
        SaveData savedata = new SaveData();
        if(type.startsWith("P") && savedata.Name != "nullERRORplox")
        {
            savedata.Name = savedata.Name.substring(0,charToWrite);
            done = true;
            ObjectStorage objectstorage = new ObjectStorage();
            objectstorage.theGame.addObject(new Textbox("So your name is " + savedata.Name + ".\n"
                    + "BUTTON.CONFIRMATION" + "\nname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
        }
        else if(type.startsWith("R") && savedata.RName != "nullERRORplox")
        {
            savedata.RName = savedata.RName.substring(0,charToWrite);
            done = true;
            ObjectStorage objectstorage = new ObjectStorage();
            if(savedata.Male)
                objectstorage.theGame.addObject(new Textbox("So her name is " + savedata.RName + ".\n"
                        + "BUTTON.CONFIRMATION" + "\nrname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
            else 
                objectstorage.theGame.addObject(new Textbox("So his name is " + savedata.RName + ".\n"
                        + "BUTTON.CONFIRMATION" + "\nrname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
        }
    }

    /**
     * Reverts the cutting of the player's name done during done().
     */
    public void uncutName(String pre)
    {
        SaveData savedata = new SaveData();
        if(pre.equals("P"))
        {
            savedata.Name = savedata.Name + "__________";
            if(savedata.Name.length() > 10) savedata.Name = savedata.Name.substring(0,10);
        }
        else if(pre.equals("R"))
        {
            savedata.RName = savedata.RName + "__________";
            if(savedata.RName.length() > 10) savedata.RName = savedata.RName.substring(0,10);
        }
    }
}
