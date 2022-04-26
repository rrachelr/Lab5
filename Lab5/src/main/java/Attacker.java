public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numAttacks);
    public abstract boolean validAttackPath(int rowBoard, int colBoard, int rowPiece, int colPiece);
}
