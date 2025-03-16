package DoorChoice;

public class Gametest {
    public static void main(String[] args) {
        Doors game = new Doors();               // Creates a new Doors game object
        game.playGame(10000);            // Plays the No Switch Door game for 10,000 trials
        game.playGameSwitch(10000);      // Plays the Switch Door game for 10,000 trials
    }
}