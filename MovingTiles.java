import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingTiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingTiles extends Actor
{
    private ObjectStorage storage = new ObjectStorage();
    private boolean collision = false;
    private int colYOffset = 0;
    /**
     * Sets the tile to the image passed to it.
     */
    public MovingTiles(String image)
    {
        setImage(new GreenfootImage(image)); 
    }
    
    public MovingTiles(String image, boolean col)
    {
        setImage(new GreenfootImage(image));
        collision = col;
    }
    
    public MovingTiles (String image, boolean col, int yOff)
    {
        setImage(new GreenfootImage(image));
        collision = col;
        colYOffset = yOff;
    }
    
    /**
     * Check if should move.
     */
    public void act() 
    {
        checkMove();
    }  

    /**
     * Check if should move and then do so.
     */
    public void checkMove()
    {
        if(storage.theGame.direction.equals("right")) setLocation(getX() - 60, getY());
        else if(storage.theGame.direction.equals("down"))setLocation(getX(), getY() - 60);
        else if(storage.theGame.direction.equals("left"))setLocation(getX() + 60, getY());
        else if(storage.theGame.direction.equals("up")) setLocation(getX(), getY() + 60);
    }
}
