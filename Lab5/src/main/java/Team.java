import java.util.ArrayList;
public class Team {
    private String teamColor;
    private ArrayList<Piece> teamPieces;

    public Team(String teamColor, ArrayList<Piece> piecesList) {
        this.teamColor=teamColor;
        this.teamPieces=piecesList;
    }

    public String getTeamColor() {
        return this.teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return this.teamPieces;
    }

    public void removePieceFromTeam(Piece piece) {
        this.teamPieces.remove(piece);
    }

    public void addPieceToTeam(Piece piece) {
        piece.setTeamColor(this.teamColor);
        this.teamPieces.add(piece);
    }

    @Override
    public String toString() {
        String stringToBeReturned = "Team " + this.teamColor + " Pieces :\n";
        for (Piece piece: this.teamPieces) {
            stringToBeReturned+=piece.toString() + " ";
        }
        return stringToBeReturned;
    }
}
