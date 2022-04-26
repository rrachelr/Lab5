public class GameS22 extends Game {
    public GameS22(int numRows, int numCols, Team team1, Team team2) {
        super(numRows, numCols, team1, team2);
    }

    @Override
    public boolean isAWinner() {
        if (getWinner() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Team getWinner() {
        if (team1.getTeamPieces().size() == 0) {
            return team1;
        } else if (team2.getTeamPieces().size() == 0) {
            return team2;
        } else {
            return null;
        }
    }

    @Override
    public boolean isGameEnded() {
        if (isAWinner()) {
            return true;
        } else {
            return false;
        }
    }
}
