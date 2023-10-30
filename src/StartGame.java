import java.util.InputMismatchException;
import java.util.Scanner;

class Run {
    public void run (){
        boolean game = true;
        String key;
        boolean gameInProcess = false;
        NewGame newGame = new NewGame();
        System.out.println("WELCOME TO THE GAME");
        while (game) {
            System.out.println("Type \"s\" to start the  game,  \"q\" to quit");
            Scanner in = new Scanner(System.in);
            key = in.nextLine().toLowerCase();
            switch (key) {
                case "s" -> {
                    System.out.println("Type the number of Players:");
                    int players = 0;
                    players = StartGame.numScanner();
                    newGame = StartGame.registration(players);
                    gameInProcess = true;
                    game = false;
                }
                case "q" -> game = false;
            }

        }
        if (gameInProcess) {
            System.out.println("Game has started!");
            for (int i = 1; i < newGame.getAmountPlayers(); i++) {
                System.out.println("--------------------");
                System.out.println(newGame.getPlayer(i).toString() + " ");
                System.out.println("--------------------");
            }
        }
        System.out.print("Type \"d\" to deal the cards \"q\"  to quit: ");
        while (gameInProcess) {
            Scanner scanner = new Scanner(System.in);
            key = scanner.nextLine().toLowerCase();
            switch (key) {
                case "d" -> {
                    newGame.firstDropCard();
                    StartGame.inProgress(newGame, gameInProcess);
                }
                case "q" -> {
                    gameInProcess = false;
                    StartGame.gameOver();
                }
            }
            newGame.doBets();
            newGame.print(1);
            gameInProcess = newGame.next(2);
            newGame.wonGame();
            gameInProcess = false;
            System.out.println("Type \"c\" to continue the game or \"q\" to quit: ");
            key = scanner.nextLine().toLowerCase();
            switch (key) {
                case "c" -> {
                    gameInProcess = true;
                    newGame.newRound();
                    System.out.print("Type \"d\" to deal the cards \"q\"  to quit: ");
                }
                case "q" -> gameInProcess = false;

            }


        }
    }
}

public class StartGame {

    static NewGame registration(int players) {
        NewGame newGame = new NewGame(players);
        for (int i = 1; i < newGame.getAmountPlayers(); i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type Name of player № " + i);
            String name = scanner.nextLine();
            newGame.getPlayer(i).setName(name);
            System.out.println("Type your wallet balance ");
            int wallet = numScanner();
            newGame.getPlayer(i).setBalance(wallet);
        }
        return newGame;
    }

    public static int numScanner() {
        int number = 0;
        boolean validInput = false;
        Scanner in = new Scanner(System.in);

        while (!validInput) {
            try {
                number = in.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please try again, numbers only! ");
                in.nextLine();
            }
        }

        return number;
    }


    static void inProgress(NewGame newGame, boolean gameInProcess) {
        while (gameInProcess) {
            System.out.println();
            System.out.println();
            System.out.println("Game has started!");
            newGame.printInfoPlayers();
            newGame.printInfoCardPool();
            newGame.printInfoDealer(1);
            gameInProcess = false;
        }

    }

    static void gameOver() {
        System.out.println("Game over!");
    }


}
