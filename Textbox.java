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
    private Scanner textInput;
    private int count;
    private boolean once;
    private Button bYes;
    private Button bNo;
    private boolean confirmation;
    private String action;
    private int actionNum;
    /**
     * Adds a scanner, textInput, that contains the text that will be displayed.
     * Also checks if a confirmation box is supposed to be displayed.
     */
    public Textbox(String txt)
    {
        text = txt;
        once = true;
        confirmation = false;
        line1 = null;
        line2 = null;
        textInput = new Scanner(text);
        line1 = textInput.nextLine();
        if(textInput.hasNext()) line2 = textInput.nextLine();
        if(line2.equals("BUTTON.CONFIRMATION"))
        {
            once = false;
            line2 = null;
        }
        else
        {
            setImage(updateImg(""));
            if(textInput.hasNext()) next = true;
        }
        count = 0;
    }

    /**
     * Adds a scanner, textInput, that contains the text that will be displayed.
     * Also checks if a confirmation box is supposed to be displayed.
     * These text boxes will also preform an action when they're closed.
     */
    public Textbox(String txt,String acion)
    {
        action = acion.substring(3,acion.length());
        actionNum = Integer.valueOf(acion.substring(0,3));
        text = txt;
        once = true;
        confirmation = false;
        line1 = null;
        line2 = null;
        textInput = new Scanner(text);
        line1 = textInput.nextLine();
        if(textInput.hasNext())
        {
            line2 = textInput.nextLine();
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
        if(textInput.hasNext()) next = true;
        count = 0;
    }

    /**
     * Check if a confirmation dialogue should be created.
     * Then check if this has been clicked and if it has more text. It will update
     * to display the next lines of text in the scanner.
     * Then check if this has been clicked on and doesn't have more to display. If
     * so it will delete itself, and possibly take action.
     * Finally if it has 'next' it will update it's image to indicate so.
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
            line1 = textInput.nextLine();
            if(textInput.hasNext()) line2 = textInput.nextLine();
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
                if(textInput.hasNext()) next = true;
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
    
    /**
     * Update this textbox's image to display if there is more to display.
     */
    public GreenfootImage updateImg(String end)
    {
        GreenfootImage Background = new GreenfootImage("White600x100" + end + ".png"); 
        Background.setColor(SaveData.Color);
        Background.drawRect(0,0,599,99);
        Background.setColor(Color.BLACK);
        Background.setFont(new Font("Serif",Font.PLAIN,20));
        Background.drawString(line1,10,25);
        if(line2 != null) Background.drawString(line2,10,75);
        return Background;
    }
    
    /**
     * Add a comfirmation dialogue.
     */
    public void confirmation()
    {
        confirmation = true;
        String purpose = textInput.nextLine();
        line2 = textInput.nextLine();
        String yes = textInput.nextLine();
        String no = textInput.nextLine();
        bYes = new Button("tyes",this,yes,purpose);
        bNo = new Button("tno",this,no,purpose);
        ObjectStorage.theGame.addObject(bYes,300,375);
        ObjectStorage.theGame.addObject(bNo,400,375);
        setImage(updateImg(""));
    }

    /**
     * Is activated if the yes button is clicked while a confirmation is being
     * displayed.
     */
    public void yes(String action)
    {
        if(action.equals("gender"))
        {
            ObjectStorage.theGame.addObject(new Textbox("Alright so what is your " + 
                    "name?\nTEXTBOX.DNEXT","002intro"),300,350);
            getWorld().removeObject(bYes);
            getWorld().removeObject(bNo);
            getWorld().removeObject(this);
        }
        else if(action.equals("name"))
        {
            if(SaveData.Male)
            ObjectStorage.theGame.addObject(new Textbox("Here comes your rival, " +
            "my grandaughter.\nYou two have always been fighting.\nWhat was her name?"
            + "\nTEXTBOX.DNEXT","003intro"),300,350);
            else
            ObjectStorage.theGame.addObject(new Textbox("Here comes your rival, " +
            "my grandson.\nYou two have always been fighting.\nWhat was his name?"
            + "\nTEXTBOX.DNEXT","003intro"),300,350);
            getWorld().removeObject(bYes);
            getWorld().removeObject(bNo);
            getWorld().removeObject(this);
        }
        else if(action.equals("rname"))
        {
            ObjectStorage.theGame.startGame();
        }
    }

    /**
     * Is activated if the no button is clicked while a confirmation is being
     * displayed.
     */
    public void no(String action)
    {
        if(action.equals("name"))
        {
            ObjectStorage.done.uncutName("P");
            ObjectStorage.done.done = false;
        }
        else if(action.equals("rname"))
        {
            ObjectStorage.done.uncutName("R");
            ObjectStorage.done.done = false;
        }
        getWorld().removeObject(bYes);
        getWorld().removeObject(bNo);
        getWorld().removeObject(this);
    }
}
