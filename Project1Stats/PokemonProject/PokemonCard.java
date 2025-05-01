package PokemonProject;

public class PokemonCard extends Card implements CardGuide, PokemonGuide {                   // PokemonCard class that extends Card superclass and implements the CardGuide and PokemonGuide interfaces
    private int hp;                                                                          // private int hp
    private String normalAttackName;                                                         // private String normalAttackName                         
    private int normalAttackDamage;                                                          // private int normalAttackDamage
    private String specialMoveName;                                                          // private String specialMoveName
    private int specialMoveDamage;                                                           // private int specialMoveDamage             
    private String type;                                                                     // private String type             
    private String weakTo;                                                                   // private String weakTo         
    private String evolveInto;                                                               // private String evolveInto
    private boolean isEvolved;                                                               // private boolean isEvolved
    
    public PokemonCard(String name, int hp, String normalAttackName, int normalAttackDamage, String specialMoveName, int specialMoveDamage, String type, String weakTo, String evolveInto, boolean isEvolved) {   // Constructor for PokemonCard
        super(name);                                                                                                                                                                                              // Calls the Card constructor to set the name
        this.hp = hp;                                                                                                                                                                                             // sets the hp
        this.normalAttackName = normalAttackName;                                                                                                                                                                 // sets the normalAttackName                  
        this.normalAttackDamage = normalAttackDamage;                                                                                                                                                             // sets the normalAttackDamage                     
        this.specialMoveName = specialMoveName;                                                                                                                                                                   // sets the specialMoveName            
        this.specialMoveDamage = specialMoveDamage;                                                                                                                                                               // sets the specialMoveDamage
        this.type = type;                                                                                                                                                                                         // sets the type           
        this.weakTo = weakTo;                                                                                                                                                                                     // sets the weakTo         
        this.evolveInto = evolveInto;                                                                                                                                                                             // sets the evolveInto   
        this.isEvolved = isEvolved;                                                                                                                                                                               // sets if isEvolved 
    }

    public int getHp() {                                                // getter method for hp            
        return hp;                                                      // Return hp      
    }

    public void setHp(int hp) {                                         // setter method for hp
        this.hp = hp;                                                   // sets the hp         
    }

    public String getNormalAttack() {                                   // getter method for normalAttackName          
        return normalAttackName;                                        // Return normalAttackName         
    }

    public int getNormalAttackDamage() {                                // getter method for normalAttackDamage         
        return normalAttackDamage;                                      // Return normalAttackDamage
    }

    public String getSpecialMove() {                                    // getter method for specialMoveName        
        return specialMoveName;                                         // Return specialMoveName
    }   

    public int getSpecialMoveDamage() {                                 // getter method for specialMoveDamage           
        return specialMoveDamage;                                       // Return specialMoveDamage           
    }

    public String getType() {                                           // getter method for type      
        return type;                                                    // Return type         
    }

    public String getWeakness() {                                       // getter method for weakness
        return weakTo;                                                  // Return weakTo         
    }

    public String getEvolvesTo() {                                      // getter method for what it evolves into 
        return evolveInto;                                              // Return evolveInto
    }

    public boolean getIfEvolved() {                                     // getter method for if evolved
        return isEvolved;                                               // Return isEvolved
    }

    public boolean checkDamageType(int damageType) {                    // checkDamageType method to check if damageType is 1 or 2
        return damageType == 1 || damageType == 2;                      // Return true if damageType is 1 or 2
    }

    private boolean pokemonWeakenedBy(PokemonCard enemy) {              // pokemonWeakenedBy method to check if enemy is weak to this PokemonCard
        return enemy.getType().equals(getWeakness());                   // Return true if pokemon is weak to enemy
    }

    private boolean pokemonSuperiorTo(PokemonCard enemy) {              // pokemonSuperiorTo method to check if this PokemonCard is superior to enemy
        return enemy.getWeakness().equals(getType());                   // Return true if pokemon is superior to enemy
    }

    private void takeDamage(PokemonCard enemy, int attackDamage) {      // takeDamage method for enemy taking damage
        enemy.setHp(enemy.getHp() - attackDamage);                      // enemy hp is subtracted by attackDamage
    }

    private void weakenedAttackDamage(PokemonCard enemy, int attackDamage) {    // weakenedAttackDamage method for weakened attack damage
        takeDamage(enemy, attackDamage  - 20);                                  // enemy takes 20 less attackDamage          
    }

    private void boostedAttackDamage(PokemonCard enemy, int attackDamage) {     // boostedAttackDamage method for boosted attack damage
        takeDamage(enemy, attackDamage + 30);                                   // enemy takes 30 more attackDamage 
    }

    public void vitalizePoke(int heals) {                                       // vitalizePoke method to heal PokemonCard utiiized in UltraPotiom class and used in the activateTrainer method
        hp += heals;                                                            // hp gets boosted by heals
    }

    public boolean pokemonDefeated() {                                          // pokemonDefeated method to check if PokemonCard is defeated
        return hp <= 0;                                                         // Return true if hp is less than/equal to 0
    }

    @Override                                                                   // Overrides the playCard method from the Card superclass
    public void playCard() {
        System.out.println(getCardName() + " is played on the field");          // prints out card name is played on the field
    }

    @Override                                                                   // Overrides the attackCharge method from the PokemonGuide interface
    public void attackCharge() {
        System.out.println(getCardName() + " is charging an attack");           // prints out that the PokemonCard is charging an attack which is overriden in each Pokemon's unqiue attackCharge method
    }

    @Override                                                                                                                                       // Overrides the damageEnemy method from the PokemonGuide interface
    public void damageEnemy(int damageType, PokemonCard enemy) {                        
        switch (damageType) {                                                                                                                       // switch statement for damageType player input             
            case 1:                                                                                                                                 // case 1 for Normal attack              
                if (pokemonWeakenedBy(enemy)) {                                                                                                     // if statement to check if enemy is weak to this PokemonCard
                    weakenedAttackDamage(enemy, getNormalAttackDamage());                                                                           // weakenedAttackDamage method used to have reduced attack damage
                    System.out.println(getCardName() + " attacks " + enemy.getCardName() + " using " + getNormalAttack() + " - damage weakened");   // prints out the activePokemon is attacking using normalAttack with lessened damage
                }
                else if (pokemonSuperiorTo(enemy)) {                                                                                                // else if statement to check if this PokemonCard is superior to enemy
                    boostedAttackDamage(enemy, getNormalAttackDamage());                                                                            // boostedAttackDamage method used to have increased attack damage                 
                    System.out.println(getCardName() + " attacks " + enemy.getCardName() + " using " + getNormalAttack() + " - damage boosted");    // prints activePokemon is attacking using normalAttack with increased damage
                }
                else {                                                                                                                              // else if types are not weak or superior to each other
                    takeDamage(enemy, getNormalAttackDamage());                                                                                     // takeDamage method used to do normal attack damage
                    System.out.println(getCardName() + " attacks " + enemy.getCardName() + " with " + getNormalAttack());                           // prints out the activePokemon is attacking using normalAttack
                }
                break;                                                                                                                              // break              

            case 2:                                                                                                                                 // case 2 for Special attack, repeating same logic as case 1 but using specialMove instead of normalAttack
                if (pokemonWeakenedBy(enemy)) {                                                                                                     // if statement to check if enemy is weak to this PokemonCard
                    weakenedAttackDamage(enemy, getSpecialMoveDamage());                                                                            // weakenedAttackDamage method callled to have reduced attack damage
                    System.out.println(getCardName() + " attacks " + enemy.getCardName() + " using " + getSpecialMove() + " - damage weakened");    // prints out the activePokemon is attacking using specialMove with lessened damage
                }
                else if (pokemonSuperiorTo(enemy)) {                                                                                                // else if statement to check if this PokemonCard is superior to enemy
                    boostedAttackDamage(enemy, getSpecialMoveDamage());                                                                             // boostedAttackDamage method is used to have increased attack damage
                    System.out.println(getCardName() + " attacks " + enemy.getCardName() + " using " + getSpecialMove() + " - damage boosted");     // prints out the activePokemon is attacking using specialMove with increased damage
                }
                else {                                                                                                                              // else if types are not weak or superior to each other                                         
                    takeDamage(enemy, getSpecialMoveDamage());                                                                                      // takeDamage method used to do special attack damage
                    System.out.println(getCardName() + " attacks " + enemy.getCardName() + " with " + getSpecialMove());                            // prints activePokemon is attacking using specialMove
                }
            break;                                                                                                                                  // break 
        }
    }

    @Override                                                                                                                                       // Overrides the evolver method from the PokemonGuide interface
    public void evolver(Player player, PokemonCard pokemon2, int choice) {                                                                          // evolver method to evolve PokemonCard in either active or bench
        if (getEvolvesTo().equals(pokemon2.getCardName())) {                                                                                        // if statement to check if this PokemonCard evolves other PokemonCard
            System.out.println(getCardName() + " is evolving to " + pokemon2.getCardName());                                                        // prints out that this PokemonCard has evolved into the PokemonCard passed in the parameter 
            if (choice == 1) {                                                                                                                      // if choice is 1
                player.removeCardHand(pokemon2);                                                                                                    // the evolved PokemonCard is removed from the hand
                player.discardCard(player.getActive());                                                                                             // player discards the active PokemonCard
                player.setActive(pokemon2);                                                                                                         // pokemon2 is set as the active PokemonCard
            }                                                                                                                                   
            else if (choice == 2) {                                                                                                                 // else if choice is 2
                player.removeCardBench(this);                                                                                                       // the evolved PokemonCard is removed from the bench
                player.discardCard(this);                                                                                                           // player discards this PokemonCard
                player.addBench(pokemon2);                                                                                                          // pokemon2 is set as the active PokemonCard
            }
        }
    }
}