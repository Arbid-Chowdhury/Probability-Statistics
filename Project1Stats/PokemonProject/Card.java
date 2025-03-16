package PokemonProject;

public class Card {                     // Card superclass
    private String name;                // private name 

    public Card(String name) {          // Constructor for Card   
        this.name = name;
    }

    public String getCardName() {       // Method for getting Card name
        return name;                    // returns name
    }
}
