import java.util.ArrayList;

public interface Action {
    int bet = 25;


    void getCard(int card);

    void setBet(int x);

    default void printSpace(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }
}
