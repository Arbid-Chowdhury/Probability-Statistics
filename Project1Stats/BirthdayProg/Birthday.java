package BirthdayProg;

import java.util.ArrayList;
import java.util.Random;

public class Birthday {
    private int classSize;                                                  // Intializes the class size
    private int runs;                                                       // Intializes the number of runs
    private Random day = new Random();                                      // Intializes Random day for Person birthday generation

    public Birthday(int size, int runs) {                                   // Constructor for the Birthday class
        this.classSize = size;                                              // Sets the class size 
        this.runs = runs;                                                   // Sets the runs 
    }

    private ArrayList<Person> classDays() {                                 // Method to make a class with randomized birthdays (1-365 days of year)
        ArrayList<Person> class_bdays = new ArrayList<Person>();            // Creates an ArrayList of persons named class_bdays
        for (int i = 0; i < classSize; i++) {                               // Loops through class size
            class_bdays.add(new Person(day.nextInt(365)+ 1));         // Adds a new Person with a random birthday, range of 1 to 365 days 
        }
        return class_bdays;                                                 // Returns class_bdays 
    }

    public boolean bdayMatcher(ArrayList<Person> class_bdays) {                                // Method to check if there is a birthday match in the class
        for (int i = 0; i < class_bdays.size(); i++) {                                         // Loops through the class_bdays              
            for (int j = i + 1; j < class_bdays.size(); j++) {                                 // Loops through the class_bdays again to compare the birthdays
                if (class_bdays.get(i).getBirthday() == class_bdays.get(j).getBirthday()) {    // Checks if the birthday of i is equal to the birthday of j in each iteration
                    return true;                                                               // Returns true if there is a birthday match
                }
            }
        }
        return false;                                                                          // Returns false if there is no birthday match                  
    }

    public void bdayFinder() {                                                                 // Method to find the probability of a birthday match in the class, based on the class size and number of runs
        int match = 0;                                                                         // Intializes birthday matches
        for (int i = 0; i < runs; i++) {                                                       // Loops through the number of runs   
            ArrayList<Person> class_bdays = classDays();                                       // Creates a new class_bdays arraylist every run with randomized birthdays
            if (bdayMatcher(class_bdays)) {                                                    // Checks if there is a birthday match in the class using the BdayMatcher method
                match++;                                                                       // Increases the count of birthday matches/true
            }
        }
        double probability = (double) match / runs * 100;                                                               // Creates double for calculation of birthday match probability by dividing the count by runs and multiplying by 100 for percentage
        System.out.println("The probability for Class of " + classSize + " in " + runs + " runs is " + probability);    // Prints the probability of a birthday match in regard to the class size and runs
    }
}