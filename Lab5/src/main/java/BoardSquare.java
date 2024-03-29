import java.util.Random;
/**
 * <h1>Lab05</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the BoardSquare class, which represents an empty BoardSpace on the imaginary game board
 * (like a chess board). Has the fields emptySpace, piece, and boardSquareColor, along with many associated methods.
 * @author Sean Johnson/Rachel Robins
 * @since 2022-04-06
 * @version 1
 */

/**
 * Board Square Modification : Lava Square
 * Lava squares can’t be landed on by any piece.
 * We modified the BoardSquare class adding a boolean modifier called lava and an
 * if statement to the constructor that makes random BoardSquares have the lava modifier.
 * In the Rules class, we check the toSquare for each action, and if it is a lava
 * square the action is invalid.
 */

public class BoardSquare {

    /*
    fields for the class
     */
    private boolean emptySpace;
    private Piece piece;
    private String boardSquareColor;
    private boolean lava;

    public BoardSquare(String color) {
        /*
        the BoardSquare constructor
         */
        int ranNum = (int) (1+(Math.random() * 10));
        this.boardSquareColor=color;
        this.piece = null;
        if (ranNum%5==0) {
            this.lava = true;
            this.emptySpace=false;
        }
        else {
            this.lava=false;
            this.emptySpace=true;
        }
    }

    public Piece getPiece() {
        /*
        A getter method for the piece field
         */
        return this.piece;
    }

    public boolean isEmpty() {
        /*
        A getter method for the emptySpace field
         */
        return this.emptySpace;
    }

    //Board Square Modification : Lava
    public boolean isLava() {
        return this.lava;
    }

    public String getSquareColor() {
        /*
        A getter method for the boardSquareColor field
         */
        return this.boardSquareColor;
    }

    public void setPiece(Piece newPiece) {
        /*
        A setter method for the piece field
         */
        this.piece=newPiece;
        this.emptySpace=false;
    }

    public Piece removePiece() {
        /*
        public method to remove a Piece from a BoardSquare object.
         */
        Piece tempPiece = this.piece;
        this.piece=null;
        this.emptySpace=true;
        this.boardSquareColor="";
        return tempPiece;
    }

    @Override
    public String toString() {
        /*
        A toString method for the BoardSquare class which overrides the objects toString method.
         */
        if (this.lava) {
            return "-Lava--";
        }
        else if (this.emptySpace) {
            return "-------";
        }
        else {
            return "-" + this.piece.toString() + "-";
        }
    }
}
