package ohtu;

public class TennisGame {
    
    private int points1 = 0;
    private int points2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            points1 += 1;
        else
            points2 += 1;
    }
    
    public String getScore() {
        String score = "";
        if (points1==points2)  {
            return scoreWhenTie();
        }
        else if (points1>=4 || points2>=4) {
            return scoreWhenOver4Points();
        }
        return scoreWhenUnder4Points();
    }

    private String scoreWhenTie() {
        switch (points1){
            case 0:
                return  "Love-All";
            case 1:
                 return  "Fifteen-All";
            case 2:
                return  "Thirty-All";
            case 3:
                return  "Forty-All";
            default:
                return  "Deuce";
        }
    }
    
    private String scoreWhenOver4Points() {
        int minusResult = points1-points2;
        if (minusResult==1) return "Advantage player1";
        else if (minusResult ==-1) return "Advantage player2";
        else if (minusResult>=2) return "Win for player1";
        else return "Win for player2";
    }
    
    private String scoreWhenUnder4Points() {
        String score="";
        int tempScore;
        for (int i=1; i<3; i++) {
            if (i==1) tempScore = points1;
            else { score+="-"; tempScore = points2;}
            switch(tempScore) {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
}