package PokemonBattler;

public class Stadium {                                                          
    
    public void battle(Pikachu p1, Charmander p2) {                             // method for battle 
        while(p1.getHp() > 0 && p2.getHp() > 0) {                               // loop until a Pokemon is knocked out
            if(p1.getSpeed() > p2.getSpeed()) {                                 // if p1's speed is greater than p2's speed
                damageTurns(p1, p2);
                if (p1.getHp() <= 0) {                                          // if p1's hp is 0 or below   
                    System.out.println("BigPika is knocked out");             // prints p1 is knocked out
                    break;                                                      // break
                }
                else if(p2.getHp() <= 0) {                                      // if p2's hp less than or equal to 0      
                    System.out.println("BigChar is knocked out");             // prints p2 is knocked out
                    break;                                                      // break   
                }   
            }
            else if(p2.getSpeed() > p1.getSpeed()) {                            // if p2's speed is greater than p1's speed
                damageTurns(p2, p1);
                if (p1.getHp() <= 0) {                                          // if p1's hp is 0 or below
                    System.out.println("BigPika is knocked out");             // prints p1 is knocked out
                    break;                                                      // break
                }
                else if (p2.getHp() <= 0) {                                     // if p2's hp less than or equal to 0      
                    System.out.println("BigChar is knocked out");             // prints p2 is knocked out
                    break;                                                      // break    
                }   
            }
        }
    }

    private void damageTurns(Pokemon p1, Pokemon p2) {                          // method for Pokemon damage
        if(p2.getDefense() > p1.getAttack()) {                                  // if p2's defense is greater than p1's attack
            p2.setHp(p2.getHp());                                               // p2's hp is not affected
        }
        else if(p1.getDefense() > p2.getAttack()) {                             // if p1's defense is greater than p2's attack
            p1.setHp(p1.getHp());                                               // p1's hp is not affected
        }
        else {
            p2.setHp((p2.getHp() + p2.getDefense()) - p1.getAttack());          // p1 attacks p2, p2 hp is protected by the defense when the attack damage is taken
            p1.setHp((p1.getHp() + p1.getDefense()) - p2.getAttack());          // p2 attacks p1, p1 hp is protected by the defense when the attack damage is taken
        }
    }
}