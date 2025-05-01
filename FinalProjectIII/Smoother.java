package FinalProjectIII;


import java.io.BufferedReader;

//https://www.tutorialspoint.com/jfreechart/index.htm this tutorial/guide helped inform on the Jfree api to generate the equation's graph, using https://javadoc.io/doc/org.jfree/jfreechart/1.5.4/index.html api docs to set up the xy series and chart
//https://www.codejava.net/java-se/graphics/using-jfreechart-to-draw-xy-line-chart-with-xydataset supplementary source for graph creation
//https://javadoc.io/doc/org.apache.commons/commons-math3/latest/index.html helped undertsand how to use apache commons math library to make the equation, specifically the DescriptiveStatistics class for the smoothing of y values
//https://javadoc.io/doc/org.jfree/jfreechart/1.5.4/org/jfree/chart/ChartUtils.html#saveChartAsPNG(java.io.File,org.jfree.chart.JFreeChart,int,int) used for png display of the graph

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.jfree.chart.ChartUtils;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.JFreeChart;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.XYSeriesCollection;

public class Smoother {

    public void smoothJf(int windowSize, String input, String output) throws IOException {     // method to graph the equation
        XYSeries xy = new XYSeries(output);                                                    // XY series for the graph, parameter output being the name
        ArrayList<String> xyPoints = new ArrayList<String>();                                  // xyPoints ArrayList for xy points
        try {
            BufferedReader check = new BufferedReader(new FileReader(input + ".csv"));         // utilizing BufferedReader for reading csv file
            BufferedWriter data = new BufferedWriter(new FileWriter(output + ".csv"));         // utilizing BufferedWriter for writing xy pairs in csv
            for (int i = 0; i < 2; i++) {                                                      // loops for two line header of csv
                data.write(check.readLine() + "\n");                                           // read line of iteration
            }
            String pair = check.readLine();                                                    // String pair is line read after headers
            while (pair != null) {                                                             // while pair is not null      
                xyPoints.add(pair);                                                            // adds the pair to the xyPoints ArrayList
                pair = check.readLine();                                                       // read next line of csv
            }
            smoothingLoop(xyPoints, windowSize, xy, data);                                     // utilizes smoothingLoop method to smooth y values
            data.close();
            check.close();
        }
        catch (IOException error) {                                                            // catch IOException
            error.printStackTrace();                                                           // displays stack trace error for debugging
        }

        XYSeriesCollection pairs = new XYSeriesCollection(xy);                                 // XYSeriesCollection pairs using xy series
        JFreeChart graph = ChartFactory.createXYLineChart (                                    // generate graph using ChartFactory
            output,                                                                            // title/name of graph
            "X",                                                                    // X-axis label                
            "Y",                                                                    // Y-axis label
            pairs                                                                              // XYSeriesCollection pairs for graph data          
        );
        ChartUtils.saveChartAsPNG(new File(output + ".png"), graph, 800, 700);                                         // Saving jfree chart graph as a png file with output as name
    }

    private void smoothingLoop(ArrayList<String> xyPoints, int windowSize, XYSeries xy, BufferedWriter data) throws IOException {   // method to smooth the data
        for (int focusY = 0; focusY < xyPoints.size(); focusY++) {                                                                  // loops through each x/pair in xyPoints
            DescriptiveStatistics tool = new DescriptiveStatistics();                                                               // tool object from apache DescriptiveStatistics for windowSize mean
            String[] coord = xyPoints.get(focusY).split(",");                                                                 // String array coord
            double x = Double.parseDouble(coord[0]);                                                                                // sets/parses the x value
            int leftBound = Math.max(0, focusY - windowSize);                                                                     // left bound of windowSize, left most y value of focusY
            int rightBound = Math.min(xyPoints.size() - 1, focusY + windowSize);                                                    // right bound of windowSize, right most y value of focusY
            for (int i = leftBound; i <= rightBound; i++) {                                                                         // loops through the windowSize of focusY
                String[] coords = xyPoints.get(i).split(",");                                                                 // String array coords 
                double curY = Double.parseDouble(coords[1]);                                                                        // parses the y value as curY
                tool.addValue(curY);                                                                                                // adds y value to tool
            }
            double yAvg = tool.getMean();                                                                                           // gets mean of the window's y values
            xy.add(x, yAvg);                                                                                                        // adds x with yAvg to the xy series
            data.write(x + "," + yAvg + "\n");                                                                                      // writes the x and yAvg to csv 
        }
    }
}