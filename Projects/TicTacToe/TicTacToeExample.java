/** TicTacToe class
* author: Lukas Carvajal
* cop 3252
* This class allows a user to play tic tac toe
* with a friend or against a computer
*/

import java.util.Scanner;
import java.util.Random;

class TicTacToe{

	public static void main(String [] args)
	{	//START OF MAIN

	// create Scanner object for user input
	Scanner scanner = new Scanner(System.in);

	// hold move
	int m;

	if(args.length == 0){
		// start a new game, display board
		TicTacToeGame play = new TicTacToeGame();
		play.drawBoard();

		// loop until game ends
		do{
			// prompt player for move until valid input given
			do{
				System.out.print("Player ");

				if(play.getPlayerTurn())
					System.out.print("1, ");
				else
					System.out.print("2, ");

				System.out.print("enter a move (1-9): ");
				m = scanner.nextInt();
				System.out.println();

			}while(!play.checkMove(m));	// valid move

			// record move
			play.setMove(m);

			// display game and positions
			play.drawBoard();

		}while(!play.finished() && !play.gameWon());

		// declare winner
		play.declareWinner();
	}
	else if(args.length != 2)	//improper usage
	{
		System.out.println("Usage: java TicTacToe [-c [1|2]]");
	}
	else if (args[0].equals("-c") && args[1].equals("1"))
	// CPU goes first
	{
		// start a new game, display board
		TicTacToeGameCPU play = new TicTacToeGameCPU(true);
		play.drawBoard();

		// loop until game ends
		do{
			// computer moves
			play.setCPUmove();

			play.drawBoard();

			//if game has not ended
			if(!play.gameWon() && !play.finished())
			{
				// prompt player for move
				// until valid input given
				do{
					System.out.print("Player ");

					if(play.getPlayerTurn())
						System.out.print("1, ");
					else
						System.out.print("2, ");

					System.out.print("enter a move");
					System.out.print(" (1-9): ");
					m = scanner.nextInt();
					System.out.println();

				}while(!play.checkMove(m)); // valid move

				// record move
				play.setMove(m);

				// display game and positions
				play.drawBoard();
			}

		}while(!play.finished() && !play.gameWon());

		// declare winner
		if(play.getPlayerTurn())
			play.declareWinner(false);
		else
			play.declareWinner(true);
	}
	else if (args[0].equals("-c") && args[1].equals("2"))
	// CPU goes second
	{
		// start a new game, display board
		TicTacToeGameCPU play = new TicTacToeGameCPU(false);
		play.drawBoard();

		// loop until game ends
		do{
			// prompt player for move until valid input given
			do{
				System.out.print("Player ");

				if(play.getPlayerTurn())
					System.out.print("1, ");
				else
					System.out.print("2, ");

				System.out.print("enter a move (1-9): ");
				m = scanner.nextInt();
				System.out.println();

			}while(!play.checkMove(m));	// valid move

			// record move
			play.setMove(m);

			// display game and positions
			play.drawBoard();

			//if game has not ended
			if(!play.gameWon() && !play.finished())
			{
				//computer moves
				play.setCPUmove();
				play.drawBoard();
			}

		}while(!play.finished() && !play.gameWon());

		// declare winner
		if(play.getPlayerTurn())
			play.declareWinner(true);  //computer wins
		else
			play.declareWinner(false); //player wins
	}
	else	//improper usage
	{
		System.out.println("Usage: java TicTacToe [-c [1|2]]");
	}

	} // END OF MAIN
}

/**
* Class for actual tic tac toe game
* Built for two players to play one another
*/
class TicTacToeGame{

	// holds X's and O's on board
	protected char [][] game = new char [3][3];

	// true if player 1's turn
	protected boolean p1Turn;

	/**
	* Constructor
	* Set all values on board to ' ' and
	* set player one to start.
	*/
	public TicTacToeGame()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				game[i][j] = ' ';
			}
		}

		p1Turn = true;
	}

	/**
	* Draws game board and board showing position numbers.
	*/
	public void drawBoard(){
		System.out.println("Game Board:               Positions:");

		int p  = 1;	// position number

		for( int i = 0; i < 3; i++)
		// loop through rows
		{
			for(int j = 0; j < 3; j++)
			// print out game row on board
			{
				System.out.print(" " + game[i][j] + " ");
				if(j < 2)
					System.out.print("|");
			}

			System.out.print("               ");

			for(int j = 0; j < 3; j++)
			// print out position row on board
			{
				System.out.print(" " + p + " ");
				p++;

				if(j < 2)
					System.out.print("|");
			}

			System.out.println();

			if(i < 2)
			// print out row dividors
			{
				System.out.print("-----------");
				System.out.print("               ");
				System.out.println("-----------");
			}

		}
	}

	/**
	* Check to see if move is valid and then sets move
	* if it is.
	* @param move the position the user wants to make the move on.
	* @return whether move is recorded or not.
	*/
	public boolean checkMove(int move){
		// only positions 1-9 are valid
		if(move < 1 || move > 9)
		{
			System.out.println("ERROR: invalid input!");
			return false;
		}

		// position is not empty
		if(!positionEmpty(move))
		{
			System.out.println("ERROR: position already filled");
			return false;
		}

		//position is empty
		return true;
	}

	/**
	* Check if position is empty.
	* @param p being checked
	*/
	public boolean positionEmpty(int move)
	{
		// check if position is empty
		boolean empty = true;
		switch (move){
			case 1:
				if( game[0][0] != ' ' )
					empty = false;
				break;
			case 2:
				if( game[0][1] != ' ' )
					empty = false;
				break;
			case 3:
				if( game[0][2] != ' ' )
					empty = false;
				break;
			case 4:
				if( game[1][0] != ' ' )
					empty = false;
				break;
			case 5:
				if( game[1][1] != ' ' )
					empty = false;
				break;
			case 6:
				if( game[1][2] != ' ' )
					empty = false;
				break;
			case 7:
				if( game[2][0] != ' ' )
					empty = false;
				break;
			case 8:
				if( game[2][1] != ' ' )
					empty = false;
				break;
			case 9:
				if( game[2][2] != ' ' )
					empty = false;
				break;
		}

		return empty;
	}

	/**
	* Method for setting move.
	* @param move move being recorded.
	*/
	public void setMove(int move){

		char m;	// holds move type being added

		if(p1Turn)
			m = 'X';
		else
			m = 'O';

		// sets move
		switch (move){
			case 1: game[0][0] = m;
				break;
			case 2: game[0][1] = m;
				break;
			case 3: game[0][2] = m;
				break;
			case 4: game[1][0] = m;
				break;
			case 5: game[1][1] = m;
				break;
			case 6: game[1][2] = m;
				break;
			case 7: game[2][0] = m;
				break;
			case 8: game[2][1] = m;
				break;
			case 9: game[2][2] = m;
				break;
		}

		// change p1Turn from T to F or F to T
		p1Turn ^= true;
	}

	/**
	* Method to check if game is complete.
	*/
	public boolean finished(){

		// loop through all game positions
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				// empty position
				if(game[i][j] == ' ')
					return false;
			}
		}

		return true;
	}

	/**
	* Accessor method for determining player's turn.
	* @return if it is player 1's turn.
	*/
	public boolean getPlayerTurn()
		{ return p1Turn; }

	/**
	*Method for checking if game is won
	*/
	public boolean gameWon(){

		char m = 'X';	// player 1

		//loop once for each player
		for(int i = 0; i < 2; i++)
		{
			// check all winning combinations
			// going through center
			if(game[1][1] == m)
			{
				if(game[0][1] == m && game[2][1] == m)
					return true;	// center column
				if(game[0][2] == m && game[2][0] == m)
					return true;	// /
				if(game[1][2] == m && game[1][0] == m)
					return true;	// center row
				if(game[2][2] == m && game[0][0] == m)
					return true;	// \
			}
			// check all winning combinations going through
			// top left corner
			if(game[0][0] == m)
			{
				if(game[0][1] == m && game[0][2] == m)
					return true;	// top row
				if(game[1][0] == m && game[2][0] == m)
					return true;	// left column
			}
			// check all winning combinations going through
			// bottom right corner
			if(game[2][2] == m)
			{
				if(game[1][2] == m && game[0][2] == m)
					return true;	// right column
				if(game[2][1] == m && game[2][0] == m)
					return true;	// bottom row
			}

			m = 'O';	// switch to player 2
		}

		// no winner found
		return false;
	}

	/**
	* Declares winner of the game if there is one, otherwise
	* declares a tie.
	*/
	public void declareWinner(){

		// check if there is a winner or game is tied
		if(gameWon())
		{
			System.out.print("Player ");

			// player 1 or 2
			if(!p1Turn)
				System.out.print("1 ");
			else
				System.out.print("2 ");

			System.out.println("has won the game!");
		}
		else
			System.out.println("The game has ended in a draw!");
	}
}

/**
* Class for CPU game
* Built so that one player is a CPU
* p1Turn represents the human player's turn
*/
class TicTacToeGameCPU extends TicTacToeGame{

	// holds all possible moves for a turn
	boolean [] moves = new boolean [9];

	// holds computer move type 'X' or 'O'
	char mType;
	// opposing type
	char oType;

	/**
	* Constructor
	* Implements parent class constructor
	* @param CPUfirst CPU goes first
	*/
	public TicTacToeGameCPU(boolean CPUfirst){

		super();	// call parent constructor

		if(CPUfirst)
		{
			mType = 'X';
			oType = 'O';
		}
		else
		{
			mType = 'O';
			oType = 'X';
		}
	}

	/**
	* Method for determining and setting CPU move
	*/
	public void setCPUmove(){

		// play winning move if available
		winningMove(mType);

		for(int i = 0; i < 9; i++)
		{
			if(moves[i] == true)
			{
				setMove(i + 1);
				displayCPUmove(i + 1);
				resetMoves();
				return;
			}
		}

		// block winning play  if possible
		winningMove(oType);

		for(int i = 0; i < 9; i++)
		{
			if(moves[i] == true)
			{
				setMove(i + 1);
				displayCPUmove(i + 1);
				resetMoves();
				return;
			}
		}

		// set move to center position
		if(game[1][1] == ' ')
		{
			setMove(5);
			displayCPUmove(5);
			return;
		}

		// choose randomly if none of the above
		boolean found = false;		//usable position
		Random rand = new Random();
		int p;				//random position

		do
		{
			//random number between 1 and 9
			p = rand.nextInt(9) + 1;

			if(positionEmpty(p))
			{
				setMove(p);
				displayCPUmove(p);
				found = true;
			}
		}while(!found);

	}

	/**
	* Displays message for move CPU makes.
	* @param dM move to display.
	*/
	public void displayCPUmove(int dM){
		System.out.println("CPU plays " + dM + ".");
		System.out.println();
	}

	/**
	* Method for adding winning moves to moves array.
	* @return if winning move is available.
	*/
	public void winningMove(char mT){

		// check all available winning combinations
		// going through center
		if(game[1][1] == mT)
		{
			if(game[0][1] == mT && game[2][1] == ' ')
				moves[7] = true; // 8 is winning move
			if(game[2][1] == mT && game[0][1] == ' ')
				moves[1] = true; // 2
			if(game[0][2] == mT && game[1][2] == ' ')
				moves[6] = true; // 6
			if(game[2][0] == mT && game[0][2] == ' ')
				moves[2] = true; // 3
			if(game[1][2] == mT && game[1][0] == ' ')
				moves[3] = true; // 4
			if(game[1][0] == mT && game[1][2] == ' ')
				moves[5] = true; // 6
			if(game[2][2] == mT && game[0][0] == ' ')
				moves[0] = true; // 1
			if(game[0][0] == mT && game[2][2] == ' ')
				moves[8] = true; // 9
		}
		// check all winning combinations going through
		// top left corner
		if(game[0][0] == mT)
		{
			if(game[0][1] == mT && game[0][2] == ' ')
				moves[2] = true; // 3
			if(game[0][2] == mT && game[0][1] == ' ')
				moves[1] = true; // 2
			if(game[1][0] == mT && game[2][0] == ' ')
				moves[6] = true; // 7
			if(game[2][0] == mT && game[1][0] == ' ')
				moves[3] = true; // 4
		}
		// check all winning combinations going through
		// bottom left corner
		if(game[2][0] == mT)
		{
			if(game[1][0] == mT && game[0][0] == ' ')
				moves[0] = true; // 1
			if(game[0][0] == mT && game[1][0] == ' ')
				moves[3] = true; // 4
			if(game[2][1] == mT && game[2][2] == ' ')
				moves[8] = true; // 9
			if(game[2][2] == mT && game[2][1] == ' ')
				moves[7] = true; // 8
		}
		// check all winning combinations going through
		// bottom right corner
		if(game[2][2] == mT)
		{
			if(game[1][2] == mT && game[0][2] == ' ')
				moves[2] = true; // 3
			if(game[0][2] == mT && game[1][2] == ' ')
				moves[5] = true; // 6
			if(game[2][1] == mT && game[2][0] == ' ')
				moves[6] = true; // 7
			if(game[2][0] == mT && game[2][1] == ' ')
				moves[7] = true; // 8
		}
		// check all winning combinations going through
		// top right corner
		if(game[0][2] == mT)
		{
			if(game[0][1] == mT && game[0][0] == ' ')
				moves[0] = true; // 1
			if(game[0][0] == mT && game[0][1] == ' ')
				moves[1] = true; // 2
			if(game[1][2] == mT && game[2][2] == ' ')
				moves[8] = true; // 9
			if(game[2][2] == mT && game[1][2] == ' ')
				moves[5] = true; // 6
		}

	}

	/**
	* Reseting moves array to 'null' values.
	*/
	public void resetMoves(){

		for(int i = 0; i < 9; i++)
		{
			moves[i] = false;
		}
	}

	/**
	* Declares winner of the game if there is one, otherwise
	* declares a tie.
	* @param w computer has won.
	*/
	public void declareWinner(boolean w){

		// check if there is a winner or game is tied
		if(gameWon())
		{
			// player 1 or 2
			if(w)
				System.out.print("Sorry, CPU has ");
			else
				System.out.print("Yay! You have ");

			System.out.println("won the game!");
		}
		else
			System.out.println("The game has ended in a draw!");
	}
}
