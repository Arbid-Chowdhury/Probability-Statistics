package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface EnergyGuide implemented by EnergyCard

public class Water extends EnergyCard {                             // Water subclass that extends the EnergyCard superclass
    public Water() {                                                // Constructor for Water
        super("Water", "Fire", "Water");   // sets the name, superiortyOver, and type
    }  
}