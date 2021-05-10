public class Combinations(){

  public Combinations(boolean state){
    this.state = state;
    this.losingCombo = new char[][][];
    this.winningCombo = new char[][][];
  }

  public char[][][] getWinningCombo(){
    return winningCombo;
  }

  public char[][][] getLosingCombo(){
    return winningCombo;
  }

}
