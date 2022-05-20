/**
 * <h1>Lab7</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the ActionSpawn class, which performs the steps
 * that occur when the Spawn action is used.
 * @author Rachel Robins and Sean Johnson
 * @since 2022-04-28
 * @version 1
 */
public class ActionSpawn extends Action{

    public ActionSpawn(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game, rowFrom, colFrom, rowTo, colTo);
    }

    /**
     * This method spawns a new piece of the same type as the original piece on an
     * adjacent square. It also calls the original piece's speak method and changes
     * the turn.
     */
    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        fromSquare.getPiece().speak();
        if ((fromSquare.getPiece() instanceof PieceMinion)) {
            ((PieceMinion) fromSquare.getPiece()).setNumTimesSpawned(((PieceMinion) fromSquare.getPiece()).getNumTimesSpawned() + 1);
        }
        Piece spawn = fromSquare.getPiece().spawn();
        game.getCurrentTeam().addPieceToTeam(spawn);
        game.getGameBoard().getSquares()[rowTo][colTo].setPiece(spawn);
        game.changeTurn();
    }
}
