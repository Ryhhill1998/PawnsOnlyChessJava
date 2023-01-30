public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(2, 6, 2, 5);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(2, 1, 2, 2);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(6, 6, 6, 4);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(2, 2, 2, 4);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(4, 0, 4, 2);
        System.out.println(game.getGameBoard());
    }
}