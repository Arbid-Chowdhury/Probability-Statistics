package SetOperations;

import java.util.ArrayList;
import java.util.Collections;

public class Tester {
    public static void main(String[] args) {
        SetOperations test = new SetOperations();                                                           // Create test object for SetOperations 
        ArrayList<String> dayarray1 = new ArrayList<>();                                                    // Create an ArrayList of days
        Collections.addAll(dayarray1, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");  // Add days Monday through Friday to the ArrayList dayarray1                                                                    
        ArrayList<String> dayarray2 = new ArrayList<>();                                                    // Create a second ArrayList of days
        Collections.addAll(dayarray2, "Thursday", "Friday", "Saturday", "Sunday");              // Add days Thursday through Sunday to the ArrayList dayarray2
        System.out.println("Union: " + test.union(dayarray1, dayarray2));                                   // Outputs the union of dayarray1 and dayarray2
        System.out.println("Intersection: " + test.intersection(dayarray1, dayarray2));                     // Outputs the intersection of dayarray1 and dayarray2
        System.out.println("Complement of A: " + test.complement(dayarray1, dayarray2));                    // Outputs the complement of dayarray 2 subset
    }
}