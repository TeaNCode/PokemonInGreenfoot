/**
 * Write a description of class PokemonData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PokemonData  
{
    //Pokemon Ints format {Base HP,Base Attack, Base Defense, Base Special attack
    //  , Base Special Defense,Base Speed,Type 1, Type 2, Catch Rate, Base Exp. yield
    //  , EV Yield 1(left to right), EV Yield 2, Gender value, Base friendship
    //  , Level up type, Egg group 1, Egg group 2};
    // Based on Bulbapedia's 'Pokémon base stats data structure in Generation III'
    
    //Pokemon Strings format {Species Name, Capitalized Abreviated EV 1 type (left to right)
    //  , EV 2 type, Held item 1, Held item 2, Ability 1, Ability 2};
    
    int[] bulbasaurInts = {45,49,49,65,65,45,12,3,45,64,1,0,31,70,3,1,8};
    String[] bulbasaurStrings = {"Bulbasaur","SA",null,null,null,"Overgrow",null};
    int[][] dataInts = new int[151][];
    String[][] dataStrings = new String[151][];
    /**
     * Constructor for objects of class PokemonData
     */
    public PokemonData()
    {
        
    }
}
