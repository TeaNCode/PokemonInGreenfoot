import greenfoot.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class Gameworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameworld extends World
{
    static Letter[] letters = new Letter[42];
    String name;
    String gender;
    boolean gotName;
    static int g;
    /**
     * Constructor for objects of class Gameworld.
     * 
     */
    public Gameworld(String typ)
    {    
        super(600, 400, 1,false); 
        gotName = false;
        if(typ == "newgame")
        {
            SaveData savedata = new SaveData(true);
            setBackground("White.png");
            newProfileName();
            if(gotName == true)
            {
                profileGender();
            }
        }
        else if(typ == "continuegame")
        {

        }
        else System.out.println("Error: invalid save-handling type");
    }
    public void Save()
    {
        Save save = new Save("Save.txt");
        save.assembleSave();
    }
    public void newProfileName()
    {
        name = JOptionPane.showInputDialog("Please enter your name. \nNote: this will be your username.");
        addObject(new loader(),300,200);
        GreenfootImage chat = getBackground();
        chat.setColor(Color.BLACK);
        chat.drawString("Sorry should introduce my self first. \nHello, I am Anthony, your profiles soul. \nSo your are " + name + "? Nice to meet you.", 200, 250);
        gotName = true;
        }
    
        public void profileGender()
    {
            gender = JOptionPane.showInputDialog("Please enter your Gender. \ntype male or female.");
            if(gender.equals("male"))
            {
                g = 1;
            }
            else if(gender.equals("female"))
            {
                g = 2;
            }
            else if(gender.equals("boss"))
            {
                g = 9;
            }
            addObject(new player(), 375, 200);
            if(g == 9)
            {
                GreenfootImage chat = getBackground();
                chat.setColor(Color.GREEN);
                chat.drawString("This isnt nuclear thrones!", 200, 300);
            }
        }
    }
