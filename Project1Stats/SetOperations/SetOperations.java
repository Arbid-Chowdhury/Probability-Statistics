package SetOperations;

import java.util.ArrayList;

public class SetOperations {

    public class set {                                                                           // Empty Class for set

    }

    public ArrayList<String> union(ArrayList<String> setA, ArrayList<String> setB) {             // Method for union of two arraylists
        ArrayList<String> union = new ArrayList<>(setA);                                         // Creates a new arraylist union and adds every setA day/element to it
        for (String day : setB) {                                                                // For every day/element in setB
            if (!union.contains(day)) {                                                          // If union does not contain the day/element from setB       
                union.add(day);                                                                  // Add the day/element to union arraylist
            }   
        }
        return union;                                                                            // Returns union 
    }

    public ArrayList<String> intersection(ArrayList<String> setA , ArrayList<String> setB) {     // Method for intersection of two arraylists 
        ArrayList<String> intersection = new ArrayList<>();                                      // Creates a new arraylist intersection
        for (String day : setA) {                                                                // For every day/element in setA
            if (setB.contains(day)) {                                                            // If setB contains the day/element from setA
                intersection.add(day);                                                           // Add the day/element to intersection arraylist
            }
        }
        return intersection;                                                                     // Returns intersection 
    }

    public ArrayList<String> complement(ArrayList<String> setA, ArrayList<String> subsetA) {     // Method for complement subset
        ArrayList<String> complement = new ArrayList<>(setA);                                    // Creates a new arraylist complement and adds every setA day/element to it
        for (String day : subsetA) {                                                             // For every day/element in subsetA
            if (complement.contains(day)) {                                                      // If complement contains the day/element from subsetA
                complement.remove(day);                                                          // Remove the day/element from the complement arraylist
            }
        }
        return complement;                                                                       // Returns complement
    }
}