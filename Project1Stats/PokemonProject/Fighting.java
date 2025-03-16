package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface EnergyGuide implemented by EnergyCard

public class Fighting extends EnergyCard {                                  // Fighting subclass that extends the EnergyCard superclass
    public Fighting() {                                                     // Constructor for Fighting      
        super("Fighting","Electric", "Fighting");  // sets the name, superiortyOver, and type
    }
}