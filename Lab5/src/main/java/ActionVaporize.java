public class ActionVaporize extends Action{

    public ActionVaporize(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game,rowFrom,colFrom,rowTo,colTo);
    }

    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        BoardSquare toSquare = game.getGameBoard().getSquares()[rowTo][colTo];
        int count = 0;
        int i;
        fromSquare.getPiece().speak();
        for (i=rowTo-1; (i < rowTo + 2) || count == 1; i++) {
            for (int j=colTo-1; (j < colTo + 2) || count == 1; j++) {
                if (!game.getGameBoard().getSquares()[i][j].isEmpty()) {
                    game.getOpponentTeam().removePieceFromTeam(toSquare.removePiece());
                    count++;
                }
            }
        }
    }
}
