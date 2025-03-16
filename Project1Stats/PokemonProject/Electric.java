package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface EnergyGuide implemented by EnergyCard

public class Electric extends EnergyCard {                                  // Electric subclass that extends EnergyCard superclass        
    public Electric() {                                                     // Constructor for Electric        
        super("Electric", "Water", "Electric");    // sets the name, superiortyOver, and type 
    }
}