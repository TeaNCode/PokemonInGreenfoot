import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Github here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Github extends Actor
{
    /**
     * Executed when the actor is added to the world
     */
    public Github()
    {
        setPicture();
    }
    /**
     * Act - do whatever the Github wants to do. This method is called whenever
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
        setImage(new GreenfootImage("https://github.com/TeaNCode/PokemonInGreenfoot",20,Color.WHITE,new Color(0,0,0,0)));
    }
}
