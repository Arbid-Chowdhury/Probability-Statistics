package PokemonProject;

public class Bulbasaur extends PokemonCard {                                                                                                       // Bulbasaur class that extends PokemonCard
    public Bulbasaur() {                                                                                                                           // Constructor for Bulbasaur                          
        super("Bulbasaur", 60, "Vine Whip", 10, "Razor Leaf", 30, "Grass", "Fire", "Ivysaur", false);  // sets the name, hp, normal attack name, normal attack damage, special move name, special move damage, type, weakness, next evolution, and if its evolved
    }

    @Override                                                                                        // Overrides the attackcharge method from PokemonCard              
    public void attackCharge() {                                                                                                 
        System.out.println(getCardName() + " is blooming and ready to whip the enemy");              // Prints out unique chargeup declaration for Bulbasaur
    }
}