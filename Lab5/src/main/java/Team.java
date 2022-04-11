/**
 * <h1>Lab05</h1>
 * <h2>CISC181-042L/040L Spring 2022</h2>
 * <h3>University of Delaware</h3>
 * This program creates the Team class, which is a team of game Pieces, this has the fields teamColor and
 * teamPieces, and has many associated methods.
 *
 * @author Sean Johnson/Rachel Robins
 * @since 2022-04-10
 * @version 1
 */

import java.util.ArrayList;

public class Team {

    /*
    fields for the class
     */
    private String teamColor;
    private ArrayList<Piece> teamPieces;

    public Team(String teamColor, ArrayList<Piece> piecesList) {
        /*
        constructor for the class
         */
        this.teamColor=teamColor;
        this.teamPieces=piecesList;
    }

    public String getTeamColor() {
        /*
        A getter method for the teamColor field
         */
        return this.teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        /*
        A getter method for the teamPieces field
         */
        return this.teamPieces;
    }

    public void removePieceFromTeam(Piece piece) {
        /*
        A method which removes the piece used in the argument from the team.
         */
        this.teamPieces.remove(piece);
    }

    public void addPieceToTeam(Piece piece) {
        /*
        A method which adds the piece used in the argument to the team.
         */
        piece.setTeamColor(this.teamColor);
        this.teamPieces.add(piece);
    }

    @Override
    public String toString() {
        /*
        A toString method for the Team class, overrides the objects toString method.
         */
        String stringToBeReturned = "Team " + this.teamColor + " Pieces :\n";
        for (Piece piece: this.teamPieces) {
            stringToBeReturned+=piece.toString() + " ";
        }
        return stringToBeReturned;
    }
}
