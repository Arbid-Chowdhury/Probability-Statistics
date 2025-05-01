package StatsLibrary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

//https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html used the BigInteger commands/descriptions to learn how to use the BigInteger library for Factorial method
//https://www.nagwa.com/en/explainers/407167856270/#:~:text=𝑃%20(%20𝐵%20)%20.-,Events%20𝐴%20and%20𝐵%20are%20independent%20if%20and%20only%20if,nonzero%20probabilities%20cannot%20be%20independent. used to understand how independent and dependent events work for the methods regarding intersection, union, and determining independence/dependence
//https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html used the BigDecimal commands/descriptions to learn how to use the BigDecimal library for binomial distribution method due to BigInteger not being able to handle decimal numbers of p and q (which would have to be inputted as fractions to work with BigInteger)
//https://www.baeldung.com/java-bigdecimal-multiply-integer & https://docs.oracle.com/javase/8/docs/api/java/math/RoundingMode.html used to understand how to multiply BigDecimal variables together for the binomial distribution method and how to round to 2 decimal places

public class StatsLibrary {

    public double getMean(int[] userInputNumbers) {                // Method to find the mean using userInputNumbers array
        int total = 0;                                             // Intializes total
        for (int number : userInputNumbers) {                      // loops through each number of the userInputNumbers array
            total = total+ number;                                 // the total adds each number in array as its looping through
        }                                                        
        double result = (double) total / userInputNumbers.length;  // the mean/result equals the total divided by the length of the userInputNumbers array as a double
        return result;                                             // Return mean/result
    }

    public double getMedian(int[] userInputNumbers) {                                                                      // Method to find the median using userInputNumbers array
        Arrays.sort(userInputNumbers);                                                                                     // sorts the userInputNumbers array ascending using the Arrays sort command
        double med;                                                                                                        // Intializes median
        if (userInputNumbers.length % 2 == 0) {                                                                            // if the length of the userInputNumbers array is even (divisible by 2)
            med = (userInputNumbers[userInputNumbers.length/2] + userInputNumbers[userInputNumbers.length/2 - 1]) / 2;     // the median equals the two most middle ints added together divided by 2
        }
        else {                                                                                                             // if the length of the userInputNumbers array is odd 
            med = userInputNumbers[userInputNumbers.length/2];                                                             // the median equals the middle number (array element at its half length)
        }
        return med;                                                                                                        // Return median  
    }
    
    public int getMode(int[] userInputNumbers) {                   // Method to find the mode using userInputNumbers array
        int mode = userInputNumbers[0];                            // Intializes mode to the first number in the userInputNumbers array
        int duplicates = 0;                                        // Intializes duplicates         
        for (int i = 0; i < userInputNumbers.length; i++) {        // loops through each number of the userInputNumbers array
            int count = 0;                                         // Intializes count which will mark down duplicates in the second loop
            for (int j = 0; j < userInputNumbers.length; j++) {    // loops through each number of the userInputNumbers array as the first loop compares each number to the array
                if (userInputNumbers[i] == userInputNumbers[j]) {  // if a number in the second loop equals the number focused on in the first loop
                    count++;                                       // count increases to show theres a duplicate of the focused number
                }
            }
            if (count > duplicates) {                              // if the count of duplicates is greater than the previous duplicates
                duplicates = count;                                // the duplicates equals the count of duplicates
                mode = userInputNumbers[i];                        // the mode equals the number focused on in the first loop with the most duplicates
            }
        }
        return mode;                                               // Return mode
    }

    public double getVariance(int[] userInputNumbers) {            // Method to find the variance using userInputNumbers array
        double mean = getMean(userInputNumbers);                   // calls the getMean method to find the mean of the userInputNumbers array
        double meanTotal = 0;                                      // Intializes meanTotal
        for (int number : userInputNumbers) {                      // loops through each number of the userInputNumbers array
            meanTotal += Math.pow(number - mean, 2);             // the meanTotal equals the array's numbers subtracted by the mean, each number then is squared, and finally added all together 
        }
        double vari = meanTotal / userInputNumbers.length;         // the variance equals the meanTotal divided by the length of the userInputNumbers array           
        return vari;                                               // Return variance
    }

    public double getStandDeviation(int[] userInputNumbers) {                   // Method to find the standard deviation using userInputNumbers array
        double standard_deviation = Math.sqrt(getVariance(userInputNumbers));   // calls the getVariance method to find the variance then square roots the value
        return standard_deviation;                                              // Return standard deviation
    }

    public BigInteger factorial(int n) {                            // Method to calculate factorial using BigInteger
        BigInteger factorial = BigInteger.ONE;                      // Intializes factorial to 1
        for (int i = 2; i <= n; i++) {                              // loops through each number from 2 to n (starts from 2 because 1 doesnt affect factorial calculation)
            factorial = factorial.multiply(BigInteger.valueOf(i));  // the factorial mutiplies itself by the BigInteger value of number its looping through
        }
        return factorial;                                           // Return factorial
    }

    public BigInteger combination(int n, int r) {                                             // Method to calculate combination of n & r using the Factorial method
        BigInteger combo = (factorial(n).divide(factorial(r).multiply(factorial(n - r))));    // Creates BigInteger variable combo using combination formula 
        return combo;                                                                         // Return combo             
    }

    public BigInteger permutation(int n, int r) {                                             // Method to calculate permutation of n & r using the Factorial method
        BigInteger permut = (factorial(n).divide(factorial(n - r)));                          // Creates BigInteger variable permut using permutation formula
        return permut;                                                                        // Return permut            
    }

    public boolean independentIntersection(List<Integer> A, List<Integer> B) {        // Method for independent intersection of two ArrayLists
        for (int i : A) {                                                             // loops through every int in A                                                                 
            if (B.contains(i)) {                                                      // If intersection contains the int from A                           
                return false;                                                         // Return false if intersection contains an int from A (not independent)    
            }                                                                                       
        }   
        return true;                                                                  // Return true (is independent)
    }

    public boolean dependentIntersection(List<Integer> A, List<Integer> B) {          // Method for intersection of two ArrayLists
        return !independentIntersection(A, B);                                        // Return boolean opposite of independentIntersection method 
    }

    public boolean exclusiveUnion(List<Integer> A, List<Integer> B) {                 // Method for exclusive union of two ArrayLists
        return independentIntersection(A, B);                                         // Return independentIntersection boolean method, same as exclusive union checking for similar elements           
    }

    public boolean notExclusiveunion(List<Integer> A, List<Integer> B) {              // Method for not exclusive union of two ArrayLists (union of A and B)
        return !exclusiveUnion(A, B);                                                 // Return boolean opposite of exclusiveUnion method
    }

    public double checkProbA(int A, int SampleSpace) {                                // Method for probability of A 
        double probA = (double) A / SampleSpace;                                      // Calculates double probA as the probability of A
        return probA;                                                                 // Return probA
    }

    public double checkProbB(int B, int SampleSpace) {                                // Method for probability of B 
        double probB = (double) B / SampleSpace;                                      // Calculates double probB as the probability of B 
        return probB;                                                                 // Return probB
    }

    public double checkProbAandB(int union, int SampleSpace) {                        // Method for probability of A and B 
        double probAandB =  union / SampleSpace;                                      // Calculates double probAandB as the probability of A and B
        return probAandB;                                                             // Return probAandB
    }

    public boolean checkDependency(int A, int B, int SampleSpace) {                                               // boolean method checking if A and B are dependent 
        return checkProbAandB(A + B, SampleSpace) == checkProbA(A, SampleSpace) * checkProbB(B, SampleSpace);     // Return true if probability of A and B is equal to probability of A times probability of B
    }

    public boolean checkIndependence(int A, int B, int SampleSpace) {                                             // boolean method if A and B being independent
        return !checkDependency(A, B, SampleSpace);                                                               // Return boolean opposite of checkDependency method, true if A and B are independent
    }

    public BigDecimal binomialDistribution(int n, int y, double p, double q) {                                         // Method to calculate binomial distribution based on Book Definition
        BigDecimal binA = new BigDecimal(combination(n, y)).multiply(BigDecimal.valueOf(Math.pow(p, y)));              // Creates new BigDecimal binomial1 with combination method for n chooose y mutiplied by (p^y), the reason for BigDecimal coversion is due to p^y mutiplying combination(n, y), which is a BigInteger and causes an error)
        BigDecimal binB = BigDecimal.valueOf(Math.pow(q, (n - y)));                                                    // Creates BigDecimal binomial2 for (q^n-y), which is a double that is converted to BigDecimal using valueOf command to allow for the following mutplication of binomial1 and binomial2, which are now both BigDecimal variables
        BigDecimal distributionPy = binA.multiply(binB);                                                               // Creates BigDecimal distributionPy using the binomial distribution formula, converting (p^y) and (q^(n-y)) to BigDecimal variables without error from BigInteger
        BigDecimal binDist = distributionPy.setScale(2, RoundingMode.HALF_UP);                                // Creates BigDecimal binDist to round the distributionPy to 2 decimal places, rounding up last digit if its 5
        return binDist;                                                                                                // returns binDist
    } 
    
    public Double geometricDistribution(int y, double p, double q) {                                                                               // Method to calculate geometric distribution based on Book Definition
        double geo = Math.pow(q, (y - 1)) * p;                                                                                                     // Creates double for the geometric distribution 
        if (y < 0) {                                                                                                                               // If y is less than 0
            System.out.println("Y is the number trials so it must be greater than 0 trials");                                                    // Informs if y is less than 0 
            return null;                                                                                                                           // Returns null                    
        }
        else if (p < 0 || q < 0 || p > 1 || q > 1 || p + q != 1) {                                                                                 // If p and q arent in between 0 and 1 or if p + q doesnt equal 1
            System.out.println("P, the success probability, and Q, failure probability, both should be between 0 & 1, both added to equal 1");   // Informs if p or q is less than 0 
            return null;                                                                                                                           // returns null
        }
        else{                                                                                                                                      // else 
            return geo;                                                                                                                            // returns geometric distribution geo
        }
    }                                                                                                                         

    public BigInteger hyperGeometricDistribution(int r, int y, int N, int n) {                                                                                                             // Method to calculate hypergeometric distribution based on Book Definition
        BigInteger geoA = combination(r, y).multiply(combination(N - r, n - y));                                                                                                           // Creates BigInteger for hypergeometric distribution numerator using combination method for n choose y multiplied by N - r choose n - y
        BigInteger geoB = combination(N, n);                                                                                                                                               // Creates BigInteger for hypergeometric distribution denominator using combination
        BigInteger hyper = geoA.divide(geoB);                                                                                                                                              // Creates BigInteger for the hypergeometric distribution by dividing geoA by geoB
        if (y > r || y > n) {
            System.out.println("Y, number of sample successes shouldnt be greater than n, the sample space, or r, number of population successes ");                                     // Informs if y is greater than n or r 
            return null;                                                                                                                                                                   // Returns null                 
        }
        else if (r < 0 || y < 0 || N < 0 || n < 0) {
            System.out.println("R, the number of population successes, Y, the number of sample successes, N, the population size, and n, the sample size, should be greater than 0");    // Informs if r, y, N, or n is less than 0 
            return null;                                                                                                                                                                   // Returns null
        }
        else if (n > N || r > N) {
            System.out.println("n, the sample size, and r, the number of population successes, should not be greater than N, the population size");                                      // Informs if n or r is greater than N
            return null;                                                                                                                                                                   // Returns null
        }
        else {
            return hyper;                                                                                                                                                                  // Returns hypergeometric distribution
        }
    }

    public BigDecimal negativeBinomialDistribution(int y, int r, double p, double q) {                            // Method to calculate negative binomial distribution based on Book Definition
        BigDecimal negA = new BigDecimal(combination(y - 1, r - 1));                                              // Creates BigDecimal for y -1 choose r - 1 part of the negative binomial distribution formula
        BigDecimal negB = BigDecimal.valueOf(Math.pow(p, r)).multiply(BigDecimal.valueOf(Math.pow(q, y - r)));    // Creates BigDecimal for p^r * q^(y-r) part of the negative binomial distribution formula
        BigDecimal negativeBin = negA.multiply(negB);                                                             // Creates BigDecimal for the negative binomial distribution by multiplying negA and negB
        BigDecimal negBinResult = negativeBin.setScale(2, RoundingMode.HALF_UP);                         // Creates BigDecimal for the negative binomial distribution rounded to 2 decimal places, rounding up if necessary
        return negBinResult;                                                                                      // Returns negative binomial distribution
    }
}