import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private String gender;
    public Player(int x, int y,int rotate)
    {
        SaveData savedata = new SaveData();
        if(savedata.Male)gender = "Brendan";
        else gender = "May";
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
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) setImage(new GreenfootImage("Brendan_R.gif"));
        else if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))setImage(new GreenfootImage("Brendan_F.gif"));
        else if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))setImage(new GreenfootImage("Brendan_L.gif"));
        else if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))setImage(new GreenfootImage("Brendan_B.gif"));
    }    
}
