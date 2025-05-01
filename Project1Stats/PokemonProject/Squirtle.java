package PokemonProject;

public class Squirtle extends PokemonCard {                                                                                                         // Squirtle class that extends PokemonCard
    public Squirtle() {                                                                                                                             // Constructor for Squirtle
        super("Squirtle", 60, "Bubble", 20, "Water Gun", 30, "Water", "Electric", "Wartortle", false);  // sets the name, hp, normal attack name, normal attack damage, special move name, special move damage, type, weakness, next evolution, and if its evolved
    }

    @Override                                                                             // Overrides the attackcharge method from PokemonCard                 
    public void attackCharge() {
        System.out.println(getCardName() + " is absorbing to overflow the enemy");        // Prints out unique chargeup declaration for Squirtle
    }
}
