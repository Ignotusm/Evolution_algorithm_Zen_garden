package Zadanie3a;

public class NewZen {

	
	public int zenning(Monk monk,int[][] garden,int fixRow,int fixCol,int kamen) {
			
		int ciel = 0;
		
		//pomocne premenna 
		int row = 0;
		int col =0;
		int theWay = 0;
		int bWay =0;
		
		int tah=1;
		int strana = 0;
		int times = 1;
		
		int fitness=0;
		
		int count=0;
		
		
		//zacina prehladavat geny a podla toho urobi zahradu
		while(true) {
			
			//1. pozri najprv kde zacina 
			
			//vykalkulujeme zaciatocne pozicie
			strana=Calculate.calculateStrana(monk.genOrdinary[count], fixRow, fixCol);
			theWay = calTheWay(strana);
			row=Calculate.calculateRow(monk.genOrdinary[count], fixRow, fixCol);
			col=Calculate.calculateCol(monk.genOrdinary[count], fixRow, fixCol);
			//2. kontruluje ci je tam este volna
			
			//ked je tam volna a mozem zacat ? ked nie tak ide na dalsiu gen
			if(garden[row][col]==0) {	
				//tak zacina tam mnich pracovat
				garden[row][col]=tah;
				fitness++;		
			}else {		
				//ked uz nema ine geny tak konci
				count++;
				if(count == monk.genOrdinary.length) {
					break;
				}
				continue;
			}
			
			//3. ked je tam volno tak ide urobit na tejto ceste zahradu kym nejde von z toho
			
			while(true) {

				if(theWay == 1) {
					//dostal von
					if(row-1 < 0) {
						break;
					}
					//ked pokracujuci policko je volny
					if(garden[row-1][col]==0) {
						
						garden[row-1][col]=tah;
						fitness++;
						row=row-1;
						
					}else {
						//vyberieme dalsi cesti 
						theWay=checkTheWay(garden,row,col,monk,theWay,fixRow,fixCol);
						//ked je to -1 tak dostal von
						if(theWay==-1) {
							break;
						}
						
					}
					
				}
				else if(theWay == 2) {
					//dostal von
					if(col+1 >= fixCol) {
						break;
					}
					//ked pokracujuci policko je volny
					if(garden[row][col+1]==0) {
						garden[row][col+1]=tah;
						fitness++;
						col=col+1;
					}else {
						//ked vyberieme dalsi cestu
						theWay=checkTheWay(garden, row, col, monk, theWay, fixRow, fixCol);
						if(theWay==-1) {
							break;
						}
					}
				}
				else if(theWay == 3 ) {
					
					if(row+1 >= fixRow) {
						break;
					}
					
					if(garden[row+1][col]==0) {
						garden[row+1][col]=tah;
						fitness++;
						row=row+1;
					}else {

						theWay=checkTheWay(garden, row, col, monk, theWay, fixRow, fixCol);

						if(theWay==-1) {
							break;
						}
					}
					
				}
				
				else if(theWay == 4 ) {
					
					if(col-1<0) {
						break;
					}
					
					if(garden[row][col-1]==0) {
						garden[row][col-1]=tah;
						fitness++;
						col=col-1;
					}else {

						theWay=checkTheWay(garden, row, col, monk, theWay, fixRow, fixCol);

						if(theWay==-1) {
							break;
						}
						
						
					}
					
				}

				if(theWay==-2) {
					return 0;
				}
				
			}

			//4. ked urobil tah tak incrementuje tah a ide na 1. bod
			tah++;	
			times=0;

		}
		
		monk.fitness=fitness;

		if(theWay != -2 && (fitness==((fixRow*fixCol)-kamen))) {
			return 1;
		}
		
		return ciel;
	}


//hlada dalsi cestu
	public int checkTheWay(int[][] garden , int row , int col,Monk monk,int way,int fixRow,int fixCol) {
		
		int theWay=-1;
	
			//ked ide hore alebo dole 
			if(way==1 || way ==3) {
	
				if((col+1>=fixCol || col-1<0)) {
					return -1;
				} else if(col+1<fixCol && garden[row][col+1]==0) {
					return 2;
				} else if(col-1 >= 0 && garden[row][col-1]==0) {
					return 4;
				} else {
					return -2;
				}
				
			}
			
			//ked mnich ide dolava alebo doprava
			if(way==2 || way ==4) {
		
				if((row+1>= fixRow || row -1<0)) {
					return -1;
				}else if(row+1<fixRow && garden[row+1][col]==0) {
					return 3;
				}else if(row - 1 >=0 && garden[row-1][col]==0) {
					return 1;
				}else {
					return -2;
				}
				
			}
					
		return theWay;
	}
	

	//vykalkuluje ze od ktorej strayn vstupil a v akom smere ide
	public int calTheWay(int strana) {
		
		int theWay=0;
		
		if(strana==1) {
			theWay=3;
			return theWay;
		}else if(strana == 2) {
			theWay=4;
			return theWay;
		}else if(strana == 3) {
			theWay = 1;
			return theWay;
		}else if(strana == 4) {
			theWay = 2;
			return theWay;
		}
		
		return theWay;
	}

}
