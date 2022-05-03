import java.util.ArrayList;

public class Rules {
    public static boolean checkValidAction(GameS22 game, int rowPiece, int colPiece, int rowPlayer, int colPlayer, char action) {
        boolean checkBounds, checkEmpty, checkMovePath;
        String checkFrom, checkTo, currentTeam, oppTeam;
        currentTeam = game.getCurrentTeam().getTeamColor();
        oppTeam = game.getOpponentTeam().getTeamColor();
        Piece checkFromPiece = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece();
        Piece checkToPiece = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece();
        checkBounds = game.getGameBoard().inBounds(rowPlayer, colPlayer);
        checkFrom = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().getTeamColor();
        checkEmpty = game.getGameBoard().getSquares()[rowPlayer][colPlayer].isEmpty();
        if (game.getGameBoard().getSquares()[rowPiece][rowPiece].getPiece()==null) {
            checkMovePath=false;
        }
        else {
            checkMovePath = game.getGameBoard().getSquares()[rowPiece][rowPiece].getPiece().validMovePath(rowPiece, colPiece, rowPlayer, colPlayer);
        }
        if (action == 'M') {
            if (checkBounds == true && checkFrom == currentTeam) {
                if (checkEmpty == true) {
                    return true;
                }
            }
        } else if (action == 'S') {
            if (checkFromPiece instanceof PieceBuzz == false) {
                return checkBounds == true && checkFrom == currentTeam && checkEmpty == true && checkMovePath == true;
            }
        } else if (action == 'R') {
            if (checkFromPiece instanceof PieceBuzz == false && checkEmpty == false) {
                checkTo = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece().getTeamColor();
                return checkBounds == true && checkFrom == currentTeam && checkTo == oppTeam && checkMovePath == true;
            }
        } else if (action == 'A') {
            if (checkBounds == true && checkFrom == currentTeam && checkMovePath == true && checkEmpty == false) {
                checkTo = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece().getTeamColor();
                if (checkFromPiece instanceof PieceBuzz && checkTo == oppTeam) {
                    return ((PieceBuzz) checkFromPiece).canAttack();
                } else if (checkFromPiece instanceof PieceBlueHen && checkTo == oppTeam) {
                    return true;
                } else if (checkFromPiece instanceof PieceEvilMinion) {
                    if (((PieceEvilMinion) checkFromPiece).canAttack()) {
                        return checkTo == oppTeam || checkToPiece instanceof PieceMinion;
                    }
                }
            }
        }
        return false;
    }

}

