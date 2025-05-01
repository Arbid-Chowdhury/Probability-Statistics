package FinalProject;
//https://www.youtube.com/watch?v=ScUJx4aWRi0 helped understand/implement file writing of the equation using BufferedWriter

import java.util.ArrayList;

public class GraphingData {
   
    public void dataGrapher(double lower, double upper, double inc, String input) {                 // method to graph formula based xy points in csv 
        if (lower > upper || inc <= 0) {                                                            // if lower is greater than upper bound or inc is less than/equal to 0
            System.out.println("Lower must be less than upper bound");                            // displays to user that lower must be less than upper bound
            return;                                                                                 // Return
        }
        DataHandler.handle1(makeArray(lower, upper, inc), input);                                   // utilizes handle1 to write xyPoints in csv
    }

    private static double calculateEquation(double x) {                                             // method to calculate 3x^2 + 5x + 3 equation
        double y = 3 * Math.pow(x, 2) + 5 * x + 3;                                                // calculates y as double
        return y;                                                                                   // Returns y for x              
    }

    private ArrayList<String> makeArray(double lower, double upper, double inc) {                   // method generate xyPoints ArrayList
        ArrayList<String> xyPoints = new ArrayList<String>();                                       // xyPoints ArrayList for xy points
        for (double x = lower; x <= upper; x += inc) {                                              // loops through x values from lower to upper bounds by inc
            xyPoints.add(x + " , " + calculateEquation(x));                                         // xy points added to xyPoints, calculating y using calculateEquation for each x iteration
        }
        return xyPoints;                                                                            // Returns xyPoints 
    }
}