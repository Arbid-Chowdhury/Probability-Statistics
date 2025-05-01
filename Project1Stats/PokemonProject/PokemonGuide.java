package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used this to understand how to make PokemonGuide interface to have PokemonCard implementing it and for it to be inherited by each Pokemon card 

public interface PokemonGuide {                                                               // Interface PokemonGuide created to be implemented by PokemonCard superclass and inherited by each Pokemon card subclass.
    void attackCharge();                                                                      // Method attackCharge created to be implemented by PokemonCard class and inherited by each Pokemon card subclass for unique attack charge declarations
    void damageEnemy(int damageType, PokemonCard enemy);                                      // Method damageEnemy created to be implemented by PokemonCard class to damgage enemy Pokemons
    void evolver(Player player, PokemonCard pokemon2, int choice);                            // Method evolver created to be implemented by PokemonCard class to evolve Pokemon
}    