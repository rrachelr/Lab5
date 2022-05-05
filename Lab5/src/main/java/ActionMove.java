/**
 * <h1>Lab7</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the ActionMove class, which performs the steps
 * that occur when the Move action is used.
 * @author Rachel Robins and Sean Johnson
 * @since 2022-04-28
 * @version 1
 */
public class ActionMove extends Action {

    public ActionMove(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game, rowFrom, colFrom, rowTo, colTo);
    }

    /**
     * All pieces can move, so this method moves the piece on the original space to the
     * selected new space. It also calls piece's speak method, and changes the turn.
     */
    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        fromSquare.getPiece().speak();
        Piece removed = fromSquare.removePiece();
        game.getGameBoard().getSquares()[rowTo][colTo].setPiece(removed);
        game.changeTurn();
    }
}
