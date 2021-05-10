/*
* @author ConstantineLinardakis
* @since 11/19/2020
* Project : P7.9 Write a program that plays tic-tac-toe. The tic-tac-toe game is played on a 3 × 3 grid as in the photo at right. (Allows players to play)
*/


import java.util.Scanner;

public class TicTacToe{
  public static Scanner input = new Scanner(System.in);
  
   /*
    * Main Method allowing user to chose a column, and row using Scanner.
    */
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    displayBoard(board);

    while (true) {

      // Prompt the first player
      makeAMove(board, 'X');
      
      displayBoard(board);
      if (isWon('X', board)) {
        System.out.println("X player won");
        System.exit(1);
      }
      else if (isDraw(board)) {
        System.out.println("No winner");
        System.exit(2);
      }

      // Prompt the second player
      makeAMove(board, 'O');
      displayBoard(board);

      if (isWon('O', board)) {
        System.out.println("O player won");
        System.exit(3);
      }
      else if (isDraw(board)) {
        System.out.println("No winner");
        System.exit(4);
      }
    }
  }

   /*
    * Method for letting the users pick their move.
    */

  public static void makeAMove(char[][] board, char player) { 
    boolean done = false;
    
    do {
      System.out.print("Enter a row for player " + player + ": ");
      int row = input.nextInt();
      System.out.print("Enter a column for player " + player + ": ");
      int column = input.nextInt();
    
      if (board[row][column] == '\u0000') { // an empty cell
        board[row][column] = player;
        done = true;
      }
      else
        System.out.println("This cell is already occupied. Try a different cell");
    }
    while (!done);
  }
  
    /*
    * Method for displaying the board after each move.
    */

  static void displayBoard(char[][] board) {
    System.out.println("\n-------------");

    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++)
        System.out.print(board[i][j] != '\u0000' ?  board[i][j] + " | ": "  | ");
      System.out.println("\n-------------");
    }
  }

    /*
    * Method to check if the player has won.
    */

  public static boolean isWon(char ch, char[][] board) {
    // Check rows
    for (int i = 0; i < 3; i++)
      if (ch == board[i][0] && ch == board[i][1] && ch == board[i][2]) return true;

    // Check columns
    for (int j = 0; j < 3; j++)
      if (ch == board[0][j] && ch == board[1][j] && ch == board[2][j]) return true;

    // Check major diagonal
    if (ch == board[0][0] && ch == board[1][1] && ch == board[2][2]) return true;

    // Check sub diagonal
    if (ch == board[0][2] && ch == board[1][1] && ch == board[2][0]) return true;

    return false;
  }

    /*
    * Method to check if an "X" or "O" has already been drawn.
    */

  public static boolean isDraw(char[][] board) {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (board[i][j] == '\u0000') return false;

    return true; // All cells are now occupied
  }
}