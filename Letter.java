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
        if(type.contains("Name")) SaveData.Letters[index] = this;
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
            ObjectStorage.done = this;
        }
    }

    /**
     * Checks what type this letter is, then checks if it has been clicked on. If it is a display
     * letter then it will refresh itself.
     */
    public void act() 
    {
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
        if(type.startsWith("P") && SaveData.Name != "nullERRORplox")
            setImage(new GreenfootImage(SaveData.Name.substring(index - 1, index),70,Color.BLACK,
                    new Color(0,0,0,0)));
        else if(type.startsWith("R") && SaveData.RName != "nullERRORplox")
            setImage(new GreenfootImage(SaveData.RName.substring(index - 1, index),70,Color.BLACK,
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
        if(type.startsWith("P"))
            shortName = SaveData.Name.substring(0,charToWrite);
        else if(type.startsWith("R"))
            shortName = SaveData.RName.substring(0,charToWrite);
        if(shortName.length() < 10)
        {
            if(type.startsWith("P"))
            {
                SaveData.Name = SaveData.Name.substring(0,charToWrite) + letter;
                SaveData.Name = SaveData.Name + "__________";
                if(SaveData.Name.length() > 10) SaveData.Name = SaveData.Name.substring(0,10);
            }
            else if(type.startsWith("R"))
            {
                SaveData.RName = SaveData.RName.substring(0,charToWrite) + letter;
                SaveData.RName = SaveData.RName + "__________";
                if(SaveData.RName.length() > 10) SaveData.RName = SaveData.RName.substring(0,10);
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
        if(type.startsWith("P") && SaveData.Name != "nullERRORplox")
        {
            SaveData.Name = SaveData.Name.substring(0,charToWrite -  1);
            charToWrite--;
            SaveData.Name = SaveData.Name + "__________";
            if(SaveData.Name.length() > 10) SaveData.Name = SaveData.Name.substring(0,10);
        }
        else if(type.startsWith("R") && SaveData.RName != "nullERRORplox")
        {
            SaveData.RName = SaveData.RName.substring(0,charToWrite -  1);
            charToWrite--;
            SaveData.RName = SaveData.RName + "__________";
            if(SaveData.RName.length() > 10) SaveData.RName = SaveData.RName.substring(0,10);
        }
    }

    /**
     * Asks if the player is done inputting the name.
     */
    public void done()
    {
        if(type.startsWith("P") && SaveData.Name != "nullERRORplox")
        {
            SaveData.Name = SaveData.Name.substring(0,charToWrite);
            done = true;
            ObjectStorage.theGame.addObject(new Textbox("So your name is " + SaveData.Name + ".\n"
                    + "BUTTON.CONFIRMATION" + "\nname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
        }
        else if(type.startsWith("R") && SaveData.RName != "nullERRORplox")
        {
            SaveData.RName = SaveData.RName.substring(0,charToWrite);
            done = true;
            if(SaveData.Male)
                ObjectStorage.theGame.addObject(new Textbox("So her name is " + SaveData.RName + ".\n"
                        + "BUTTON.CONFIRMATION" + "\nrname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
            else 
                ObjectStorage.theGame.addObject(new Textbox("So his name is " + SaveData.RName + ".\n"
                        + "BUTTON.CONFIRMATION" + "\nrname" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
        }
    }

    /**
     * Reverts the cutting of the player's name done during done().
     */
    public void uncutName(String pre)
    {
        if(pre.equals("P"))
        {
            SaveData.Name = SaveData.Name + "__________";
            if(SaveData.Name.length() > 10) SaveData.Name = SaveData.Name.substring(0,10);
        }
        else if(pre.equals("R"))
        {
            SaveData.RName = SaveData.RName + "__________";
            if(SaveData.RName.length() > 10) SaveData.RName = SaveData.RName.substring(0,10);
        }
    }
}
