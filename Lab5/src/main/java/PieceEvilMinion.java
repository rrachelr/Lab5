public class PieceEvilMinion extends PieceMinion1{
    private int numAttacks;
    private boolean hungry;

    final public int MAX_NUM_ATTACKS = 4;

    public PieceEvilMinion (char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
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

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public void updateHungry() {
        if (this.numAttacks < MAX_NUM_ATTACKS) {
            this.hungry = true;
        } else {
            this.hungry = false;
        }
    }

    public void speak() {
        System.out.println("Roar!");
    }

    public boolean validMovePath() {
        return true;
    }

    public PieceEvilMinion spawn() {
        PieceEvilMinion babyMinion = new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0 , 0, false, false);
        babyMinion.hungry = true;
        babyMinion.setNumTimesSpawned(this.numTimesSpawned + 1);
        return babyMinion;
    }

}
