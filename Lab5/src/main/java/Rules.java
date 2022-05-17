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
        boolean checkBounds, checkEmpty, checkMovePath, checkAttackPath, checkRecruitPath, checkSpawnPath, checkLava, checkVaporizePath;
        String checkFrom, checkTo, currentTeam, oppTeam;
        currentTeam = game.getCurrentTeam().getTeamColor();
        oppTeam = game.getOpponentTeam().getTeamColor();
        Piece checkFromPiece = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece();
        Piece checkToPiece = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece();
        checkBounds = game.getGameBoard().inBounds(rowPlayer, colPlayer);
        checkFrom = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().getTeamColor();
        checkEmpty = game.getGameBoard().getSquares()[rowPlayer][colPlayer].isEmpty();
        checkLava = game.getGameBoard().getSquares()[rowPlayer][colPlayer].isLava();
        checkMovePath = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().validMovePath(rowPiece, colPiece, rowPlayer, colPlayer);
        checkSpawnPath = game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece().validSpawnPath(rowPiece, colPiece, rowPlayer, colPlayer);

        if (action == 'M' || action == 'm') {
            if (checkBounds && checkFrom.equals(currentTeam)) {
                if (checkEmpty && checkMovePath) {
                    return true;
                }
            }
        } else if (action == 'S' || action == 's') {
            if (!(checkFromPiece instanceof PieceBuzz)) {
                return checkBounds && (checkFrom.equals(currentTeam)) && checkEmpty && checkSpawnPath;
            }
        } else if (action == 'R' || action == 'r') {
            checkRecruitPath = ((Recruiter) game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece()).validRecruitPath(rowPiece, colPiece, rowPlayer, colPlayer);
            if (!(checkFromPiece instanceof PieceBuzz) && !checkEmpty && !checkLava) {
                checkTo = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece().getTeamColor();
                return checkBounds && checkFrom.equals(currentTeam) && checkTo.equals(oppTeam) && checkRecruitPath;
            }
        } else if (action == 'A' || action == 'a') {
            checkAttackPath = ((Attacker) game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece()).validAttackPath(rowPiece, colPiece, rowPlayer, colPlayer);
            if (checkBounds && checkFrom.equals(currentTeam) && !checkEmpty && !checkLava) {
                checkTo = game.getGameBoard().getSquares()[rowPlayer][colPlayer].getPiece().getTeamColor();
                if (checkFromPiece instanceof PieceBuzz && checkTo.equals(oppTeam)) {
                    return ((PieceBuzz) checkFromPiece).canAttack() && checkAttackPath;
                } else if (checkFromPiece instanceof PieceBlueHen && checkTo.equals(oppTeam)) {
                    return checkAttackPath;
                } else if (checkFromPiece instanceof PieceEvilMinion) {
                    if (((PieceEvilMinion) checkFromPiece).canAttack() && checkAttackPath) {
                        return checkTo.equals(oppTeam) || checkToPiece instanceof PieceMinion;
                    }
                }
            }
        } else if (action == 'V' || action == 'v') {
            checkVaporizePath = ((PieceRoboMonkey) game.getGameBoard().getSquares()[rowPiece][colPiece].getPiece()).validVaporizePath(rowPiece, colPiece, rowPlayer, colPlayer);
            if (checkBounds && checkFrom.equals(currentTeam) && !checkEmpty && !checkLava) {
                return checkVaporizePath;
            }
        }
        return false;
    }

}

