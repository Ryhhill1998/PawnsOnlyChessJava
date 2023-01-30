import java.util.ArrayList;

public class Game {

    private static final int MAX_PIECES = 16;

    private Board board;
    private ArrayList<WhitePawn> whitePawns;
    private ArrayList<BlackPawn> blackPawns;

    public Game() {
        board = new Board();
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
        initialiseBoard();
    }

    public void initialiseBoard() {
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
        BlackPawn blackPawn = new BlackPawn(x, y);
        blackPawns.add(blackPawn);
        board.addPawn(blackPawn);
    }

    private void createWhitePawn(int x, int y) {
        WhitePawn whitePawn = new WhitePawn(x, y);
        whitePawns.add(whitePawn);
        board.addPawn(whitePawn);
    }

    public String getGameBoard() {
        return board.toString();
    }
}
