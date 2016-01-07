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
    /**
     * Sets the player's image according to their gender and direction.
     */
    public Player(int rotate)
    {
        if(SaveData.Male)gender = "Brendan";
        else gender = "May";
        ObjectStorage.player = this;
        if(rotate == 0) setImage(new GreenfootImage(gender + "_R.gif"));
        else if(rotate == 90) setImage(new GreenfootImage(gender + "_F.gif"));
        else if(rotate == 180) setImage(new GreenfootImage(gender + "_L.gif"));
        else if(rotate == 270) setImage(new GreenfootImage(gender + "_B.gif"));
    }

    /**
     * Checks if a directional button has been pressed and change the image accordingly.
     */
    public void act() 
    {
        if(ObjectStorage.theGame.direction.equals("right") || ObjectStorage.theGame.face.equals("right")) setImage(new GreenfootImage(gender + "_R.gif"));
        else if(ObjectStorage.theGame.direction.equals("down") || ObjectStorage.theGame.face.equals("down"))setImage(new GreenfootImage(gender + "_F.gif"));
        else if(ObjectStorage.theGame.direction.equals("left") || ObjectStorage.theGame.face.equals("left"))setImage(new GreenfootImage(gender + "_L.gif"));
        else if(ObjectStorage.theGame.direction.equals("up") || ObjectStorage.theGame.face.equals("up"))setImage(new GreenfootImage(gender + "_B.gif"));
    }    

    public boolean colliding(String direction)
    {
        if(direction.equals("right")) setLocation(getX() + 60, getY());
        else if(direction.equals("down")) setLocation(getX(), getY() + 60);
        else if(direction.equals("left")) setLocation(getX() - 60, getY());
        else if(direction.equals("up")) setLocation(getX(), getY() - 60);
        int x = getX();
        int y = getY();
        MovingTiles tile = getOneIntersectingObject(MovingTiles.class);
        try
        {
            if(tile != null)
            {
                if(tile.collision)
                {
                    if(tile.colX1 + tile.getX() != x && tile.colX2 + tile.getX() != x)
                    {
                        if(tile.colY1 + tile.getY() != y && tile.colY2 + tile.getY() != y)
                        {
                            return false;
                        }
                        else return true;
                    }
                    else return true;
                }
                else return false;
            }
            else return false;
        }
        finally
        {
            if(direction.equals("right")) setLocation(getX() - 60, getY());
            else if(direction.equals("down")) setLocation(getX(), getY() - 60);
            else if(direction.equals("left")) setLocation(getX() + 60, getY());
            else if(direction.equals("up")) setLocation(getX(), getY() + 60);
        }
    }
}
