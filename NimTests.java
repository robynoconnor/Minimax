public class NimTests {
    public static void main (String[] args) {
        System.out.println("Testing my NimRunner class."); 
        System.out.println(NimRunner.minimax(0, true) == 1); //BASE CASE, should return true
        System.out.println(NimRunner.minimax(1, false) == 1); //true
        System.out.println(NimRunner.minimax(4, true) ==1);  //true
        System.out.println(NimRunner.minimax(2, false ) == -1); //true
        System.out.println(NimRunner.minimax(3, false) == -1); //true
        System.out.println(NimRunner.bestMove(1, false)); //should return automatic 1 bc no optimal move
        System.out.println(NimRunner.bestMove(4, true)); //should return 3
        System.out.println(NimRunner.bestMove(3, false)); //should return 2
        System.out.println(NimRunner.bestMove(2, true)); //should return random 1 bc no optimal move
        System.out.println(NimRunner.getXMove(4)); //should return 3
        System.out.println(NimRunner.getYMove(3)); //should return 2
        System.out.println(NimRunner.runGame()); 
    }

}