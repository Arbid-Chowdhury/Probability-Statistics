package BirthdayProg;

public class Daytester {
    public static void main(String[] args) {   
        int classSize = 33;                                     // Set the accurate Stats class size
        int runs = 10000;                                       // Set the runs to 10,000
        Birthday test = new Birthday(classSize, runs);          // Create new Birthday object using Size and Runs 
        test.bdayFinder();                                      // Tests probability of shared birthdays in class using bdayFinder method
    }
}