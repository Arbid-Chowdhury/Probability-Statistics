package PokemonProject;
//https://www.geeksforgeeks.org/interfaces-in-java/ used for understanding how to interface EnergyGuide & CardGuide to be implemented by EnergyCard

public class EnergyCard extends Card implements CardGuide, EnergyGuide {                        // EnergyCard subclass that extends Card superclass and implements the CardGuide and EnergyGuide interfaces
    private String superiortyOver;                                                              // private String superiortyOver                  
    private String type;                                                                        // private String type          

    public EnergyCard(String name, String superiortyOver, String type) {                        // Constructor for EnergyCard       
        super(name + " Energy Card");                                                           // Calls Card constructor to set the name with Energy Card added on to it           
        this.superiortyOver = superiortyOver;                                                   // sets the superiortyOver         
        this.type = type;                                                                       // sets the type       
    }

    public String getSuperiortyOver() {                                                         // getter method for superiortyOver
        return superiortyOver;                                                                  // Return Energy superiortyOver to inform player what nature of Energy/Pokemon it has superiorty over          
    }

    public String getType() {                                                                   // getter method for type
        return type;                                                                            // Return Energy type for checking if it matches the Active pokemon type
    }

    @Override                                                                                   // Overrides the playCard method from the Card superclass              
    public void playCard() {                                                                    
        System.out.println(getCardName() + " is played on the field");                          // prints out card name is played on the field    
    }

    @Override                                                                                                                       // Overrides the playCard method from the Card superclass          
    public void attachEnergy(Player player) {                                                                                       // attachEnergy method to attach energy card to active Pokemon
        if (getType().equals(player.getActive().getType())) {                                                                       // checks if the EnergyCard type matches the Active Pokemon type
            System.out.println(getCardName() + " is attached to the active Pokemon: " + player.getActive().getCardName());          // prints out that the EnergyCard is attached to the Active Pokemon
            player.getActivePokemonEnergy().add(this);                                                                              // adds the EnergyCard to the player's activePokemonEnergy             
            player.removeCardHand(this);                                                                                            // removes the EnergyCard from the player's hand
        }
        else {                                                                                                                      // else statement if the EnergyCard type does not match the Active Pokemon type               
            System.out.println(getCardName() + " type isnt same the active Pokemon type: " + player.getActive().getCardName());     // prints out that the EnergyCard type does not match the Active Pokemon type
        }
    }
}