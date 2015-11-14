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
        addObject(new Display("Pokemon in Greenfoot",50,java.awt.Color.WHITE),300,40);
        addObject(new Button("start"),300,240);
        addObject(new Display("https://github.com/TeaNCode/PokemonInGreenfoot"
        ,20,java.awt.Color.WHITE),415,385);
        Greenfoot.start();
        Greenfoot.setSpeed(50);
    }
}
