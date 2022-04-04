public abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    public Piece(char symbol, String teamColor, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    //ignore the commit where i say we have to override these in each class apparently we don't? idk
    public abstract void speak();

    public abstract boolean canSpawn();

    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    @Override
    public String toString() {
        return this.teamColor + "---" + this.symbol;
    }
}
