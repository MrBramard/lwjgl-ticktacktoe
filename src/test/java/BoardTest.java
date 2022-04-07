import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testNewBoardIsEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    void testAddOneMoveToTheBoard() throws Exception {
        assertTrue(board.isEmpty());
        board.makeMove(0,0, Move.Cross);
        assertEquals(board.get(0,0), Move.Cross);
        assertFalse(board.isEmpty());
    }

    @Test
    void testAddTwoMovesToTheBoard() throws Exception {
        assertTrue(board.isEmpty());
        board.makeMove(0, 0, Move.Cross);
        board.makeMove(0, 1, Move.Circle);
        assertEquals(board.get(0, 0), Move.Cross);
        assertEquals(board.get(0, 1), Move.Circle);
        assertFalse(board.isEmpty());
    }

    @Test
    void testAddMoveOnOtherMoveShouldThrowException() throws Exception {
        board.makeMove(0,0,Move.Cross);
        assertThrows(TileOccupiedException.class,
                () -> board.makeMove(0,0,Move.Circle));
    }

    @Test
    void testAddMoveAnywhereOnTheBoard() throws Exception {
        fillBoard();

        assertEquals(board.get(0, 0), Move.Cross);
        assertEquals(board.get(0, 1), Move.Cross);
        assertEquals(board.get(0, 2), Move.Cross);
        assertEquals(board.get(1, 0), Move.Cross);
        assertEquals(board.get(1, 1), Move.Cross);
        assertEquals(board.get(1, 2), Move.Cross);
        assertEquals(board.get(2, 0), Move.Cross);
        assertEquals(board.get(2, 1), Move.Cross);
        assertEquals(board.get(2, 2), Move.Cross);
    }

    @Test
    void testAddMoveOutsideOfTheBoardShouldThrowException() {
        assertThrows(MoveOutsideOfTheBoardException.class,
                () -> board.makeMove(0,3, Move.Circle));
        assertThrows(MoveOutsideOfTheBoardException.class,
                () -> board.makeMove(0,-1, Move.Circle));
        assertThrows(MoveOutsideOfTheBoardException.class,
                () -> board.makeMove(3, 0, Move.Cross));
        assertThrows(MoveOutsideOfTheBoardException.class,
                () -> board.makeMove(-1, 0, Move.Cross));
        assertThrows(MoveOutsideOfTheBoardException.class,
                () -> board.makeMove(-1, -1, Move.Cross));
        assertThrows(MoveOutsideOfTheBoardException.class,
                () -> board.makeMove(3, 3, Move.Cross));
    }

    @Test
    void testBoardIsFull() throws Exception {
        assertFalse(board.isFull());
        fillBoard();
        assertTrue(board.isFull());
    }

    void fillBoard() throws Exception {
        board.makeMove(0,0,Move.Cross);
        board.makeMove(0,1,Move.Cross);
        board.makeMove(0,2,Move.Cross);
        board.makeMove(1,0,Move.Cross);
        board.makeMove(1,1,Move.Cross);
        board.makeMove(1,2,Move.Cross);
        board.makeMove(2,0,Move.Cross);
        board.makeMove(2,1,Move.Cross);
        board.makeMove(2,2,Move.Cross);
    }
}
