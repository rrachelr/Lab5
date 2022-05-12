public class PieceBlueHen extends Piece implements Attacker, Recruiter {
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen (char symbol,
                          String teamColor,
                          int numAttacks, int numRecruits,
                          boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }

    public int getNumAttacks()    {
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }

    public boolean canFly()    {
        return this.flies;
    }

    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }

    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (canFly()) {
            return true;
        } else {
            if ((fromSquareCol >= (toSquareCol - 1) && fromSquareCol <= (toSquareCol + 1)) && fromSquareRow == toSquareRow) {
                return true;
            }
        }
        return false;
    }

    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (canFly()) {
            return true;
        } else {
            if ((fromSquareRow >= (toSquareRow - 1) && fromSquareRow <= (toSquareRow + 1)) && fromSquareCol == toSquareCol) {
                return true;
            }
        }
        return false;
    }

    private void updateFly()    {
        this.flies = this.numAttacks < MAX_NUM_ATTACKS;
    }

    public void speak(){
        System.out.println("Go UD!");
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (canFly()) {
            return true;
        } else {
            if ((toSquareRow >= (fromSquareRow - 1) && toSquareRow <= (fromSquareRow + 1)) && (toSquareCol >= (fromSquareCol -1) && toSquareCol <= (fromSquareCol + 1))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (canFly()) {
            return true;
        } else {
            if ((toSquareRow == (fromSquareRow - 1) || toSquareRow == (fromSquareRow + 1)) && (fromSquareCol == (toSquareCol - 1) || fromSquareCol == (toSquareCol + 1))) {
                return true;
            }
        }
        return false;
    }

    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }

    public boolean canSpawn(){
        return true;
    }
}
