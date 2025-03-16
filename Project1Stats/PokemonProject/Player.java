package PokemonProject;

import java.util.ArrayList;
import java.util.Random;
//https://www.geeksforgeeks.org/switch-statement-in-java/ helped understand switch cases can be implemented vs if else statements which were causing issues in the code for turnloop method, but implementing switch cases helped for readability and efficiency by jumping to int values instead checking multiple conditions.
//https://www.baeldung.com/java-type-casting helped understand object type casting used to help convert object types to specific card types for the player's arraylists, for example hand contains Cards but bench only conatains Pokemon Card, so casting is needed to add cards to bench arraylist, via getCardFromHand method(Card) allowing it be a PokemonCard that is added to bench arraylist.
// the object casting done was due to how the ArrayLists were intialized for different card types, also how zero based index of card display was shifted to one based and player input was shifted to zero based to match the card choice for takeTurn method.

public class Player {                                                   // Player class 
    private String name;                                                // private String name
    private Deck deck;                                                  // private Deck deck object
    private ArrayList<Card> hand;                                       // private ArrayList<Card> hand
    private ArrayList<Card> prizePile;                                  // private ArrayList<Card> prizePile
    private PokemonCard activePokemon;                                  // private PokemonCard activePokemon              
    private ArrayList<EnergyCard> activePokemonEnergy;                  // private ArrayList<EnergyCard> activePokemonEnergy
    private ArrayList<PokemonCard> bench;                               // private ArrayList<PokemonCard> bench
    private ArrayList<Card> discardPile;                                // private ArrayList<Card> discardPile
   
    public Player(String name, Deck deck) {                             // Player constructor with String name and Deck deck
        this.name = name;                                               // sets name
        this.deck = deck;                                               // sets deck        
        hand = new ArrayList<Card>();                                   // sets hand as new empty ArrayList<Card>
        prizePile = new ArrayList<Card>();                              // sets prizePile as new empty ArrayList<Card>
        this.activePokemon = null;                                      // sets activePokemon as null      
        activePokemonEnergy = new ArrayList<EnergyCard>();              // sets activePokemonEnergy as new empty ArrayList<EnergyCard>
        bench = new ArrayList<PokemonCard>();                           // sets bench as new empty ArrayList<PokemonCard>
        discardPile = new ArrayList<Card>();                            // sets discardPile as new empty ArrayList<Card>
    }
    
    public String getName() {                                          // getName method
        return name;                                                   // Return Player name, based on player input         
    }

    public PokemonCard getActive() {                                   // getActive method
        return activePokemon;                                          // Return activePokemon PokemonCard             
    }

    public PokemonCard setActive(PokemonCard card) {                   // setActive method
        return activePokemon = card;                                   // Return and sets activePokemon as card
    }

    public void displayActive() {                                      // displayActive method for game display
        System.out.println(activePokemon.getCardName());               // Print activePokemon name
    }

    public ArrayList<EnergyCard> getActivePokemonEnergy() {            // getActivePokemonEnergy method
        return activePokemonEnergy;                                    // Return activePokemonEnergy 
    }

    public boolean coinFlipHeads(int flipChoice) {                     // coinFlipHeads boolean method for determining coin flip winner
        Random random = new Random();                                  // Random object random     
        int flip = random.nextInt(2);                            // int flip is random.nextInt(2)
        return flip == flipChoice;                                     // Return true if flip == flipChoice, based on player input
    }

    public int getDeckSize() {                                         // getDeckSize method for game display
        return deck.deckSize();                                        // Return getDeckSize method from Deck class
    }

    private boolean ifDeckEmpty() {                                    // checkDeckEmpty boolean method
        return deck.emptyDeck();                                       // Return boolean emptyDeck method from Deck class
    }

    public int checkHandSize() {                                       // checkHandSize method for hand size
        return hand.size();                                            // Return hand size
    }

    public int checkBenchCapacity() {                                  // checkBenchCapacity method for bench size
        return bench.size();                                           // Return bench size                            
    }

    public Card getCardFromHand(int pokePosition) {                                 // getCardFromHand method for player input
        return hand.get(pokePosition);                                              // Return card from hand ArrayList based on pokePosition
    }

    public Card getCardFromBench(int pokePosition) {                                // getCardFromBench method for player input
        return bench.get(pokePosition);                                             // Return card from bench ArrayList based on pokePosition
    }

    public void removeCardHand(Card card) {                                         // removeCardHand method for removing card from hand
        hand.remove(card);                                                          // removes card from hand 
    }

    public void removeCardBench(PokemonCard card) {                                 // removeCardBench method for removing card from bench
        bench.remove(card);                                                         // removes card from bench
    }

    public int getDiscardSize() {                                                   // getDiscardSize method for game display
        return discardPile.size();                                                  // Return discardPile size
    }

    public void discardCard(Card card) {                                            // discardCard method for discarding card
        discardPile.add(card);                                                      // adds card to discardPile 
    }

    public void discardHand() {                                                     // discardHand method for discarding hand
        discardPile.addAll(hand);                                                   // add all cards from hand to discardPile
        hand.clear();                                                               // clears hand after adding all cards to discardPile
    }

    public void drawCard(int cards) {                                               // drawCard method for int cards
        for (int i = 0; i < cards; i++) {                                           // for loop to draw cards depending on int cards 
            if (!ifDeckEmpty()) {                                                   // if deck is not empty
                hand.add(deck.removeCard(0));                          // add top card of deck to hand
            }
            else {                                                                  // else
                System.out.println("Deck is empty so cards can't be drawn");      // Inform player that deck is empty
                break;                                                              // break                                        
            }
        }
    }

    public void makeHand() {                                                         // makeHand method for generating hand
        drawCard(7);                                                           // draw 7 cards using drawCard method
    }

    public void displayHand() {                                                      // displayHand method for game display
        for (int i = 0; i < hand.size(); i++) {                                      // for loop to display cards within hand range
            System.out.print((i + 1) + ": " + hand.get(i).getCardName() + ", ");     // print card name and index from hand ArrayList shifted to one based index
        }
    }

    private boolean checkHand() {                                                                                          // checkHand boolean method for making sure hand has PokemonCard and prize pile setup
        for (Card card : hand) {                                                                                           // for each loop to check each card in hand
            if (card instanceof PokemonCard && !((PokemonCard) card).getIfEvolved()) {                                     // if the card is instance of PokemonCard and is basic (not evolved)
                return true;                                                                                               // Return true if card is PokemonCard            
            }
        }
        return false;                                                                                                      // Return false if 0 PokemonCard is in hand
    }

    public void displayBench() {                                                                                           // displayBench method for game display
        for (int i = 0; i < checkBenchCapacity(); i++) {                                                                   // for loop to display cards within bench range
            System.out.print((i + 1) + ": " + bench.get(i).getCardName() + " [ HP ]: " + bench.get(i).getHp() + ", ");     // print card name and index from bench ArrayList shifted to one based index 
        }
    }

    public void addBench(PokemonCard card) {                                                                               // addBench method for adding PokemonCard to bench
        if (checkBenchCapacity() < 5) {                                                                                    // if checkBenchCapacity is less than 5
            bench.add(card);                                                                                               // add the card to bench
            System.out.println(card.getCardName() + " has been added to your bench");                                      // Inform player the card has been added to bench
            removeCardHand(card);                                                                                          // remove card from hand
        }
        else {                                                                                                             // else
            System.out.println("Only Pokemon allowed on the bench and a maximum of 5 Pokemon allowed");                  // Inform player only Pokemon allowed on bench with 5 Pokemon limit
        }
    }

    public void makePrizePile(Player player2) {                                                             // makePrizePile method for game setup
        makeHand();                                                                                         // current player makes hand using makeHand method
        while (!checkHand()) {                                                                              // while checkHand is false, no Pokemon in hand
            System.out.println("Hand: ");                                                                 // Hand display text
            displayHand();                                                                                  // Reveals hand using displayHand method                   
            System.out.println("No basic Pokemon in Hand, Redrawing ...");                                // Inform player theres no basic Pokemon in hand then redrawing hand
            deck.addAll(hand);                                                                              // add all cards from hand to deck using addAllCards method from deck class
            deck.deckShuffle();                                                                             // shuffle deck using deckShuffle method from deck class
            System.out.println(player2.getName() + " draws an extra card from their deck");                 // Inform player2 that will draw an extra card from their deck
            player2.drawCard(1);                                                                      // Draws 1 card for player2 using drawCard method
            makeHand();                                                                                     // current player makes hand again using makeHand method
        }
        deckToPrizePile(prizePile);                                                                         // generate prizePile using deckToPrizePile method
    }

    private void deckToPrizePile(ArrayList<Card> prizePile) {                                               // deckToPrizePile for generating prizePile
        for (int card = 0; card < 1; card++) {                                                              // for loop to add 6 cards to prizePile
            prizePile.add(deck.removeCard(0));                                                 // add top card from deck to prizePile each iteration
        }
    }

    public int countPrizePile() {                                                                           // countPrizePile method for game info display
        return prizePile.size();                                                                            // Return prizePile size, for player awarness of game status 
    }

    private void takePrizeCard() {                                                                              // takePrizeCard method for player after knocking out pokemon
        if (countPrizePile() != 0) {                                                                            // if countPrizePile is not 0
            hand.add(prizePile.remove(0));                                                                // add top card from prizePile to hand
            System.out.println("You have won 1 of your prize cards: ");                                       // Inform player they have acquired 1 prize card
            System.out.println(countPrizePile() + " prize cards left to collect");                              // Inform player how many prize cards are left
        }
        else {                                                                                                  // else               
            System.out.println(getName() + " prize pile is all collected");                                     // Inform player prize pile is fully collected
        }
    }

    public void benchActivePokemon() {                                                                          // benchActivePokemon method for benching activePokemon
        if (checkBenchCapacity() < 5) {                                                                         // if checkBenchCapacity is less than 5
            bench.add(getActive());                                                                             // add the activePokemon to bench
            activePokemon = null;                                                                               // set activePokemon to null
            discardAllEnergy();                                                                                 // discardAllEnergy method used to discard all energy attached to activePokemon
        }
        else {                                                                                                  // else
            System.out.println("Bench is currently full so removing Active Pokemon is not allowed");          // Inform player bench is full
        }
    }                                
    
    private void discardAllEnergy() {
        discardPile.addAll(activePokemonEnergy);                                                            // discardAllEnergy method for discarding all energy cards after replacing activePokemon
        activePokemonEnergy.clear();                                                                        // clear activePokemonEnergy after adding all energy cards to discardPile
    }

    public int activeEnergyCounter() {                                                                      // activeEnergyCounter method for checking activePokemon Energy count on game display
        return activePokemonEnergy.size();                                                                  // Return activePokemonEnergy size                                                                      
    }

    public boolean swapActivePokemon(PokemonCard card) {                                                    // swapActivePokemon method for swapping activePokemon based on bench Pokemon player input 
        if (activeEnergyCounter() >= 1) {                                                                   // if activeEnergyCounter is greater than or equal to 1
            benchActivePokemon();                                                                           // bench activePokemon               
            setActive(card);                                                                                // set new activePokemon as card
            removeCardBench(card);                                                                          // remove card from bench
            return true;                                                                                    // Return true
        }
        else {                                                                                              // else                   
            System.out.println("Active Pokemon does not have enough energy to swap");                     // Inform player activePokemon does not have enough energy to swap
            return false;                                                                                   // Return false
        }
    }

    public void fillActiveWhenDefeated(Player player, Player player2) {                                                 // fillActiveWhenDefeated method for filling activePokemon spot when defeated
        player.takePrizeCard();                                                                                         // takePrizeCard method used by player
        player2.discardAllEnergy();                                                                                     // discardAllEnergy method used by player2
        player2.discardPile.add(player2.getActive());                                                                   // add player 2's activePokemon to discardPile
        if (player2.checkBenchCapacity() > 0) {                                                                         // if player2 checkBenchCapacity is greater than 0
            player2.setActive(player2.bench.remove(0));                                                           // Sets player 2's activePokemon as the first in bench
        }
        else {                                                                                                          // else
            System.out.println(player2.getName() + " has no Pokemon left from bench to fill Active ");                  // Inform player2 has no Pokemon left to fill activePokemon
            System.out.println(player2.getName() + " has lost the Pokemon Game due to empty field ");                   // Inform player2 has lost the Pokemon Game due to their empty field
        }
    }

    public boolean activePokemonAttack(int attackType, Player player, Player player2) {                                 // activePokemonAttack boolean method for attacking enemy activePokemon
        getActive().playCard();                                                                                         // use getActive method for Pokemon to use playCard method to declare its played on field
        getActive().attackCharge();                                                                                     // use getActive method for Pokemon to use attackCharge method to declare its unique charge attack statement
        System.out.println(getActive().getCardName() + " has " + activeEnergyCounter() + " energy cards attached");     // Inform player how many energy cards are attached to activePokemon
        if (activeEnergyCounter() >= 1 && attackType == 1 && !getActive().getIfEvolved()) {                             // if activeEnergyCounter is greater than or equal to 1, attackType is 1, and Pokemon is basic
            getActive().damageEnemy(1, player2.getActive());                                                 // use getActive method for Pokemon to use damageEnemy method to damage enemy Pokemon
            return true;                                                                                                // Return true
        }
        else if (activeEnergyCounter() >= 2 && attackType == 2 && !getActive().getIfEvolved()) {                        // else if activeEnergyCounter is greater than or equal to 2, attackType is 2, and Pokemon is basic
            getActive().damageEnemy(2, player2.getActive());                                                 // use getActive method for Pokemon to use damageEnemy method to damage enemy Pokemon
            return true;                                                                                                // Return true
        } 
        else if (activeEnergyCounter() >= 2 && attackType == 1 && getActive().getIfEvolved()) {                         // else if activeEnergyCounter is greater than or equal to 2, attackType is 1, and Pokemon is evolved
            getActive().damageEnemy(1, player2.getActive());                                                 // use getActive method for Pokemon to use damageEnemy method to damage enemy Pokemon
            return true;                                                                                                // Return true
        }
        else if (activeEnergyCounter() >= 3 && attackType == 2 && getActive().getIfEvolved()) {                         // else if activeEnergyCounter is greater than or equal to 3, attackType is 2, and Pokemon is evolved
            getActive().damageEnemy(2, player2.getActive());                                                 // use getActive method for Pokemon to use damageEnemy method to damage enemy Pokemon
            return true;                                                                                                // Return true
        }
        else {                                                                                                          // else
            System.out.println("Not enough energy to attack with Active Pokemon");                                    // Inform player not enough energy to perform attack
            return false;                                                                                               // Return false                    
        }
    }

    public boolean evaluateWinner(Player player2) {                                                                     // evaluateWinner boolean method for evaluating the Pokemon Game winner 
        if (countPrizePile() == 0) {                                                                                    // if Win Condition 1, countPrizePile is 0
            System.out.println(getName() + " has collected all their prize pile cards");                                // Inform player has collected all their prize cards
            return true;                                                                                                // Return true
        }
        else if (player2.ifDeckEmpty()) {                                                                               // else if Win Condition 2, player2 deck is empty       
            System.out.println(player2.getName() + "'s deck is now empty");                                                 // Inform current player that player2's deck is empty
            return true;                                                                                                // Return true                  
        }
        else if (player2.checkBenchCapacity() == 0 && player2.getActive().pokemonDefeated() == true) {                  // else if Win Condition 3, player2 bench is empty and activePokemon is defeated
            System.out.println(player2.getName() + " has 0 Pokemon left on their field");                               // Inform current player that player2 has empty field
            return true;                                                                                                // Return true                          
        }   
        return false;                                                                                                   // Return false if none of the Win Conditions are met                                
    }
}