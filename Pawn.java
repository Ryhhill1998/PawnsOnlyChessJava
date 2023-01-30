import java.util.ArrayList;

public abstract class Pawn {

    private String colour;
    private String symbol;
    private int xPosition;
    private int yPosition;
    private int directionMultiplier;

    public Pawn(String colour, String symbol, int xPosition, int yPosition, int directionMultiplier) {
        this.colour = colour;
        this.symbol = symbol;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.directionMultiplier = directionMultiplier;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPositionX() {
        return xPosition;
    }

    public int getPositionY() {
        return yPosition;
    }

    public boolean move(Board board, int x, int y) {
        ArrayList<int[]> possibleMoves = getPossibleMoves(board);
        boolean moveAllowed = false;

        for (int[] coordinates : possibleMoves) {
            if (coordinates[0] == x && coordinates[1] == y) {
                moveAllowed = true;
                break;
            }
        }

        return moveAllowed;
    }

    public ArrayList<int[]> getPossibleMoves(Board board) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        
        int[] coordinates = new int[2];

        if (board.spaceIsFree(xPosition, yPosition + directionMultiplier)) {
            coordinates[0] = xPosition;
            coordinates[1] = yPosition;
            possibleMoves.add(coordinates);
        }

        return possibleMoves;
    }
}
