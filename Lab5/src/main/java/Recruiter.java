public interface Recruiter {
    int getNumRecruits();
    void setNumRecruits(int numRecruits);
    boolean validRecruitPath(int rowBoard, int colBoard, int rowPiece, int colPiece);
}
