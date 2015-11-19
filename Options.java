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
     * This world is the options screen. It has a bunch of buttons that change
     * various settings.
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
        addObject(new OButton("OCGray"),40,45);
        addObject(new OButton("OCGreen"),120,45);
        addObject(new OButton("OCLight_Gray"),247,45);
        addObject(new OButton("OCMagenta"),392,45);
        addObject(new OButton("OCOrange"),509,45);
        addObject(new OButton("OCPink"),40,80);
        addObject(new OButton("OCRed"),107,80);
        addObject(new OButton("OCYellow"),187,80);
        addObject(new OButton("OCWhite"),279,80);
    }
}
