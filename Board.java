public class Board {

    private String[][] gameBoard;

    public Board() {
        gameBoard = new String[8][8];
    }

    public String stringifyBoard() {
        
    }

    public boolean addPiece(String symbol, int x, int y) {
        boolean pieceAdded = false;

        if (spaceIsFree(x, y)) {
            gameBoard[y][x] = symbol;
            pieceAdded = true;
        }

        return pieceAdded;
    }

    public boolean spaceIsFree(int x, int y) {
        return gameBoard[y][x].equals(" ");
    }
}
