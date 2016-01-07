import greenfoot.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
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
    static String direction;
    static String face;
    static SimpleTimer SystemTimer;
    /**
     * Check what type of world is being added and load the game based on that. Prints an error if the type is invalid.
     * newgame starts a new game and continuegame attempts to load a previous save.
     */
    public Gameworld(String typ)
    {    
        super(600, 400, 1,false); 
        startMenu = false;
        delay = 0;
        if(typ.equals("newgame"))
        {
            setBackground("White.png");
            SaveData savedata = new SaveData(true);
            SystemTimer = new SimpleTimer(0);
            addObject(new Textbox("Welcome to the world of Pokémon!\nPlease tell me a bit about yourself.\nAre you a boy or a girl?\nTEXTBOX.DNEXT","001intro"),300,350);
        }
        else if(typ.equals("continuegame"))
        {
            if(!SaveData.loaded)
                SaveReader.loadSave();
            SystemTimer = new SimpleTimer(SaveData.Time);
            startGame();
        }
        else System.out.println("Fatal Error: invalid save-handling type");
    }

    /**
     * Check if the player is attempting to move, and move the world according to that.
     * Also checks if the menu is being opened.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) 
        {          
            if(!ObjectStorage.player.colliding("right"))
            {
                direction = "right";
                face = "right";
            }
            else
            {
                face = "nah";
                direction = "nah";
            }
        }
        else if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))
        {
            if(!ObjectStorage.player.colliding("down"))
            {
                direction = "down";
                face = "down";
            }
            else
            {
                face = "nah";
                direction = "nah";
            }
        }
        else if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            if(!ObjectStorage.player.colliding("down"))
            {
                direction = "left";
                face = "left";
            }
            else
            {
                face = "nah";
                direction = "nah";
            }
        }
        else if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) 
        {
            if(!ObjectStorage.player.colliding("down"))
            {
                direction = "up";
                face = "up";
            }
            else
            {
                face = "nah";
                direction = "nah";
            }
        }
        else
        {
            face = "nah";
            direction = "nah";
        }
        //if(getObjects(null).isEmpty()) addObject(new Textbox("Congratulations on creating your "
        //+ "own character!\n How does it look?\n Another line!"),300,350); //Textbox demonstration
        if(delay != 0) delay--;
        if(Greenfoot.isKeyDown("/") && delay == 0)
        {
            menu();
        }
    }

    /**
     * Saves the game to 'Save.a'
     */
    public void Save()
    {
        Save save = new Save("Save.a");
        save.assembleSave();
    }

    /**
     * Displays the buttons to allow the player to chose their gender during newgame.
     * It clears the world before that.
     */
    public void pickGender()
    {
        removeObjects(getObjects(null));
        addObject(new Button("male"),100,200);
        addObject(new Button("female"),500,200);
    }

    /**
     * Clears the world then adds a keyboard to allow the player to input the name of something.
     * It is currently limited to Player name, "P", or Rival name, "R".
     */
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

    /**
     * If the menu isn't being shown, it shows it. If it is being shows then it gets deleted.
     */
    public void menu()
    {
        if(!startMenu)
        {
            delay = 20;
            startMenu = true;
            //   \/ below is the code for calendar which only appears with the menu, to cahnge this copy lines 89-96 \/
            /**Calendar test = new GregorianCalendar();
            int hour = test.get(Calendar.HOUR_OF_DAY);
            if (test.get(Calendar.HOUR_OF_DAY) > 12){ 
            hour = hour - 12;
            }
             **/
            addObject(new startMenu(), 508, 148);
            /**GreenfootImage bg = getBackground();
            bg.setColor(Color.GREEN);
            bg.drawString("Today is "+(new Date()+";"+"\nalso known as "+hour+":"+test.get(Calendar.MINUTE)+"."), 100, 30);
             **/
        }
        else 
        {
            startMenu = false;
            ObjectStorage.StartMenu.delete();
        }
    }

    /**
     * Progresses the intro according to the stage passed here.
     */
    public void intro(int stage)
    {
        if(stage == 1) pickGender();
        else if(stage == 2) addKeyboard("P");
        else if(stage == 3) addKeyboard("R");
    }

    /**
     * Starts the game, adding all the objects into the world.
     */
    public void startGame()
    {
        setBackground("White.png");
        removeObjects(getObjects(null));
        addObject(new MovingTiles("Black.gif"),300,200);
        addObject(new MovingTiles("Bed60x80.gif"),420,200);
        addObject(new MovingTiles("GoodComputer.gif",true,0,60,20,20),180,160);
        addObject(new Player(90),300,200);
        Greenfoot.setSpeed(33);
    }
}
