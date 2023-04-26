import java.util.*; 

public class NimRunner {
    public static void main (String [] args) {

    }   
    
    public static boolean runGame() { //returns true if x wins and returns false if y wins 
        int pieces = 4; //OPTIONAL: change to make an array (ex. {1,3,5,7})
        boolean Xwins = true; 

        while (pieces > 0) {
            pieces -= getXMove(pieces); //updates pieces based on X's move
            if (pieces ==0) {
                Xwins = false; 
                break; 
            } 
            pieces -= getYMove(pieces); //updates pieces based on Y's move
            if (pieces ==0) {
                break; 
            }
        }

        return Xwins; 
    }

    public static int minimax(int state, boolean myTurn) {
        //base case 
        if (state ==0 & myTurn) {
            return 1; 
        } 

        else if (state ==0 & !myTurn) {
            return -1; 
        }

        //recursive step 
        else { 
            List<Integer> scores = new ArrayList<Integer>(); 
            for (int p=1; p<4; p++) { //loop through possible moves 
                //for each move, call minimax using opposite turn and new state 
                if (p<=state) {
                    scores.add(minimax(state-p, !myTurn)); 
                }
            }

            int min = scores.get(0); 
            int max = scores.get(0); 
            for (int j = 0; j<scores.size(); j++) {
                //dependant on myTurn, decide if you are minimizing or maximizing 
                if (myTurn && scores.get(j) >max) { //if X'S TURN and current score is greater than max, reassign max
                    max = scores.get(j); 
                }
                else if (!myTurn && scores.get(j) <min) { //if Y'S TURN and current score is less than min, reassign min 
                    min = scores.get(j); 
                }
            }
            if (myTurn) { //maximizing 
                return max; 
            }
            else { //minimizing
                return min; 
            }
        }
    }

    public static int getXMove(int state) { //returns the pieces taken in the move
        return bestMove(state, true); //player x wants to make the best move for them
    }

    public static int getYMove(int state) { //returns the pieces taken in the move
        return bestMove(state, false); //player y wants to make the best move for them 
    }

    public static int bestMove(int state, boolean myTurn) { //returns how many pieces you want to take 
        int score =0; //will hold the score given by each move
        for (int p=1; p<4; p++) { //loop through possible moves 
                if (p<=state) {
                    score = minimax(state-p, !myTurn); //call minimax to test that move and save to score
                    if (myTurn && score ==1) {
                        return p; 
                    }
                    else if (!myTurn && score ==-1) {
                        return p;
                    }
                }
            } 
        // if you never get 1 or -1 (depending on whose turn it is), return 1
        return 1; 
    }

    //OPTIONAL public static int getUserMove () {

    //}

    //pseudocode to generate an arraylist of arraylists for all possibe moves (getPossibleMoves)
    //to be used 
        // 1) set up moves (ArrayList(ArrayList int))
        // 2) for loop to index through state which represents each pile 
        // 3) within that another for loop/while loop to index through the pieces in each pile (represents number of possible pieces you can take from THIS pile )
        // 4) create an arraylist (int) which represents one move
        // 5) At the index you are at in state (pile index), add the numbver of pieces 
        // 6) Add one move (arrayList (int)) to moves (big arraylist)
}