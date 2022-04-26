public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);
    public abstract boolean validRecruitPath(int rowBoard, int colBoard, int rowPiece, int colPiece);
}
