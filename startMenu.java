import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startMenu extends Actor
{
    static Button buttons[] = new Button[6];
    private boolean once;
    public startMenu()
    {
        setImage("backg.jpg");
        once = false;
        ObjectStorage objectStorage = new ObjectStorage();
        objectStorage.StartMenu = this;
        String types[] = {"options","me","items","pokemon","save","exit"};
        for(int i = 0; i < 6; i++)
        {
            buttons[i] = new Button(types[i]);
        }
    }

    /**
     * Act - do whatever the startMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!once)
        {
            once = true;
            ObjectStorage objectStorage = new ObjectStorage();
            for(int i = 0; i < 6; i++)
            {
                objectStorage.theGame.addObject(buttons[i],508,70 + (30 * i));
            }
        }
    }    

    public void delete()
    {
        for(int i = 0; i < 6; i++)
        {
            getWorld().removeObject(buttons[i]);
        }
        getWorld().removeObject(this);
    }
}
