import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Map;
import java.util.HashMap;
import java.awt.Color;
/**
 * Write a description of class OButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OButton extends Actor
{
    private String type;
    private boolean delete;
    private Map<String, Color> colorStringMap = new HashMap<String, Color>();
    static boolean update;
    /**
     * These buttons are used in the options menu. This class was made to not clutter the button
     * class further.
     */
    public OButton(String typ)
    {
        type = typ; //Store type for later use
        setPicture();
        delete = false;
        update = false;
    }

    /**
     * Checks if this has been clicked on. Also checks if the picture needs to be updated.
     */
    public void act() 
    {
        if(!update) setPicture();
        if(Greenfoot.mouseClicked(this))
        {
            SaveData savedata = new SaveData();
            ObjectStorage objectStorage = new ObjectStorage();
            if(type.startsWith("OC"))
            {
                colorStringMapping();
                savedata.Color = colorStringMap.get(type.substring(2,type.length()));
                update = false;
            }
            else
            {
                switch(type)
                {
                    case "back": if(objectStorage.lastWorld.equals("Game")) Greenfoot.setWorld(objectStorage.theGame);
                    else Greenfoot.setWorld(new Menu());
                }
            }
        }
    }    

    /**
     * Sets the actor's image depending on the type.
     */
    public void setPicture()
    {
        if(type.startsWith("OC"))
        {
            colorStringMapping();
            SaveData savedata = new SaveData();
            if(savedata.Color == colorStringMap.get(type.substring(2,type.length())) &&
            savedata.Color == Color.YELLOW)
            {
                setImage(new GreenfootImage(type.substring(2,type.length()),
                        40,colorStringMap.get(type.substring(2,type.length())),Color.ORANGE));
                        update = true;
            }
            else if(savedata.Color == colorStringMap.get(type.substring(2,type.length())))
            {
                setImage(new GreenfootImage(type.substring(2,type.length()),
                        40,colorStringMap.get(type.substring(2,type.length())),Color.YELLOW));
                        update = true;
            }
            else
                setImage(new GreenfootImage(type.substring(2,type.length()),
                        40,colorStringMap.get(type.substring(2,type.length())),new Color(0,0,0,0)));
        }
        else
        {
            switch(type)
            {
                case "back": setImage(new GreenfootImage("Back",50,Color.BLACK,new Color(0,0,0,0)));
            }
        }
    }

    /**
     * Populates the map colorStringMap which is used for converting Strings to colors.
     */
    public void colorStringMapping()
    {
        colorStringMap.put("Black",Color.BLACK);
        colorStringMap.put("Blue",Color.BLUE);
        colorStringMap.put("Cyan",Color.CYAN);
        colorStringMap.put("Dark_Gray",Color.DARK_GRAY);
        colorStringMap.put("Gray",Color.GRAY);
        colorStringMap.put("Green",Color.GREEN);
        colorStringMap.put("Light_Gray",Color.LIGHT_GRAY);
        colorStringMap.put("Magenta",Color.MAGENTA);
        colorStringMap.put("Orange",Color.ORANGE);
        colorStringMap.put("Pink",Color.PINK);
        colorStringMap.put("Red",Color.RED);
        colorStringMap.put("White",Color.WHITE);
        colorStringMap.put("Yellow",Color.YELLOW);
    }
}
