import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Subtitle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Subtitle extends Actor
{
    /**
     * Executed whenever Subtitle is added to the world
     */
    public Subtitle()
    {
        setPicture();
    }
    /**
     * Act - do whatever the Subtitle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("enter")) //Check if should progress
        {
            Greenfoot.setWorld(new Menu());
        }
    }    
    /**
     * Sets the actor's image
     */
    public void setPicture()
    {
       setImage(new GreenfootImage("Press Enter to start",40,Color.LIGHT_GRAY,new Color(0,0,0,0))); 
    }
}
