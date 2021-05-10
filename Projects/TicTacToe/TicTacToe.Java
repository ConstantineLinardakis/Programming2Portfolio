import java.util.Scanner;
import java.util.Random;

public class TicTacToe (){

  public TicTacToe(boolean startingPlayer, boolean human, boolean playing){
   this.startingPlayer = startingPlayer;
   this.human = human;
   this.playing = playing;
  }

  public static void Main(String[] args){
    Scanner input = new Scanner(System.in);
    TicTacToe(startingPlayer,human, playing);
  }

  public boolean playAgain(){
    return startingPlayer;
  }

}
