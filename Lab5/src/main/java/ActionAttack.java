/**
 * <h1>Lab7</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the ActionAttack class, which performs the steps
 * that occur when the Attack action is used.
 * @author Rachel Robins and Sean Johnson
 * @since 2022-04-28
 * @version 1
 */
public class ActionAttack extends Action {

    public ActionAttack(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game,rowFrom,colFrom,rowTo,colTo);
    }

    /**
     * This method first checks if the piece is an evil minion and the piece being
     * attacked is a Minion on the same team, it is allowed to convert minions on its
     * own team to evil minions by attacking them. If not, the piece attacked is removed
     * from the board and the team, and the attacker piece moves to the square the attacked
     * piece was on. The method also calls the piece's speak method and changes the turn.
     */
    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        BoardSquare toSquare = game.getGameBoard().getSquares()[rowTo][colTo];
        fromSquare.getPiece().speak();
        Piece removedPiece = toSquare.removePiece();
        if ((fromSquare.getPiece() instanceof PieceEvilMinion) && (removedPiece instanceof PieceMinion)
                && (fromSquare.getPiece().getTeamColor().equals(removedPiece.getTeamColor()))) {
            ((Attacker) fromSquare.getPiece()).setNumAttacks(((Attacker) fromSquare.getPiece()).getNumAttacks() + 1);
            game.getCurrentTeam().removePieceFromTeam(removedPiece);
            PieceEvilMinion newEvilMinion = new PieceEvilMinion();
            game.getCurrentTeam().addPieceToTeam(newEvilMinion);
            game.getGameBoard().getSquares()[rowTo][colTo].setPiece(newEvilMinion);
        }
        else {
            ((Attacker) fromSquare.getPiece()).setNumAttacks(((Attacker) fromSquare.getPiece()).getNumAttacks() + 1);
            game.getOpponentTeam().removePieceFromTeam(removedPiece);
            game.getGameBoard().getSquares()[rowTo][colTo].setPiece(fromSquare.getPiece());
            fromSquare.removePiece();
        }
        game.changeTurn();
    }
}
