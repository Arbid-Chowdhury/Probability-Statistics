package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface TrainerGuide implemented by TrainerCard

public class ProfessorsResearch extends TrainerCard {                                                                           // ProfessorsResearch subclass that extends TrainerCard superclass          
    public ProfessorsResearch() {
        super("Professor's Research", "Discarding hand and drawing 7 new cards.", "Supporter");    // sets the name, information, and trainerType
    }

    @Override                                                           // Overrides the activateTrainer method from the TrainerGuide interface which is implemented by the TrainerCard superclass              
    public void activateTrainer(Player player) {                        
        System.out.println("Activating " + getCardName());              // prints out that this specific TrainerCard is being activated
        playCard();                                                     // Calls the playCard method from the TrainerCard superclass, which is overridden in the TrainerCard subclass from the Card superclass
        getInformation();                                               // Calls the getInformation method from the TrainerCard superclass       
        player.discardCard(this);                                       // Calls the discard method so its added to the discard pile
        player.removeCardHand(this);                                    // Calls the removeCard method to remove the card from the hand  
        player.discardHand();                                           // Calls the discardHand method for player to discard their entire hand
        player.makeHand();                                              // Calls the makeHand method for player to draw 7 new cards for their hand          
    }
}