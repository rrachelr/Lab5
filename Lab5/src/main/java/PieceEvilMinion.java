public class PieceEvilMinion extends PieceMinion1{
    private int numAttacks;
    private boolean hungry;

    final public int MAX_NUM_ATTACKS = 4;

    public PieceEvilMinion (char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
    }

    public PieceEvilMinion () {
        this('E', "NON", 0, 0, 0, false, true);
    }

    public int getNumAttacks() {
        return this.numAttacks;
    }

    public boolean isHungry() {
        return this.hungry;
    }

    public boolean canAttack() {
        return hungry;
    }
}
