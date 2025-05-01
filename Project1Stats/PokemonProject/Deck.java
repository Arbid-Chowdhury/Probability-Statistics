package PokemonProject;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {                                             // Deck class for Deck Generation and
    private ArrayList<Card> deck;                               // Deck ArrayList containing Cards 

    public Deck() {                                             // Deck constructor for Decks used by players         
        deck = new ArrayList<>();                               // deck ArrayList created
        makeDeck();                                             // makeDeck method called to generate deck
    }

    public void makeDeck() {                                    // makeDeck method to generate deck
        for (int i = 0; i < 4; i++) {                           // for loop to add 4 of each 5 Pokemon Cards & their 5 respective Energy Cards to deck (charmeleon can be switched for mankey with fighting energy)
            deck.add(new Charmander());                         // add Charmander Pokemon card to deck
            deck.add(new Squirtle());                           // add Squirtle Pokemon card to deck
            deck.add(new Bulbasaur());                          // add Bulbasaur Pokemon card to deck
            deck.add(new Pikachu());                            // add Pikachu Pokemon card to deck
            deck.add(new Charmeleon());                         // add Charmeleon Pokemon card to deck
            deck.add(new Fire());                               // add Fire Energy card to deck
            deck.add(new Water());                              // add Water Energy card to deck
            deck.add(new Grass());                              // add Grass Energy card to deck
            deck.add(new Electric());                           // add Electric Energy card to deck
            deck.add(new Fire());                               // add Fire energy Energy to deck
        }
        for (int i = 0; i < 5; i++) {                           // for loop to add 5 of each 5 Trainer Cards to deck
            deck.add(new BillTrainer());                        // add Bill Trainer card to deck
            deck.add(new ProfessorsResearch());                 // add Professor's Research Trainer card to deck
            deck.add(new BobTrainer());                         // add Bob Trainer card to deck
            deck.add(new UltraPotion());                        // add UltraPotion Trainer card to deck
        }
        deckShuffle();                                          // deckShuffle method called to shuffle deck
    }

    public void deckShuffle() {                                 // deckShuffle method to shuffle deck
        Collections.shuffle(deck);                              // shuffle deck using Collections.shuffle command
    }

    public int deckSize() {                                     // deckSize method to get size of deck
        return deck.size();                                     // Return size of deck
    }

    public boolean emptyDeck() {                                // emptyDeck method to check if deck is empty
        return deck.isEmpty();                                  // Return true if the deck is empty
    }

    public Card removeCard(int cardPosition) {                  // removeCard method to remove card from deck 
        return deck.remove(cardPosition);                       // Return card removed from deck based on int cardPosition  
    }

    public void addAll(ArrayList<Card> cards) {                 // addAll method to add all cards to deck
        deck.addAll(cards);                                     // add all cards from cards to deck            
        cards.clear();                                          // clear cards ArrayList
    }

    public void displayDeckMenu() {                                 // displayDeckMenu method to display deck menu
        for (Card card : deck) {                                    // for each loop to iterate through Cards in deck 
            System.out.print("[" + card.getCardName() + "], ");     // print every cards' name from deck ArrayList seperated by commas
        }
    }
}