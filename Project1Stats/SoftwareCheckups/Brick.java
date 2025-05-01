package SoftwareCheckups;

import java.util.ArrayList;
import java.util.Collections;

public class Brick {                                                // Brick class

    public ArrayList<Cards> deckMaker(int rareCandyQuantity) {      // Method that generates the deck
        ArrayList<Cards> Deck = new ArrayList<>();                  // Creates a new deck arraylist
        for (int i = 0; i < rareCandyQuantity; i++) {               // loop to add the rare candy cards to the deck
            Deck.add(new Cards(Cards.PokemonCardType.RareCandy));   // Add the rare candy cards to the deck
        }
        while (Deck.size() < 60) {                                  // loop to add the pokemon/energy cards to the deck as long as deck is less than 60
            Deck.add(new Cards(Cards.PokemonCardType.Pokemon));     // Adding the pokemon cards to the deck
            Deck.add(new Cards(Cards.PokemonCardType.Energy));      // Adding the energy cards to the deck
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

    public ArrayList<Cards> drawHand(ArrayList<Cards> deck) {       // Method to draw intial hand
        ArrayList<Cards> hand = new ArrayList<>();                  // Creates a new hand ArrayList
        for (int i = 0; i < 7; i++) {                               // loop to draw 7 cards from the deck
            drawCard(deck, hand);                                   // Draws a card from the deck and adds it to the hand
        }
        return hand;                                                // Return hand
    }

    public boolean checkMulliganHand(ArrayList<Cards> hand) {                           // Method to check if mulligan has happened
        for (Cards card : hand) {                                                       // for each card element in the hand 
            if (card.getType() == Cards.PokemonCardType.Pokemon) {                      // it checks if the card is a pokemon card type 
                return false;                                                           // Returns false
            }
        }
        return true;                                                                    // Returns true if no pokemon cards in hand
    }

    public ArrayList<Cards> prizePileDrawer(ArrayList<Cards> deck, ArrayList<Cards> hand) {       // Method to draw a prize pile after checking for mulligan
        ArrayList<Cards> PrizePile = new ArrayList<>();                                           // Creates a new prize pile ArrayList
        if(!checkMulliganHand(hand)) {                                                            // If checkMulliganHand boolean is false for hand drawn from deck
            for (int i = 0; i < 6; i++) {                                                         // loop to draw 6 cards from the deck for the prize pile
                PrizePile.add(deck.remove(0));                                              // Adds top card of deck to the prize pile and removes it from deck
            }
        }                                                                     
        return PrizePile;                                                               // Return prize pile 
    }

    public boolean checkPrizePile(ArrayList<Cards> PrizePile) {                         // Method to check if there is atleast one rare candy card in the prize pile 
        for (Cards card : PrizePile) {                                                  // loops through each card element in the prize pile arraylist
            if (card.getType() == Cards.PokemonCardType.RareCandy) {                    // Checks if the card type is the rare candy card type
                return true;                                                            // Returns true
            }
        }
        return false;                                                                   // Otherwise returns false
    }
    
    public double candyPrizeProbabilty(int RareCandyQuantity) {                         // Method to calculate the probability of rare candy in the prize pile
        int candycount = 0;                                                             // Initialize the rare candy count to 0
        for (int i = 0; i < 10000; i++) {                                               // loop for 10,000 runs
            ArrayList<Cards> deck = deckMaker(RareCandyQuantity);                       // Generates a new deck depending on rare candy quantity
            if (checkPrizePile(prizePileDrawer(deck, drawHand(deck)))) {                // If the prize pile has a rare candy
                candycount++;                                                           // Increases candycount
            }
        }
        double candyprob = (double) candycount / 10000 * 100;                           // Calculate the probability of rare candy in prize pile for 10,000 runs, mutiplied by 100 to get a percentage and casted as double
        return candyprob;                                                               // Return candyprob
    }

    public void candyProbabilityTest() {                                                                              // Method testing the rare candy probability, varying amount of rare candy cards   
        System.out.println("Rare Candy Probability for Prize Pile");                                                // Print test title 
        for (int i = 1; i <= 4; i++) {                                                                                // loops to test the probability of a rare candy in the prize pile for 1 - 4 rare candy cards/iterations, i being RareCandyQuantity
            System.out.println(i + " Rare Candy Card in Prize Pile Proability " + candyPrizeProbabilty(i) + " %");    // Print each probability of 1-4 rare candy cards in prize pile for 10,000 runs each
        }
    }
}