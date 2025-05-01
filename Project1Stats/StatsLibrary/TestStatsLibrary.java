package StatsLibrary;

import java.util.ArrayList;
import java.util.Collections;

public class TestStatsLibrary {
    public static void main(String[] args) {
        StatsLibrary tester = new StatsLibrary();                                                 // creates a new object tester of the StatsLibrary class
        int[] Numbers = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};                                           // creates Numbers array of ints
        ArrayList<Integer> Numbers2 = new ArrayList<Integer>();                                   // creates an ArrayList of numbers named Numbers2
        Collections.addAll(Numbers2, 9, 10, 11, 12);                                  // adds numbers 9-12 to Numbers2 ArrayList using Collections.addAll command
        ArrayList<Integer> Numbers3 = new ArrayList<Integer>();                                   // creates an ArrayList of numbers named Numbers3
        Collections.addAll(Numbers3, 12, 13, 14, 15);                                 // adds numbers 12-15 to Numbers3 ArrayList using Collections.addAll command
        System.out.println("Mean: " + tester.getMean(Numbers));                                   // calls the getMean method to find the mean for Numbers array
        System.out.println("Median: " + tester.getMedian(Numbers));                               // calls the getMedian method to find the median for Numbers array
        System.out.println("Mode: " + tester.getMode(Numbers));                                   // calls the getMode method to find the mode for Numbers array
        System.out.println("Variance: " + tester.getVariance(Numbers));                           // calls the getVariance method to find the variance for Numbers array
        System.out.println("Standard Deviation: " + tester.getStandDeviation(Numbers));           // calls the getStandardDeviation method to find the standard deviation for Numbers array
        System.out.println();
        System.out.println("Factorial of 5: " + tester.factorial(5));                                                                                     // Prints the factorial of 5
        System.out.println("Combination of n(5) & r(2): " + tester.combination(5, 2));                                                                  // Prints the combination of n = 5 and r = 2 Ex. 2.11 in Book
        System.out.println("Permutation of n(30) & r(3): " +tester.permutation(30, 3));                                                                 // Prints the permutation of n = 8 and r = 4 Ex. 2.8 in Book
        System.out.println();
        System.out.println("Do Numbers2 and Numbers3 have an independent intersection: " + tester.independentIntersection(Numbers2, Numbers3));             // Prints true/false Numbers2 and Numbers3 have independent intersection
        System.out.println("Do Numbers2 and Numbers3 have a dependent intersection: " + tester.dependentIntersection(Numbers2, Numbers3));                  // Prints true/false Numbers2 and Numbers3 have dependent intersection
        System.out.println("Do Numbers2 and Numbers3 have an exclusive union: " + tester.exclusiveUnion(Numbers2, Numbers3));                               // Prints true/false Numbers2 and Numbers3 have an exclusive union
        System.out.println("Do Numbers2 and Numbers3 have a not exclusive union: " + tester.notExclusiveunion(Numbers2, Numbers3));                         // Prints true/false Numbers2 and Numbers3 have a not exclusive union
        System.out.println("What is the probability of Event A's 5 outcomes over its Sample Space of 20: " + tester.checkProbA(5, 20));       // Prints the probability of Event A's 5 outcomes over its Sample Space of 20 
        System.out.println("What is the probability of Event B's 10 outcomes over its Sample Space of 20: " + tester.checkProbB(10, 20));     // Prints the probability of Event B's 10 outcomes over its Sample Space of 20
        System.out.println("Are Events A and B dependent: " + tester.checkDependency(5, 10, 20));                                           // Prints true/false if Events A and B are dependent
        System.out.println("Are Events A and B independent: " + tester.checkIndependence(5, 10, 20));                                       // Prints true/false if Events A and B are independent
        System.out.println();
        System.out.println("Binomial Distribution of n(5), y(0), p(0.05), q(0.95): " + tester.binomialDistribution(5, 0, 0.05, 0.95));                      // Prints the binomial distribution of n = 5, y = 0, p = 0.05, q = 0.95 Ex. 3.7 in Book
        System.out.println("Geometric Distribution of y(3), p(0.30), q(0.70): " + tester.geometricDistribution(3, 0.30, 0.70));                               // Prints the geometric distribution of y = 3, p = 0.30, q = 0.70 (both the binomial and geometric distributions in the book use pmf formula for the answer so if have 1 subtract the output from the test cases, you get the answers in the book)
        System.out.println("Hypergeometric Distribution of r(5), y(5), N(20), n(10): " + tester.hyperGeometricDistribution(5, 5, 20, 10));                  // Prints the hypergeometric distribution of r = 5, y = 5, N = 20, n = 10 Ex. 3.16 in Book
        System.out.println("Negative Binomial Distribution of y(5), r(3), p(0.20), q(0.80): " + tester.negativeBinomialDistribution(5, 3, 0.20, 0.80));     // Prints the negative binomial distribution of y = 5, r = 3, p = 0.20, q = 0.80 Ex. 3.14 in Book
    }                                                                                                                                                 
}
