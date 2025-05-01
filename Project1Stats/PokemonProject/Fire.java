package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface EnergyGuide implemented by EnergyCard

public class Fire extends EnergyCard {                               // Fire subclass that extends the EnergyCard superclass
    public Fire() {                                                  // Constructor for Fire  
        super("Fire", "Water", "Fire");     // sets the name, superiortyOver, and type
    }
}