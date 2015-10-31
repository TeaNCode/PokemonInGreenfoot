import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
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
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            SaveData savedata = new SaveData();
            ObjectStorage objectStorage = new ObjectStorage();
            switch(type)
            {
                case "newgame": objectStorage.theGame = new Gameworld("newgame"); 
                Greenfoot.setWorld(objectStorage.theGame); break;
                case "continuegame": objectStorage.theGame = new Gameworld("continuegame"); 
                Greenfoot.setWorld(objectStorage.theGame); break;
                case "lowercase": lowerCase(); break;
                case "uppercase": upperCase(); break;
                case "male": savedata.Male = true;
                confirmGender(); break;
                case "female": savedata.Male = false;
                confirmGender(); break;
                case "tyes": textbox.yes(action); break;
                case "tno": textbox.no(action); break;
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
        }
    }

    public void lowerCase()
    {
        SaveData savedata = new SaveData();
        String[] lowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n"
            ,"o","p","q","r","s","t","u","v","w","x","y","z",",",".","?","!","1","2","3","4",
                "5","6","7","8","9","0"};
        for(int i = 0; i < 40; i++)
        {
            savedata.Letters[i].letter = lowercase[i];
            savedata.Letters[i].updateKeyboard();
        }
        getWorld().addObject(new Button("uppercase"),getX(),getY());
        delete = true;
    }

    public void upperCase()
    {
        SaveData savedata = new SaveData();
        String[] uppercase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
                "R","S","T","U","V","W","X","Y","Z",",",".","?","!","1","2","3","4",
                "5","6","7","8","9","0"};
        for(int i = 0; i < 40; i++)
        {
            savedata.Letters[i].letter = uppercase[i];
            savedata.Letters[i].updateKeyboard();
        }
        getWorld().addObject(new Button("lowercase"),getX(),getY());
        delete = true;
    }
    
    public void confirmGender()
    {
        ObjectStorage objectstorage = new ObjectStorage();
        SaveData savedata = new SaveData();
        if(savedata.Male)
        objectstorage.theGame.addObject(new Textbox("So you are a boy.\n"
        + "BUTTON.CONFIRMATION" + "\ngender" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
        else
        objectstorage.theGame.addObject(new Textbox("So you are a boy.\n"
        + "BUTTON.CONFIRMATION" + "\ngender" + "\nIs this correct?" + "\nYes" + "\nNo"),300,350);
    }
}
