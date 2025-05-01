package FinalProjectIII;

//https://www.tutorialspoint.com/jfreechart/index.htm this tutorial/guide helped inform on the Jfree api to generate the equation's graph, using https://javadoc.io/doc/org.jfree/jfreechart/1.5.4/index.html api docs to set up the xy series and chart
//https://www.codejava.net/java-se/graphics/using-jfreechart-to-draw-xy-line-chart-with-xydataset supplementary source for graph creation
//https://javadoc.io/doc/org.apache.commons/commons-math3/latest/index.html helped undertsand how to use apache commons math library to make the equation, specifically the PolynomialFunction class in https://javadoc.io/doc/org.apache.commons/commons-math3/latest/index.html
//https://javadoc.io/doc/org.jfree/jfreechart/1.5.4/org/jfree/chart/ChartUtils.html#saveChartAsPNG(java.io.File,org.jfree.chart.JFreeChart,int,int) used for png display of the graph

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jfree.chart.ChartUtils;
import org.jfree.data.xy.XYSeries;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.XYSeriesCollection;

public class Grapher {

    public void graphJf(double lower, double upper, double inc, String output) throws IOException {     // method to graph the xy series
        XYSeries xy = new XYSeries(output);                                                             // XY series xy with parameter output being the name   
        PolynomialFunction equation = new PolynomialFunction(new double[]{3, 5, 3});                    // Polynomial Function for the equation 3x^2 + 5x + 3           
        try (BufferedWriter data = new BufferedWriter(new FileWriter(output + ".csv"))) {               // utilizing BufferedWriter for writing xy pairs in csv 
            data.write("    x,y\n");                                                                // write two line header
            data.write("----------------\n");
            for (double x = lower; x <= upper; x += inc) {                                              // loop through x from lower to upper by inc            
                double y = equation.value(x);                                                           // calculate y using the Polynomial Function equation     
                xy.add(x, y);                                                                           // adds current x/y pair to coords        
                data.write(x + " , " + y + "\n");                                                       // x/y pair written to the csv
            }
            data.close();                                                                               
        } 
        catch (IOException error) {                                                                     // catch IOException    
            error.printStackTrace();                                                                    // displays stack trace error for debugging
        }

        XYSeriesCollection pairs = new XYSeriesCollection(xy);                                          // XYSeriesCollection pairs using xy series
        JFreeChart graph = ChartFactory.createXYLineChart (                                             // generate graph using ChartFactory
            output,                                                                                     // title/name of graph
            "X",                                                                             // X-axis label
            "Y",                                                                             // Y-axis label                       
            pairs                                                                                       // XYSeriesCollection pairs for graph data
            );
        ChartUtils.saveChartAsPNG(new File(output + ".png"), graph, 800, 700);             // Saving jfree chart graph as a png file with output as name
    }
}