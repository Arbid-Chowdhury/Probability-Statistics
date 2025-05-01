package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface TrainerGuide implemented by TrainerCard

public class BobTrainer extends TrainerCard {                                                   // BobTrainer subclass that extends TrainerCard superclass         
    public BobTrainer() {                                                                       // Constructor for BobTrainer             
        super("Bob", "Drawing 4 cards for your hand", "Item");     // sets the name, information, and trainerType
    }

    @Override                                                            // Overrides the activateTrainer method from the TrainerGuide interface which is implemented by the TrainerCard superclass
    public void activateTrainer(Player player) {                         
        System.out.println("Activating " + getCardName());               // prints out that this specific TrainerCard is being activated
        playCard();                                                      // Calls the playCard method from the TrainerCard superclass, which is overridden in the TrainerCard subclass from the Card superclass
        getInformation();                                                // Calls the getInformation method from the TrainerCard superclass
        player.drawCard(4);                                        // Calls the drawCard method for player to draw 4 cards for hand
        player.discardCard(this);                                        // Calls the discard method so its added to the discard pile after activation
        player.removeCardHand(this);                                     // Calls the removeCard method to remove the card from hand
    }
}