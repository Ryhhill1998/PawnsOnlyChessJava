import java.util.ArrayList;
import java.util.Arrays;

public abstract class Pawn {

    private String colour;
    private String symbol;
    private int xPosition;
    private int yPosition;
    private int directionMultiplier;
    private boolean hasMoved;

    public Pawn(String colour, String symbol, int xPosition, int yPosition, int directionMultiplier) {
        this.colour = colour;
        this.symbol = symbol;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.directionMultiplier = directionMultiplier;
        hasMoved = false;
    }

    public String getColour() {
        return colour;
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
                xPosition = coordinates[0];
                yPosition = coordinates[1];
                hasMoved = true;
                break;
            }
        }

        return moveAllowed;
    }

    private ArrayList<int[]> getPossibleMoves(Board board) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        
        int[] coordinates = new int[2];

        if (board.spaceIsFree(xPosition, yPosition + directionMultiplier)) {
            coordinates[0] = xPosition;
            coordinates[1] = yPosition + directionMultiplier;
            possibleMoves.add(coordinates);

            coordinates = new int[2];

            if (!hasMoved && board.spaceIsFree(xPosition, yPosition + (2 * directionMultiplier))) {
                coordinates[0] = xPosition;
                coordinates[1] = yPosition + (2 * directionMultiplier);
                possibleMoves.add(coordinates);
            }
        }

        coordinates = new int[2];

        // right take
        int x = xPosition - directionMultiplier;
        int y = yPosition + directionMultiplier;

        if (takeIsPossible(board, x, y)) {
            coordinates[0] = x;
            coordinates[1] = y;
            possibleMoves.add(coordinates);
        }

        // left take
        x = xPosition + directionMultiplier;
        y = yPosition + directionMultiplier;

        coordinates = new int[2];

        if (takeIsPossible(board, x, y)) {
            coordinates[0] = x;
            coordinates[1] = y;
            possibleMoves.add(coordinates);
        }

        return possibleMoves;
    }

    private boolean takeIsPossible(Board board, int x, int y) {
        boolean isPossible = false;

        Pawn pawnAtPosition = board.getPawnAtPosition(x, y);

        if (pawnAtPosition != null && !pawnAtPosition.getColour().equals(colour)) {
            isPossible = true;
        }

        return isPossible;
    }
}
