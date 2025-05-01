package StatsLibrary2;
public class TestStatsLibrary {
    public static void main(String[] args) {

        StatsLibrary2 tester = new StatsLibrary2();                                                                                                 // tester object
        
        System.out.println("The Factorial of 20 is: " + tester.factorial(20));                                                                    // Tests the factorial method using 20  
        System.out.println("The Poisson Distribution of lamda(5) and y(7) is: " + tester.poissonDistribution(5, 7));                        // Tests the Poisson Distribution method using landa(5) and y(7)
        System.out.println("Chebyshev's Theorem for k(4) is: " + tester.chebyshevsTheorem(4) + "\n");                                             // Tests Chebyshev's Theorem method using k(4)
        System.out.println("Uniform Probability Distribution of a(4) and b(8) is: " + tester.uniformProbabilityDistribution(4, 8)+ "\n");       // Tests the Uniform Probability Distribution method using a(4) and b(8)
        System.out.println("Normal Distribution of y(6), mean(3) and stdDev(2) is: " + tester.normalDistribution(6, 3, 2));           // Tests the Normal Distribution method using y(6), mean(3) and stdDev(2)
    }
}