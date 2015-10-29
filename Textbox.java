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
    private boolean next;
    private Scanner scanner;
    private int count;
    public Textbox(String txt)
    {
        text = txt;
        line1 = null;
        line2 = null;
        scanner = new Scanner(text);
        line1 = scanner.nextLine();
        if(scanner.hasNext()) line2 = scanner.nextLine();
        setImage(updateImg(""));
        if(scanner.hasNext()) next = true;
        count = 0;
    }

    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && next)
        {
            line1 = null;
            line2 = null;
            line1 = scanner.nextLine();
            if(scanner.hasNext()) line2 = scanner.nextLine();
            setImage(updateImg(""));
            if(scanner.hasNext()) next = true;
            else next = false;
            count = 0;
        }
        else if(Greenfoot.mouseClicked(this)) getWorld().removeObject(this);
        if(next)
        {
            count++;
            if(count < 31) setImage(updateImg("T"));
            else if(count == 60)count = 0;
            else setImage(updateImg("TE"));
        }
    }    

    public GreenfootImage updateImg(String end)
    {
        GreenfootImage Background = new GreenfootImage("White600x100" + end + ".png"); 
        Background.setColor(Color.BLACK);
        Background.setFont(new Font("Serif",Font.PLAIN,20));
        Background.drawString(line1,10,25);
        if(line2 != null) Background.drawString(line2,10,75);
        return Background;
    }

    public void yes(String acion)
    {

    }

    public void no(String acion)
    {

    }
}
