package FinalProjectIII;

//https://www.tutorialspoint.com/jfreechart/index.htm this tutorial/guide helped inform on the Jfree api to generate the equation's graph, using https://javadoc.io/doc/org.jfree/jfreechart/1.5.4/index.html api docs to set up the xy series and chart
//https://www.codejava.net/java-se/graphics/using-jfreechart-to-draw-xy-line-chart-with-xydataset supplementary source for graph creation
//https://javadoc.io/doc/org.apache.commons/commons-math3/latest/index.html helped undertsand how to use apache commons math library to make the equation, specifically the PolynomialFunction class in https://javadoc.io/doc/org.apache.commons/commons-math3/latest/index.html
//https://javadoc.io/doc/org.jfree/jfreechart/1.5.4/org/jfree/chart/ChartUtils.html#saveChartAsPNG(java.io.File,org.jfree.chart.JFreeChart,int,int) used for png display of the graph
//with the apache api docs, the addition of RandomDataGenerator was used for the salting logic

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.jfree.chart.ChartUtils;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.XYSeriesCollection;

public class Salter {
    
    public void saltJf(double saltBound, String input, String output) throws IOException {     // method to salt xy series 
        XYSeries xy = new XYSeries(output);                                                    // XY series for the graph, parameter output being the name
        RandomDataGenerator randgen = new RandomDataGenerator();                               // randgen object from apache RandomDataGenerator 
        try {
            BufferedReader check = new BufferedReader(new FileReader(input + ".csv"));         // utilizing BufferedReader for reading csv file
            BufferedWriter data = new BufferedWriter(new FileWriter(output + ".csv"));         // utilizing BufferedWriter for writing xy pairs in csv
            for (int i = 0; i < 2; i++) {                                                      // loops for two line header of csv
                data.write(check.readLine() + "\n");                                           // read line of iteration
            }
            String pair = check.readLine();                                                    // String pair is line read after headers
            while (pair != null) {                                                             // while pair is not null      
                String[] coords = pair.split(",");                                       // String coords array of xy values, splitting x and y into strings with comma between               
                double x = Double.parseDouble(coords[0]);                                      // converts the split String x value into double 
                double y = Double.parseDouble(coords[1]);                                      // converts the split String y value into double
                y += randgen.nextUniform(-saltBound, saltBound);                               // salts y value randomly using number within +/- saltBound
                xy.add(x, y);                                                                  // adds current x/y pair to xy
                data.write(x + " , " + y + "\n");                                              // write the salted pair to the csv
                pair = check.readLine();                                                       // read next line of csv
            }
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
        ChartUtils.saveChartAsPNG(new File(output + ".png"), graph, 800, 700);    // Saving jfree chart graph as a png file with output as name
    }
}