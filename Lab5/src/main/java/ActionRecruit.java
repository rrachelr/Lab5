public class ActionRecruit extends Action {

    public ActionRecruit(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game, rowFrom, colFrom, rowTo, colTo);
    }

    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        BoardSquare toSquare = game.getGameBoard().getSquares()[rowTo][colTo];
        fromSquare.getPiece().speak();
        game.getCurrentTeam().addPieceToTeam(toSquare.getPiece());
        game.getOpponentTeam().removePieceFromTeam(toSquare.getPiece());
        game.changeTurn();
    }
}
