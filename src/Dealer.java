import java.util.ArrayList;

public class Dealer extends Player implements Action {
    private final String name = "Dealer";
    int bet;
    private int sumPoint = 0;

    public boolean isOver17() {
        if (sumPoint > 17) {
            return true;
        }
        return false;
    }

    @Override
    public void setBet(int x) throws outOfMoney {
        sumBet += bet * 25;
    }

    @Override
    public String toString() {
        return "Name : " + name;
    }
}
