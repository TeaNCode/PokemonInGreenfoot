import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String type;
    private boolean delete;
    /**
     * Executed when Button added to world.
     * Button type needs to be specified
     */
    public Button(String typ)
    {
        type = typ; //Store type for later use
        setPicture();
        delete = false;
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && type == "newgame") Greenfoot.setWorld
            (new Gameworld("newgame"));
        else if(Greenfoot.mouseClicked(this) && type == "continuegame") 
            Greenfoot.setWorld(new Gameworld("continuegame"));
        else if(Greenfoot.mouseClicked(this) && type == "lowercase")
            lowerCase();
        else if(Greenfoot.mouseClicked(this) && type == "uppercase")
            upperCase();
        if(delete) getWorld().removeObject(this);
    }    

    /**
     * Sets the actor's image depending on the type
     */
    public void setPicture()
    {
        if(type == "newgame") setImage(new GreenfootImage("New Game"
                ,40,Color.LIGHT_GRAY,new Color(0,0,0,0)));
        else if(type == "continuegame") setImage(new GreenfootImage(
                    "Continue Game",40,Color.LIGHT_GRAY,new Color(0,0,0,0)));
        else if(type == "lowercase") setImage(new GreenfootImage(
                    "lower case",40,Color.BLACK,new Color(0,0,0,0)));
        else if(type == "uppercase") setImage(new GreenfootImage(
                    "UPPER CASE",40,Color.BLACK,new Color(0,0,0,0)));
    }

    public void lowerCase()
    {
        SaveData savedata = new SaveData();
        String[] lowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n"
            ,"o","p","q","r","s","t","u","v","w","x","y","z",",",".","?","!","1","2","3","4",
                "5","6","7","8","9","0"};
        for(int i = 0; i < 40; i++)
        {
            savedata.Letters[i].letter = lowercase[i];
            savedata.Letters[i].updateKeyboard();
        }
        getWorld().addObject(new Button("uppercase"),getX(),getY());
        delete = true;
    }

    public void upperCase()
    {
        SaveData savedata = new SaveData();
        String[] uppercase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
                "R","S","T","U","V","W","X","Y","Z",",",".","?","!","1","2","3","4",
                "5","6","7","8","9","0"};
        for(int i = 0; i < 40; i++)
        {
            savedata.Letters[i].letter = uppercase[i];
            savedata.Letters[i].updateKeyboard();
        }
        getWorld().addObject(new Button("lowercase"),getX(),getY());
        delete = true;
    }
}
