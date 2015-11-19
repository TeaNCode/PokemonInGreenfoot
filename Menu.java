import greenfoot.*;
import java.io.File;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Displays the menu. Continue and Options will be avalible if a save exists.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        File save = new File("Save.a");
        if(save.canRead())
        {
            addObject(new Button("continuegame"),153,80);
            addObject(new Button("gOptions"),98,160);
        }
        addObject(new Button("newgame"),120,120);
    }
}
