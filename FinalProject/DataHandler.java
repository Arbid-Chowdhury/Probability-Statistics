package FinalProject;
//https://www.youtube.com/watch?v=ScUJx4aWRi0 helped understand/implement file writing of the equation using BufferedWriter
//https://www.digitalocean.com/community/tutorials/java-filewriter-example helped understand how to use FileWriter so that duplication error could be prevented in checkVariance 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataHandler {
    
    public static void handle1(ArrayList<String> xyPoints, String output) {                         // method to write xy points in csv
         try {                                                                                                   
            BufferedWriter data = new BufferedWriter(new FileWriter(output + ".csv"));              // utilizing BufferedWriter for writing xy pairs in csv
            data.write("    x , y\n");                                                          // displays two line header
            data.write("---------------\n");                                                              
            for (String pair : xyPoints) {                                                          // for each xy pair in xyPoints
                data.write(pair + "\n");                                                            // xy pair written in the csv file
            }
            data.close();          
        }
        catch (IOException error) {                                                                 // catch IOException               
            error.printStackTrace();                                                                // displays stack trace error for debugging
        }
    }

    public static void handle2(ArrayList<String> xyPoints, String input, String output, double saltBound, int windowSize, int type) {   // method to write salted/smoothed xy points in csv
        xyPoints.clear();                                                                                                               // clears xyPoints for upcoming salted/smoothed data                
        try {
            BufferedReader check = new BufferedReader(new FileReader(input + ".csv"));                          // utilizing BufferedReader for reading csv file
            BufferedWriter data = new BufferedWriter(new FileWriter(output + ".csv"));                          // utilizing BufferedWriter for writing xy pairs in csv
            for (int i = 0; i < 2; i++) {                                                                       // loops for two line header of csv
                check.readLine();                                                                               // read line of csv
            }
            String pair = check.readLine();                                                                     // String pair is line read after headers
            while (pair != null) {                                                                              // while pair is not null, rest of csv      
                xyPoints.add(pair);                                                                             // pair is added to xyPoints 
                pair = check.readLine();                                                                        // pair is now next read line of the csv
            }
            if (type == 1) {                                                                                    // if type is 1
                SaltingData salt = new SaltingData();                                                           // SaltingData salt object
                salt.saltArrayList(xyPoints, saltBound);                                                        // utilizes saltArrayList to salt xyPoints
            }
            else if (type == 2) {                                                                               // if type is 2
                SmoothingData smooth = new SmoothingData();                                                     // SmoothingData smooth object
                smooth.smoothArrayList(xyPoints, windowSize);                                                   // utilizes smoothArrayList to smooth xyPoints
            }
            else {                                                                                              // else
                System.out.println("Type must be either 1 or 2 for salting and smoothing respectively.");     // Displays type error 
                data.close();                                                        
                check.close();                                                      
                return;                                                                                         // Return to end method
            }
            handle1(xyPoints, output);                                                                          // utilizes handle1 to write headers and xyPoints to output csv          
            data.close();
            check.close();
        } 
        catch (IOException error) {                                                                             // catch IOException
            error.printStackTrace();                                                                            // displays stack trace error for debugging
        }
    }

    public void printArrayList(String input) {                                                                  // method to print xyPoints as ArrayList
        System.out.println("--------------------------------------");
        System.out.println("\nPrinting " + input + ".csv :");                                                   // displays header with input file name
        System.out.println("--------------------------------------");
        try {
            BufferedReader check = new BufferedReader(new FileReader(input  + ".csv"));                         // utilizes BufferedReader to read csv file
            for (int i = 0; i < 2; i++) {                                                                       // loops for two line header of csv
                System.out.print(check.readLine());                                                             // read two-line header
                System.out.print("\n");                                         
            }
            String pair = check.readLine();                                                                     // String pair is line read after headers
            while (pair != null) {                                                                              // while pair is not null, rest of csv     
                System.out.println(pair);                                                                       // displays the pair
                pair = check.readLine();                                                                        // pair is now next read line of the csv
            }
            check.close();                                                      
        }
        catch (IOException error) {                                                                             // catch IOException
            error.printStackTrace();                                                                            // displays stack trace error for debugging
        }
    }

    public static void checkVariance(String input, String output, ArrayList<Double> yComparison, int iteration) {        // method to check variance of csv file
        double variance = 0;                                                                                             // initialize variance outside try block
        if (iteration == 1) {                                                                                            // if iteration is 1 (fixes duplication error in vars csv)
            try {
                FileWriter reset = new FileWriter(output + ".csv", false);                                        // utilizing FileWriter for reseting file for next iteration of variance added to csv
                reset.write("");                                                                                     // overwrites output file to empty csv, erasing the duplication error
                reset.close();                                                              
            }
            catch (IOException error) {                                                                                  // catch IOException
                error.printStackTrace();                                                                                 // displays stack trace error for debugging
            }
        }

        try {
            ArrayList<Double> yPoints = new ArrayList<Double>();                                                         // ArrayList yPoints for variance calculation
            int count = 0;                                                                                               // int count 
            double mean = 0;                                                                                             // initialize mean to 0
            BufferedReader check = new BufferedReader(new FileReader(input + ".csv"));                                   // utilizing BufferedReader for reading csv file
            for (int i = 0; i < 2; i++) {                                                                                // loops for two line header of csv
                check.readLine();                                                                                        // read line of csv
            }
            String pair = check.readLine();                                                                              // String pair is line read after headers
            while (pair != null) {                                                                                       // while pair is not null, rest of csv      
                String[] coords = pair.split(" , ");                                                               // String coords array of xy pairs, splitting x and y into strings with comma between
                double y = Double.parseDouble(coords[1]);                                                                // converts split String y into double
                yPoints.add(y);                                                                                          // adds y to xyPoints
                count++;                                                                                                 // increases count
                pair = check.readLine();                                                                                 // pair is now next read line of the csv
            }
            for (Double y : yPoints) {                                                                                   // for each y in yPoints
                mean += y;                                                                                               // adds y value to mean
            }
            mean /= count;                                                                                               // mean is averaged by of amount of y values
            for (Double y : yPoints) {                                                                                   // for each y in yPoints
                variance += Math.pow(y - mean, 2);                                                                     // variance is sum of all squared difference of every y with the mean
            }      
            variance /= count;                                                                                           // variance is averaged over all y values
            yComparison.add(variance);                                                                                   // adds variance to yComparison
            try {
                BufferedWriter data = new BufferedWriter(new FileWriter(output + ".csv", true));                  // utilizing BufferedWriter for writing xy pairs in csv
                data.append("Parameter(" + iteration + "): " + variance + "\n");                                         // writes/appends variance to output file
                data.close();                                                                
            }
            catch (IOException error) {                                                                                  // catch IOException
                error.printStackTrace();                                                                                 // displays stack trace error for debugging
            }
            check.close();                                                                  
        }
        catch (IOException error) {                                                                                      // catch IOException               
            error.printStackTrace();                                                                                     // displays stack trace error for debugging
        }
    }
}   