/**
 * <h1>Lab05</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates a Piece object with its appropriate properties and methods that get, set and form the basis
 * for any extending classes.
 * @author Sean Johnson/Rachel Robins
 * @since 2022-04-10
 * @version 1
 */
public abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    /**
     * Piece is a constructor that takes a character, color in the form of a string,
     * and two boolean values representing whether the piece is hidden and original to
     * assign the appropriate values to a Piece object.
     * @param symbol
     * @param teamColor
     * @param hidden
     * @param original
     */
    public Piece(char symbol, String teamColor, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    /**
     * Getter method for symbol
     * @return
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Getter method for teamColor
     * @return
     */
    public String getTeamColor() {
        return teamColor;
    }

    /**
     * Method that returns the value of hidden
     * @return
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Method that returns the value of original
     * @return
     */
    public boolean isOriginal() {
        return original;
    }

    /**
     * Setter method for symbol
     * @param symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Setter method for teamColor
     * @param teamColor
     */
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    /**
     * Setter method for hidden
     * @param hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Setter method for original
     * @param original
     */
    public void setOriginal(boolean original) {
        this.original = original;
    }

    /**
     * Abstract prototypes for the following methods that appear in classes that extend Piece
     */
    public abstract void speak();

    public abstract boolean canSpawn();

    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);

    public abstract boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);

    public abstract boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);

    public abstract boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);

    public abstract Piece spawn();

    /**
     * Overrides the toString method to return the Piece object's team color and symbol
     * @return
     */
    @Override
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }
}
