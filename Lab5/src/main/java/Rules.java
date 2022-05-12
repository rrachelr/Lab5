/**
 * <h1>Lab7</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the Rules class, which ensures each
 * action performed abides by the rules of the game.
 * @author Rachel Robins and Sean Johnson
 * @since 2022-04-28
 * @version 1
 */
public class Rules {
    /**
     * This method checks an action that the player wants to perform, and if it follows
     * passes each of the checks performed in the if statement, then true is returned
     * and the piece may perform the action. Otherwise, false is returned.
     * @param game
     * @param rowPiece
     * @param colPiece
     * @param rowPlayer
     * @param colPlayer
     * @param action
     * @return
     */
    public static boolean checkValidAction(GameS22 game, int rowPiece, int colPiece, int rowPlayer, int colPlayer, char action) {
        boolean checkBounds, checkEmpty, checkMovePath, checkAttackPath, checkRecruitPath, checkSpawnPath;
        String checkFrom, checkTo, currentTeam, oppTeam;
        currentTeam = game.getCurrentTeam().getTeamColor();
        oppTeam = game.getOpponentTeam().getTeamColor();
        Piece checkFromPiece = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece();
        Piece checkToPiece = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece();
        checkBounds = game.getGameBoard().inBounds(rowPlayer, colPlayer);
        checkFrom = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().getTeamColor();
        checkEmpty = game.getGameBoard().getSquares()[rowPlayer][colPlayer].isEmpty();
        if (game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece()==null) {
            checkMovePath = false;
            checkAttackPath = false;
            checkRecruitPath = false;
            checkSpawnPath = false;
        }
        else {
            checkMovePath = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().validMovePath(rowPiece, colPiece, rowPlayer, colPlayer);
            checkAttackPath = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().validAttackPath(rowPiece, colPiece, rowPlayer, colPlayer);
            checkRecruitPath = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().validRecruitPath(rowPiece, colPiece, rowPlayer, colPlayer);
            checkSpawnPath = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().validSpawnPath(rowPiece, colPiece, rowPlayer, colPlayer);
        }
        if (action == 'M') {
            if (checkBounds == true && checkFrom == currentTeam) {
                if (checkEmpty == true) {
                    return true;
                }
            }
        } else if (action == 'S') {
            if (checkFromPiece instanceof PieceBuzz == false) {
                return checkBounds == true && checkFrom == currentTeam && checkEmpty == true && checkSpawnPath == true;
            }
        } else if (action == 'R') {
            if (checkFromPiece instanceof PieceBuzz == false && checkEmpty == false) {
                checkTo = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece().getTeamColor();
                return checkBounds == true && checkFrom == currentTeam && checkTo == oppTeam && checkRecruitPath == true;
            }
        } else if (action == 'A') {
            if (checkBounds == true && checkFrom == currentTeam && checkAttackPath == true && checkEmpty == false) {
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

