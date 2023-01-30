public class Game {

    private Board board;
    private String turn;
    private boolean gameOver;

    public Game() {
        board = new Board();
        turn = "white";
        gameOver = false;
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

    public String getTurn() {
        return turn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getGameBoard() {
        return board.toString();
    }

    public void movePawn(int x, int y, int newX, int newY) {
        Pawn pawnToMove = board.getPawnAtPosition(x, y);

        if (pawnToMove != null && pawnToMove.getColour().equals(turn)) {
            boolean pawnHasMoved = pawnToMove.move(board, newX, newY);
            if (pawnHasMoved) {
                board.movePawn(x, y, newX, newY);

                changeTurn();

                if (gameIsWon(pawnToMove)) {
                    System.out.println(pawnToMove.getColour() + " wins!");
                    gameOver = true;
                }
            }
        }
    }

    private void changeTurn() {
        turn = turn.equals("white") ? "black" : "white";
    }

    public boolean gameIsWon(Pawn pawnMoved) {
        boolean gameWon;

        if (pawnMoved.getColour().equals("white")) {
            gameWon = whiteHasWon(pawnMoved);
        } else {
            gameWon = blackHasWon(pawnMoved);
        }

        return gameWon;
    }

    private boolean whiteHasWon(Pawn pawnMoved) {
        return pawnMoved.getPositionY() == 0;
    }

    private boolean blackHasWon(Pawn pawnMoved) {
        return pawnMoved.getPositionY() == 7;
    }
}
