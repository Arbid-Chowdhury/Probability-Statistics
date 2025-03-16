package SoftwareCheckups;

public class ProbTester {
    public static void main(String[] args) {
        Mulligan mull = new Mulligan();         // Create a new mull object of the mulligan class
        mull.probabilityTest();                 // Call the ProbabilityTest method to run the varying pokemon deck test
        System.out.println();                   // Print a new line for spacing
        Brick candy = new Brick();              // Create a new candy object of the candy class
        candy.candyProbabilityTest();           // Call the CandyProbabilityTest method to run the varying rare candy prize pile test
    }
}