public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(2, 6, 2, 4);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(3, 1, 3, 3);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(2, 4, 3, 3);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(1, 1, 1, 3);
        System.out.println(game.getGameBoard());

        System.out.println();
        game.movePawn(3, 3, 3, 2);
        System.out.println(game.getGameBoard());
    }
}