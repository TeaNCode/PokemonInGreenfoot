import greenfoot.*;
/**
 * Write a description of class Gameworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameworld extends World
{
    public boolean startMenu;
    public int delay;
    /**
     * Constructor for objects of class Gameworld.
     * 
     */
    public Gameworld(String typ)
    {    
        super(600, 400, 1,false); 
        startMenu = false;
        delay = 0;
        if(typ == "newgame")
        {
            setBackground("White.png");
            SaveData savedata = new SaveData(true);
            addObject(new Textbox("Welcome to the world of Pokémon!\nPlease tell me a bit about yourself.\nAre you a boy or a girl?\nTEXTBOX.DNEXT","001intro"),300,350);
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
        if(delay != 0) delay--;
         if(Greenfoot.isKeyDown("/") && delay == 0)
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
        if(!startMenu)
        {
            delay = 20;
            startMenu = true;
            addObject(new startMenu(), 508, 148);
        }
        else 
        {
            startMenu = false;
            ObjectStorage objectStorage = new ObjectStorage();
            objectStorage.StartMenu.delete();
        }
    }
    
    public void intro(int stage)
    {
        System.out.print("Running intro stage: " + stage);
        if(stage == 1) pickGender();
        else if(stage == 2) addKeyboard("P");
        else if(stage == 3) addKeyboard("R");
    }
}
