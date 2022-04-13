/**
 * <h1>Lab05</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the Game class which uses the previous GameBoard,
 * BoardSquare, and Team functions to set up the game. It initialized the game
 * board so it appears on the screen, assigns teams, places pieces on empty spaces,
 * and controls the turns for the game.
 * @author Sean Johnson/Rachel Robins
 * @since 2022-04-10
 * @version 1
 */
import java.util.Collections;

public class Game {
    private GameBoard board;
    private Team team1;
    private Team team2;
    private String turn;

    /**
     * This method creates a GameBoard and places pieces from each team on
     * empty spaces.
     * @param numRows
     * @param numCols
     */
    private void initializeGameBoard(int numRows, int numCols) {
        board = new GameBoard(numRows, numCols);
        for (int i = 0; i < team1.getTeamPieces().size(); i++) {
            BoardSquare emptySpace = board.findRandomEmptySpace();
            if (emptySpace.isEmpty()) {
                emptySpace.setPiece(team1.getTeamPieces().get(i));
            }
        }
        for (int i = 0; i < team2.getTeamPieces().size(); i++) {
            BoardSquare emptySpace = board.findRandomEmptySpace();
            if (emptySpace.isEmpty()) {
                emptySpace.setPiece(team2.getTeamPieces().get(i));
            }
        }
    }

    /**
     * This method is a constructor for Game objects. It assigns number
     * of rows, number of collumns, and two teams.
     * @param numRows
     * @param numCols
     * @param team1
     * @param team2
     */
    public Game(int numRows, int numCols, Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.turn = team1.getTeamColor();
        initializeGameBoard(numRows, numCols);
    }

    public GameBoard getGameBoard() {
        return this.board;
    }

    public Team getCurrentTeam() {
        if (this.turn == team1.getTeamColor()) {
            return team1;
        } else {
            return team2;
        }
    }

    public Team getOpponentTeam() {
        if (this.turn == team1.getTeamColor()) {
            return team2;
        } else {
            return team1;
        }
    }

    /**
     * If it is the team's turn, turn is set to true. Otherwise, it
     * is set to false.
     * @param team
     * @return
     */
    public boolean isTurn(Team team) {
        if (this.turn == team.getTeamColor()) {
            return true;
        } else {
            return false;
        }
    }

    public BoardSquare[][] getBoardSquare() {
        return getGameBoard().getSquares();
    }

    /**
     * This method swaps the value of turn to the other team
     */
    public void changeTurn() {
        if (this.turn == team1.getTeamColor()) {
            this.turn = team2.getTeamColor();
        } else {
            this.turn = team1.getTeamColor();
        }
    }

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }

}
