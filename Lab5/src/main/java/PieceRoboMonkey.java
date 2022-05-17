//New Piece Modification : Robo Monkey
//This new class creates Robo Monkey pieces for our game.that can attack, recruit, spawn, and move.

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
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        for (int i=fromSquareRow-1; i < fromSquareRow + 2; i++) {
            for (int j = fromSquareCol - 1; j < fromSquareCol + 2; j++) {
                if (toSquareRow == i && toSquareCol == j) {
                    return true;
                }
            }
        }
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
        for (int i=fromSquareRow-1; i < fromSquareRow + 2; i++) {
            for (int j = fromSquareCol - 1; j < fromSquareCol + 2; j++) {
                if (toSquareRow == i && toSquareCol == j) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (fromSquareRow + 1 == toSquareRow && fromSquareCol + 1 == toSquareCol) {
            return true;
        } else if (fromSquareRow - 1 == toSquareRow && fromSquareCol - 1 == toSquareCol) {
            return true;
        } else if (fromSquareRow - 1 == toSquareRow && fromSquareCol + 1 == toSquareCol) {
            return true;
        } else if (fromSquareRow + 1 == toSquareRow && fromSquareCol - 1 == toSquareCol) {
            return true;
        }
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
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (fromSquareRow + 1 == toSquareRow && fromSquareCol == toSquareCol) {
            return true;
        }
        if (fromSquareCol + 1 == toSquareCol && fromSquareRow == toSquareRow) {
            return true;
        }
        return false;
    }

    public boolean validVaporizePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }
}
