public class ActionVaporize extends Action{

    public ActionVaporize(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        super(game,rowFrom,colFrom,rowTo,colTo);
    }

    public void performAction() {
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][colFrom];
        int i, rowNeg, rowPlus, colNeg, colPlus;
        rowNeg = rowTo - 1;
        rowPlus = rowTo + 1;
        colNeg = colTo - 1;
        colPlus = colTo + 1;
        if (rowNeg < 0) {
            rowNeg = rowTo;
        } else if (rowPlus > 7) {
            rowPlus = rowTo;
        } else if (colNeg < 0) {
            colNeg = colTo;
        } else if (colPlus > 7) {
            colPlus = colTo;
        }
        fromSquare.getPiece().speak();
        outerloop:
        for (i=rowNeg; (i < rowPlus + 1); i++) {
            for (int j=colNeg; (j < colPlus + 1); j++) {
                if (!game.getGameBoard().getSquares()[i][j].isEmpty() && (game.getGameBoard().getSquares()[i][j].getPiece() != game.getGameBoard().getSquares()[rowTo][colTo].getPiece())) {
                    if (game.getGameBoard().getSquares()[i][j].getPiece().getTeamColor().equals(game.getCurrentTeam().getTeamColor())) {
                        game.getCurrentTeam().removePieceFromTeam(game.getGameBoard().getSquares()[i][j].removePiece());
                    } else {
                        game.getOpponentTeam().removePieceFromTeam(game.getGameBoard().getSquares()[i][j].removePiece());
                    }
                    break outerloop;
                }
            }
        }
        game.changeTurn();
    }
}
