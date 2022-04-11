/**
 * <h1>Lab05</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the GameBoard class, which is the GameBoard used for the game, which is made  up of
 * smaller, individual BoardSquares. This class has the fields numRows, numColumns, and squares, along with
 * many associated methods.
 *
 * @author Sean Johnson/Rachel Robins
 * @since 2022-04-06
 * @version 1
 */
public class GameBoard {

    /*
    fields for the class
     */
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns) {
        /*
        constructor for the class
         */
        this.numRows = numRows;
        this.numColumns = numColumns;
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        /*
        A getter method for the numRows field
         */
        return this.numRows;
    }

    public int getNumColumns() {
        /*
        A getter method for the numColumns field
         */
        return this.numColumns;
    }

    public BoardSquare[][] getSquares() {
        /*
        A getter method for the squares field
         */
        return squares;
    }

    public boolean inBounds(int row, int column) {
        /*
        A method which returns true if the two parameters in the method call are appropriate indexes in the
        squares array
         */
        if (row >= this.numRows || column >= this.numColumns || row<0 || column < 0) {
            return false;
        } else {
            return true;
        }
    }

    private void setUpEmptyBoard() {
        /*
        A method which initializes all the BoardSquare objects in the squares array, setting up an empty board,
        also alternates the colors of each BoardSquare to simulate a chess board color scheme.
         */
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
                else {
                    this.squares[i][j] = new BoardSquare("White");
                }
            }
        }
    }

    public BoardSquare findRandomEmptySpace() {
        /*
        A method which uses Math.random to generate a random space inside the squares array, which is repeated until
        a random space which is empty is found, that empty space is then returned.
         */
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
        /*
        A toString method for the GameBoard class, overrides the objects toString method.
         */
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
