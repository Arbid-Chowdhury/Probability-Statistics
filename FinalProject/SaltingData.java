package FinalProject;
//https://codegym.cc/groups/posts/stringsplit-method-in-java helped understand/implement string splitting so specifically y values can be salted
//https://labex.io/tutorials/java-java-double-parsedouble-method-117627 helped to implement string to double conversion for salting of only y values, ensuring no x values alteration
//https://www.baeldung.com/java-generating-random-numbers-in-range helped to understand the implementation of random salting withinn the saltbounds

import java.util.ArrayList;
import java.util.Random;

public class SaltingData {
 
    public void dataSalter(String input, String output, double saltBound) {              // method to write x/salted y points in csv
        if (saltBound <= 0) {                                                            // if saltBound is less than/equal to 0
            System.out.println("Salt bound must be greater than 0");                   // displays to user that saltBound must be greater than 0
            return;                                                                      // Return 
        }
        ArrayList<String> xyPoints = new ArrayList<String>();                            // ArrayList for xy points
        DataHandler.handle2(xyPoints, input, output, saltBound, 0, 1);   // uses handle2 method to salt xyPoints
    }

    public void saltArrayList(ArrayList<String> xyPoints, double saltBound) {            // method to salt xyPoints
        Random rand = new Random();                                                      // Random rand object
        for (int curX = 0; curX < xyPoints.size(); curX++) {                             // loops x values in xyPoints
            String[] coords = xyPoints.get(curX).split(" , ");                     // String coords array of xy values, splitting x and y into strings with comma between                                        
            double x = Double.parseDouble(coords[0]);                                    // converts the split String x value into double 
            double y = Double.parseDouble(coords[1]);                                    // converts the split String y value into double
            y += rand.nextDouble() * 2 * saltBound - saltBound;                          // salts y value randomly using number within +/- saltBound                                          
            xyPoints.set(curX, x + " , " + y);                                           // sets xyPoints pairs to new salted pairs based on curX
        }
    }
}
