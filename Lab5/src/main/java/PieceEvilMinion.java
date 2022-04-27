/**
 * <h1>Lab05</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the PieceEvilMinion class, which creates a PieceEvilMinion object and
 * its appropriate properties and methods that get, set, print it's catchphrase, and spawn new
 * "baby" pieces.
 * @author Sean Johnson/Rachel Robins
 * @since 2022-04-10
 * @version 1
 */
public class PieceEvilMinion extends PieceMinion implements Recruiter, Attacker{
    private int numAttacks;
    private boolean hungry;

    final public int MAX_NUM_ATTACKS = 4;

    /**
     * This is a constructor for PieceEvilMinion objects. Along with the requirement
     * for the Piece and PieceMinion classes it extends, it assigns numAttacks and calls
     * updateHungry().
     * @param symbol
     * @param teamColor
     * @param numRecruits
     * @param numAttacks
     * @param numTimesSpawned
     * @param hidden
     * @param original
     */
    public PieceEvilMinion (char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    /**
     * This is the default constructor for PieceEvilMinion.
     */
    public PieceEvilMinion () {
        this('E', "NON", 0, 0, 0, false, true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public boolean isHungry() {
        return hungry;
    }

    public boolean canAttack() {
        return hungry;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int rowBoard, int colBoard, int rowPiece, int colPiece) {
        return true;
    }

    /**
     * This method updates hungry to true if numAttacks is less than the max number
     * of attacks. Otherwise, it updates to false.
     */
    public void updateHungry() {
        this.hungry = this.numAttacks < MAX_NUM_ATTACKS;
    }

    /**
     * This method prints Roar!
     */
    public void speak() {
        System.out.println("Roar!");
    }

    /**
     * This method returns true
     * @return
     */
    public boolean validMovePath() {
        return true;
    }

    /**
     * This method spawns in a new PieceEvilMinion of the same team
     * of the piece that spawned it. It has a lowercase letter symbol
     * and hungry is set to true.
     * @return
     */
    public PieceEvilMinion spawn() {
        PieceEvilMinion babyMinion = new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0 , 0, false, false);
        babyMinion.hungry = true;
        babyMinion.setNumTimesSpawned(this.numTimesSpawned + 1);
        return babyMinion;
    }

    @Override
    public boolean validRecruitPath(int rowBoard, int colBoard, int rowPiece, int colPiece) {
        return true;
    }
}
