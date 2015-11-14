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
    public MovingTiles(String image)
    {
       setImage(new GreenfootImage(image)); 
    }
    
    public void act() 
    {
        checkMove();
    }  
    
    public void checkMove()
    {
       if(storage.theGame.direction.equals("right")) setLocation(getX() - 60, getY());
        else if(storage.theGame.direction.equals("down"))setLocation(getX(), getY() - 60);
        else if(storage.theGame.direction.equals("left"))setLocation(getX() + 60, getY());
        else if(storage.theGame.direction.equals("up")) setLocation(getX(), getY() + 60);
    }
}
