import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String type;
    private boolean delete;
    private Textbox textbox;
    private String display;
    private String action;
    /**
     * Executed when Button added to world.
     * Button type needs to be specified
     */
    public Button(String typ)
    {
        type = typ; //Store type for later use
        setPicture();
        delete = false;
    }

    /**
     * These buttons have been added by a Textbox. They are yes and no buttons, and do something
     * upon being clicked on.
     */
    public Button(String typ, Textbox Textbox, String disply, String acion)
    {
        type = typ; //Store type for later use
        textbox = Textbox;
        display = disply;
        action = acion;
        setPicture();
        delete = false;
    }

    /**
     * Checks if this has been clicked on. If so it then goes through a list of types and
     * executes the proper action.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("enter") && type.equals("start"))
            Greenfoot.setWorld(new Menu());
        if(Greenfoot.mouseClicked(this))
        {
            switch(type)
            {
                case "newgame": ObjectStorage.theGame = new Gameworld("newgame"); 
                Greenfoot.setWorld(ObjectStorage.theGame); break;
                case "continuegame": ObjectStorage.theGame = new Gameworld("continuegame"); 
                Greenfoot.setWorld(ObjectStorage.theGame); break;
                case "lowercase": lowerCase(); break;
                case "uppercase": upperCase(); break;
                case "male": SaveData.Male = true;
                confirmGender(); break;
                case "female": SaveData.Male = false;
                confirmGender(); break;
                case "tyes": textbox.yes(action); break;
                case "tno": textbox.no(action); break;
                case "exit": ObjectStorage.StartMenu.delete(); 
                ObjectStorage.theGame.startMenu = false; break;
                case "options":if(!SaveData.loaded) SaveReader.loadSave();
                Greenfoot.setWorld(new Options()); ObjectStorage.lastWorld = "Game"; break;
                case "gOptions":SaveReader.loadSave(); Greenfoot.setWorld(new Options()); ObjectStorage.lastWorld = "Menu"; break;
                case "start": Greenfoot.setWorld(new Menu()); break;
                case "save": 
            }
        }
        if(delete) getWorld().removeObject(this);
    }    

    /**
     * Sets the actor's image depending on the type
     */
    public void setPicture()
    {
        switch(type)
        {
            case "newgame": setImage(new GreenfootImage("New Game",40,Color.LIGHT_GRAY,
                    new Color(0,0,0,0))); break;
            case "continuegame": setImage(new GreenfootImage("Continue Game",40,Color.LIGHT_GRAY,
                    new Color(0,0,0,0))); break;
            case "lowercase": setImage(new GreenfootImage("lower case",40,Color.BLACK,
                    new Color(0,0,0,0))); break;
            case "uppercase": setImage(new GreenfootImage("UPPER CASE",40,Color.BLACK,
                    new Color(0,0,0,0))); break;
            case "male": GreenfootImage Male = new GreenfootImage("male.png");
            Male.scale(144,220);
            setImage(Male); break;
            case "female": GreenfootImage Female = new GreenfootImage("female.png");
            Female.scale(148,220);
            setImage(Female); break;
            case "tyes": setImage(new GreenfootImage(display,25,Color.BLACK,new Color(0,0,0,0)));
            break;
            case "tno": setImage(new GreenfootImage(display,25,Color.BLACK,new Color(0,0,0,0)));
            break;
            case "options": setImage(new GreenfootImage("Options",40,Color.BLACK,
                    new Color(0,0,0,0))); break;
            case "items": setImage(new GreenfootImage("Items",40,Color.BLACK,
                    new Color(0,0,0,0))); break;
            case "pokemon": setImage(new GreenfootImage("Pokémon",40,Color.BLACK,
                    new Color(0,0,0,0))); break;
            case "save": setImage(new GreenfootImage("Save",40,Color.BLACK,
                    new Color(0,0,0,0))); break;
            case "exit": setImage(new GreenfootImage("Exit",40,Color.BLACK,
                    new Color(0,0,0,0))); break;
            case "me": setImage(new GreenfootImage(SaveData.Name,30,Color.BLACK,new Color(0,0,0,0))); break;
            case "gOptions": setImage(new GreenfootImage("Options",40,Color.LIGHT_GRAY,
                    new Color(0,0,0,0))); break;
            case "start": setImage(new GreenfootImage("Press Enter to start",40,Color.LIGHT_GRAY,
                    new Color(0,0,0,0))); break;

        }
    }

    /**
     * Changes the keyboard's case to lower.
     */
    public void lowerCase()
    {
        String[] lowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n"
            ,"o","p","q","r","s","t","u","v","w","x","y","z",",",".","?","!","1","2","3","4",
                "5","6","7","8","9","0"};
        for(int i = 0; i < 40; i++)
        {
            SaveData.Letters[i].letter = lowercase[i];
            SaveData.Letters[i].updateKeyboard();
        }
        getWorld().addObject(new Button("uppercase"),getX(),getY());
        delete = true;
    }

    /**
     * Sets the keyboard's case to upper
     */
    public void upperCase()
    {
        String[] uppercase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
                "R","S","T","U","V","W","X","Y","Z",",",".","?","!","1","2","3","4",
                "5","6","7","8","9","0"};
        for(int i = 0; i < 40; i++)
        {
            SaveData.Letters[i].letter = uppercase[i];
            SaveData.Letters[i].updateKeyboard();
        }
        getWorld().addObject(new Button("lowercase"),getX(),getY());
        delete = true;
    }

    /**
     * Makes sure the player is happy with their gender.
     */
    public void confirmGender()
    {
        if(SaveData.Male)
            ObjectStorage.theGame.addObject(new Textbox("So you are a boy.\n"
                    + "BUTTON.CONFIRMATION" + "\ngender" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
        else
            ObjectStorage.theGame.addObject(new Textbox("So you are a girl.\n"
                    + "BUTTON.CONFIRMATION" + "\ngender" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
    }
}
