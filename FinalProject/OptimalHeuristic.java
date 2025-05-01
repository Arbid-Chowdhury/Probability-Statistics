package FinalProject;
//https://www.geeksforgeeks.org/java-math-abs-method-examples/ helped understand how to use absolute value in comparison of variances

import java.util.ArrayList;

public class OptimalHeuristic {
    
    public void simulateOptimalHeuristic(double variance, int heuristicRange, String type, String input, String output, String vars) {       // method to find optimal heuristic of smoothing windowSizes
        ArrayList<Double> yComparison = new ArrayList<Double>();                                                                             // ArrayList yComparison for variances of each saltBound/window size
        SmoothingData smooth = new SmoothingData();                                                                                          // smooth object
        SaltingData salt = new SaltingData();                                                                                                // salt object
        if (type.equals("salt")) {                                                                                                  // if type equals salt   
            vars = "salted" + vars;                                                                                                          // sets vars with prefix salted
            for (int i = 1; i <= heuristicRange; i++) {                                                                                      // loops from 1 to heuristic range
                salt.dataSalter(input, output + i, i);                                                                                       // utilizes dataSalter based on iteration for saltBound
                DataHandler.checkVariance(output + i, vars, yComparison, i);                                                                 // checkVariance utilized to get variance of all y values
            }
        } 
        else if (type.equals("smooth")) {                                                                                           // else if type equals smooth
            vars = "smoothed" + vars;                                                                                                        // sets vars with prefix smoothed
            for (int i = 1; i <= heuristicRange; i++) {                                                                                      // loops from 1 to heuristic range
                smooth.dataSmoother(input, output + i, i);                                                                                   // utilizes dataSmoother based on iteration for windowSize
                DataHandler.checkVariance(output + i, vars, yComparison, i);                                                                 // checkVariance utilized to get variance of all y values
            }
        }
        double optimalDiff = Math.abs(yComparison.get(0) - variance);                                                                  // calculates the optimalDiff (absolute value for y and variance's difference), for varDiff comparison in the loop
        double optimalIndex = 1;                                                                                                             // sets optimalIndex to 1, representing yComparison's first index
        for (int i = 1; i < yComparison.size(); i++) {                                                                                       // loops through yComparison starting from second index based on optimalDiff
            double varDiff = Math.abs(yComparison.get(i) - variance);  
            if (varDiff < optimalDiff) {                                                                                                     // if varDiff is less than optimalDiff
                optimalDiff = varDiff;                                                                                                       // sets optimalDiff to varDiff
                optimalIndex = i + 1;                                                                                                        // increases optimalIndex by 1 if better optimalDiff found
            } 
        }
        System.out.println("The Optimal Heuristic for " + type + " with trials(" + heuristicRange + ") is " + optimalIndex + " with variance difference of " + optimalDiff);       // displays optimal heuristic range with its variance difference
    }
}