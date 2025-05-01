package StatsLibrary2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class StatsLibrary2 {
    
    public BigInteger factorial(int n) {                                                                                   // method to calculate factorial using BigInteger
        BigInteger factorial = BigInteger.ONE;                                                                             // Intializes factorial to 1
        for (int i = 2; i <= n; i++) {                                                                                     // loops through each number from 2 to n (starts from 2 because 1 doesnt affect factorial calculation)
            factorial = factorial.multiply(BigInteger.valueOf(i));                                                         // the factorial mutiplies itself by the BigInteger value of number its looping through
        }
        return factorial;                                                                                                  // Return factorial
    }

    public BigDecimal poissonDistribution(double lamda, int y) {                                                           // method to calculate Poisson Distribution using BigDecimal
        BigDecimal pois1 = BigDecimal.valueOf(Math.exp(-lamda) * Math.pow(lamda, y));                                      // converts formula's numerator to BigDecimal
        BigDecimal pois2 = pois1.divide(new BigDecimal(factorial(y)), 3, RoundingMode.HALF_UP);                      // calculates formula's numerator divided by denominator, converted to a BigDecimal and rounded to 3 decimals
        System.out.println("Expected Value, E(Y), and Variance, V(Y): " + lamda);                                          // displays lamda, the expected value and variance
        return pois2;                                                                                                      // Return pois2            
    }

    public double chebyshevsTheorem(double k) {                                                                            // method to calculate Chebyshev's Theorem
        if (k < 1) {
            System.out.println("the K value must be more than 1");                                                       // informs user that k must be more than 1
            System.out.println("the following output is incorrect because k should be greater than 1");                  // informs user that the output is incorrect due to k being less than 1
            return 0;                                                                                                      // Return 0 for incorrect k value
        }
        double cheby1 = 1 - (1 / (k * k));                                                                                 // cheby1 double is the calculated formula with k
        return cheby1;                                                                                                     // Return cheby1
    }

    public double uniformProbabilityDistribution(double a, double b){                                                      // method to calculate uniform probability distribution
        if (b < a) {
            System.out.println("b must be more than a");
            return 0;                                                                                                      // Return 0 for incorrect b value
        }
        double uniform = 1 / (b - a);                                                                                      // uniform double is pdf of uniform distribution
        System.out.println("E(Y) or Expected: " + uniformExVal(a, b));                                                     // utilizes uniformExVal method to display expected value
        System.out.println("V(Y) or Variance: " + uniformVariance(a, b));                                                  // utilizes uniformVariance method to display variance
        return uniform;                                                                                                    // Return uniform
    }                                         
    
    private double uniformExVal(double a, double b){                                                                       // method to calculate uniform expected value
        double exValue = (a + b)/2;                                                                                        // exValue double is calculated with book formula
        return exValue;                                                                                                    // Return exValue
    }

    private double uniformVariance(double a, double b){                                                                    // method to calculate uniform variance
        double var = Math.pow(b - a, 2) / 12;                                                                            // var double is calculated using the book formula
        return var;                                                                                                        // Return var
    }

    public double normalDistribution(double y, double mean, double stdDev) {                                               // method to calculate normal distribution
        double norm1 = (1 / (stdDev * Math.sqrt(2 * Math.PI)));                                                            // normal double is formula's fraction 
        double norm2 = Math.exp(-Math.pow(y - mean, 2) / (2 * Math.pow(stdDev, 2)));                                   // normal double is formula's e and exponent
        double normdist = norm1 * norm2;                                                                                   // normdist double is norm1 and norm2 multiplied
        System.out.println("E(Y) or Expected: " + mean);                                                                   // displays the expected value/mean
        System.out.println("V(Y) or Variance: " + normalVariance(stdDev) );                                                // utilizes normalVariance method to display variance
        return normdist;                                                                                                   // Return normdist
    }

    private double normalVariance(double stdDev) {                                                                         // method to calculate normal variance
        double var = Math.pow(stdDev, 2);                                                                                // var double is stdDev squared
        return var;                                                                                                        // Return var
    }
}