public class BoardSquare {
    private boolean emptySpace;
    private Piece piece;
    private String boardSquareColor;

    public BoardSquare(String color) {
        this.boardSquareColor=color;
        this.emptySpace=true;
        this.piece = null;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public boolean isEmpty() {
        return this.emptySpace;
    }

    public String getSquareColor() {
        return this.boardSquareColor;
    }

    public void setPiece(Piece newPiece) {
        this.piece=newPiece;
        this.emptySpace=false;
    }

    public Piece removePiece() {
        Piece tempPiece = this.piece;
        this.piece=null;
        this.emptySpace=true;
        this.boardSquareColor="";
        return tempPiece;
    }

    @Override
    public String toString() {
        if (this.emptySpace) {
            return "-------";
        }
        else {
            return "-" + this.piece.toString() + "-";
        }
    }
}
