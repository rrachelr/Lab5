/**
 * <h1>Lab7</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the abstract Action class, which contains an Action
 * constructor and an abstract prototype for performAction.
 * @author Rachel Robins and Sean Johnson
 * @since 2022-04-28
 * @version 1
 */
public abstract class Action {
    protected GameS22 game;
    protected int rowFrom, colFrom, rowTo, colTo;

    public Action(GameS22 game, int rowFrom, int colFrom, int rowTo, int colTo) {
        this.game = game;
        this.rowFrom = rowFrom;
        this.colFrom = colFrom;
        this.rowTo = rowTo;
        this.colTo = colTo;
    }

    public abstract void performAction();
}
