
public class Board {

	//Αρχικοποίηση του πίνακα-ταμπλό του παιχνιδιού.
	public void intializeBoard(String[][] currentBoard) {
		for(int i=0; i<3; i++) 
			for (int j=0; j<3; j++) 
				currentBoard[i][j] = " ";
	}
	
	//Εκτύπωση της τρέχουσας κατάστασης του πίνακα-ταμπλό του παιχνιδιού.
	public void printCurrentState(String[][] currentBoard) {
		System.out.println("   A B C");
		for (int i=0; i<3; i++) {
			System.out.print((i+1) +" |");
			for (int j=0; j<3; j++) {
				System.out.print(currentBoard[i][j] + "|");
			}
			System.out.println();
		}
	}

}
