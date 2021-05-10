/*
* Main class that prints Sequence
* @author Constantine Linardakis
* @since 04/16/2021
*/

public class Main {
  public static void main(String[] args){
    PrimeSequence primeSequence = new PrimeSequence();

    for(int i=1;i<=100;i++){
      System.out.println(i + " : " + primeSequence.next());
    }

  }
}
