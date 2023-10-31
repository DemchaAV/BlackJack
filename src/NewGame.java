import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NewGame {
    private int amountPlayers = 0;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Integer> amoundScore = new ArrayList<>();
    private ArrayList<Integer> beats = new ArrayList<>();
    String separator = "--------------------------  ";
    Deck deck = new Deck();
    Rules rules;

    NewGame() {

    }


    NewGame(int amountPlayers) {
        rules = new Rules(this);
        this.amountPlayers = amountPlayers + 1;
        amoundScore = new ArrayList<>(this.amountPlayers);
        this.players = new ArrayList<>();
        this.beats = new ArrayList<>();
        Player dealer = new Player();
        dealer.setName("Dealer");
        dealer.setBalance(669999990);
        players.add(dealer);
        for (int i = 0; i < amountPlayers; i++) {
            players.add(new Player());
        }

    }

    public ArrayList<Integer> getAmoundScore() {
        return amoundScore;
    }

    public int getAmountPlayers() {
        return amountPlayers;
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> outPlayers = players;
        return outPlayers;
    }

    public void printInfoPlayers() {
        Player player;
        for (int j = 0; j < amountPlayers - 1; j++) {

            System.out.print(separator);
        }

        System.out.println();


        for (int j = 1; j < amountPlayers; j++) {
            player = players.get(j);
            System.out.print(player + " ");
            printSpace((separator.length()) - (player.toString().length()));
        }
        System.out.println();
        for (int j = 0; j < amountPlayers - 1; j++) {
            System.out.print(separator);
        }
        System.out.println();


    }

    public void printInfoDealer(int round) {
        if (round >= 1) {
            for (int i = 0; i < amountPlayers - 1; i++) {
                System.out.print(separator);
            }


            System.out.println();

            String st = "Name: " + players.get(0).getName();
            printSpace(((separator.length()) * (amountPlayers - 1) - (st.length())) / 2);
            System.out.print(st);
            System.out.println();
            for (int i = 0; i < amountPlayers - 1; i++) {
                System.out.print(separator);
            }
            System.out.println();
            System.out.println();

            String card = "Card:";
            printSpace(((separator.length()) * (amountPlayers - 1) - (card.length())) / 2);
            System.out.println(card);

            if (round == 1) {
                String hide = "#########unknowns card#######";
                card = showCard(players.get(0).getPool().get(0));
                printSpace(((separator.length()) * (amountPlayers - 1) - (card.length())) / 2);
                System.out.println(card);
                printSpace(((separator.length()) * (amountPlayers - 1) - (hide.length())) / 2);
                System.out.println(hide);
                for (int i = 0; i < amountPlayers - 1; i++) {
                    System.out.print(separator);
                }
            } else {
                for (int i = 0; i < players.get(0).getPool().size(); i++) {
                    card = showCard(players.get(0).getPool().get(i));
                    printSpace(((separator.length()) * (amountPlayers - 1) - (card.length())) / 2);
                    System.out.println(card);
                }

                for (int i = 0; i < amountPlayers - 1; i++) {
                    System.out.print(separator);
                }

            }

        }
        System.out.println();
    }

    public void printInfoCardPool() {
        System.out.println();
        for (int j = 1; j < players.size(); j++) {
            System.out.print("Cards:");
            printSpace((separator.length()) - 5);
        }
        int lines = largestLength();
        System.out.println();
        for (int i = 0; i < lines; i++) {
            for (int j = 1; j < players.size(); j++) {
                if (players.get(j).getPool().size() > i) {
                    String tempPrint = showCard(players.get(j).getPool().get(i));
                    System.out.print(tempPrint);
                    printSpace(separator.length() - tempPrint.length());
                } else {
                    printSpace(separator.length());
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    public void printSpace(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }

    private int largestLength() {
        int length = 0;
        for (Player player : players) {
            if (player.getPool().size() > length) {
                length = player.getPool().size();
            }

        }
        return length;
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    String showCard(int card) {
        String suit;
        if (card <= 13) {
            suit = "Hearts ";
        } else if (card <= 26) {
            card -= 13;
            suit = "Diamonds";
        } else if (card <= 39) {
            card -= 26;
            suit = "Clubs";
        } else if (card <= 52) {
            card -= 39;
            suit = "Spades";
        } else {
            suit = "non";
        }
        switch (card) {
            case 1 -> {
                return "2 of " + suit;
            }
            case 2 -> {
                return "3 of " + suit;
            }
            case 3 -> {
                return "4 of " + suit;
            }
            case 4 -> {
                return "5 of " + suit;
            }
            case 5 -> {
                return "6 of " + suit;
            }
            case 6 -> {
                return "7 of " + suit;
            }
            case 7 -> {
                return "8 of " + suit;
            }
            case 8 -> {
                return "9 of " + suit;
            }
            case 9 -> {
                return "10 of " + suit
                        ;
            }
            case 10 -> {
                return "Jack of " + suit;
            }
            case 11 -> {
                return "Queen of " + suit;
            }
            case 12 -> {
                return "King of " + suit;
            }
            case 13 -> {
                return "Ace of " + suit;
            }
            case 53, 54 -> {
                return "Joker"
                        ;
            }
            default -> {
                return "#####################";
            }
        }


    }

    public void getCard(int player) {
        if (player > 0)
            players.get(player).getCard(deck.getCard());
        else players.get(0).getCard(deck.getCard());

    }


    public void firstDropCard() {

        for (int j = 0; j < 2; j++) {

            for (int i = 1; i < getAmountPlayers(); i++) {
                players.get(i).getCard(deck.getCard());

            }
            players.get(0).getCard(deck.getCard());
        }
    }

    public void doBets() {
        System.out.println("Type your bet 1 bet equals 25");
        for (int i = 0; i < players.size(); i++) {
            if (i == 0) {
                beats.add(0);
            } else {
                if (players.get(i).getBalance() > 25) {
                    System.out.println(players.get(i).getName() + " your bet: ");
                    int betCof = StartGame.numScanner();

                    try {
                        players.get(i).setBet(betCof);
                        beats.add(betCof * 25);
                    } catch (outOfMoney e) {
                        System.out.println("Available bet is: 1 -" + players.get(i).getBalance() / 25);
                        i = i - 1;
                    } catch (NoSuchElementException e) {

                        System.out.println("Please try again, numbers only");
                        i = i - 1;
                    }

                } else System.out.println("Player " + players.get(i).getName() +
                        " don`t have enough money " +
                        "next player");
            }
        }
    }

    public boolean next(int round) {
        String key = "start";
        System.out.println();
        System.out.println("Type \"+\" to get one more card, or \"-\" to scip a turn!");
        OUTER:
        for (int i = 1; i < players.size(); i++) {
            Scanner in = new Scanner(System.in);
            if (key.equals("q")) {
                break;
            }
            boolean step = true;
            while (step) {
                if (!rules.isOver(21, i)) {
                    System.out.println("Player " + players.get(i).getName());
                    key = in.next().toLowerCase();
                    switch (key) {
                        case "-" -> {
                            step = false;
                        }
                        case "+" -> {
                            getCard(i);
                            print(1);
                            System.out.println();

                        }
                        case "q" -> {
                            step = false;
                            return false;
                        }
                    }

                } else {
                    step = false;
                    System.out.println("Player: " + players.get(i).getName());
                    System.out.println("Lost game");
                    players.get(i).clearPool();
                    print(1);
                    System.out.println();
                    continue OUTER;

                }
            }
            if (players.size() - 1 == i && key.equals("-")) {
                break;
            }
        }
        while (!rules.isOver(17, 0)) {
            getCard(0);
            print(2);
            if (rules.isOver(21, 0)) {
                players.get(0).clearPool();
                break;
            }
        }
        print(2);
        if (amoundScore.size() > 0) {
            for (int i = 0; i < players.size(); i++) {
                amoundScore.set(i, rules.scoring(i));
            }
        } else {
            for (int i = 0; i < players.size(); i++) {
                amoundScore.add(rules.scoring(i));
            }
        }
        return true;
    }

    public void print(int round) {
        System.out.println();
        System.out.println();
        System.out.println("Game has started!");
        printInfoPlayers();
        printInfoCardPool();
        printInfoDealer(round);
        System.out.println();
    }

    public void wonGame() {
        int player = 0;
        int temp = 0;
        for (int i = 0; i < amoundScore.size(); i++) {
            if (amoundScore.get(i) > temp && amoundScore.get(i) <= 21) {
                temp = amoundScore.get(i);
                player = i;
            }
        }
        System.out.println();
        System.out.println("Winner is : " + players.get(player).getName());
        if (player != 0) {
            players.get(player).topUp(beats.get(player) * 2);
        }
    }

    public boolean blackJack() {
        int player = rules.whoBlackJack();
        if (player != 500) {
            System.out.println("Winner is : " + players.get(player).getName() + " BlackJack!!!");
            if (rules.whoBlackJack() != 0) {
                players.get(player).topUp(beats.get(player) * 2);
            }

        }
        return true;
    }

    public void newRound() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).reset();

        }
    }


}
