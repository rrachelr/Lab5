public class ActionSpawn extends Action{

    public ActionSpawn(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game, rowFrom, colFrom, rowTo, colFrom);
    }

    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        fromSquare.getPiece().speak();
        Piece spawn = fromSquare.getPiece().spawn();
        game.getCurrentTeam().addPieceToTeam(spawn);
        game.getGameBoard().getSquares()[rowTo][colTo].setPiece(spawn);
        game.changeTurn();
    }
}
