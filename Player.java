import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private ObjectStorage storage = new ObjectStorage();
    private String gender;
    public Player(int x, int y,int rotate)
    {
        SaveData savedata = new SaveData();
        if(savedata.Male)gender = "Brendan";
        else gender = "May";
        ObjectStorage storage = new ObjectStorage();
        storage.player = this;
        setLocation(x,y);
        if(rotate == 0) setImage(new GreenfootImage(gender + "_R.gif"));
        else if(rotate == 90) setImage(new GreenfootImage(gender + "_F.gif"));
        else if(rotate == 180) setImage(new GreenfootImage(gender + "_L.gif"));
        else if(rotate == 270) setImage(new GreenfootImage(gender + "_B.gif"));
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(storage.theGame.direction.equals("right")) setImage(new GreenfootImage(gender + "_R.gif"));
        else if(storage.theGame.direction.equals("down"))setImage(new GreenfootImage(gender + "_F.gif"));
        else if(storage.theGame.direction.equals("left"))setImage(new GreenfootImage(gender + "_L.gif"));
        else if(storage.theGame.direction.equals("up"))setImage(new GreenfootImage(gender + "_B.gif"));
    }    
}
