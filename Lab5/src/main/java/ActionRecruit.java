/**
 * <h1>Lab7</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the ActionRecruit class, which performs the steps
 * that occur when the Recruit action is used.
 * @author Rachel Robins and Sean Johnson
 * @since 2022-04-28
 * @version 1
 */
public class ActionRecruit extends Action {

    public ActionRecruit(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game, rowFrom, colFrom, rowTo, colTo);
    }

    /**
     * This method adds the piece on the To square to the piece on the From square's team, thereby recruiting it
     * and removing it from it's old team. The method also calls the From square piece's speak method and changes
     * the turn.
     */
    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        BoardSquare toSquare = game.getGameBoard().getSquares()[rowTo][colTo];
        fromSquare.getPiece().speak();
        ((Recruiter) fromSquare.getPiece()).setNumRecruits(((Recruiter) fromSquare.getPiece()).getNumRecruits() + 1);
        game.getCurrentTeam().addPieceToTeam(toSquare.getPiece());
        game.getOpponentTeam().removePieceFromTeam(toSquare.getPiece());
        game.changeTurn();
    }
}
