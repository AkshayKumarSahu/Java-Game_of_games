import java.util.*;

class PlayG extends guess{
	public static void main(String[] args){
			Scanner Sc = new Scanner(System.in);
			int choice;
		do{			
			System.out.println("\t\t---------- GAME OF GAMES -----------");
			System.out.println("\t\t          ~~~~~~~~~~~~~~~ ");
			System.out.println("1. GUESS THE NUMBER");
			System.out.println("2. STONE PAPER SCISSOR");
			System.out.println("3. TIC TAC TOE");
			System.out.println("4. HANG-MAN");
			System.out.println("5. EXIT");
			System.out.println("\nENTER CHOICE: ");
			choice = Sc.nextInt();
			
			switch(choice){
				case 1:
						guess Player1 = new guess();
						Player1.now();
						break;
				case 2:
						sps Player2 = new sps();
						Player2.main1();
						break;
				case 3:
						TicTacToe Player3 = new TicTacToe();
						Player3.main2();
						break;
				case 4:
						Hangman2 Player4 = new Hangman2();
						Player4.main3();
						break;
				case 5:
						System.exit(0);
						
				default:
					System.out.println("Wrong Choice, Try Again");
				
			}
		}while(choice != 5);
	}
}
	// STONE PAPER SCISSOR GAME START
class sps extends sps1{
	void main1(){
		System.out.println("\t\t\t----- STONE PAPER SCISSOR GAME -----");
		
		sps a1 = new sps();
		
		for(int i= 1;i<=2 ;i++){
			System.out.println("\n\t\t SET "+i);
			System.out.println("\t\t------");
			a1.user();
			a1.computer();
			a1.result();
			a1.score();
		}
		a1.fresult();
	}
}

class sps1{
	String comp,user;
	int comp_score, user_score;
	public void computer(){

	String[] s = {"Stone","Paper","Scissor"};
	int rand1 = (int)(Math.random()*3);
	comp = s[rand1];
	System.out.println("COMPUTERS CHOICE IS --> "+comp);
}

public void user(){

	System.out.print("\n1]Stone");
	System.out.print("\t\t2]Paper");
	System.out.print("\t\t3]Scissor");
	System.out.print("\n\nEnter Your Choice --> ");

	Scanner sc =  new Scanner(System.in);
	int u = sc.nextInt();


	switch(u){

	 case 1: user = "Stone";
			break;

	 case 2: user = "Paper";
			break; 

	 case 3: user = "Scissor";
			break;

	}
	System.out.println("\nYOUR CHOICE IS --> "+user);
}
public void result(){

	if(user == "Stone" && comp == "Paper"){
			comp_score++;
			System.out.println("\nCOMPUTER WON !!!");
	}
	else if(user == "Stone" && comp == "Scissor"){
			user_score++;
			System.out.println("\nYOU WON !!!");
	}
	else if(user == "Paper" && comp == "Stone"){
			user_score++;
			System.out.println("\nYOU WON !!!");
	}
	else if(user == "Paper" && comp == "Scissor"){
			comp_score++;
			System.out.println("\nCOMPUTER WON !!!");
	}
	else if(user == "Scissor" && comp == "Stone"){
			comp_score++;
			System.out.println("\nCOMPUTER WON !!!");
	}
	else if(user == "Scissor" && comp == "Paper"){
			user_score++;
			System.out.println("\nYOU WON !!!");
	}
	else{
		System.out.println("\nITS A DRAW !!!");	
	}
}

public void score(){

	System.out.println("\n\nYour score --> "+user_score+"  computer score --> "+comp_score);

}
public void fresult(){
	if(user_score > comp_score)
		System.out.println("\n\nYOU WON THE GAME");
	else if(comp_score > user_score)
		System.out.println("\n\nCOMPUTER WON THE GAME");
	else
		System.out.println("\n\nGAME IS A DRAW");	
}
}

// TIC TAC TOE GAME START

class TicTacToe {
	static Scanner in;
	static String[] board;
	static String turn;

	void main2(){
		in = new Scanner(System.in)	;
		board = new String[9];
		turn = "X";
		String winner = null;
		populateEmptyBoard();
		
		System.out.println("\n\n\t\t---------- Tic Tac Toe ----------");
		System.out.println("\n\t\tWELCOME TO 2 PLAYER TIC TAC TOE");
				
		printBoard();
		
		System.out.print("X will play first. Enter a slot number to place X in: ");

		while (winner == null) {
			int numInput;
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Invalid input a; re-enter slot number:");
					continue;
				}  
			} catch (InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = turn;
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				printBoard();
				winner = checkWinner();
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}

	static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	static void printBoard() {
		System.out.println("\n");
		System.out.println("\t\t| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("\t\t|-----------|");
		System.out.println("\t\t| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("\t\t|-----------|");
		System.out.println("\t\t| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("\n");
	}

	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
}

//HANG-MAN CODE START

class Hangman2 {

	private static String[] words = {"terminator", "banana", "computer", "cow", "rain", "water","program","java", "project","india" };
	private static String word = words[(int) (Math.random() * 10)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;

	void main3() {
		
		System.out.println("\n\n\t\t---------- HANG MAN ----------");
		
		System.out.println("\n\n\tGUESS THE WORD IN ASTERISK !");
		Scanner sc = new Scanner(System.in);
		Hangman2 obj= new Hangman2();
		while (count < 7 && asterisk.contains("*")) {
			System.out.println("\nWORD: "+ asterisk);
			System.out.print("GUESS ANY LETTER IN THE ABOVE WORD : ");
			String guess = sc.next();
			obj.hang(guess);
		}
		
	}

	 void hang(String guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanImage();
		} else {
			System.out.println("\nCORRECT GUESS !!\n");
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("CORRECT! YOU WIN! THE WORD WAS:  " + word);
		}
	}

	 void hangmanImage() {
		
		if (count == 1) {
			System.out.println("\nWrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t___|___");
			System.out.println("\n");
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t___|___");
			System.out.println("\n");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("\t\t   ____________");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   | ");
			System.out.println("\t\t___|___");
			System.out.println("\n");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("\t\t   ____________");
			System.out.println("\t\t   |          _|_");
			System.out.println("\t\t   |         /   \\");
			System.out.println("\t\t   |        |     |");
			System.out.println("\t\t   |         \\_ _/");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t   |");
			System.out.println("\t\t___|___");
			System.out.println("\n");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("\t\t   ____________");
			System.out.println("\t\t   |          _|_");
			System.out.println("\t\t   |         /   \\");
			System.out.println("\t\t   |        |     |");
			System.out.println("\t\t   |         \\_ _/");
			System.out.println("\t\t   |           |");
			System.out.println("\t\t   |           |");
			System.out.println("\t\t   |");
			System.out.println("\t\t___|___");
			System.out.println("\n");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again\n");
			System.out.println("\t\t   ____________");
			System.out.println("\t\t   |          _|_");
			System.out.println("\t\t   |         /   \\");
			System.out.println("\t\t   |        |     |");
			System.out.println("\t\t   |         \\_ _/");
			System.out.println("\t\t   |           |");
			System.out.println("\t\t   |           |");
			System.out.println("\t\t   |          / \\ ");
			System.out.println("\t\t___|___      /   \\");
			System.out.println("\n");
		}
		if (count == 7) {
			System.out.println("\n\t\t-----GAME OVER-------");
			System.out.println("\t\t   ____________");
			System.out.println("\t\t   |          _|_");
			System.out.println("\t\t   |         /   \\");
			System.out.println("\t\t   |        |     |");
			System.out.println("\t\t   |         \\_ _/");
			System.out.println("\t\t   |          _|_");
			System.out.println("\t\t   |         / | \\");
			System.out.println("\t\t   |          / \\ ");
			System.out.println("\t\t___|___      /   \\");
			System.out.println("\n\t\tGAME OVER! The word was:  " + word);
		}
		System.out.println("\n\n");
	}
	
}


