package PokemonProject;

import java.util.Scanner;

//https://www.geeksforgeeks.org/switch-statement-in-java/ helped understand switch cases can be implemented vs if else statements which were causing issues in the code for turnloop method, but implementing switch cases helped for readability and efficiency by jumping to int values instead checking multiple conditions.
//https://www.baeldung.com/java-type-casting helped understand object type casting used to help convert object types to specific card types for the player's arraylists, for example hand contains Cards but bench only conatains Pokemon Card, so casting is needed to add cards to bench arraylist, via getCardFromHand method(Card) allowing it be a PokemonCard that is added to bench arraylist.

public class PokemonGameMenu {

    public void startGameMenu() {                                                                           // startGameMenu method that displays the game menu options (1-4)
        Scanner gameSelect = new Scanner(System.in);                                                        // Scanner gameSelect for game menu input
        System.out.println("------------------------------");                                             
        System.out.println(" Welcome to Pokemon Card Game");                                              // Game Menu Display Header 
        System.out.println("------------------------------");
        System.out.println("Select One Of The Game Menu Options: ");                                      // Game Menu Options Display
        System.out.println("1. Start Game");                                                              // Start Game option 1
        System.out.println("2. Learn Game Rules");                                                        // Learn Game Rules option 2
        System.out.println("3. Display Standard Game Deck");                                              // Display Standard Game Deck option 3
        System.out.println("4. Exit Game");                                                               // Exit Game option 4
        System.out.println("------------------------------");

        int selection = gameSelect.nextInt();                                                               // int selection for game menu option choice
        switch (selection) {                                                                                // switch case for int selection
            case 1:                                                                                         // Case 1 for starting the game
                System.out.println("Entering Pokemon Card Game...");                                      // Entering game    
                gameTime();                                                                                 // gameTime method used to begin game setup and gameplay
                break;                                                                                      // break to end after game is over

            case 2:                                                                                         // Case 2 for game rules display
                System.out.println("Gane Rules Of Pokemon Card Game: \n");                                // Display game rules header
                gameRules();                                                                                // gameRules method used to display game rules
                System.out.println("\nReturning to main menu...\n");                                      // Return to main menu 
                startGameMenu();                                                                            // startGameMenu method used to return to main menu
                break;                                                                                      // break

            case 3:                                                                                         // Case 3 for displaying the standard deck used by players
                System.out.println("The Standard Deck For Pokemon Card Game: \n");                        // Display standard deck header
                Deck standardDeckDisplay = new Deck();                                                      // New Deck standardDeckDisplay created                                  
                standardDeckDisplay.displayDeckMenu();                                                      // displayDeckMenu method used to display deck
                System.out.println("\nReturning to main menu...\n");                                      // Return to main menu
                startGameMenu();                                                                            // startGameMenu method used to return to main menu
                break;                                                                                      // break

            case 4:                                                                                         // Case 4 for exiting the game
                System.out.println("Pokemon Card Game Shutting Down...\n");                               
                System.out.println("Thanks for playing Pokemon Card Game!\n");                            
                break;                                                                                      // break

            default:                                                                                        // default Case for invalid input !(1-4)
                System.out.println("Select from the options (1 - 4)");                                    // Inform player to select from the valid options (1-4)
                startGameMenu();                                                                            // startGameMenu method used to return to main menu
        }   
        gameSelect.close();                                                                                 // close gameSelect scanner
    } 
    
    private void gameRules() {                                                                              // Displays Pokemon Card Game Rules
        System.out.println("-------------------------");
        System.out.println(" Pokemon Card Game Rules ");
        System.out.println("-------------------------");
        System.out.println("1. Each Player draws 7 cards from their deck, making theres atleast one Pokemon card, otherwise the player reveals/reshuffle Hand into deck and get new Hand, other player draws a card in chance of this event called a Mulligan");
        System.out.println("1b. after assuring both Players have a Pokemon in their Hand, they take the next 6 cards to fill their Prize Pile");
        System.out.println("2. Players set their field by placing 1 Pokemon card as the Active Pokemon and up to 5 Pokemon cards on their Bench");
        System.out.println("3. Players can draw once per turn then choose to play a Trainer/Pokemon/Energy card, swap/retreat Active with a Bench Pokemon, attack with Active Pokemon, evolve a Pokemon, or pass the turn");
        System.out.println("4. Players can fill their bench with Pokemons every turn from Hand Pokemons, but Active can only be replaced by Bench Pokemon, removing all the Energy attached to swap/retreat Active Pokemon to Bench");
        System.out.println("5. Players can play Trainer cards to better their hand or heal their Pokemon");
        System.out.println("6. Players can play Energy cards to attach to their Active Pokemon for attacking once per turn, turn ending after the attack");
        System.out.println("7. Players can attack with their Active Pokemon once per turn, using their normal attack or stronger special move, special move requiring 1 more Energy attached to the Pokemon");
        System.out.println("8. Players can win the game by collecting all of their 6 prize cards by defeating 6 of the opponent's Pokemon");
        System.out.println("9. Players can evolve their Active or bench Pokemon as long as the Pokemon matches the Pokemon evolution line, also Evolved Pokemon require 1 extra energy than basic for their attacks");
        System.out.println("10. Players can also win if their opponent doesnt have any Pokemon on both Active and Bench or just ran out cards in deck");
    }

    private void gameTime() {                                                                               // gameTime method encompasses setting up field and gameplay
        Scanner choice = new Scanner(System.in);
        Player p1 = setPlayer(choice, 1);                                                               // setPlayer method to set player 1
        Player p2 = setPlayer(choice, 2);                                                               // setPlayer method to set player 2
        p1.makePrizePile(p2);                                                                               // makePrizePile method to create prize pile for player 1
        p2.makePrizePile(p1);                                                                               // makePrizePile method to create prize pile for player 2            
        System.out.println("Battle Incoming: ");                                                          // Display battle incoming 
        System.out.println(p1.getName() + " VS. " + p2.getName());                                          // Display player 1 vs player 2
        System.out.println("First turn/field setup goes to coin flip winning player.");                   // Display coin flip rules
        System.out.println(p1.getName() + " choose 0 for heads or 1 for tails: ");                          // Player 1 is informed to select 0 for heads or 1 for tails
        int coinOption = choice.nextInt();                                                                  // int coinOption is input from player 1
        while (coinOption != 0 && coinOption != 1 ) {                                                       // while not choosing 0 or 1   
            System.out.println("Must choose either 0 or 1 for heads or tails respectively: ");            // Inform player again to choose 0 or 1
            coinOption = choice.nextInt();                                                                  // Take coinOption input again
        }
        boolean player1winner = p1.coinFlipHeads(coinOption);                                               // boolean player1winner set to player 1 coinFlipHeads method using coinOption 
        if (player1winner) {                                                                                // if player1winner is true
            System.out.println(p1.getName() + " goes first!");                                              // Display player 1 goes first
            playerSetField(p1, choice);                                                                     // playerSetField method for player 1 
            playerSetField(p2, choice);                                                                     // playerSetField method for player 2 
            turnLoop(p1, p2, choice);                                                                       // turnLoop method for player 1 and player 2 to take turns and evaluate winner
        }
        else {                                                                                              // else player 2 goes first
            System.out.println(p2.getName() + " goes first!");                                              // Display player 2 goes first
            playerSetField(p2, choice);                                                                     // playerSetField method for player 2 
            playerSetField(p1, choice);                                                                     // playerSetField method for player 1
            turnLoop(p2, p1, choice);                                                                       // turnLoop method for player 2 and player 1 to take turns and evaluate winner
        }
    }

    private Player setPlayer(Scanner choice, int num) {                                                     // setPlayer method that sets the player's name and deck
        System.out.println("Player " + num + " Enter your name: ");                                         // Player is asked to enter their name
        String name = choice.nextLine();                                                                    // String name is the input from player
        Deck deck = new Deck();                                                                             // Deck generated for player
        return new Player(name, deck);                                                                      // Return new Player with name and deck
    }

    private void playerSetField(Player player, Scanner choice) {                                            // playerSetField method that sets the player's activePokemon and bench
        activeSetup(player, choice);                                                                        // activeSetup method for player to set activePokemon
        benchSetup(player, choice);                                                                         // benchSetup method for player to set bench 
        System.out.println("\n[ " + player.getName() + " ] has set their field \n");                        // Display player has set their field
    }

    private void activeSetup(Player player, Scanner choice) {                                                                                                                                                      // activeSetup method that sets the player's activePokemon
        System.out.println(player.getName() + " choose your Active Pokemon by entering its assigned number: \n");                                                                                                  // Informs player to choose active Pokemon
        player.displayHand();                                                                                                                                                                                      // Display the player's hand, adjusted to 1 based index in displayHand method
        System.out.println();
        int activePoke = choice.nextInt() - 1;                                                                                                                                                                     // int activePoke is input from player - 1, due to ArrayList being 0 based index
        while (activePoke < 0 || activePoke >= player.checkHandSize() || !(player.getCardFromHand(activePoke) instanceof PokemonCard) || (((PokemonCard) player.getCardFromHand(activePoke)).getIfEvolved())) {    // while outside hand range or not a basic Pokemon card type                                                             
            System.out.println("Choose a basic Pokemon card within your hand size: ");                                                                                                                           // Inform player to choose a Pokemon within their hand 
            activePoke = choice.nextInt() - 1;                                                                                                                                                                     // Take activePoke input again
        }
        PokemonCard activeCard = (PokemonCard) player.getCardFromHand(activePoke);                                                                                                                                 // PokemonCard activeCard is the input from player casted as PokemonCard to be the activePokemon
        player.setActive(activeCard);                                                                                                                                                                              // player's addActivePokemonSetUp method to set active Pokemon as the inputted card
        player.removeCardHand(activeCard); 
    }

    private void benchSetup(Player player, Scanner choice) {                                                                                                                                                       // benchSetup method that sets the player's bench Pokemon
        System.out.println( player.getName() + " choose up to 5 bench Pokemon by entering the card's number or 0 to stop adding to bench: \n");                                                                    // Player is asked to choose up to 5 bench Pokemon or enter 0 to stop adding to bench
        player.displayHand();                                                                                                                                                                                      // Display the player's hand
        System.out.println();
        int benchPoke = choice.nextInt() - 1;                                                                                                                                                                      // int benchPoke is input from player
        if (exitInput(benchPoke)) {                                                                                                                                                                                // exit input to stop bench setup before adding any bench Pokemon
            return;                                                                                                                                                                                                // Return to stop bench setup 
        }
        while (benchPoke < 0 || benchPoke >= player.checkHandSize() || !(player.getCardFromHand(benchPoke) instanceof PokemonCard) || (((PokemonCard) player.getCardFromHand(benchPoke)).getIfEvolved())) {        // while loop outside hand range or not a basic Pokemon card type
            System.out.println("Choose a Pokemon card within your hand size: ");                                                                                                                                 // Informs player to choose a card within their hand
            player.displayHand();                                                                                                                                                                                  // Display the player's hand
            benchPoke = choice.nextInt() - 1;                                                                                                                                                                      // Take benchPoke input again
            if (exitInput(benchPoke)) {                                                                                                 // exit input to stop bench setup during bench reselection
                break;                                                                                                                  // break 
            }
        }
        PokemonCard benchCard = (PokemonCard) player.getCardFromHand(benchPoke);                                                        // PokemonCard benchCard is the input from player casted as PokemonCard to be added to bench
        player.addBench(benchCard);                                                                                                     // player's addBench method used with benchCard PokemonCard choice, to add bench Pokemon as the inputted card
        if (player.checkBenchCapacity() < 5) {                                                                                          // if player's bench capacity is less than 5
            System.out.println("Add another bench Pokemon or enter 0 to stop adding to bench: ");                                     // Informs player to add another bench Pokemon or enter 0 to stop adding to bench
            benchSetup(player, choice);                                                                                                 // benchSetup method to add up to 5 bench Pokemon
        }
    }

    private void takeTurn(Player p1, Player p2, Scanner turn) {                                                                         // takeTurn method that allows the players to take their turn
        boolean checkDraw = false;                                                                                                      // boolean checkDraw is false until player 1 draws a card in which it doesnt allow them to draw again
        boolean checkEnergy = false;                                                                                                    // boolean checkEnergy is false until the player attaches an energy card to their activePokemon in which it doesnt allow them to attach again
        boolean checkRetreat = false;                                                                                                   // boolean checkRetreat is false until the player swaps/retreats their activePokemon in which it doesnt allow them to swap/retreat again
        boolean checkAttack = false;                                                                                                    // boolean checkAttack is false until the player attacks with their activePokemon in which it doesnt allow them to attack again
        boolean turnOver = false;                                                                                                       // boolean turnOver is false until the player ends their turn by selecting the end turn option or attacking

        while (!turnOver) {                                                                                                             // while turnOver boolean is false
            displayField(p1, p2);                                                                                                       // Calls displayField method to display game field 
            int optionSelected = turn.nextInt();                                                                                        // int optionSelected is input from the player 1
            switch (optionSelected) {                                                                                                   // switch case for the optionSelected input from player 1
                case 1:                                                                                                                 // Case 1 for drawing a card
                    if (!checkDraw) {                                                                                                   // if checkDraw is false
                        p1.drawCard(1);                                                                                           // player 1 uses drawCard method to draw 1 card for hand
                        checkDraw = true;                                                                                               // checkDraw is set to true
                    }   
                    else {                                                                                                              // else
                        System.out.println("You can draw only once a turn, Choose another turn option: ");                            // Informs player 1 they can only draw once per turn 
                    }
                    break;                                                                                                              // break 
                case 2:                                                                                                                 // Case 2 for playing a Trainer card
                    p1.displayHand();                                                                                                   // display player 1's hand
                    System.out.println("Choose a Trainer card to play or enter 0 to exit option: \n");                                // Informs player 1 to choose Trainer to play or enter 0 to exit option
                    int trainerCard = turn.nextInt() - 1;                                                                               // trainerCard is input from player 
                    playTrainerTurn(turn, p1, trainerCard);                                                                             // playTrainerTurn method to play the Trainer 
                    break;                                                                                                              // break

                case 3:                                                                                                                 // Case 3 for playing an Energy card
                    if (!checkEnergy) {                                                                                                 // if checkEnergy is false
                        p1.displayHand();                                                                                               // display player 1's hand
                        System.out.println("Choose an Energy card to attach to the Active Pokemon or 0 to exit option: \n");          // Informs player 1 to choose an Energy to attach to activePokemon or enter 0 to exit option
                        int energyCard = turn.nextInt() - 1;                                                                            // energyCard is input from player
                        checkEnergy = playEnergyTurn(turn, p1, energyCard);                                                             // playEnergyTurn method to play the Energy and checkenergy boolean is true if Energy is attached
                    }
                    else {                                                                                                              // else
                        System.out.println("You can only attach one energy card per turn, Choose another turn option: \n");           // Informs player 1 they can only attach one Energy per turn
                    }       
                    break;                                                                                                              // break

                case 4:                                                                                                                 // Case 4 for playing a Pokemon card on bench or as activePokemon
                    p1.displayHand();                                                                                                   // display player 1's hand
                    System.out.println("Choose a Pokemon card to play or enter 0 to exit option: \n");                                // Informs player 1 to choose a Pokemon to play or enter 0 to exit option
                    int pokemonCard = turn.nextInt() - 1;                                                                               // gets the Pokemon choice from player
                    playPokemonTurn(turn, p1, pokemonCard);                                                                             // playPokemonTurn method to play the Pokemon
                    break;                                                                                                              // break

                case 5:                                                                                                                             // Case 5 for swapping/retreating active Pokemon with bench Pokemon
                    if (!checkRetreat) {                                                                                                            // if checkRetreat is false
                        System.out.println("Active: ");                                                                                           // Print activePokemon
                        p1.displayActive();                                                                                                         // Display player 1's activePokemon
                        System.out.println(" [HP]: " + p1.getActive().getHp());                                                                     // Display activePokemon hp
                        System.out.println("Choose a Pokemon card to Swap/Retreat with the Active Pokemon or enter 0 to exit option: ");          // Informs player 1 to choose a Pokemon card to Swap/Retreat with the activePokemon or enter 0 to exit option
                        System.out.println("Minimum of 1 Energy required to Swap/Retreat: ");                                                     // Informs player 1 that atleast 1 Energy is needed to Swap/Retreat
                        p1.displayBench();                                                                                                          // Display player 1's bench
                        System.out.println("\n");                                                                                           
                        int benchPokemon = turn.nextInt() - 1;                                                                                      // gets the bench Pokemon choice from player
                        checkRetreat = playSwapRetreatTurn(turn, p1, benchPokemon);                                                                 // playRetreatTurn method to Swap/Retreat the activePokemon with a benchPokemon and checkRetreat boolean is true if swap/retreat occurs
                    } 
                    else {                                                                                                                          // else
                        System.out.println("You can only Swap/Retreat once per turn, Choose another turn option: ");                              // Informs player 1 they can Swap/Retreat only once per turn
                    }
                    break;                                                                                                                          // break

                case 6:                                                                                                                             // Case 6 for attacking with active Pokemon
                    if (!checkAttack && checkDraw && p1.getActive() != null && p2.getActive() != null) {                                            // if checkAttack is false, checkDraw is true, and both players' activePokemon are not empty
                        System.out.println("Active Pokemon: ");                                                                                   // Print Active Pokemon
                        p1.displayActive();                                                                                                         // Display player 1's activePokemon
                        System.out.println("Choose the Active Pokemon attack (1 for Normal Attack & 2 for Special Move) or 0 to exit option: ");  // Informs player 1 to choose the activePokemon attack option or enter 0 to exit option
                        System.out.println("Normal attack costs 1 and the Special Move costs 2 Energy: ");                                        // Informs player 1 of the energy cost for each attack
                        System.out.println("If Active Pokemon is evolved, the energy cost is one more for each attack: ");                        // Informs player 1 that if activePokemon is evolved, the energy cost is one more for each attack
                        System.out.println("1. " + p1.getActive().getNormalAttack() + " [DMG]: " + p1.getActive().getNormalAttackDamage());         // Display activePokemon normal attack and damage
                        System.out.println("2. " + p1.getActive().getSpecialMove() + " [DMG]: " + p1.getActive().getSpecialMoveDamage());           // Display activePokemon special move and damage
                        int attackType = turn.nextInt();                                                                                            // attackType is input from player 1
                        checkAttack = playAttackTurn(turn, attackType, p1, p2);                                                                     // playAttackTurn method to attack with the activePokemon and checkAttack boolean is true if attack occurs
                        turnOver = checkAttack;                                                                                                     // turnOver is set to checkAttack boolean, if attack occurs turn is over
                    }
                    else {
                        System.out.println("You must draw once before attacking and Active must be filled: ");                                    // Informs player 1 they must draw once before attacking
                    } 
                    break;                                                                                                                          // break

                case 7:                                                                                                                             // Case 7 for evolving Pokemon
                    System.out.println("Choose Active Pokemon or bench to evolve, 1 and 2 respectively, or enter 0 to exit option: ");            // Informs player to choose activePokemon or bench to evolve Pokemon or enter 0 to exit option
                    int choice = turn.nextInt();                                                                                                    // choice is input from player 1
                    if (choice == 1) {                                                                                                              // if choice is 1
                        playEvolveActiveTurn(turn, p1);                                                                                             // playEvolveActiveTurn method to evolve activePokemon
                    }
                    else if (choice == 2) {                                                                                                         // else if choice is 2
                        playEvolveBenchTurn(turn, p1);                                                                                              // playEvolveBenchTurn method to evolve Pokemon from bench
                    }
                    else {                                                                                                                          // else
                        System.out.println("Enter 1 or 2 to evolve Pokemon or 0 to exit: ");                                                     // Informs player 1 to enter 1 or 2 to evolve Pokemon or enter 0 to exit
                    }
                    break;                                                                                                                          // break

                case 8:                                                                                                                             // Case 8 for ending the turn
                    if (checkDraw) {                                                                                                                // if checkDraw is true, player must have drawn a card during turn
                        System.out.println(p1.getName() + " Ended their Turn");                                                                     // Informs players that player 1 ended the turn
                        turnOver = true;                                                                                                            // turnOver is true
                        break;                                                                                                                      // break
                    }
                    else {                                                                                                                          // else
                        System.out.println("Draw a Card before ending the turn: ");                                                               // Informs player 1 to draw a card before ending turn
                    }
                    break;                                                                                                                          // break

                default:                                                                                                                            // default Case for incorrect input
                    System.out.println("Choose one of the assigned turn options: ");                                                              // Inform player 1 to select one of the assigned turn options
            }
            System.out.println("---------^-------------------------------------------^----------");                                               // Display turn results divider
            System.out.println("---------|---------- T U R N  R E S U L T S ---------|----------");
            System.out.println("---------|-------------------------------------------|----------");
        }
    }

    private void displayField(Player p1, Player p2) {                                                                                               // displayField method that displays the game field for both players
            System.out.println("\n--------------------------------------------------------------------");
            System.out.println("Opponent's Bench: ");                                                                           
            p2.displayBench();                                                                                                                      // Display player 2's bench
            System.out.println("\n");
            System.out.println("Deck Cards: " + p2.getDeckSize() + " -- Discard Pile: " + p2.getDiscardSize());                                     // Display player 2's deck size and discard pile size 
            System.out.println("Opponent's Active Pokemon: \n");
            p2.displayActive();                                                                                                                     // Display player 2's active Pokemon
            System.out.print(" [ HP ]: " + p2.getActive().getHp());                                                                                 // Display player 2's active Pokemon HP
            System.out.println("\n--------------------------------------------------------------------");
            System.out.println("\nPrize Pile Differnce: " + p1.getName() + " [" + p1.countPrizePile() + "] " + " --  " + p2.getName() + " [" + p2.countPrizePile() + "] \n");  //Prize Pile status between players
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Active Pokemon: \n");   
            p1.displayActive();                                                                                                     // Display player 1's active Pokemon
            System.out.print(" [ HP ]: " + p1.getActive().getHp());                                                                 // Display player 1's active Pokemon HP
            System.out.println("  Energy Available: " + p1.activeEnergyCounter() + "\n");                                           // Display player 1's active Pokemon Energy count
            System.out.println("Bench: ");
            p1.displayBench();                                                                                                      // Display player 1's bench
            System.out.println("\n");                                                                           
            System.out.println("Deck Cards: " + p1.getDeckSize() + " -- Discard Pile: " + p1.getDiscardSize());                     // Display player 1's deck size and discard pile size                                                                                                   
            System.out.println("--------------------------------------------------------------------");
            System.out.println(p1.getName() + "'s turn \n");                                                                        // Display player 1's turn
            System.out.println("Hand: ");
            p1.displayHand();                                                                                                       // Display player 1's hand
            System.out.println("\n");

            System.out.println("Select One Of The Turn Options: ");                                                               // Display player 1's turn options (Cases)
            System.out.println("1. Draw A Card");                                                                                 // Case 1: Draw a card
            System.out.println("2. Play A Trainer Card");                                                                         // Case 2: Play a Trainer card
            System.out.println("3. Play An Energy Card");                                                                         // Case 3: Play an Energy card
            System.out.println("4. Play A Pokemon Card From Hand");                                                               // Case 4: Play a Pokemon card from hand
            System.out.println("5. Swap/Retreat Active to Bench");                                                                // Case 5: Swap/Retreat active Pokemon with bench Pokemon
            System.out.println("6. Attack With Active Pokemon");                                                                  // Case 6: Attack with active Pokemon
            System.out.println("7. Evolve Pokemon");                                                                              // Case 7: Evolve Pokemon             
            System.out.println("8. End Turn");                                                                                    // Case 8: End turn
    }

    private boolean exitInput(int exit) {                                                                                           // boolean method used in the turn options to let the player to exit turn option
        return exit == -1;                                                                                                          // Return true if player input is -1
    }

    private void playTrainerTurn(Scanner turn, Player player, int trainerCard) {                                                                         // playTrainerTurn method lets player to play a Trainer card 
        if (exitInput(trainerCard)) {                                                                                                                    // if exitInput is true, player can exit before choosing Trainer 
            return;                                                                                                                                      // Return 
        }
        while (trainerCard < 0 || trainerCard >= player.checkHandSize() || !(player.getCardFromHand(trainerCard) instanceof TrainerCard)) {              // if trainerCard is outside hand range or not a Trainer card type
            System.out.println("Choose Trainer card within your hand size or enter 0 to exit option: ");                                               // Informs player to choose a Trainer within their hand or enter 0 to exit 
            player.displayHand();                                                                                                                        // Display player's hand
            System.out.println();
            System.out.println("\n");                                                                                                                  // Informs player to choose a Trainer to play or enter 0 to exit 
            trainerCard = turn.nextInt() - 1;                                                                                                            // Trainer choice is input from player
            if (exitInput(trainerCard)) {                                                                                                                // if exitInput is true, player can exit during Trainer selection
                System.out.println("Exitng Trainer turn option...");                                                                                   // Informs player they are exiting Trainer turn option
                break;                                                                                                                                   // break 
            }
        }
        TrainerCard activatedTrainer = (TrainerCard) player.getCardFromHand(trainerCard);                                                                // TrainerCard activatedTrainer is created from trainerCard casted as TrainerCard
        activatedTrainer.activateTrainer(player);                                                                                                        // activatedTrainer uses activateTrainer method
    }

    private boolean playEnergyTurn(Scanner turn, Player player, int energyCard) {                                                                        // playEnergyTurn method lets player to attach an Energy 
        if (exitInput(energyCard)) {                                                                                                                     // if exitInput is true, player can exit before choosing Energy 
            return false;                                                                                                                                // Return false to exit in takeTurn method, player has not attached Energy
        }
        while (energyCard < 0 || energyCard >= player.checkHandSize() || !(player.getCardFromHand(energyCard) instanceof EnergyCard) || !((EnergyCard) player.getCardFromHand(energyCard)).getType().equals(player.getActive().getType())) {      // if energyCard is outside hand range or not an Energy card that matches activePokemon type
            System.out.println("Choose an matching Energy card to attach to Active Pokemon or 0 to exit option: ");                                                                                                                             // Informs player to choose a matching Energy to attach to activePokemon or enter 0 to exit 
            player.displayHand();                                                                                                                                                                                                                 // Display player's hand
            System.out.println();
            energyCard = turn.nextInt() - 1;                                                                                                             // Energy choice is input from player
            if (exitInput(energyCard)) {                                                                                                                 // if exitInput is true, player can exit during Energy selection
                System.out.println("Exitng Energy turn option...");                                                                                    // Informs player they are exiting Energy turn option
                return false;                                                                                                                            // Return false to exit in takeTurn method, player has not attached Energy
            }
        }
        EnergyCard attachedEnergy = (EnergyCard) player.getCardFromHand(energyCard);                                                                     // EnergyCard attachedEnergy is created from energyCard casted as EnergyCard
        attachedEnergy.attachEnergy(player);                                                                                                             // attachedEnergy uses attachEnergy method to be added to player's activePokemonEnergy
        System.out.println(" Energy Count: " + player.activeEnergyCounter());                                                                            // Display player's activePokemonEnergy count
        System.out.println("Type Superior to: " + attachedEnergy.getSuperiortyOver());                                                                   // Display attachedEnergy type superiority over
        return true;                                                                                                                                     // Return true in takeTurn method, player has attached Energy
    }

    private void playPokemonTurn(Scanner turn, Player player, int pokemonCard) {                                                                         // playPokemonTurn method lets player to play Pokemon 
        if (exitInput(pokemonCard)) {                                                                                                                    // if exitInput is true, player can exit before choosing Pokemon 
            return;                                                                                                                                      // Return 
        }
        while (pokemonCard < 0 || pokemonCard >= player.checkHandSize() || !(player.getCardFromHand(pokemonCard) instanceof PokemonCard) || ((PokemonCard) player.getCardFromHand(pokemonCard)).getIfEvolved()) {                                // if pokemonCard is outside hand range or not a basic Pokemon card
            System.out.println("Choose a basic Pokemon card within your hand size or enter 0 to exit option: ");                                                                                                                               // Informs player to choose a basic Pokemon within their hand size or enter 0 to exit 
            player.displayHand();                                                                                                                                                                                                                // Display player's hand
            System.out.println();
            pokemonCard = turn.nextInt() - 1;                                                                                                            // Pokemon choice is input from player
            if (exitInput(pokemonCard)) {                                                                                                                // if exitInput is true, player can exit during Pokemon selection
                System.out.println("Exiting Pokemon turn option...");                                                                                  // Informs player they are exiting Pokemon turn option
                break;                                                                                                                                   // break
            }
        }
        PokemonCard playedCard = (PokemonCard) player.getCardFromHand(pokemonCard);                                                                      // PokemonCard playedCard is created from pokemonCard casted as PokemonCard
        System.out.println("Enter 1 to place Pokemon card on bench and 2 to for Active Pokemon, or enter 0 to exit option: ");                         // Informs player to enter 1 to place Pokemon on bench and 2 for activePokemon, or enter 0 to exit 
        int option = turn.nextInt();                                                                                                                     // option is input from player
        placeOption(turn, player, playedCard, option);                                                                                                   // placeOption method to place Pokemon on bench or as activePokemon, based on int option
    }

    private void placeOption(Scanner turn, Player player, PokemonCard card, int option) {                                                                // placeOption method lets player to place Pokemon on bench or as activePokemon
        option = turn.nextInt();                                                                                                                         // option is input from player
        switch (option) {                                                                                                                                // switch case for option 
            case 1:                                                                                                                                      // Case 1 for placing Pokemon on bench
                player.addBench(card);                                                                                                                   // player's addBench method to add Pokemon
                break;                                                                                                                                   // break

            case 2:                                                                                                                                      // Case 2 for placing Pokemon as activePokemon
                if (player.getActive() == null) {                                                                                                        // if player's activePokemon is null
                    player.setActive(card);                                                                                                              // player's setActive method to set activePokemon as the card
                }                           
                else {                                                                                                                                   // else
                    System.out.println("Active Pokemon slot is taken, use the Swap/Retreat option to switch Active Pokemon with bench: ");             // Informs player that activePokemon slot is taken and to use Swap/Retreat option to swap activePokemon with bench 
                    break;                                                                                                                               // break
                }
                break;                                                                                                                                   // break

            default:                                                                                                                                     // default case for incorrect input
                System.out.println("Enter 1 or 2 to place Pokemon card on bench and as Active Pokemon, or enter 0 to exit option: ");                  // Informs player to enter 1 or 2 to place Pokemon in bench or as activePokemon or enter 0 to exit 
        }
    }

    private boolean playSwapRetreatTurn(Scanner turn, Player player, int benchPokemon) {                                                                 // playSwapRetreatTurn method lets player to Swap/Retreat activePokemon with bench 
        if (exitInput(benchPokemon)) {                                                                                                                   // if exitInput is true, player can exit before choosing bench Pokemon
            return false;                                                                                                                                // Return false to exit in takeTurn method, player has not Swap/Retreated Pokemon
        }
        while (benchPokemon < 0 || benchPokemon >= player.checkBenchCapacity() || !(player.getCardFromBench(benchPokemon) instanceof PokemonCard)) {     // if benchPokemon is outside bench range or not a Pokemon card 
            System.out.println("Choose a Pokemon card to Swap/Retreat with the Active Pokemon or enter 0 to exit option: ");                           // Informs player to choose a Pokemon within their bench or enter 0 to exit 
            player.displayBench();                                                                                                                       // Display player's bench
            System.out.println();
            benchPokemon = turn.nextInt() - 1;                                                                                                           // benchPokemon is input from player
            if (exitInput(benchPokemon)) {                                                                                                               // if exitInput is true, player can exit during Swap/Retreat bench selection
                System.out.println("Exiting Swap/Retreat turn option...");                                                                             // Informs player they are exiting Swap/Retreat turn option
                return false;                                                                                                                            // Return false to exit in takeTurn method, player has not Swap/Retreated Pokemon
            }
        }
        PokemonCard swappedCard = (PokemonCard) player.getCardFromBench(benchPokemon);                                                                   // PokemonCard swappedCard is created from benchPokemon casted as PokemonCard
        player.swapActivePokemon(swappedCard);                                                                                                           // player's swapActivePokemon method to switch activePokemon
        return true;                                                                                                                                     // Return true in takeTurn method, player has Swap/Retreated Pokemon
    }

    private boolean playAttackTurn(Scanner turn, int attackType, Player player1, Player player2) {                                                       // playAttackTurn method lets player to attack with activePokemon
        if (attackType == 0) {                                                                                                                           // if attackType is 0
            return false;                                                                                                                                // Return false to exit in takeTurn method, player has not attacked because they ended option before selection
        }
        while (attackType != 1 && attackType != 2) {                                                                                                     // while attackType is not 1 or 2
            System.out.println("Enter 1 or 2 to attack with the Active Pokemon or enter 0 to exit option: ");                                          // Informs player to enter 1 or 2 to attack with activePokemon or enter 0 to exit 
            attackType = turn.nextInt();                                                                                                                 // attackType is input from player
            if (attackType == 0) {                                                                                                                       // if attackType is 0
                return false;                                                                                                                            // Return false to exit in takeTurn method, player has not attacked because they ended option during selection
            }
        }   
        if (player1.activePokemonAttack(attackType, player1, player2)) {                                                                                                // if player1 activePokemon attack is true/successful 
            System.out.println(player2.getName() + " Active Pokemon [ HP ]: " + player2.getActive().getHp() + " - Energy Left: " + player2.activeEnergyCounter());      // Display player 2's activePokemon HP and Energy count
            System.out.println(player1.getName() + " Active Pokemon [ HP ]: " + player1.getActive().getHp() + " - Energy Left: " + player1.activeEnergyCounter());      // Display player 1's activePokemon HP and Energy count
            System.out.println(player1.getName() + "'s turn is over");                                                                                                  // Display player 1's turn is over  
            if (player2.getActive().pokemonDefeated()) {                                                                                                                // if player2 activePokemon is defeated, using pokemonDefeated method from PokemonCard class
                player1.fillActiveWhenDefeated(player1, player2);                                                                                                       // fillActiveWhenDefeated method for player 2 to fill activePokemon if its defeated after the attack
            }
            return true;                                                                                                                                                // Return true in takeTurn method, player has attacked
        }                                                                
        else {                                                                                                                                                          // else
            return false;                                                                                                                                               // Return false in takeTurn method, player has not attacked
        }                                  
    }

    private void playEvolveActiveTurn(Scanner turn, Player player) {                                                                                     // playEvolveActiveTurn method lets player to evolve activePokemon
        System.out.println("Active Pokemon: ");                                                                                                        // Print activePokemon
        player.displayActive();                                                                                                                          // Display player's activePokemon
        System.out.println("Choose a Pokemon card from hand to evolve the active Pokemon or enter 0 to exit option: ");                                // Informs player to choose a Pokemon from hand to evolve activePokemon or enter 0 to exit 
        player.displayHand();                                                                                                                            // Display player's hand
        int evolvedCard = turn.nextInt() - 1;                                                                                                            // evolvedCard is input from player
        if (exitInput(evolvedCard)) {                                                                                                                    // if exitInput is true, player can exit before evolved Pokemon selection
            return;                                                                                                                                      // Return
        }
        while (evolvedCard < 0 || evolvedCard >= player.checkHandSize() || !(player.getCardFromHand(evolvedCard) instanceof PokemonCard) || !((PokemonCard) player.getCardFromHand(evolvedCard)).getCardName().equals(player.getActive().getEvolvesTo())) {    // if evolvedCard is outside hand range or not a Pokemon card of same Pokemon line
            System.out.println("Choose a Pokemon card within your hand size that has same evolutionary line or enter 0 to exit option: ");                                                                                                                   // Informs player to choose a Pokemon within their hand or enter 0 to exit
            player.displayHand();                                                                                                                                                                                                                              // Display player's hand
            System.out.println();
            evolvedCard = turn.nextInt() - 1;                                                                                                            // evolvedCard is input from player
            if (exitInput(evolvedCard)) {                                                                                                                // if exitInput is true, player can exit during evolved Pokemon selection
                System.out.println("Exiting Evolve turn option...");                                                                                   // Informs player they are exiting Evolve turn option
                break;                                                                                                                                   // break
            }
        }
        PokemonCard evolvedPokemon = (PokemonCard) player.getCardFromHand(evolvedCard);                                                                  // PokemonCard evolvedPokemon is created from evolvedCard casted as PokemonCard
        player.getActive().evolver(player, evolvedPokemon, 1);                                                                                    // player's activePokemon uses evolver method to evolve into evolvedPokemon
        System.out.println("Active has evolved into: ");                                                                                               // Informs player that activePokemon has evolved
        player.displayActive();
    }

    private void playEvolveBenchTurn(Scanner turn, Player player) {                                                                                      // playEvolveBenchTurn method lets player to evolve Pokemon from bench
        System.out.println("Bench: ");                                                                                                                 // Print bench
        player.displayBench();                                                                                                                           // Display player's bench
        System.out.println("Choose a Pokemon card to evolve from bench or enter 0 to exit option: ");                                                  // Informs player to choose a Pokemon to evolve from bench or enter 0 to exit 
        int benchPokemon = turn.nextInt() - 1;                                                                                                           // benchPokemon is input from player
        if (exitInput(benchPokemon)) {                                                                                                                   // if exitInput is true, player can exit before bench Pokemon selection
            return;                                                                                                                                      // Return 
        }
        while (benchPokemon < 0 || benchPokemon >= player.checkBenchCapacity()) {
            System.out.println("Choose a Pokemon card to evolve within your bench size or enter 0 to exit option: ");                                  // Informs player to choose a Pokemon within their bench or enter 0 to exit
            player.displayBench();                                                                                                                       // Display player's bench
            System.out.println();
            benchPokemon = turn.nextInt() - 1;                                                                                                           // benchPokemon is input from player
            if (exitInput(benchPokemon)) {                                                                                                               // if exitInput is true, player can exit during bench Pokemon selection
                System.out.println("Exiting Evolve turn option...");                                                                                   // Informs player they are exiting Evolve turn option
                break;                                                                                                                                   // break
            }
        }
        PokemonCard benchedPokemon = (PokemonCard) player.getCardFromBench(benchPokemon);                                                                // PokemonCard benchedPokemon is created from benchPokemon casted as PokemonCard
        System.out.println("Choose a Pokemon card from hand to evolve bench Pokemon with, or enter 0 to exit option: ");                               // Informs player to choose a Pokemon from hand to evolve benchPokemon with or enter 0 to exit 
        player.displayHand();                                                                                                                            // Display player's hand
        int evolvedCard = turn.nextInt() - 1;                                                                                                            // evolvedCard is input from player
        if (exitInput(evolvedCard)) {                                                                                                                    // if exitInput is true, player can exit before choosing the evolved Pokemon
            return;                                                                                                                                      // Return to exit
        }
        while (evolvedCard < 0 || evolvedCard >= player.checkHandSize() || !(player.getCardFromHand(evolvedCard) instanceof PokemonCard) || !((PokemonCard) player.getCardFromHand(evolvedCard)).getCardName().equals(benchedPokemon.getEvolvesTo())) {    // if evolvedCard is outside hand range or not a Pokemon card with same Pokemon evolution line
            System.out.println("Choose a Pokemon card within your hand size with same evolution line or enter 0 to exit option: ");                                                                                                                      // Informs player to choose a Pokemon within their hand or enter 0 to exit
            player.displayHand();                                                                                                                                                                                                                          // Display player's hand
            System.out.println();
            evolvedCard = turn.nextInt() - 1;                                                                                                            // evolvedCard is input from player
            if (exitInput(evolvedCard)) {                                                                                                                // if exitInput is true, player can exit during evolved Pokemon selection
                System.out.println("Exiting Evolve turn option...");                                                                                   // Informs player they are exiting Evolve turn option
                break;                                                                                                                                   // break
            }
        }
        PokemonCard evolvedPokemon = (PokemonCard) player.getCardFromHand(evolvedCard);                                                                  // PokemonCard evolvedPokemon is created from evolvedCard casted as PokemonCard
        benchedPokemon.evolver(player, evolvedPokemon, 2);                                                                                        // benchedPokemon uses evolver method to evolve into evolvedPokemon
    }
    
    private void turnLoop(Player p1, Player p2, Scanner turn) {                                                                                          // turnLoop method alternates players' turns checking for winner after the turns end
        boolean endGame = false;                                                                                                                         // boolean endGame is false 
        while (!endGame) {                                                                                                                               // while endGame is false
            takeTurn(p1, p2, turn);                                                                                                                      // player 1 takes their turn
            if (p1.evaluateWinner(p2) == true) {                                                                                                         // evaluates if player 1 has won, considering the 3 win conditions
                System.out.println(p1.getName() + " Won The Pokemon Battle!");                                                                           // Display player 1 has won the battle
                System.out.println("G A M E  O V E R ");                                                                                               
                System.out.println("Pokemon Card Game Shutting Down...\n");                               
                System.out.println("Thanks for playing Pokemon Card Game!\n");        
                endGame = true;                                                                                                                          // endGame is now true
                break;                                                                                                                                   // break
            }
            else {                                                                                                                                       // else
                takeTurn(p2, p1, turn);                                                                                                                  // player 2 takes their turn
                if (p2.evaluateWinner(p1) == true) {                                                                                                     // evaluates if player 2 has won, considering the 3 win conditions
                    System.out.println(p2.getName() + " Won The Pokemon Battle!");                                                                       // Display player 2 has won the battle
                    System.out.println("G A M E  O V E R ");                                                                                               
                    System.out.println("Pokemon Card Game Shutting Down...\n");                               
                    System.out.println("Thanks for playing Pokemon Card Game!\n");        
                    endGame = true;                                                                                                                      // endGame is now true
                    break;                                                                                                                               // break
                }
            }
        }
    }
}