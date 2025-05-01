package FinalProjectIII;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {

        Grapher graph = new Grapher();                                                      // graph object
        Salter salt = new Salter();                                                         // salt object
        Smoother smooth = new Smoother();                                                   // smooth object

        graph.graphJf(-30, 30, 1, "graphingData");                         // bounds of [-30, 30] 
        graph.graphJf(-70, 70, 1, "graphingData2");                        // bounds of [-70, 70]
        graph.graphJf(-100, 100, 1, "graphingData3");                      // bounds of [-100, 100]

        salt.saltJf(45, "graphingData", "saltingData");              // saltBound of 45
        salt.saltJf(85, "graphingData2", "saltingData2");            // saltBound of 85
        salt.saltJf(165, "graphingData3", "saltingData3");           // saltBound of 165

        smooth.smoothJf(2, "saltingData", "smoothingData");         // windowSize of 1
        smooth.smoothJf(3, "saltingData2", "smoothingData2");       // windowSize of 3
        smooth.smoothJf(4, "saltingData3", "smoothingData3");       // windowSize of 4

    }
    
}