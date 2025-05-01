package FinalProject;

public class DataTester {
    public static void main(String[] args) {
        
        GraphingData graph = new GraphingData();                                                // graph object 
        SaltingData salt = new SaltingData();                                                   // salt object
        SmoothingData smooth = new SmoothingData();                                             // smooth object                  
        DataHandler data = new DataHandler();                                                   // data object
        OptimalHeuristic optimal = new OptimalHeuristic();                                      // optimal object
       
        
        graph.dataGrapher(-30, 30, 1, "grapherData");                           // Equation graphed into csv, bounds of [-30,30]     SET1
        graph.dataGrapher(-50, 50, 1, "grapherData2");                          // Equation graphed into csv, bounds of [-50,50]     SET2
        graph.dataGrapher(-80, 80, 1, "grapherData3");                          // Equation graphed into csv, bounds of [-80,80]     SET3

        salt.dataSalter("grapherData", "salterData", 45);                // Salts the csv file by bounds of  [-45,45]         SET1
        salt.dataSalter("grapherData2", "salterData2", 75);              // Salts the csv file by bounds of  [-75,75]         SET2
        salt.dataSalter("grapherData3", "salterData3", 150);             // Salts the csv file by bounds of  [-150,150]       SET3
        
        smooth.dataSmoother("salterData", "smootherData", 1);           // Smooths first salted csv file, windowSize of 1   SET1
        smooth.dataSmoother("salterData2", "smootherData2", 3);         // Smooths second salted csv file, windowSize of 3  SET2
        smooth.dataSmoother("salterData3", "smootherData3", 6);         // Smooths third salted csv file, windowSize of 6   SET3 
        
        data.printArrayList( "grapherData");                                                // Prints graphed csv file
        
        graph.dataGrapher(-140, 140, 1, "grapherData4");                                                                                        // SET4 graph
        salt.dataSalter("grapherData4", "salterData4", 140);                                                                                    // SET4 salted graph
        
        optimal.simulateOptimalHeuristic(1,20, "salt", "grapherData3", "SET1-OptimalSalt", "VarsSET1");          // SET1 OptimalHeuristic method to find optimal saltBound, using grapherData3
        optimal.simulateOptimalHeuristic(1,20, "smooth", "salterData3", "SET1-OptimalSmooth", "VarsSET1");       // SET1 OptimalHeuristic method to find optimal windowSize, using salterData3
        optimal.simulateOptimalHeuristic(1,20, "salt", "grapherData4", "SET2-OptimalSalt", "VarsSET2");          // SET2 OptimalHeuristic method to find optimal saltBound, using grapherData4
        optimal.simulateOptimalHeuristic(1,20, "smooth", "salterData4", "SET2-OptimalSmooth", "VarsSET2");       // SET2 OptimalHeuristic method to find optimal windowSize, using salterData4
         
    }
}