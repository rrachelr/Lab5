import java.util.Scanner;

public class TextView {

    private int rowFrom;
    private int colFrom;
    private int rowTo;
    private int colTo;
    private char actionType;

    public int getRowFrom() {
        return this.rowFrom;
    }

    public int getColFrom() {
        return this.colFrom;
    }

    public int getRowTo() {
        return this.rowTo;
    }

    public int getColTo() {
        return this.colTo;
    }

    public char getActionType() {
        return this.actionType;
    }

    public static char getUsersNextActionType(Scanner scan) {
        System.out.println("Enter one of these characters or a word beginning with them: A, M, R, S");
        char answer;
        String word;
        word = scan.nextLine();
        while (word.toUpperCase().charAt(0) != 'A' && word.toUpperCase().charAt(0) != 'M' &&
                word.toUpperCase().charAt(0) != 'R' && word.toUpperCase().charAt(0) != 'S' &&
                word.toUpperCase().charAt(0) != 'V') {
            System.out.println("Enter a correct character: ");
            word = scan.nextLine();
        }
        return word.charAt(0);
    }

    public static int getValidInt(int one, int two, Scanner scan) {
        System.out.println(" Enter an int between " + one + " and " + two + ":");
        int userVar;
        String wrongInput;
        if (scan.hasNextInt()) {
            userVar = scan.nextInt();
        } else {
            wrongInput = scan.nextLine();
            userVar = -2000000000;
        }
        while (userVar < one || userVar > two) {
            System.out.println("Enter a correct value");
            if (scan.hasNextInt()) {
                userVar = scan.nextInt();
            } else {
                wrongInput = scan.next();
            }
        }
        return userVar;
    }

    public void getPlayersNextAction(GameS22 game) {
        Scanner scan = new Scanner(System.in);
        this.actionType=getUsersNextActionType(scan);
        System.out.println("Please enter the row and column indexes of the square you would like to start from. " +
                "Enter the row first, then the column second");
        this.rowFrom = getValidInt(0,game.getGameBoard().getNumRows()-1,scan);
        this.colFrom = getValidInt(0,game.getGameBoard().getNumColumns()-1,scan);
        System.out.println("Please enter the row and column indexes of the square you would like to perform your " +
                "action on. Enter the row first, then the column second");
        this.rowTo = getValidInt(0,game.getGameBoard().getNumRows()-1,scan);
        this.colTo = getValidInt(0,game.getGameBoard().getNumColumns()-1,scan);
    }

    public void updateView(GameS22 game) {
        System.out.println(game.toString());
    }

    public void printEndOfGameMessage(GameS22 game) {
        System.out.println("The game has ended!");
        if (game.getCurrentTeam().getTeamPieces().size() == game.getOpponentTeam().getTeamPieces().size()) {
            System.out.println("The game ended in a draw");
        }
        else {
            System.out.println("The team that one is: Team " + game.getWinner().getTeamColor());
        }
    }

}
