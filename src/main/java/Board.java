public class Board {
    final static int WIDTH = 3;
    final static int HEIGHT = 3;

    Move moves[][] = new Move[WIDTH][HEIGHT];

    public boolean isEmpty() {
        boolean empty = true;
        for (Move[] row : moves) {
            for(Move move: row) {
                if(move == Move.Circle || move == Move.Cross){
                    empty = false;
                }
            }
        }
        return empty;
    }

    public void makeMove(int column, int row, Move move) throws Exception {
        checkIfTileIsOccupied(column, row);

        moves[column][row] = move;
    }

    private void checkIfMoveOutsideOfTheBoard(int column, int row) throws MoveOutsideOfTheBoardException {
        if(row >= HEIGHT ||  row < 0 || column >= WIDTH || column < 0) {
            throw new MoveOutsideOfTheBoardException();
        }
    }

    private void checkIfTileIsOccupied(int column, int row) throws TileOccupiedException, MoveOutsideOfTheBoardException {
        if(get(column, row) != null) {
            throw new TileOccupiedException();
        }
    }

    public Move get(int column, int row) throws MoveOutsideOfTheBoardException {
        checkIfMoveOutsideOfTheBoard(column, row);
        return moves[column][row];
    }

    public boolean isFull() {
        boolean full = true;
        for (Move[] row : moves) {
            for(Move move: row) {
                if(move == null) {
                    full = false;
                }
            }
        }
        return full;
    }
}
