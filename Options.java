import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{

    /**
     * Constructor for objects of class Options.
     * 
     * Method if size is 20:
     * addObject(new OButton("OCBlack"),260,9);
        addObject(new OButton("OCBlue"),300,9);
        addObject(new OButton("OCCyan"),335,9);
        addObject(new OButton("OCDark_Gray"),392,9);
        addObject(new OButton("OCGray"),448,9);
        addObject(new OButton("OCGreen"),490,9);
        addObject(new OButton("OCLight_Gray"),554,9);
        addObject(new OButton("OCMagenta"),270,23);
        addObject(new OButton("OCOrange"),330,23);
        addObject(new OButton("OCPink"),370,23);
        addObject(new OButton("OCRed"),402,23);
        addObject(new OButton("OCYellow"),442,23);
        addObject(new OButton("OCWhite"),488,23);
     */
    public Options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new OButton("back"),47,383);
        addObject(new Display("Textbox outline:",30),94,12);
        addObject(new OButton("OCBlack"),227,15);
        addObject(new OButton("OCBlue"),307,15);
        addObject(new OButton("OCCyan"),379,15);
        addObject(new OButton("OCDark_Gray"),496,15);
        addObject(new OButton("OCGray"),4,15);
        addObject(new OButton("OCGreen"),4,15);
        addObject(new OButton("OCLight_Gray"),5,15);
        addObject(new OButton("OCMagenta"),270,40);
        addObject(new OButton("OCOrange"),330,40);
        addObject(new OButton("OCPink"),370,40);
        addObject(new OButton("OCRed"),402,40);
        addObject(new OButton("OCYellow"),442,40);
        addObject(new OButton("OCWhite"),488,40);
    }
}
