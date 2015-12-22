import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingTiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingTiles extends Actor
{
    public boolean collision = false;
    public int colY1 = 0;
    public int colY2 = 0;
    public int colX1 = 0;
    public int colX2 = 0;
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
    
    public MovingTiles (String image, boolean col, int xOff1, int xOff2, int yOff1, int yOff2)
    {
        setImage(new GreenfootImage(image));
        collision = col;
        colY1 = yOff1;
        colY2 = yOff2;
        colX1 = xOff1;
        colX2 = xOff2;
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
        if(ObjectStorage.theGame.direction.equals("right")) setLocation(getX() - 60, getY());
        else if(ObjectStorage.theGame.direction.equals("down"))setLocation(getX(), getY() - 60);
        else if(ObjectStorage.theGame.direction.equals("left"))setLocation(getX() + 60, getY());
        else if(ObjectStorage.theGame.direction.equals("up")) setLocation(getX(), getY() + 60);
    }
}
