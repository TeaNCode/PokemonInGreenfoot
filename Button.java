import greenfoot.*;
import java.awt.Color;
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
    private Gameworld world;
    private Textbox textbox;
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

    public Button(String typ, Gameworld wrld)
    {
        type = typ; //Store type for later use
        world = wrld;
        setPicture();
        delete = false;
    }

    public Button(String typ, Textbox Textbox)
    {
        type = typ; //Store type for later use
        textbox = Textbox;
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
            switch(type)
            {
                case "newgame": Greenfoot.setWorld(new Gameworld("newgame")); break;
                case "continuegame": Greenfoot.setWorld(new Gameworld("continuegame"));
                break;
                case "lowercase": lowerCase(); break;
                case "uppercase": upperCase(); break;
                case "male": savedata.Female = false;
                world.pickName(); break;
                case "female": savedata.Female = true;
                world.pickName(); break;
            }
        }
        if(delete) 
getWorld().
removeObject(this);
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
}
