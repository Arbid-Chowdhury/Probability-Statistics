package PokemonProject;

public class Pikachu extends PokemonCard {                                                                                                           // Pikachu class that extends PokemonCard          
    public Pikachu() {                                                                                                                               // Constructor for Pikachu
        super("Pikachu", 60, "Gnaw", 10, "Thunder Jolt", 30, "Electric", "Fighting", "Raichu", false);   // sets the name, hp, normal attack name, normal attack damage, special move name, special move damage, type, weakness, next evolution, and if its evolved
    }   

    @Override                                                                               // Overrides the attackcharge method from PokemonCard
    public void attackCharge() {
        System.out.println(getCardName() + " is jolting up to electrify the enemy");        // Prints out unique chargeup declaration for Pikachu
    }
}