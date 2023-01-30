public class Board {

    public static final int BOARD_SIZE = 8;

    private Pawn[][] gameBoard;

    public Board() {
        gameBoard = new Pawn[BOARD_SIZE][BOARD_SIZE];
    }

    public boolean addPawn(Pawn pawnToAdd) {
        boolean pieceAdded = false;
        int x = pawnToAdd.getPositionX();
        int y = pawnToAdd.getPositionY();

        if (spaceIsFree(x, y)) {
            gameBoard[y][x] = pawnToAdd;
            pieceAdded = true;
        }

        return pieceAdded;
    }

    public boolean spaceIsFree(int x, int y) {
        return gameBoard[y][x] == null;
    }

    public Pawn getPawnAtPosition(int x, int y) {
        return gameBoard[y][x];
    }

    public boolean movePawn(int x, int y, int newX, int newY) {
        boolean pawnMoved = false;

        if (spaceIsFree(newX, newY)) {
            Pawn pawn = gameBoard[y][x];
            gameBoard[y][x] = null;
            gameBoard[newY][newX] = pawn;
        }

        return pawnMoved;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("      0     1     2     3     4     5     6     7\n");

        for (int i = 0; i < BOARD_SIZE; i++) {
            output.append("   +-----+-----+-----+-----+-----+-----+-----+-----+\n");

            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == 0) {
                    output.append(i).append("  |  ");
                }

                if (gameBoard[i][j] == null) {
                    output.append(" ");
                } else {
                    output.append(gameBoard[i][j].getSymbol());
                }

                output.append("  |  ");
            }

            output.append("\n");
        }

        output.append("   +-----+-----+-----+-----+-----+-----+-----+-----+\n");
        return output.toString();
    }
}
