package FinalProject;
//https://www.geeksforgeeks.org/program-find-minimum-maximum-element-array/ helped use min and max for bounds of windowSize in loop

import java.util.ArrayList;

public class SmoothingData {
    
    public void dataSmoother(String input, String output, int windowSize) {                             // method to write x/smoothed y points in csv
        ArrayList<String> xyPoints = new ArrayList<String>();                                           // ArrayList for xy points
        DataHandler.handle2(xyPoints, input, output, 0, windowSize, 2);                  // uses handle2 method to smooth xyPoints
    }

    public void smoothArrayList (ArrayList<String> xyPoints, int windowSize) {                          // method to smooth xyPoints
        ArrayList<Double> yPoints = new ArrayList<Double>();                                            // ArrayList for y points
        for (String pairs : xyPoints) {                                                                 // for each xy pair in xyPoints
            String[] coords = pairs.split(" , ");                                                 // String coords array of xy pairs
            double y = Double.parseDouble(coords[1]);                                                   // parsing y from coords
            yPoints.add(y);                                                                             // adds y to yPoints
        }                     
        for (int focusY = 0; focusY < yPoints.size(); focusY++) {                                       // looping through y points, focusY is middle of the window
            int count = 0;                                                                              // set count to 0
            double yTotal = 0;                                                                          // set yTotal to 0
            int leftBound = Math.max(0, focusY - windowSize);                                         // left bound of the window
            int rightBound = Math.min(focusY + windowSize, yPoints.size() - 1);                         // right bound of the window
            for (int i = leftBound; i <= rightBound; i++) {                                             // for window's y values
                yTotal += yPoints.get(i);                                                               // add y point to yTotal
                count++;                                                                                // increment count
            }
            double yAvg = yTotal / count;                                                               // average of y points in the window
            String[] coords = xyPoints.get(focusY).split(" , ");                                  // String coords array of xy pairs
            double x = Double.parseDouble(coords[0]);                                                   // parsing x from coords
            xyPoints.set(focusY, x + " , " + yAvg);                                                     // set x and yAvg in xyPoints based on focusY index
        }
    }
}