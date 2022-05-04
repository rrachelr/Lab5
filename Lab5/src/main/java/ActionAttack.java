public class ActionAttack extends Action {

    public ActionAttack(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game,rowFrom,colFrom,rowTo,colTo);
    }

    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        BoardSquare toSquare = game.getGameBoard().getSquares()[rowTo][colTo];
        fromSquare.getPiece().speak();
        Piece removedPiece = toSquare.removePiece();
        if ((fromSquare.getPiece() instanceof PieceEvilMinion) && (removedPiece instanceof PieceMinion)
                && (fromSquare.getPiece().getTeamColor().equals(removedPiece.getTeamColor()))) {
            game.getCurrentTeam().removePieceFromTeam(removedPiece);
            PieceEvilMinion newEvilMinion = new PieceEvilMinion();
            game.getCurrentTeam().addPieceToTeam(newEvilMinion);
            game.getGameBoard().getSquares()[rowTo][colTo].setPiece(newEvilMinion);

        }
        else {
            game.getOpponentTeam().removePieceFromTeam(removedPiece);
            game.getGameBoard().getSquares()[rowTo][colTo].setPiece(fromSquare.getPiece());
            fromSquare.removePiece();
        }
        game.changeTurn();
    }
}
