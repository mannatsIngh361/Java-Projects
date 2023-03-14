import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors{
    /**
     */
    public static void main(String[] args) {
        System.out.println("Rock Paper Scissors Gamer");
        Scanner sc = new Scanner(System.in);
        while (true){
        String[] rps = {"r","p","s"};
        
        String computerMove = rps[new Random().nextInt(rps.length)];

        String PlayerMove;

        while(true){
            System.out.println("Enter your move(r,p,s)");
            PlayerMove = sc.nextLine();
            if(PlayerMove.equals("r")||PlayerMove.equals("p")||PlayerMove.equals("s")){
                break;
            }
            System.out.println("Invalid Move");
        }
        System.out.println("Computer Played "+ computerMove);
        if(PlayerMove.equals(computerMove)){
            System.out.println("TIE");
        }
        else if(PlayerMove.equals("r")){
            if(computerMove.equals("p")) System.out.println("Computer Wins");
            else System.out.println("Player Wins");
        
        }
        else if(PlayerMove.equals("p")){
            if(computerMove.equals("s")) System.out.println("Computer Wins");
            else System.out.println("Player Wins");
        }
        else{
            if(computerMove.equals("r")) System.out.println("Computer Wins"); 
            else System.out.println("Player Wins");
        }

        String choice;

        System.out.println("Do you want to play again(y/n)");
        choice = sc.nextLine();
        if(choice.equals("n")||choice.equals("N")) {
            System.out.println("Bye");
            break;
        }


    }
    sc.close();
    }
}