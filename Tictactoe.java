import java.util.Scanner;
import java.util.ArrayList;


public class Tictactoe{
	// variables
	public final String ANSI_RESET = "\u001B[0m";
	public final String ANSI_RED = "\u001B[31m";
	public final String ANSI_YELLOW = "\u001B[33m";
	public final String ANSI_PURPLE = "\u001B[35m";
	public final String ANSI_GREEN = "\u001B[32m";
	Scanner sc = new Scanner(System.in);
	private String player1;
	private String player2;
	ArrayList<String> board = new ArrayList<String>();
	int[][] winCombinations = {
		{7,8,9},
		{4,5,6},
		{1,2,3},
		{7,4,1},
		{8,5,2},
		{9,6,3},
		{1,5,9},
		{7,5,3}
	};
	
	
	public void play(){
		// main game loop 
		System.out.println("Running Game");
		// set usernames
		setUserNames(sc);
		// make game board
		createGameBoard();
		// render game board
			//nu in makemove
		// ask player for input
		makeMove(player1);
	}
	
	
	public void setUserNames(Scanner sc){
		System.out.println("Player 1, What is your name?");
		this.player1 = sc.nextLine();
		while(player1.length() < 3){
				System.out.println("name must be at least 3 characters: ");
				player1 = sc.nextLine();
			}
		System.out.println("Player 2, What is your name?");
		player2 = sc.nextLine();
		while(player2.length() < 3 || player2.equals(player1)){
			String msg = player2.length() < 3 ? msg = "Name must be at least 3 characters:" : "Name already in use";
				System.out.println(msg);
				player2 = sc.nextLine();
			}
	}
	
	
	public void createGameBoard(){
		// tot 9, null word niet gebruikt omdat dat makkelijker is om grid als numpad te zien. 
		for(int i = 0; i < 10 ; i++){
			this.board.add(" ");
		}
	}
	
	
	public void renderBoard(){
		for(int i = 3; i > 0 ; i--){
			System.out.println(" " + board.get((3*i)-2) + " | " + board.get((3*i) - 1) + " | " + board.get(3*i));
			System.out.println("---+---+---");
		}
	}
	
	
	public void makeMove(String player){
		if(checkWin()){
			return;
		};
		renderBoard();
		String playerSign = player1.equals(player)? ANSI_YELLOW + "X" + ANSI_RESET : ANSI_PURPLE + "O" + ANSI_RESET;
		System.out.println("It's " + player + "'s turn what square do you want to play in?");
		int playerMove = 0;
		try{
			playerMove = Integer.parseInt(sc.nextLine());
			if(playerMove <= 0 || playerMove >= 10){
				throw new NumberFormatException("Not part of the board");
			}
		}catch(NumberFormatException err){
			System.out.println(ANSI_RED + "That is not a valid move, try again" + ANSI_RESET);
			playerMove = Integer.parseInt(sc.nextLine());
		}
		if(board.get(playerMove).equals(" ")){ 
			board.set(playerMove, playerSign);
		}else{
			System.out.println(ANSI_RED + "That square is already taken" + ANSI_RESET);
			makeMove(player);
		}
		if(player1.equals(player)){
			makeMove(player2);
		}else{
			makeMove(player1);
		}
	}
	
	
	public boolean checkWin(){
		String playerOneSign = ANSI_YELLOW + "X" + ANSI_RESET;
		String playerTwoSign = ANSI_PURPLE + "O" + ANSI_RESET;
		for(int[] combo : winCombinations){
			if(board.get(combo[0]).equals(playerOneSign) && board.get(combo[1]).equals(playerOneSign) && board.get(combo[2]).equals(playerOneSign)){
				System.out.println("combo: " + board.get(combo[0]) + " " + board.get(combo[1]) + " " + board.get(combo[2]));
				System.out.println(ANSI_GREEN + player1 + " Wins!" + ANSI_RESET);
				return true;
			}else if(board.get(combo[0]).equals(playerTwoSign) && board.get(combo[1]).equals(playerTwoSign) && board.get(combo[2]).equals(playerTwoSign)){
				System.out.println(ANSI_GREEN + player2 + " Wins!" + ANSI_RESET);
				return true;
			}else if(!board.get(7).equals(" ") && !board.get(8).equals(" ") && !board.get(9).equals(" ") && !board.get(4).equals(" ") && !board.get(5).equals(" ") && !board.get(6).equals(" ") && 					!board.get(1).equals(" ") && !board.get(2).equals(" ") && !board.get(3).equals(" ")){
				System.out.println(ANSI_RED + "Nobody Wins :(" + ANSI_RESET);
				return true;
			}
		}
		return false;
	}
}

/* answer to question:
* Add a method that asks if the player wants to continue playing
* make a method that empties the board, 
* and add a counter variable for eacht player to keep track of each players wins
* Add a method that asks if the player wants to continue playing
*/