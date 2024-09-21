import org.junit.Test;
import static org.junit.Assert.*;

public class JunitTestCases {
    // Give correct winner if Player A is winning
    @Test
    public void testPlayerAWin(){
        Player playerA = new Player("Player A", 5000, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 50);
        Game game = new Game(playerA, playerB);
        game.start();
        assertTrue(playerA.isAlive());
    }

    // Give correct winner if Player B is winning
    @Test
    public void testPlayerBWin(){
        Player playerA = new Player("Player A", 5, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 50);
        Game game = new Game(playerA, playerB);
        game.start();
        assertTrue(playerB.isAlive());
    }
    
}
