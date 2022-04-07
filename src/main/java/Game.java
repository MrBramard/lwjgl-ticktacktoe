public class Game {
    Board board;

    public Game() {
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        boolean gameOver = false;
        if(board.isFull()) {
            gameOver = true;
        }
        return gameOver;
    }
}
