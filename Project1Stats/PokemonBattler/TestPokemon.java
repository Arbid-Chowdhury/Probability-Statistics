package PokemonBattler;

public class TestPokemon {
    public static void main(String[] args) {
        Charmander BigChar = new Charmander();       // creates a new Charmander BigChar  
        Pikachu BigPika = new Pikachu();             // creates a new Pikachu BigPika     
        Stadium tester = new Stadium();              // creates a new Stadium tester
        tester.battle(BigPika, BigChar);             // Intiates Stadium class method battle using BigPika and BigChar as the p1 & p2 parameters
    }
}