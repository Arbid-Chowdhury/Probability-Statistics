package SoftwareCheckups;

//https://www.w3schools.com/java/java_enums.asp used their enum concept to learn how to call the card types in both Brick and Mulligan classes

public class Cards {                                            // Card class

    PokemonCardType cardtype;                                   // Intialize cardtype
    
    public enum PokemonCardType {                               // Enum the Card types Energy, Pokemon, RareCandy for deck creation
        Energy, Pokemon, RareCandy 
    };

    public Cards(PokemonCardType cardtype) {                    // Constructor for cardtype 
        this.cardtype = cardtype;
    }
    public PokemonCardType getType() {                          // Getter for cardtype      
        return cardtype;
    }
}