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
