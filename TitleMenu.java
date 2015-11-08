import greenfoot.*;

/**
 * Write a description of class TitleMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleMenu extends World
{
    /**
     * Constructor for objects of class TitleMenu.
     * 
     */
    public TitleMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Title(),getWidth() / 2, getHeight() * 1 / 10);
        addObject(new Subtitle(),getWidth() / 2, getHeight() * 6 / 10);
        addObject(new Github(),415,385);
        //Greenfoot.setWorld(new Gameworld("newgame")); //For quick testing
        //Greenfoot.start();
        //Greenfoot.setWorld(new Options());
    }
}
