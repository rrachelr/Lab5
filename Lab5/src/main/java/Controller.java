import java.util.ArrayList;
public class Controller {
    private GameS22 game;
    private TextView view;

    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller() {
        this.game=setUpGameModel();
        this.view=new TextView();
        view.updateView(game);
    }

    public void carryOutAction(int rowFrom, int colFrom, int rowTo, int colTo, char actionType) {
        if (actionType=='A'||actionType=='a') {
            ActionAttack actionAttack = new ActionAttack(game,rowFrom,colFrom,rowTo,colTo);
            actionAttack.performAction();
        }
        else if(actionType=='M'||actionType=='m') {
            ActionMove actionMove = new ActionMove(game,rowFrom,colFrom,rowTo,colTo);
            actionMove.performAction();
        }
        else if (actionType=='R'||actionType=='r') {
            ActionRecruit actionRecruit = new ActionRecruit(game,rowFrom,colFrom,rowTo,colTo);
            actionRecruit.performAction();
        }
        else {
            ActionSpawn actionSpawn = new ActionSpawn(game,rowFrom,colFrom,rowTo,colTo);
            actionSpawn.performAction();
        }

    }

    public void playGame() {
        boolean gameEnd = game.isGameEnded();
        while (gameEnd == false) {
            view.getPlayersNextAction(game);
            boolean ruling = Rules.checkValidAction(game, view.getRowFrom(), view.getColFrom(), view.getRowTo(), view.getColTo(), view.getActionType());
            while (!ruling) {
                view.getPlayersNextAction(game);
                ruling = Rules.checkValidAction(game, view.getRowFrom(), view.getColFrom(), view.getRowTo(), view.getColTo(), view.getActionType());
            }
            carryOutAction(view.getRowFrom(), view.getColFrom(), view.getRowTo(), view.getColTo(), view.getActionType());
            view.updateView(game);
            gameEnd = game.isGameEnded();
        }
        view.printEndOfGameMessage(game);
    }

    public static void main(String[] args) {
        Controller newController = new Controller();
        newController.playGame();
    }
}
