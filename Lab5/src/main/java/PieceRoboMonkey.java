public class PieceRoboMonkey extends Piece implements Attacker, Recruiter{
    private int numAttacks;
    private int numRecruits;

    public PieceRoboMonkey(char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
    }

    public PieceRoboMonkey(){
        this('R', "- -", 0, 0, false,true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int rowBoard, int colBoard, int rowPiece, int colPiece) {
        return false;
    }

    public void speak() {
        System.out.println("Ooh Ooh Ah!");
    }

    public boolean canSpawn() {
        return true;
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }

    public Piece spawn() {
        PieceRoboMonkey copyMonkey = new PieceRoboMonkey(Character.toLowerCase(this.symbol), this.teamColor, this.numAttacks, this.numRecruits, false, false);
        return copyMonkey;
    }

    public int getNumRecruits() {
        return numRecruits;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rowBoard, int colBoard, int rowPiece, int colPiece) {
        return false;
    }
}
