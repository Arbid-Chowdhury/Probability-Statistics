package ArbidSimpleHashMap;

//https://www.geeksforgeeks.org/measure-time-taken-function-java/ helped understand how to collect the time of contains method's completion
//https://www.tutorialspoint.com/java/lang/character_isletter.htm helped understand how to hash based on amount of letters in String

import java.util.LinkedList;
@SuppressWarnings("unchecked")

public class Hashing {
    
    private LinkedList<String>[] wordlist;                                                          // Array of LinkedLists wordlist
    private int mapSize;                                                                            // int mapSize
    
    public Hashing(int mapSize) {                                                                   // Constructor for Hashing 
        this.mapSize = mapSize;                                                                     // sets mapSize
        wordlist = new LinkedList[mapSize];                                                         // LinkedList array of size mapSize
        createList();                                                                               // uses createList method to create LinkedList array
    }

    private void createList() {                                                                     // method to create LinkedList array
        for (int hashvalue = 0; hashvalue < mapSize; hashvalue++) {                                 // loops mapSize length
            wordlist[hashvalue] = new LinkedList<>();                                               // creates a new LinkedList wordlist for each key
        }
    }

    private int dumbHash(String storedWord) {                                                       // method to get dumbhash of storedWord
        int lettercount = 0;                                                                        // int lettercount
        for (int hashvalue = 0; hashvalue < storedWord.length(); hashvalue++) {                     // loops through storedWord's length
            if (Character.isLetter(storedWord.charAt(hashvalue))) {                                 // if character is a letter at current iteration
                lettercount++;                                                                      // increases lettercount           
            }
        }
        return lettercount;                                                                         // Returns lettercount
    }

    public boolean contains(String storedWord) {                                                    // method checking if wordlist contains storedWord
        int hashvalue = dumbHash(storedWord);                                                       // dumbHash storedWord hash value
        if (hashvalue >= mapSize) {                                                                 // if hashvalue is greater than mapSize (not in simple hash map)
            return false;                                                                           // Returns false
        }
        return wordlist[hashvalue].contains(storedWord);                                            // Returns boolean of wordlist hashvalue key containing storedWord
    }

    public void add(String storedWord) {                                                            // method to add storedWord to wordlist
        if (contains(storedWord)) {                                                                 // if wordlist contains storedWord
            System.out.println(storedWord + " cant be added to wordlist again");                    // displays dusplicate error message
            return;                                                                                 // Returns
        }       
        int hashvalue = dumbHash(storedWord);                                                       // dumbHash storedWord hash value
        while (hashvalue >= mapSize) {                                                              // while hashvalue is greater than/equal to mapSize
            resize();                                                                               // utilizes resize method til mapSize fits hashvalue 
        }
        wordlist[hashvalue].add(storedWord);                                                        // adds storedWord to wordlist for dumbhash key hashvalue
    }

    private void resize() {                                                                         // method to resize wordlist
        mapSize *= 2;                                                                               // doubles mapSize for adding values
        LinkedList<String>[] resizedList = new LinkedList[mapSize];                                 // creates LinkedList resizedList based on new mapSize
        for (int hashvalue = 0; hashvalue < mapSize; hashvalue++) {                                 // loops mapSize 
            resizedList[hashvalue] = new LinkedList<>();                                            // creates resized LinkedList for each hashvalue key
        }
        for (LinkedList<String> list : wordlist) {                                                  // for each LinkedList list in wordlist              
            for (String word : list) {                                                              // for each word in list
                resizedList[dumbHash(word)].add(word);                                               // transfers/adds word to resizedList for hashvalue/dumbHash of word 
            }
        }
        wordlist = resizedList;                                                                     // wordlist equals resizedList
    }

    public void displayWords() {                                                                    // method to display words in wordlist
        for (int hashvalue = 0; hashvalue < wordlist.length; hashvalue++) {                         // loops wordlist length         
            System.out.print("Key " + hashvalue + "'s value: " + wordlist[hashvalue] + ", ");       // displays the key and value
        }
    }

    public void speedTester(String storedWord, int trials) {                                                             // method to test speed of contains method on storedWord
        long searchTime = 0;                                                                                             // sets searchTime
        boolean result = false;                                                                                          // sets result to false by default
        for (int i = 0; i < trials; i++) {                                                                               // loops 1 million times
            long beginTest = System.nanoTime();                                                                          // sets beginTest using System.nanoTime
            result = contains(storedWord);                                                                               // calls contains method with storedWord
            long endTest = System.nanoTime();                                                                            // sets endTest using System.nanoTime
            searchTime += endTest - beginTest;                                                                           // sets searchTime of contains method
        }
        long avgTime = searchTime / trials;                                                                              // sets avgTime of searchTime divided by trials
        System.out.println(storedWord + " found:" + result);                                                             // displays if word was found
        System.out.println("Total Search Time: " + searchTime + " nanoseconds");                                         // displays total searchTime in nanoseconds
        System.out.println("Average Time Over Trials: " + avgTime + " nanoseconds \n");                                  // displays average time in nanoseconds
    }    
}