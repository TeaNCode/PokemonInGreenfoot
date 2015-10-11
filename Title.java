import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    /**
     * Executed whenever Title is added to the world
     */
    public Title()
    {
        setPicture();
    }
    /**
     * Act - do whatever the Title wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    /**
     * Sets the actor's image
     */
    public void setPicture()
    {
        setImage(new GreenfootImage("Pokemon in Greenfoot",50,Color.WHITE,new Color(0,0,0,0)));
    }
}
