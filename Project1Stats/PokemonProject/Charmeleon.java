package PokemonProject;

public class Charmeleon extends PokemonCard {                                                                                                       // Charmeleon class that extends PokemonCard
    public Charmeleon() {                                                                                                                           // Constructor for Charmeleon                      
        super("Charmeleon", 80, "Slash", 30, "Flamethrower", 80, "Fire", "Water", "Charizard", true);   // sets the name, hp, normal attack name, normal attack damage, special move name, special move damage, type, weakness, next evolution, and if its evolved
    }

    @Override                                                                    // Overrides the attackcharge method from PokemonCard                  
    public void attackCharge() {
        System.out.println(getCardName() + " is boiling to blaze the enemy");    // Prints out unique chargeup declaration for Charmeleon
    }
}