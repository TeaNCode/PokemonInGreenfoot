import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Letter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letter extends Actor
{
    private String letter;
    private String type;
    private int index;
    private int first_;
    public Letter(String typ,String lttr,int indx)
    {
        index = indx;
        letter = lttr;
        type = typ;
        if(type == "PName") setImage(new GreenfootImage(letter,30,Color.BLACK,new Color(0,0,0,0)));
        else setImage(new GreenfootImage("_",50,Color.BLACK,new Color(0,0,0,0)));
    }

    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        SaveData savedata = new SaveData();
        if(type == "PName")
        {
            if(Greenfoot.mouseClicked(this))
            {
                updateName();
            }
        }
        else if(savedata.Name != "nullERRORplox")updatePicture();
    }    

    public void updatePicture()
    {
        SaveData savedata = new SaveData();
        setImage(new GreenfootImage(savedata.Name.substring(index - 1, index),50,Color.BLACK,new Color(0,0,0,0)));
        //System.out.println(savedata.Name);
    }

    public void updateName()
    {
        SaveData savedata = new SaveData();
        if(savedata.Name == "nullERRORplox") savedata.Name = letter + "_________";
        else
        {
            first_ = 10;
            for(int i = 1;  i < 10; i++)
            {
                if(savedata.Name.substring(i,i + 1) == "_")
                {
                    if(i < first_)
                    {
                        first_ = i;
                    }
                }
            }
            savedata.Name = savedata.Name.substring(0,first_) + letter;
            while(savedata.Name.length() < 10) savedata.Name.concat("_");
        }
        //System.out.println(savedata.Name); //For debugging
    }
}
