public interface Attacker {
    int getNumAttacks();
    void setNumAttacks(int numAttacks);
    boolean validAttackPath(int rowBoard, int colBoard, int rowPiece, int colPiece);
}
