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
    private String text;
    private String line1;
    private String line2;
    private String yes;
    private String no;
    private boolean next;
    private boolean dNext;
    private Scanner scanner;
    private int count;
    private boolean once;
    private Button bYes;
    private Button bNo;
    private boolean confirmation;
    private String action;
    private int actionNum;
    public Textbox(String txt)
    {
        text = txt;
        once = true;
        confirmation = false;
        line1 = null;
        line2 = null;
        scanner = new Scanner(text);
        line1 = scanner.nextLine();
        if(scanner.hasNext()) line2 = scanner.nextLine();
        if(line2.equals("BUTTON.CONFIRMATION"))
        {
            once = false;
            line2 = null;
        }
        else
        {
            setImage(updateImg(""));
            if(scanner.hasNext()) next = true;
        }
        count = 0;
    }

    public Textbox(String txt,String acion)
    {
        action = acion.substring(3,acion.length());
        actionNum = Integer.valueOf(acion.substring(0,3));
        text = txt;
        once = true;
        confirmation = false;
        line1 = null;
        line2 = null;
        scanner = new Scanner(text);
        line1 = scanner.nextLine();
        if(scanner.hasNext())
        {
            line2 = scanner.nextLine();
            if(line2.equals("BUTTON.CONFIRMATION"))
            {
                once = false;
                line2 = null;
            }
            else if(line2.equals("TEXTBOX.DNEXT"))
            {
                dNext = true;
                line2 = null;
            }
        }
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
        if(!once)
        {
            once = true;
            confirmation();
        }
        if(Greenfoot.mouseClicked(this) && next)
        {
            next = false;
            dNext = false;
            line1 = null;
            line2 = null;
            line1 = scanner.nextLine();
            if(scanner.hasNext()) line2 = scanner.nextLine();
            if(line2.equals("BUTTON.CONFIRMATION"))
            {
                once = false;
                line2 = null;
            }
            else if(line2.equals("TEXTBOX.DNEXT"))
            {
                dNext = true;
                line2 = null;
            }
            else
            {
                setImage(updateImg(""));
                if(scanner.hasNext()) next = true;
            }
            count = 0;
        }
        else if(Greenfoot.mouseClicked(this) && !confirmation) 
        {
            ObjectStorage objectStorage = new ObjectStorage();
            if(action.equals("intro"))
                objectStorage.theGame.intro(actionNum);
            else getWorld().removeObject(this);
        }
        if(next || dNext)
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

    public void confirmation()
    {
        ObjectStorage objectstorage = new ObjectStorage();
        confirmation = true;
        String purpose = scanner.nextLine();
        line2 = scanner.nextLine();
        String yes = scanner.nextLine();
        String no = scanner.nextLine();
        bYes = new Button("tyes",this,yes,purpose);
        bNo = new Button("tno",this,no,purpose);
        objectstorage.theGame.addObject(bYes,300,375);
        objectstorage.theGame.addObject(bNo,400,375);
        setImage(updateImg(""));
    }

    public void yes(String action)
    {
        if(action.equals("gender"))
        {
            ObjectStorage objectstorage = new ObjectStorage();
            //objectstorage.theGame.addKeyboard("P");
            objectstorage.theGame.addObject(new Textbox("Alright so what is your " + 
                    "name?\nTEXTBOX.DNEXT","002intro"),300,350);
            getWorld().removeObject(bYes);
            getWorld().removeObject(bNo);
            getWorld().removeObject(this);
        }
        else if(action.equals("name"))
        {
            ObjectStorage objectstorage = new ObjectStorage();
            objectstorage.theGame.addKeyboard("R");
        }
        else if(action == "rname")
        {
            ObjectStorage objectstorage = new ObjectStorage();
            getWorld().setBackground("space1.jpg");
            getWorld().removeObjects(getWorld().getObjects(null));
        }
    }

    public void no(String action)
    {
        if(action.equals("name"))
        {
            ObjectStorage objectstorage = new ObjectStorage();
            objectstorage.done.uncutName("P");
            objectstorage.done.done = false;
        }
        else if(action.equals("rname"))
        {
            ObjectStorage objectstorage = new ObjectStorage();
            objectstorage.done.uncutName("R");
            objectstorage.done.done = false;
        }
        getWorld().removeObject(bYes);
        getWorld().removeObject(bNo);
        getWorld().removeObject(this);
    }
}
