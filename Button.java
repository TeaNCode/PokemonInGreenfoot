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
    /**
     * Executed when Button added to world.
     * Button type needs to be specified
     */
    public Button(String typ)
    {
        type = typ; //Store type for later use
        setPicture();
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
    }
}
