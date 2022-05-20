/**
 * New Action Modification : Vaporize
 * A target piece is chosen (can be from either current or opponent team)
 * and one adjacent piece (also from either team) to the target piece
 * is “vaporized” or removed from the game. We didn’t add team
 * specifications to allow for more unique strategies and gambits using this action.
 *
 * We created the ActionVaporize class that extends Action and includes
 * the performAction method required for the vaporization to occur. We also
 * included a section in checkValidAction in Rules, a validVaporizePath method
 * in PieceRoboMonkey that always returns true because it can be used from anywhere
 * on any piece, a section in carryOutAction in Controller that uses ActionVaporize
 * to make the action happen, and finally in TextView we updated getUsersNextActionType
 * to recognize a user input of v.
 */
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
        }
        if (rowPlus > 7) {
            rowPlus = rowTo;
        }
        if (colNeg < 0) {
            colNeg = colTo;
        }
        if (colPlus > 7) {
            colPlus = colTo;
        }
        fromSquare.getPiece().speak();
        outerloop:
        for (i=rowNeg; (i < rowPlus + 1); i++) {
            for (int j=colNeg; (j < colPlus + 1); j++) {
                if (!game.getGameBoard().getSquares()[i][j].isEmpty() && (!(game.getGameBoard().getSquares()[i][j].isLava()))&& (game.getGameBoard().getSquares()[i][j].getPiece() != game.getGameBoard().getSquares()[rowTo][colTo].getPiece())) {
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
