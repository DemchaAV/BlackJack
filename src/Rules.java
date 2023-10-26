public class Rules {
    NewGame game;

    public Rules(NewGame game) {
        this.game = game;
    }


    public int scoring(int i) {
        int score = 0;
        for (int card :
                game.getPlayer(i).getPool()) {
            score += getScore(card);
        }

        return score;

    }

    public boolean isBlackJack(int player) {
        System.out.println(scoring(player));
        if (scoring(player) == 21 && game.getPlayers().get(player).getPool().size() == 2) return true;
        else return false;
    }

    private int getScore(int card) {

        if (card <= 13) {
        } else if (card <= 26) {
            card -= 13;
        } else if (card <= 39) {
            card -= 26;
        } else if (card <= 52) {
            card -= 39;
        }
        switch (card) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 8;
            case 9:
                return 10;
            case 10, 11, 12:
                return 10;
            case 13:
                return 11;
            case 53:
            case 54:
                return 0
                        ;
            default:
                return 0;
        }

    }

    boolean isOver(int over, int player) {
        int score = scoring(player);
        if (over == 17) {
            if (score >= over) return true;
            else return false;
        } else {
            if (score >= over) return true;
            else return false;
        }
    }


}
