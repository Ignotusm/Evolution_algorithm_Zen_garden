package Zadanie3a;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//pomocne premenna
		int fixRow;
		int fixCol;
		int row;
		int col;
		int choose=0;
		//citanie rozmery
		System.out.print("Add rozmer[row][col]:");
		fixRow=scanner.nextInt();
		fixCol=scanner.nextInt();
		//vyberanie sposob selektovanie
		System.out.println("Choose Selection method 1) Roulette or 2) Tournament ");
		choose=scanner.nextInt();
		
		if(choose==1) {
			//selektujeme s Roulettou
			ZenningWithRulette zR = new ZenningWithRulette();
			zR.zWithR(fixRow, fixCol);
			
		}
		else if(choose == 2) {
			
			//selektujeme s Tournamentom
			ZenningWithTournament zT = new ZenningWithTournament();
			zT.zWithT(fixRow, fixCol);
			
		}
		else {
			System.out.println("INVALID CHOOSE");
		}
		
		

	}

}
