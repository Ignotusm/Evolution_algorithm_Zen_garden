package Zadanie3a;

public class Garden {
	
	int[][] garden;
	private int row;
	private int col;
	
	
	public Garden(int row,int col) {
		
		this.row=row;
		this.col=col;
		this.garden=new int[row][col];
		
		for(int i = 0 ; i<row;i++) {
			for(int j = 0; j<col ;j++) {
				garden[i][j]=0;
			}
		}
	}
	
	
	//vypisujeme zahradu
	public static void printGarden(int[][] garden,int row,int col) {
		
		for(int i = 0 ; i  < row;i++) {
			for(int j = 0 ; j< col ; j++) {
				
				if(garden[i][j]==-1) {
					System.out.print(" [K] ");
				}
				else {
				System.out.print(" ["+garden[i][j]+"] ");
				}
			}
			System.out.println();
		}
		
		
	}
	
	//urobime zahradu
	public static void createGarden(int[][] garden,int row,int col) {
		for(int i = 0 ; i<row;i++) {
			for(int j = 0; j<col ;j++) {
				if(garden[i][j]==-1) {
					continue;
				}
				garden[i][j]=0;
			}
		}
		
		
	}

	public int getRow() {
		return row;
	}



	public int getCol() {
		return col;
	}


}
