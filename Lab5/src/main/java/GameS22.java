/**
 * <h1>Lab7</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the GameS22 class, which creates a new game and
 * contains methods that determine the winner and check the status of the
 * game.
 * @author Rachel Robins and Sean Johnson
 * @since 2022-04-28
 * @version 1
 */
public class GameS22 extends Game {

    public GameS22(int numRows, int numCols, Team team1, Team team2) {
        super(numRows, numCols, team1, team2);
    }

    /**
     * This method checks if there is a winner based on the return value of
     * getWinner.
     * @return
     */


    @Override
    public boolean isAWinner() {
        return getWinner() != null;
    }

    /**
     * This methods gets the winning team by returning the team with no pieces left.
     * If there is no winner, it returns null.
     * @return
     */
    @Override
    public Team getWinner() {
        if ((team1.getTeamPieces().size() > team2.getTeamPieces().size()) && getNumTurns()>=5) {
            return team1;
        } else if ((team1.getTeamPieces().size() < team2.getTeamPieces().size()) && getNumTurns()>=5) {
            return team2;
        } else if ((team1.getTeamPieces().size() == team2.getTeamPieces().size()) && getNumTurns()>=5) {
            return team1;
        } else if (team1.getTeamPieces().size() == 0) {
            return team2;
        } else if (team2.getTeamPieces().size() ==0) {
            return team1;
        }
        else {
            return null;
        }
    }

    /**
     * This method checks if the game is ended, which is true if there is a winner.
     * @return
     */
    @Override
    public boolean isGameEnded() {
        return isAWinner();
    }
}
