import java.util.Random;
import java.util.Scanner;

public class Player {
	
	/*Εισαγωγή της κίνησης του παίκτη1 στο ταμπλό του παιχνιδιού.
	Έλεγχος εγκυρότητας της επιλογής του παίκτη.
	Τοποθέτηση του συμβόλου 'Χ' στο κελί που επιλέχθηκε.*/	
	public void insertPlayer1Move(String[][] currentBoard) {
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.print("Player Move (X): ");
			String playerMove = in.nextLine();	
			if (playerMove.equals("A1")) 
				if (currentBoard[0][0] == " ") { 
					currentBoard[0][0] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("A2"))
				if (currentBoard[1][0] == " ") {
					currentBoard[1][0] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("A3"))
				if (currentBoard[2][0] == " ") {
					currentBoard[2][0] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("B1"))
				if (currentBoard[0][1] == " ") {
					currentBoard[0][1] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("B2"))
				if (currentBoard[1][1] == " ") {
					currentBoard[1][1] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("B3"))
				if (currentBoard[2][1] == " ") {
					currentBoard[2][1] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("C1"))
				if (currentBoard[0][2] == " ") {
					currentBoard[0][2] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("C2"))
				if (currentBoard[1][2] == " ") {
					currentBoard[1][2] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else if (playerMove.equals("C3"))
				if (currentBoard[2][2] == " ") {
					currentBoard[2][2] = "X";
					break;
				}else System.out.println("The space entered is already taken");
			else System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1)");
		}
	}

	/*Εισαγωγή της κίνησης του υπολογιστή.
	Τυχαία επιλογή ενός άδειου κελιού του ταμπλό.
	Τοποθέτηση του συμβόλου 'Ο' στο κελί που επιλέχθηκε.*/
	public void insertPcPlayerMove(String[][] currentBoard) {
		Random random = new Random();
		while(true) {
			int pcRowSelected = random.nextInt(3);
			int pcColumnSelected = random.nextInt(3);
			
			if (currentBoard[pcRowSelected][pcColumnSelected] == " ") {
				
				if (pcRowSelected == 0 && pcColumnSelected == 0)
					System.out.println("Computer Move (O): A1");
				else if(pcRowSelected == 1 && pcColumnSelected == 0)
					System.out.println("Computer Move (O): A2");
				else if(pcRowSelected == 2 && pcColumnSelected == 0)
					System.out.println("Computer Move (O): A3");
				else if(pcRowSelected == 0 && pcColumnSelected == 1)
					System.out.println("Computer Move (O): B1");
				else if(pcRowSelected == 1 && pcColumnSelected == 1)
					System.out.println("Computer Move (O): B2");
				else if(pcRowSelected == 2 && pcColumnSelected == 1)
					System.out.println("Computer Move (O): B3");
				else if(pcRowSelected == 0 && pcColumnSelected == 2)
					System.out.println("Computer Move (O): C1");
				else if(pcRowSelected == 1 && pcColumnSelected == 2)
					System.out.println("Computer Move (O): C2");
				else if(pcRowSelected == 2 && pcColumnSelected == 2)
					System.out.println("Computer Move (O): C3");
				
				currentBoard[pcRowSelected][pcColumnSelected] = "O";
				break;
			}
		}
	}

	//Έλεγχος του ταμπλό για την εύρεση νικητή.
	public boolean isWinner(String[][] currentBoard, String playerSymbol) {
		
		//Έλεγχος στηλών.
		for (int i=0; i<3; i++) 
			if (currentBoard[0][i].equals(currentBoard[1][i]) && currentBoard[1][i].equals(currentBoard[2][i]))
				if (currentBoard[0][i].equals(playerSymbol))
					return true;
		
		//Έλεγχος γραμμών.
		for (int i=0; i<3; i++)
			if (currentBoard[i][0].equals(currentBoard[i][1]) && currentBoard[i][1].equals(currentBoard[i][2]))
				if (currentBoard[i][0].equals(playerSymbol))
					return true;
		
		//Έλεγχος κύριας διαγωνίου.
		if (currentBoard[0][0].equals(currentBoard[1][1]) && currentBoard[1][1].equals(currentBoard[2][2]))
			if (currentBoard[0][0].equals(playerSymbol))
				return true;
		
		//Έλεγχος αριστερής διαγωνίου.
		if (currentBoard[0][2].equals(currentBoard[1][1]) && currentBoard[1][1].equals(currentBoard[2][0]))
			if (currentBoard[0][2].equals(playerSymbol))
				return true;
		
		return false;
	}

	
}
