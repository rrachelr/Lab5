public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return this.numRows;
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }

    public boolean inBounds(int row, int column) {
        if (row >= this.numRows || column >= this.numColumns || row<0 || column < 0) {
            return false;
        } else {
            return true;
        }
    }

    private void setUpEmptyBoard() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    this.squares[i][j] = new BoardSquare("White");
                } else if (i % 2 == 0 && j % 2 == 1) {
                    this.squares[i][j] = new BoardSquare("Black");
                } else if (i % 2 == 1 && j % 2 == 0) {
                    this.squares[i][j] = new BoardSquare("Black");
                } else if (i % 2 == 1 && j % 2 == 1) {
                    this.squares[i][j] = new BoardSquare("White");
                }
            }
        }
    }

    public BoardSquare findRandomEmptySpace() {
        boolean flag = true;
        BoardSquare space=new BoardSquare("");
        int result1;
        int result2;
        while (flag) {
            result1 = (int) (Math.random() * (numRows));
            result2 = (int) (Math.random() * (numColumns));
            if (squares[result1][result2].isEmpty()) {
                flag = false;
                space = squares[result1][result2];
            }
        }
        return space;
    }

   @Override
   public String toString(){
       StringBuilder boardString = new StringBuilder();
       boardString.append("Col :       ");

       for(int col = 0; col < squares[0].length; col++){
           boardString.append(col + "        ");
       }
       boardString.append("\n");
       for(int row = 0; row < squares.length; row++){
           boardString.append("Row : " + row + "   ");
           for(int col = 0; col < squares[row].length; col++){
               boardString.append(squares[row][col].toString() + "  ");
           }
           boardString.append("\n");
       }
       return boardString.toString();
   }

}
