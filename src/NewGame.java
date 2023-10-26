import java.util.ArrayList;
import java.util.Scanner;

public class NewGame {
    private int amountPlayers = 0;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Integer> firstBet;
    private ArrayList<Integer> Bet;
    String separator = "--------------------------  ";
    Deck deck = new Deck();
    Rules rules;

    NewGame() {

    }


    NewGame(int amountPlayers) {
        rules = new Rules(this);
        this.amountPlayers = amountPlayers + 1;
        this.players = new ArrayList<>(this.amountPlayers);
        Player dealer = new Player();
        dealer.setName("Dealer");
        dealer.setBalance(669999990);
        players.add(dealer);
        for (int i = 0; i < amountPlayers; i++) {
            players.add(new Player());
        }

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
    }

    public void printInfoCardPool() {
        System.out.println();
        for (int j = 1; j < amountPlayers; j++) {
            System.out.print("Cards:");
            printSpace((separator.length()) - 5);
        }
        System.out.println();
        int player = 1;
        int line = 0;
        int lines = largestLength();
        System.out.println();
        OUTER:
        while (line < lines || player < players.size() - 1) {

            while (players.get(player).getPool().size() > line) {

                String tempPrint = showCard(players.get(player).getPool().get(line));
                System.out.print(tempPrint);
                printSpace(separator.length() - tempPrint.length());
                player++;
                if (player > players.size() - 1) {
                    player = 1;
                    line++;
                    System.out.println();
                    continue OUTER;
                }

            }
            printSpace(separator.length());
            player++;
            if (player > players.size() - 1 && line >= lines - 1) {
                break;
            }

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
                return "Incorect card";
            }
        }


    }

    public void getCard(int player) {
        if (player > 0)
            players.get(player).getCard(deck.getCard());
        else players.get(0).getCard(deck.getCard());

    }


    public void removePlayer(int player) {
        if (rules.isOver(21,player)) ;
    }

    public void firstDropCard() {

        for (int j = 0; j < 2; j++) {

            for (int i = 1; i < getAmountPlayers(); i++) {
                players.get(i).getCard(deck.getCard());

            }
            players.get(0).getCard(deck.getCard());
        }
    }

    public boolean next(int round) {
        String key = "start";
        System.out.println("Type \"-\" to skip (enouph yor step, \"+\" get one more card");
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
                            print(2);
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
                    print(2);

                }
            }
            if (players.size() - 1 == i && key.equals("-")) {

                while (!rules.isOver(17,0)){
                    getCard(0);
                }

                return false;

            }
        }
        print(2);
        return true;
    }

    public void print(int round) {
        System.out.println();
        System.out.println();
        System.out.println("Game has started!");
        printInfoPlayers();
        printInfoCardPool();
        printInfoDealer(round);
    }


}
