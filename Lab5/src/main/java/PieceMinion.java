public class PieceMinion extends Piece implements Recruiter {
    protected int numRecruits;
    protected int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor,
                        int numRecruits, int numTimesSpawned,
                        boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion(){
        this('M',"- -",
                0,0,
                false,true);
    }

    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setNumRecruits(int numRecruits) {
       this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (fromSquareCol == toSquareCol) {
            return true;
        }
        if (fromSquareRow == toSquareRow && (toSquareCol == (fromSquareCol - 2) || toSquareCol == (fromSquareCol + 2))) {
            return true;
        }
        return false;
    }

    public void setNumTimesSpawned(int numTimesSpawned) { this.numTimesSpawned = numTimesSpawned; }

    public void speak(){
        System.out.println("Bello!");
    }

   @Override
   public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (fromSquareCol == toSquareCol) {
            return true;
        } else if (fromSquareRow == toSquareRow && (toSquareCol == (fromSquareCol - 2) || toSquareCol == (fromSquareCol + 2))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (canSpawn()) {
            if (fromSquareCol == toSquareCol) {
                return true;
            }
            if (fromSquareRow == toSquareRow && (toSquareCol == (fromSquareCol - 2) || toSquareCol == (fromSquareCol + 2))) {
                return true;
            }
        }
        return false;
    }

    public PieceMinion spawn(){
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

}
