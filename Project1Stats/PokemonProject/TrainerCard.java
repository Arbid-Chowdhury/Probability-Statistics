package PokemonProject;

//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding how to interface TrainerGuide & CardGuide to be implemented by TrainerCard

public class TrainerCard extends Card implements CardGuide, TrainerGuide {          // TrainerCard superclass that extends Card superclass and implements the CardGuide and TrainerGuide interfaces
    private String information;                                                     // private String information
    private String trainerType;                                                     // private String trainerType           

    public TrainerCard(String name, String information, String trainerType) {       // Constructor for TrainerCard 
        super(name);                                                                // Calls Card constructor to set the name
        this.information = information;                                             // sets the trainer information  
        this.trainerType = trainerType;                                             // sets the trainerType 
    }

    public String getInformation() {                                                // getter method for information                 
        return information;                                                         // Return the trainer information               
    }

    public String getTrainerType() {                                                // getter method for trainerType    
        return trainerType;                                                         // Return the trainerType
    }

    @Override                                                                       // Overrides the playCard method from the Card superclass               
    public void playCard() {                         
        System.out.println(getCardName() + " is played on the field");              // prints out card name is played on the field    
    }

    @Override                                                                       // Overrides the the activateTrainer method from the TrainerGuide interface
    public void activateTrainer(Player player) {                                   
        System.out.println("Activating " + getCardName());                          // prints out that the card is being activated
    }
}