package PokemonProject;

public class Charmander extends PokemonCard {                                                                                                      // Charmander class that extends PokemonCard
    public Charmander() {                                                                                                                          // Constructor for Charmander   
        super("Charmander", 60, "Scratch", 10, "Ember", 30, "Fire", "Water", "Charmeleon", false);     // sets the name, hp, normal attack name, normal attack damage, special move name, special move damage, type, weakness, next evolution, and if its evolved
    }

    @Override                                                                       // Overrides the attackcharge method from PokemonCard                
    public void attackCharge() {
        System.out.println(getCardName() + " is firing up to scorch the enemy");    // Prints out unique chargeup declaration for Charmander
    }
}