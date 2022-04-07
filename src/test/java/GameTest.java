import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testInitializeBoard() {
        assertNotNull(game.getBoard());
    }

    @Test
    void testNewGameIsNotOver() {
        assertFalse(game.isGameOver());
    }

    @Test
    void testFullBoardIsGameOver() throws Exception {
        game.board.makeMove(0,0, Move.Circle);
        game.board.makeMove(0,1, Move.Circle);
        game.board.makeMove(0,2, Move.Circle);
        game.board.makeMove(1,0, Move.Circle);
        game.board.makeMove(1,1, Move.Circle);
        game.board.makeMove(1,2, Move.Circle);
        game.board.makeMove(2,0, Move.Circle);
        game.board.makeMove(2,1, Move.Circle);
        game.board.makeMove(2,2, Move.Circle);

        assertTrue(game.board.isFull());
        assertTrue(game.isGameOver());
    }

    @Test
    void testFirstColumnFilledMeansGameOver() throws Exception {
        game.board.makeMove(0,0, Move.Circle);
        game.board.makeMove(0,1, Move.Circle);
        game.board.makeMove(0,2, Move.Circle);

        assertTrue(game.isGameOver());
    }
}
