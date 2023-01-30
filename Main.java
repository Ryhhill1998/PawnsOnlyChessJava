import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println(game.getGameBoard());
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            System.out.println(game.getTurn() + "'s turn!");

            System.out.print("Enter the x and y coordinates of the piece you wish to move: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.print("Enter the x and y coordinates of the space you wish to move this piece to: ");
            int newX = scanner.nextInt();
            int newY = scanner.nextInt();

            game.movePawn(x, y, newX, newY);

            System.out.println(game.getGameBoard());
            System.out.println();
        }
    }
}