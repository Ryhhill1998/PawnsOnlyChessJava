public class Board {

    private String[][] gameBoard;

    public Board() {
        gameBoard = new String[8][8];
    }

    public boolean addPiece(String symbol, int x, int y) {
        return true;
    }

    public boolean spaceIsFree(int x, int y) {
        return gameBoard[y][x].equals(" ");
    }
}
