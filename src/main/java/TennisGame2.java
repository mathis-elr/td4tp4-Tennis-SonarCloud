import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";

    private static final String[] SCORES = {LOVE, FIFTEEN, THIRTY, FORTY};

    public int pUnPoint = 0;
    public int pDeuxPoint = 0;

    public String getScore() {
        if (isTied()) {
            return getTiedScore();
        }
        if (isEndGame()) {
            return getAdvantageOrWinScore();
        }
        return SCORES[pUnPoint] + "-" + SCORES[pDeuxPoint];
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, "player1"))
            setPUnScore(1);
        else
            setP2Score(1);
    }

    public void setPUnScore(int number){

        for (int i = 0; i < number; i++)
        {
            addScorePUn();
        }
    }

    public void setP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            addScorePDeux();
        }
    }

    private boolean isTied() {
        return pUnPoint == pDeuxPoint;
    }

    private String getTiedScore() {
        if (pUnPoint < 3) {
            return SCORES[pUnPoint] + "-All";
        }
        return "Deuce";
    }

    private boolean isEndGame() {
        return pUnPoint >= 4 || pDeuxPoint >= 4;
    }

    private String getAdvantageOrWinScore() {
        int pointDifference = pUnPoint - pDeuxPoint;
        if (pointDifference == 1) {
            return "Advantage player1";
        }
        if (pointDifference == -1) {
            return "Advantage player2";
        }
        if (pointDifference >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private void addScorePUn(){
        pUnPoint++;
    }

    private void addScorePDeux(){
        pDeuxPoint++;
    }
}