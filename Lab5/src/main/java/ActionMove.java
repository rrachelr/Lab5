public class ActionMove extends Action {

    public ActionMove(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game, rowFrom, colFrom, rowTo, colTo);
    }

    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        fromSquare.getPiece().speak();
        Piece removed = fromSquare.removePiece();
        game.getGameBoard().getSquares()[rowTo][colTo].setPiece(removed);
        game.changeTurn();
    }
}
