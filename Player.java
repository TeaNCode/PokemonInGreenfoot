import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public Player(int x, int y,int rotate)
    {
        ObjectStorage storage = new ObjectStorage();
        storage.player = this;
        setLocation(x,y);
        if(rotate == 0) setImage(new GreenfootImage("Brendan_R.gif"));
        else if(rotate == 90) setImage(new GreenfootImage("Brendan_F.gif"));
        else if(rotate == 180) setImage(new GreenfootImage("Brendan_L.gif"));
        else if(rotate == 270) setImage(new GreenfootImage("Brendan_B.gif"));
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
    }    
}
