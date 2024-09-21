import java.util.Scanner;

public class Main {
   
	// Method to create a player based on user input
    public static Player createPlayer(char player){
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter name for Player
        System.out.println("Enter name of Player " + player +": ");
        String name = scanner.nextLine();

        // Prompt user to enter attributes for Player
        System.out.println("Enter attributes for Player " + player + " - ");

        System.out.println("Health: ");
        int health = scanner.nextInt();

        System.out.println("Strength: ");
        int strength = scanner.nextInt();

        System.out.println("Attack: ");
        int attack = scanner.nextInt();
    	
        System.out.println();

        // Returning a new Player with the provided attributes
        return new Player(name, health, strength, attack);
    }
    // Main method (entry of program)
    public static void main(String[] agrs){
        // Creating two players
        Player playerA = createPlayer('A');
        Player playerB = createPlayer('B');
        
        // Creating a Game with the above players
        Game game = new Game(playerA, playerB);

        // Starting a Game using start method from Game's class
        game.start();
    }
}
