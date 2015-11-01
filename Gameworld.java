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
         if(Greenfoot.isKeyDown("/"))
        {
            menu();
        }
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

    public void addKeyboard(String pre)
    {
        removeObjects(getObjects(null));
        addObject(new Letter(pre + "Done"),550,380);
        for(int i = 1; i < 11;  i++) addObject(new Letter(pre + "Display" + i,"a",i),53 + (i * 45),75);
        String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
                "R","S","T","U","V","W","X","Y","Z"};
        for(int i = 0; i < 26; i++)
        {
            if(i < 15) addObject(new Letter(pre + "Name",letters[i],i),75 + (i * 35),150);
            else addObject(new Letter(pre + "Name",letters[i],i),75 + ((i - 15) * 35),200);
        }
        addObject(new Letter(pre + "Name",",",26),460,200);
        addObject(new Letter(pre + "Name",".",27),495,200);
        addObject(new Letter(pre + "Name","?",28),530,200);
        addObject(new Letter(pre + "Name","!",29),565,200);
        for(int i = 0; i < 9; i++) addObject(new Letter(pre + "Name",Integer.toString(i + 1),30 + i),
                75 + (i * 35),250);
        addObject(new Letter(pre + "Name","0",39),390,250);
        addObject(new Button("lowercase"),150,300);
        addObject(new Letter(pre + "Del"),500,250);
    }
    
    public void menu()
    {
        addObject(new Button("options"), 100, 50);
        addObject(new Button("items"), 100, 75);
        addObject(new Button("pokemon"), 100, 100);
        addObject(new Button("save"), 100, 125);
        addObject(new Button("exit"), 100, 150);
    }
}
