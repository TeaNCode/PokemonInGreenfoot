import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Display here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Display extends Actor
{
    /**
     * A constructor that displays 'txt' with a size of 40 in Black with a Transparent background
     */
    public Display(String txt)
    {
        setImage(new GreenfootImage(txt,40,Color.BLACK,new Color(0,0,0,0)));
    }
    /**
     * A constructor that displays 'txt' with a size of 'siz' in Black with a Transparent background
     */
    public Display(String txt,int siz)
    {
        setImage(new GreenfootImage(txt,siz,Color.BLACK,new Color(0,0,0,0)));
    }
    /**
     * A constructor that displays 'txt' with a size of 'siz' in 'colour1' with a Transparent background
     */
    public Display(String txt,int siz,Color colour1)
    {
        setImage(new GreenfootImage(txt,siz,colour1,new Color(0,0,0,0)));
    }
    /**
     * A constructor that displays 'txt' with a size of 'siz' in 'colour1' with a 'colour2' background
     */
    public Display(String txt,int siz,Color colour1,Color colour2)
    {
        setImage(new GreenfootImage(txt,siz,colour1,colour2));
    }  
}
