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
    /**
     * Adds a start menu to the world. Prepares to add buttons, and it will retain a reference to
     * them.
     */
    public startMenu()
    {
        setImage("backg.jpg");
        once = false;
        ObjectStorage objectStorage = new ObjectStorage();
        objectStorage.StartMenu = this;
        String types[] = {"pokemon","items","me","save","options","exit"};
        for(int i = 0; i < 6; i++)
        {
            buttons[i] = new Button(types[i]);
        }
    }

    /**
     * Add the buttons once.
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

    /**
     * Deletes this and the buttons that it added
     */
    public void delete()
    {
        for(int i = 0; i < 6; i++)
        {
            getWorld().removeObject(buttons[i]);
        }
        getWorld().removeObject(this);
    }
}
