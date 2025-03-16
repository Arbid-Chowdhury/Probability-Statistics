package SoftwareCheckups;

import java.util.ArrayList;
import java.util.Collections;

public class Mulligan {                                             // Mulligan class
   
    public ArrayList<Cards> deckMaker(int pokeQuantity) {           // Method that generates the deck
        ArrayList<Cards> Deck = new ArrayList<>();                  // Creates a new deck ArrayList
        for (int i = 0; i < pokeQuantity; i++) {                    // loop adding pokemon cards to the deck
            Deck.add(new Cards(Cards.PokemonCardType.Pokemon));     // Add the pokemon cards to the deck
        }
        for (int i = pokeQuantity; i < 60; i++) {                   // loop adding energy cards to the deck
            Deck.add(new Cards(Cards.PokemonCardType.Energy));      // Add the energy cards to the deck
        }
        deckShuffler(Deck);                                         // Shuffles the deck using the deckShuffler method
        return Deck;                                                // Return deck
    }

    public void deckShuffler(ArrayList<Cards> deck) {               // Method to shuffle the deck
        Collections.shuffle(deck);                                  // Shuffles the deck using the Collections library shuffle commmand
    }

    public void drawCard(ArrayList<Cards> deck, ArrayList<Cards> hand) {  // Method to draw a card
        hand.add(deck.remove(0));                                   // Adds the top card of the deck to the hand and removes it from the deck
    }

    public ArrayList<Cards> drawHand(ArrayList<Cards> deck) {         // Method to draw intial hand
        ArrayList<Cards> hand = new ArrayList<>();                    // Creates a new hand ArrayList
        for (int i = 0; i < 7; i++) {                                 // loop to draw 7 cards from the deck
            drawCard(deck, hand);                                     // Draws a card from the deck and adds it to the hand
        }
        return hand;                                                  // Return hand
    }

    public boolean checkMulliganHand(ArrayList<Cards> hand) {                           // Method to check if mulligan has happened
        for (Cards card : hand) {                                                       // for each card element in the hand 
            if (card.getType() == Cards.PokemonCardType.Pokemon) {                      // If the card type is pokemon card 
                return false;                                                           // Returns false
            }
        }
        return true;                                                                    // Returns true if no pokemon cards are in the hand
    }

    public double mulliganProbability(int pokeQuantity) {                               // Method to calculate mulligan probability
        int mullcount = 0;                                                              // Initialize the mulligan count to 0
        for (int i = 0; i < 10000; i++) {                                               // loops to run the experiment 10,000 times
            ArrayList<Cards> deck = deckMaker(pokeQuantity);                            // Generates new deck 
            if (checkMulliganHand(drawHand(deck))) {                                    // If mulligan is there in drawn hand
                mullcount++;                                                            // mullcount increases
            }
        }
        double mullprob = (double) mullcount / 10000 * 100;                             // Calculates the mulligan probability for 10,000 runs, mutiplied by 100 to get a percentage and casted as double
        return mullprob;                                                                // Return mullprob
    }

    public void probabilityTest() {                                                                     // Method to test the probability of a mulligan for different deck with incremented pokemon cards
        System.out.println("Mulligan Probability for Pokemon Decks");                                 // Print test title
        for (int i = 1; i <= 60; i++) {                                                                 // loop to test the probability of a mulligan for decks with 1 - 60 pokemon cards, i being pokeQuantity
            System.out.println(i + " Pokemon Deck Probability: " +  mulliganProbability(i) + " %");     // Print the probability of a mulligan for each deck generated with i pokemon cards
        }
    }
}