package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding the possible implementation of the interface TrainerGuide implemented by TrainerCard

public class UltraPotion extends TrainerCard {                                                                          // PotionTrainer subclass that extends TrainerCard superclass                
    public UltraPotion() {
        super("Potion", "Healing/Overhealing 30 hp for Active Pokemon: ", "Item");         // sets the name, information, and trainerType
    }

    @Override                                                                           // Overrides the activateTrainer method from the TrainerGuide interface which is implemented by the TrainerCard superclass
    public void activateTrainer(Player player) {            
        System.out.println("Activating " + getCardName());                              // prints out that this specific TrainerCard is being activated               
        playCard();                                                                     // Calls the playCard method from the TrainerCard superclass, which is overridden in the TrainerCard subclass from the Card superclass
        System.out.println(getInformation() + player.getActive().getCardName());        // prints out the information and the name of the active Pokemon
        player.getActive().vitalizePoke(30);                                      // Calls the vitalizePoke method for the active Pokemon to heal 30 damage (Overheal can occur)          
        player.discardCard(this);                                                       // Calls the discard method so its added to the discard pile after activation 
        player.removeCardHand(this);                                                    // Calls the removeCard method to remove the card from the hand
    }
}