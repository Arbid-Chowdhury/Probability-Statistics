package PokemonBattler;

public class Pokemon {
    private int hp;                                    // Intializes private hp for Pokemon superclass
    private int attack;                                // Intializes private attack for Pokemon superclass
    private int defense;                               // Intializes private defense for Pokemon superclass
    private int spAttack;                              // Intializes private spAttack for Pokemon superclass (not used but used for giving pokemon full stats)
    private int speed;                                 // Intializes private speed for Pokemon superclass

    public int getHp() {                               // the getter for Pokemon hp
        return hp;                                     // returns hp
    }

    public void setHp(int userhp) {                   // the setter for Pokemon hp  
        hp = userhp;                                  // sets hp to userhp parameter
    }

    public int getAttack() {                          // the getter for Pokemon attack
        return attack;                                // returns attack
    }

    public void setAttack(int userAttack) {           // the setter for Pokemon attack
        this.attack = userAttack;                     // sets attack to userAttack parameter
    }

    public int getDefense() {                         // the getter for Pokemon defense
        return defense;                               // returns defense
    }

    public void setDefense(int userDefense) {         // the setter for Pokemon defense
        this.defense = userDefense;                   // sets defense to userDefense parameter
    }

    public int getSpAttack() {                        // the getter for Pokemon spAttack
        return spAttack;                              // returns spAttack
    }

    public void setSpAttack(int userspAttack) {       // the setter for Pokemon spAttack
        this.spAttack = userspAttack;                 // sets spAttack to userspAttack parameter
    }

    public int getSpeed() {                           // the getter for Pokemon speed
        return speed;                                 // returns speed
    }

    public void setSpeed(int userSpeed) {             // the setter for Pokemon speed
        this.speed = userSpeed;                       // sets speed to userSpeed parameter
    }   
}