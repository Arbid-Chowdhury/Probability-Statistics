package DoorChoice;

import java.util.Random;

public class Doors {
    private Random rand = new Random();                    // Random number object
    private double winpercentage;                          // Intializes Win percentage for the game

    public void playGame(int trials) {                     // Method for the No Switching door game with int trials
        int wins = 0;                                      // wins set to 0
        for (int i = 0; i < trials; i++) {                 // loops through the trials
            int doorChoice = rand.nextInt(3) + 1;    // Randomly chooses a door as the doorChoice (1-3)
            int moneyDoor = rand.nextInt(3) + 1;     // Randomly sets a door as the moneyDoor (1-3)
            if (doorChoice == moneyDoor) {                 // If the doorChoice is the moneyDoor
               wins++;                                     // win count increases
            } 
        }
        winpercentage = (double) wins/trials * 100;                                         // Calculates the win percentage by dividing wins by trials multiplied by 100 for a percentage, casting as double
        System.out.println("Win Percentage for Same Door Choice: " + winpercentage + "%");  // Prints the win percentage for the No Switch Door game
    }
    
    public void playGameSwitch(int trials) {                                                // Method for the Switching door game with int trials
        int wins = 0;                                                                       // wins set to 0
        for (int i = 0; i < trials; i++) {                                                  // loops through the trials parameter
            int doorChoice = rand.nextInt(3) + 1;                                     // Randomly chooses a door as the doorChoice (1-3)
            int moneyDoor = rand.nextInt(3) + 1;                                      // Randomly sets a door as the moneyDoor (1-3)
            int exposedDoor = rand.nextInt(3) + 1;                                    // Randomly sets a door as the exposed door (1-3) which will lead to the door choice switch
            while (exposedDoor == doorChoice || exposedDoor == moneyDoor) {                 // While the exposedDoor is not the moneyDoor or the doorChoice
                exposedDoor = rand.nextInt(3) + 1;                                    // Randomly sets a door as the exposedDoor (1-3)
            }
            int switchNewDoor = rand.nextInt(3) + 1;                                  // Initializes the switchNewDoor after the switch
            while (switchNewDoor == exposedDoor || switchNewDoor == doorChoice) {           // While the switchNewDoor is the exposedDoor or the doorChoice
                switchNewDoor = rand.nextInt(3) + 1;                                  // Randomly sets a door as the new doorChoice (1-3)
            }
            if (switchNewDoor == moneyDoor) {                                               // If switchNewDoor is moneyDoor
                wins++;                                                                     // win count increases
            }
        }
        winpercentage = (double) wins/trials * 100;                                           // Calculates the win percentage by dividing wins by trials multiplied by 100 for a percentage, casting as double
        System.out.println("Win Percentage for Random Door Choice: " + winpercentage + "%");  // Prints the win percentage for the Switch Door game
    }

    /* 
    Question A:
    For the random door choice game the player has a win percentage of 33.3% when not swicthing their door choice, due to each door having same chance of being picked (the sample space is {D1}, {D2}, {PD} which means the outcomes all have 1/3 chance of being picked by the player in no switch game version).

    Question B:
    i. If the player sticks with their first choice G, the win probability remains 1/3 regardless of the revealed door from the host
    ii. If the player selected door G then the chances will be 1/3, after the door reveal the switch to the other door will increase the chances to 2/3 of losing the game.
    iii. If the player selected the empty door and the host revealed another empty door, then swicthing would guarantee the player to win the game.
    iv. Depending on intial door choice, if G is intial and the player switches the door then its 2/3 of losing the game. If one of empty doors is intial choice, then player switching door causing a win is likely. Essentially, the player has a 2/3 chance of winning the game if they switch doors.
    v. Considering the sample space, 3 doors means the intial choice has 1/3 chance of success so switching door choice will have 2/3 chance of winning the game. Switching doors would be the better strategy to win the game and is supported by the GameTest.java output. 
    */
}

    
