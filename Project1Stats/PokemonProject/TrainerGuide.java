package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used to learn and incorporate interfaces into the project 3 main card types (Pokemon, Trainer, Energy) using the interface to implement the playCard method for each card type

public interface TrainerGuide {                         // TrainerGuide interface for TrainerCard class
    public void activateTrainer(Player player);         // activateTrainer method for TrainerCard class which will be inherited by all TrainerCards
}