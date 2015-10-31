import greenfoot.*;

/**
 * Write a description of class Gameworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameworld extends World
{
    /**
     * Constructor for objects of class Gameworld.
     * 
     */
    public Gameworld(String typ)
    {    
        super(600, 400, 1,false); 
        if(typ == "newgame")
        {
            SaveData savedata = new SaveData(true);
            pickGender();
        }
        else if(typ == "continuegame")
        {

        }
        else System.out.println("Fatal Error: invalid save-handling type");
    }

    public void act()
    {
        //if(getObjects(null).isEmpty()) addObject(new Textbox("Congratulations on creating your "
        //+ "own character!\n How does it look?\n Another line!"),300,350); //Textbox demonstration
    }

    public void Save()
    {
        Save save = new Save("Save.txt");
        save.assembleSave();
    }

    public void pickGender()
    {
        removeObjects(getObjects(null));
        setBackground("White.png");
        addObject(new Button("male"),100,200);
        addObject(new Button("female"),500,200);
    }

    public void pickName()
    {
        removeObjects(getObjects(null));
        for(int i = 1; i < 11;  i++) addObject(new Letter("PDisplay" + i,"a",i),53 + (i * 45),75);
        String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
                "R","S","T","U","V","W","X","Y","Z"};
        for(int i = 0; i < 26; i++)
        {
            if(i < 15) addObject(new Letter("PName",letters[i],i),75 + (i * 35),150);
            else addObject(new Letter("PName",letters[i],i),75 + ((i - 15) * 35),200);
        }
        addObject(new Letter("PName",",",26),460,200);
        addObject(new Letter("PName",".",27),495,200);
        addObject(new Letter("PName","?",28),530,200);
        addObject(new Letter("PName","!",29),565,200);
        for(int i = 0; i < 9; i++) addObject(new Letter("PName",Integer.toString(i + 1),30 + i),
                75 + (i * 35),250);
        addObject(new Letter("PName","0",39),390,250);
        addObject(new Button("lowercase"),150,300);
        addObject(new Letter("PDel"),500,250);
        addObject(new Letter("PDone"),550,380);
    }
}
