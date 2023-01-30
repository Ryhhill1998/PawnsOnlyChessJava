import java.util.ArrayList;

public class Game {

    private static final int MAX_PIECES = 16;

    private Board board;
    private ArrayList<Pawn> whitePawns;
    private ArrayList<Pawn> blackPawns;

    public Game() {
        board = new Board();
        whitePawns = new ArrayList<>();
        blackPawns = new ArrayList<>();
    }

    public void initialiseBoard() {

    }
}
