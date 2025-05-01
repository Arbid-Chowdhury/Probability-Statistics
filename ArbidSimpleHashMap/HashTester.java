package ArbidSimpleHashMap;

public class HashTester {
    
    public static void main(String[] args) {
        
        Hashing hashtest = new Hashing(10);                                                // Hashing hashtest object with mapSize[10]
        hashtest.add("blue");                                                           // adding colors into hashtest
        hashtest.add("red");    
        hashtest.add("green");     
        
        System.out.println("Contains 'blue': " + hashtest.contains("blue"));            // utilzing contains method to check if word is in hashing
        System.out.println("Contains 'green': " + hashtest.contains("green"));

        System.out.println("Contains 'yellow': " + hashtest.contains("yellow"));        // utilzing contains method to check if word, not in hashing, is in hashing
        System.out.println("Contains 'purple': " + hashtest.contains("purple"));

        hashtest.add("blue");                                                           // adding duplicates for error checking
        hashtest.add("red"); 
        hashtest.add("123");                                                            // adding 123 to see where its located in hashtest, should be hashvalue 0

        hashtest.add("green");

        hashtest.add("kaliedascope");                                                   // adding a kaliedascope to test add method's early resize if dumbhash is greater than mapSize

        hashtest.displayWords();                                                                   // displays the words 
        System.out.println("\n");

        Hashing dataset = new Hashing(30);                                                 // Hashing dataset object with mapSize[30]
        String [] animals = { "dog", "cat", "puppy", "kitten", "lion", "tiger", "monkey", "gorilla", "buffalo", "crocodile", "alligator", "eagle", "tarantula", "butterfly", "hornet", "grasshopper", "ant", "spider", "snake", "swan", "penguin", "frog", "deer", "elk", "moose", "bear", "whale", "shark", "clownfish", "sea urchin", "octopus", "squid", "shrimp", "lobster", "anglerfish", "piranha", "polarbear", "elephant", "cheetah", "gazelle", "iguana", "lizard", "turtle", "clam", "pandabear", "bengaltiger", "vulture", "ostrich"};
        for (String animal : animals) {                                                            // for each animal in animals
            dataset.add(animal);                                                                   // add every String animal to dataset for experimentation
        }
        dataset.speedTester("cat", 5);                                          // testing speed of checking dataset for cat
        dataset.speedTester("dolphin", 5);                                      // testing speed of checking dataset for dolphin
        dataset.speedTester("dire wolf", 5);                                    // testing speed of checking dataset for dire wolf
        dataset.speedTester("anglerfish", 5);                                   // testing speed of checking dataset for anglerfish
        dataset.speedTester("bengaltiger", 5);                                  // testing speed of checking dataset for bengaltiger
    }   
}