package Zadanie3a;

public class Calculate {

	public static int calculateRow(int num,int row,int col) {
		
		int theRow = 0;
		
		if(num <=row ) {
			theRow = row - num;
			return theRow;
		}
		else if (num <= row+col) {			
			theRow = 0;
			return theRow;
			
		}else if (num <= row+col+row) {
			theRow=num-row-col-1;
			return theRow;		
		}else if (num <=row+col+row+col) {	
			theRow = row-1;
			return theRow;
		}
		
		return -1;	
	}
	
	public static int calculateCol(int num,int row,int col) {
		
		int theCol = 0;
		
		if(num <=row ) {
			theCol = 0;
			return theCol;
		}
		else if (num <= row+col) {	
			theCol = num - row - 1;
			return theCol;		
		}else if (num <= row+col+row) {			
			theCol=col-1;
			return theCol;			
		}else if (num <=row+col+row+col) {			
			theCol = col - (num-row-col-row);
			return theCol;
		}
				
		return -1;
	}
	
	
public static int calculateStrana(int num,int row,int col) {
		
		int theCol = 0;
		
		if(num <=row ) {
			return 4;
		}
		else if (num <= row+col) {
			return 1;		
		}else if (num <= row+col+row) {	
			return 2;		
		}else if (num <=row+col+row+col) {
			return 3;	
		}
		
		return -1;
	}
	
}