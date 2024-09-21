import java.util.Random;

public class Game {
    private Player playerA;
    private Player playerB;
    private Random random;
    
    //Constructor of Game class
    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.random = new Random();
    }

    // Starting method of Game
    public void start() {
        System.out.println("\n------------------Starting the Game -------------------");
    	
        // Determining the initial attacker and defender based on their health
    	Player attacker = (playerA.getHealth() <= playerB.getHealth()) ? playerA : playerB;
        Player defender = (attacker == playerA) ? playerB : playerA;
        
        int rounds = 0;
        
        while (playerA.getHealth()>0 && playerB.getHealth()>0) {
        	takeSomeTime();
            System.out.println("\nRound Number : " + ++rounds + " Started\n");
            attack(attacker, defender);

            // Swaping attacker and defender for the next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        
        // Determine the winner and looser of the Game
        Player winner = (playerA.getHealth()>0) ? playerA : playerB;
        Player looser = (winner==playerA) ? playerB : playerA;

        System.out.println("\n\n-------------GAME OVER-------------------\n");

        // Showing the results of Game
        System.out.println("Winner: " + winner.getName());
        System.out.println("Looser: "+ looser.getName());
        System.out.println("Rounds taken: "+rounds);
    }
    
    // Method to handle an attack between two players
    public void attack(Player attacker, Player defender) {
    	System.out.println(attacker.getName() + " is the attacker and " + defender.getName() + " is the defender");

        int attackDamage = calculateAttackDamage(attacker);
        int defendStrength = calculateDefendStrength(defender);

        int damageTaken = (attackDamage - defendStrength >= 0) ? (attackDamage - defendStrength) : 0;
        System.out.println(attacker.getName() + ": Damaging " + defender.getName() + " with: " + damageTaken);

        defender.applyDamage(damageTaken); // Apply damage to the defending player
        
        System.out.println(defender.getName() + ": Remaining Health: " + defender.getHealth());
    }

     // Method for rolling a die
    public int rollDice(String name) {
        int diceValue = random.nextInt(6) + 1;
        System.out.println(name + ": Rolling dice and got dice value = " + diceValue);
        return diceValue; // Return a random integer between 1 and 6
    }

     // Method to calculate the damage done by the player's attack
    public int calculateAttackDamage(Player player) {
        int diceValue = rollDice(player.getName());
        int attackValue = player.getAttackValue() * diceValue;
        System.out.println(player.getName() + ": Attack Value = " + attackValue);
        return attackValue;
    }
    
    // Method to calculate the defense strength of the player
    public int calculateDefendStrength(Player player) {
        int diceValue = rollDice(player.getName());
        int defendValue = player.getStrengthValue() * diceValue;
        System.out.println(player.getName() + ": Defend Value = " + defendValue);
        return defendValue;
    }

    // Method to give some relaxing time between consecutive rounds
    public void takeSomeTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        
        }
    }
}
