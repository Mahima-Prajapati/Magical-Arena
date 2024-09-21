public class Game {
    private Player playerA;
    private Player playerB;
    
    //Constructor of Game class
    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void start() {
    	// Determining the initial attacker and defender based on their health
    	Player attacker = (playerA.getHealth() <= playerB.getHealth()) ? playerA : playerB;
        Player defender = (attacker == playerA) ? playerB : playerA;
        
        System.out.println("\n-----------Starting the Game between " + this.playerA.getName() + " - " + this.playerB.getName() + "------------");
        
        int rounds = 0;
        
        while (playerA.isAlive() && playerB.isAlive()) {
        	pause();
            System.out.println("\nRound Number : " + ++rounds + " Started\n");
            attack(attacker, defender);

            // Swaping attacker and defender for the next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        
        // Determine the winner and looser of the Game
        Player winner = playerA.isAlive() ? playerA : playerB;
        Player looser = (winner==playerA) ? playerB : playerA;

        System.out.println("\n\n-------------GAME OVER-------------------\n");

        // Showing the results of Game
        System.out.println("Winner: " + winner.getName());
        System.out.println("Looser: "+ looser.getName());
        System.out.println("Rounds Taken: "+rounds);
    }
    
    // Method to handle an attack between two players
    public void attack(Player attacker, Player defender) {
    	System.out.println(attacker.getName() + " is the attacker and " + defender.getName() + " is the defender");
        int attackDamage = attacker.calculateAttackDamage();
        int defendStrength = defender.calculateDefendStrength();

        int damageTaken = (attackDamage - defendStrength >= 0) ? (attackDamage - defendStrength) : 0;
        System.out.println(attacker.getName() + ": Damaging " + defender.getName() + " with: " + damageTaken);

        defender.receiveDamage(damageTaken); // Apply damage to the defending player
        
        System.out.println(defender.getName() + ": Remaining Health: " + defender.getHealth());
    }

    public void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Do nothing if unable to sleep
        }
    }
}
