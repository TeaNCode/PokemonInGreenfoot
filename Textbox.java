import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
/**
 * Write a description of class Textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textbox extends Actor
{
    public String text;
    public String line1;
    public String line2;
    public Textbox(String txt)
    {
        GreenfootImage Background = new GreenfootImage("White600x100.png");
        setImage(Background);
        text = txt;
        line1 = null;
        line2 = null;
        Scanner scanner = new Scanner(text);
        line1 = scanner.nextLine();
        if(scanner.hasNext()) line2 = scanner.nextLine();
        //GreenfootImage Line1 = new GreenfootImage(line1,25,Color.BLACK,new Color(0,0,0,0));
        //GreenfootImage Line2 = new GreenfootImage(line2,25,Color.BLACK,new Color(0,0,0,0));
        //Background.drawImage(Line1,300,300);
        //Background.drawImage(Line2,300,350);
        //setImage(Background);
        Background.setColor(Color.BLACK);
        Background.drawString(line1,300,300);
        if(line2 != null) Background.drawString(line2,300,350);
        setImage(Background);
    }
    
    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}
