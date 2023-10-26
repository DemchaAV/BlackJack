import java.util.Scanner;

class Run {
    public static void main(String[] args) {
        boolean game = true;
        String key;
        boolean gameInProcess = false;
        NewGame newGame = new NewGame();

        System.out.println("WELCOME TO THE GAME");
        while (game) {

            System.out.println("Type \"S\" to start game,  \"Q\" to Quite");
//            key = in.nextLine().toLowerCase();
            key = "s";
            switch (key) {
                case "s" -> {
                    System.out.println("Type the Amount of Players:");
//                    int players = in.nextInt();
                    int players = 2;
//                    newGame = registration(players);
                    newGame = new NewGame(players);
                    newGame.getPlayer(1).setName("Artem");
                    newGame.getPlayer(2).setName("Ivan");
                    newGame.getPlayer(1).setBalance(466);
                    newGame.getPlayer(2).setBalance(456);
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
        System.out.print("Type \"d\" to Drop the cards\"q\"  quite: ");
        while (gameInProcess) {
//            Scanner scanner = new Scanner(System.in);
//            key = scanner.nextLine().toLowerCase();
            key = "d";
            switch (key) {
                case "d" -> {
                    newGame.firstDropCard();
                    StartGame.inProgress(newGame, gameInProcess);
                    System.out.println(newGame.rules.scoring(1));

                }
                case "q" -> {
                    gameInProcess = false;
                    StartGame.gameOver();
                }
            }
            gameInProcess = newGame.next(2);
            gameInProcess = false;


        }

        System.out.println(newGame.rules.isBlackJack(1));
newGame.deck.getDeckView();
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
            System.out.println("Type your wallet ");
            int wallet = scanner.nextInt();
            newGame.getPlayer(i).setBalance(wallet);
        }
        return newGame;
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
