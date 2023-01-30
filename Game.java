import java.util.ArrayList;

public class Game {

    private static final int MAX_PIECES = 16;

    private Board board;
    private String turn;

    public Game() {
        board = new Board();
        turn = "white";
        initialiseBoard();
    }

    private void initialiseBoard() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                createBlackPawn(j, i);
            }
        }

        for (int i = 6; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                createWhitePawn(j, i);
            }
        }
    }

    private void createBlackPawn(int x, int y) {
        board.addPawn(new BlackPawn(x, y));
    }

    private void createWhitePawn(int x, int y) {
        board.addPawn(new WhitePawn(x, y));
    }

    public String getGameBoard() {
        return board.toString();
    }

    public boolean movePawn(int x, int y, int newX, int newY) {
        boolean pawnMoved = false;
        Pawn pawnToMove = board.getPawnAtPosition(x, y);

        if (pawnToMove != null && pawnToMove.getColour().equals(turn)) {
            pawnMoved = pawnToMove.move(board, newX, newY);
            if (pawnMoved) {
                board.movePawn(x, y, newX, newY);
                changeTurn();
            }
        }

        return pawnMoved;
    }

    private void changeTurn() {
        turn = turn.equals("white") ? "black" : "white";
    }
}
