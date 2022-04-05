public class PieceMinion1 extends Piece {
    protected int numRecruits;
    protected int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion1(char symbol, String teamColor,
                        int numRecruits, int numTimesSpawned,
                        boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion1(){
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

    public void setNumTimesSpawned(int numTimesSpawned) { this.numTimesSpawned = numTimesSpawned; }

    public void speak(){
        System.out.println("Bello!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    public PieceMinion1 spawn(){
        return new PieceMinion1(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

}
