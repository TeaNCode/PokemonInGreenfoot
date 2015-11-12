/**
 * Write a description of class PokemonData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PokemonData  
{
    // Pokemon Ints format {Base HP,Base Attack, Base Defense, Base Special attack
    //  , Base Special Defense, Base Speed, Type 1, Type 2 (If none type Type 1 again), Catch Rate
    //  , Base Exp. yield (Gen V+), EV Yield 1(First != 0 left to right), EV Yield 2, Gender ratio value
    //  , Lower hatch time value / 255, Base friendship, Level up type, Egg group 1
    //  , Egg group 2};
    // Based on Bulbapedia's 'Pokémon base stats data structure in Generation III'
    
    // Pokemon Strings format {Species Name, Pokemon Category
    //  , Capitalized Abreviated EV 1 type (left to right), EV 2 type, Held item 1, Held item 2
    //  , Ability 1, Ability 2};
    
    int[] bulbasaurInts = {45,49,49,65,65,45,12,3,45,64,1,0,31,21,70,3,1,8};
    String[] bulbasaurStrings = {"Bulbasaur","Seed Pokémon","SA",null,null,null,"Overgrow",null};
    int[] ivysaurInts = {60,62,63,80,80,60,12,3,45,142,1,1,31,21,70,3,1,8};
    String[] ivysaurStrings = {"Ivysaur","Seed Pokémon","SA","SD",null,null,"Overgrow",null};
    int[] venusaurInts = {80,82,83,100,100,80,12,3,45,236,2,1,31,21,70,3,1,8};
    String[] venusaurStrings = {"Venusaur","Seed Pokémon","SA","SD",null,null,"Overgrow",null};
    int[] charmanderInts = {39,52,43,60,50,65,10,10,45,62,1,0,31,21,70,3,1,15};
    String[] charmanderStrings = {"Charmander","Lizard Pokémon","S",null,null,null,"Blaze",null};
    int[] charmeleonInts = {58,64,58,80,65,80,10,10,45,142,1,1,31,21,70,3,1,15};
    String[] charmeleonStrings = {"Charmeleon","Flame Pokémon","SA","S",null,null,"Blaze",null};
    int[] charizardInts = {78,84,78,109,85,100,10,2,45,240,3,0,31,21,70,3,1,15};
    String[] charizardStrings = {"Charizard","Flame Pokémon","SA",null,null,null,"Blaze",null};
    int[] squirtleInts = {44,48,65,50,64,43,11,11,45,63,1,0,31,21,70,3,1,2};
    String[] squirtleStrings = {"Squirtle","Tiny Turtle Pokémon","D",null,null,null,"Torrent",null};
    int[] wartortleInts = {59,63,80,65,80,58,11,11,45,142,1,1,31,21,70,3,1,2};
    String[] wartortleStrings = {"Wartortle","Turtle Pokémon","D","SD",null,null,"Torrent",null};
    int[] blastoiseInts = {79,83,100,85,105,78,11,11,45,239,3,0,31,21,70,3,1,2};
    String[] blastoiseStrings = {"Blastoise","Shellfish Pokémon","SD",null,null,null,"Torrent",null};
    int[] caterpieInts = {45,30,35,20,20,45,6,6,255,39};//EXP YIELD
    int[][] dataInts = new int[151][];
    String[][] dataStrings = new String[151][];
    /**
     * Constructor for objects of class PokemonData
     */
    public PokemonData()
    {
        
    }
}
