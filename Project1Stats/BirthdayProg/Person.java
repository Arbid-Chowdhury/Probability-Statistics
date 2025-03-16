package BirthdayProg;

public class Person {                           // Person class
    private int bday;                           // Intialize int birthday

    public Person(int bday) {                   // Constructor for Person birthday
        this.bday = bday;                       // Set birthday to bday
    }

    public int getBirthday() {                  // Getter for birthday
        return bday;                            // Return bday
    }
}