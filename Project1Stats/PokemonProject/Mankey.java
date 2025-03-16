package PokemonProject;

public class Mankey extends PokemonCard {                                                                                                              // Mankey class that extends PokemonCard
    public Mankey() {                                                                                                                                  // Constructor for Mankey
        super("Mankey", 60, "Low Kick", 10, "Hang Down", 30, "Fighting", "Psychic", "Primeape", false);    // sets the name, hp, normal attack name, normal attack damage, special move name, special move damage, type, weakness, next evolution, and if its evolved
    } 

    @Override                                                                                    // Overrides the attackcharge method from PokemonCard                
    public void attackCharge() {
        System.out.println(getCardName() + " is beating its chest to pummel the enemy");         // Prints out unique chargeup declaration for Charmander
    }
}