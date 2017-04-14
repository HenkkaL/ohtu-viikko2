package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.getPlayerName()) {
            player1.addPoit();
        } else {
            player2.addPoit();
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1.getPlayerScore() == player2.getPlayerScore()) {
            score = getEvenScore(player1);
        } else if (player1.getPlayerScore() >= 4 || player2.getPlayerScore() >= 4) {
            score = getAdvOrWin(player1, player2);
        } else {
            score = getSinglePlayerScore(player1) + "-" + getSinglePlayerScore(player2);
        }

        return score;
    }

    private String getEvenScore(Player player) {
        switch (player.getPlayerScore()) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";

        }
    }

    private String getAdvOrWin(Player player1, Player player2) {
        String score = "";
        int minusResult = player1.getPlayerScore() - player2.getPlayerScore();
        if (minusResult == 1) {
            score = "Advantage " + player1.getPlayerName();
        } else if (minusResult == -1) {
            score = "Advantage " + player2.getPlayerName();
        } else if (minusResult >= 2) {
            score = "Win for " + player1.getPlayerName();
        } else {
            score = "Win for " + player2.getPlayerName();
        }
        return score;
    }

    private String getSinglePlayerScore(Player player) {
        String score = "";
        switch (player.getPlayerScore()) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }
}
