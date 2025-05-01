package ArbidSimpleHashMap.MapExcercise;
// In-class Excercise

import java.util.HashMap;
//import java.util.TreeMap; 
//import java.util.ArrayList;

public class TestingMapsAgain {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();                         // HashMap hm holds String as key with an Integer as value
        hm.put("Alpha", 18);                                         // Puts Alpha, 18 into hm
        hm.put("Beta", 24);                                          // Puts Beta, 24 into hm
        hm.put("Charlie", 23);                                       // Puts Charlie, 23 into hm
        hm.put("Delta", 19);                                         // Puts Delta, 19 into hm
        hm.put("Echo", 21);                                          // Puts Echo, 21 into hm

        // Sometimes helpful to have a 'super' data structure                  // Super Data Structure Info
        //TreeMap<String, ArrayList<String> > hm = new TreeMap<>();            // TreeMap hm holds String as key with an ArrayList of Strings as value

        System.out.println("the size of my map is: " + hm.size());             // Prints hm size
        System.out.println("what is Beta: " + hm.get("Beta"));             // Prints Beta Integer value

        for (String singleValue : hm.keySet()) {                               // For each key in hm
            System.out.println(singleValue + ": " + hm.get(singleValue));      // Prints each key and its value
        }
    }
    
}
