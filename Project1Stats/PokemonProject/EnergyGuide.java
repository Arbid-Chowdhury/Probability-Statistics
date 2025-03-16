package PokemonProject;
import java.util.ArrayList;                 

//https://www.geeksforgeeks.org/interfaces-in-java/ used this interface EnergyGuide to have EnergyCard implementing it and for it to be inherited by each energy card

public interface EnergyGuide {                                                       // Interface EnergyGuide created to be implemented by EnergyCard superclass and inherited by each energy card subclass.                                 
    void attachEnergy(Player player, ArrayList<EnergyCard> activePokemonSlot);       // Method attachEnergy created to be implemented by EnergyCard class to allow player to attach energy card to their active Pokemon (to be used to attack opposing active pokemon).
}