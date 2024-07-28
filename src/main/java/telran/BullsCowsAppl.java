package telran;

import java.util.List;
import java.util.Scanner;

public class BullsCowsAppl {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BullsCowsService service = new BullsCowsMapImpl();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    showResults();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Start New Game");
        System.out.println("2. Show Results");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void startNewGame() {
        Long gameId = service.createNewGame();
        System.out.println("New game started. Game ID: " + gameId);

        boolean gameRunning = true;
        while (gameRunning) {
            System.out.print("Enter your move (4 non-repeated digits): ");
            String move = scanner.nextLine();
            Move moveObj = new Move(gameId, move);
            List<MoveResult> results = service.getResults(gameId, moveObj);
            results.forEach(result -> {
                System.out.println("Move: " + result.getClientSequence() +
                        ", Bulls: " + result.getBulls() +
                        ", Cows: " + result.getCows());
            });

            if (service.isGameOver(gameId)) {
                System.out.println("Game Over! You guessed the sequence.");
                gameRunning = false;
            }
        }
    }

    private static void showResults() {
        //TODO Not yet implemented
        System.out.println("Show Results functionality not implemented.");
    }
}