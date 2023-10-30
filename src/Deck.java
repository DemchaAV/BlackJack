import java.util.ArrayList;

public class Deck {
    private  final int amountDeck = 52;
    private  ArrayList<Integer> shuffledDeck = new ArrayList<>(amountDeck);

    public Deck() {
        shufffle();

    }

     void getDeckView() {
        var show = shuffledDeck;
        System.out.println(show);
        show.sort((x, y) -> x - y);
        System.out.println(show);
    }


    public int getCard() {
        if (shuffledDeck.size() > 0) {
            int returnCard = shuffledDeck.get(0);
            shuffledDeck.remove(0);
            return returnCard;
        }
        return 0;
    }


    private void shufffle() {
        for (int i = 0; i < amountDeck; i++) {
            int randomNum;
            boolean check = true;
            while (check) {
                randomNum = ((int) (Math.random() * amountDeck + 1));
                if (randomNum > 0 && !shuffledDeck.contains(randomNum)) {
                    shuffledDeck.add(randomNum);
                    check = false;
                }

            }
        }
    }
    public  void newShuffle(){
        ArrayList<Integer> newShuffle = new ArrayList<>();
        for (int i = 0; i < amountDeck; i++) {
            int randomNum;
            boolean check = true;
            while (check) {
                randomNum = ((int) (Math.random() * amountDeck + 1));
                if (randomNum > 0 && !newShuffle.contains(randomNum)) {
                    newShuffle.add(randomNum);
                    check = false;
                }

            }
        }

        shuffledDeck = newShuffle;
    }


    public static void main(String[] args) {
        Deck deck = new Deck();
    }
}