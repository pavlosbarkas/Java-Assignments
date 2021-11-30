
public class Main {

	public static void main(String [] args) {
		
		Board board = new Board();
		Player player1 = new Player();
		Player pcPlayer = new Player();
		
		String[][] currentBoard = new String[3][3];
		
		System.out.println("************");
		System.out.println("Tic-Tac-Toe!");
		System.out.println("************");
		
		System.out.println("Please enter the column (A, B or C) and then the row (1, 2 or 3) of your move.");
		
		//Αρχικοποίηση του πίνακα.
		board.intializeBoard(currentBoard);
		
		//Μετρητής συνολικών κινήσεων των παικτών.
		int movesCounter = -1;
		
		while (true){	

			//Εισαγωγή της κίνησης του παίκτη.
			board.printCurrentState(currentBoard);
			player1.insertPlayer1Move(currentBoard);
			movesCounter++;
			//Έλεγχος αν νίκησε ο παίκτης και εκτύπωση κατάλληλου μηνύματος στην οθόνη.
			if (player1.isWinner(currentBoard, "X")) {
				board.printCurrentState(currentBoard);
				System.out.println("You Win!");
				break;
			}
			
			/*Εκτύπωση μηνύματος ισοπαλίας
			Το παιχνίδι λήγει ισόπαλο όταν έχουν εισαχθεί 9 κινήσεις,
			οπότε ο πίνακας έχει γεμίσει, και δεν έχει βρεθεί νικητής.*/
			if (movesCounter == 8) { 
				board.printCurrentState(currentBoard);
				System.out.println("It's a Draw!");
				break;
			}
			
			//Εισαγωγή κίνησης του υπολογιστή.
			board.printCurrentState(currentBoard);
			pcPlayer.insertPcPlayerMove(currentBoard);
			movesCounter++;
			//Έλεγχος αν νίκησε ο υπολογιστής και εκτύπωση κατάλληλου μηνύματος στην οθόνη.
			if (pcPlayer.isWinner(currentBoard, "O")) {
				board.printCurrentState(currentBoard);
				System.out.println("You Lose!");
				break;
			}
			
		}
	
	}

}
