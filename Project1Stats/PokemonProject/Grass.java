package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface EnergyGuide implemented by EnergyCard

public class Grass extends EnergyCard {                                 // Grass subclass that extends the EnergyCard superclass
    public Grass() {                                                    // Constructor for Grass        
        super("Grass", "Fighting", "Grass");   // sets the name, superiortyOver, and type
    }
}