public class PieceEvilMinion extends PieceMinion1{
    private int numAttacks;
    private boolean hungry;

    public PieceEvilMinion (char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original, boolean hungry) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        this.hungry = hungry;
    }
}
