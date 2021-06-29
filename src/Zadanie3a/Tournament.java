package Zadanie3a;

public class Tournament {

	public Population tournamentSelection(Population gen,int maxRow,int maxCol,int kamen) {
		
		//vytvorime novu generaciu
		Population newGen = new Population(gen.population.length,maxRow,maxCol,kamen);
		
		int randomIndex=0;
		int index = 0;
		int winnerIndex = 0;
		int size = gen.population.length;
		int tourSize= (int)(size*0.15);
		
		
		Monk parent1;
		Monk parent2;
		
		int crossPoint;
		int start;
		int end;
		
		
		index = 0;
		
		int inx=0;
		int count = 0;
		
		while(true) {
			
			Monk child1=new Monk(maxRow+maxCol, kamen);
			Monk child2=new Monk(maxRow+maxCol, kamen);
			
			//hladanie parent1
			
			randomIndex=(int)(Math.random()*size);
			winnerIndex=randomIndex;
			
			for(int j = 0 ; j < tourSize;j++) {
				randomIndex=(int)(Math.random()*size);
				
				if(gen.population[winnerIndex].fitness<gen.population[randomIndex].fitness) {
					winnerIndex=randomIndex;
				}
				
			}
			
			parent1=gen.population[winnerIndex];
			
			//hladanie parent2
			
			randomIndex=(int)(Math.random()*size);
			winnerIndex=randomIndex;
			
			for(int j = 0 ; j < tourSize;j++) {
				randomIndex=(int)(Math.random()*size);
				
				if(gen.population[winnerIndex].fitness<gen.population[randomIndex].fitness) {
					winnerIndex=randomIndex;
				}
				
			}
			
			parent2=gen.population[winnerIndex];
			
			//urobime dve nove deti do noveho generacie
			
			crossPoint=(maxRow+maxCol)/2;
			
			start = (int)(Math.random())*((maxRow+maxCol)/2);
			end = (int)(Math.random())*((maxRow+maxCol)/2)+crossPoint;
			
			
			
			for(int i = start;i<crossPoint;i++) {
				
				child1.genOrdinary[i]=parent1.genOrdinary[i];
				child2.genOrdinary[i]=parent2.genOrdinary[i];
			}
			for(int i = crossPoint ; i<end;i++) {
				
				child1.genOrdinary[i]=parent2.genOrdinary[i];
				child2.genOrdinary[i]=parent1.genOrdinary[i];
				
			}
			
		
			
			newGen.population[count++]=child1;
			
			if(count==gen.population.length) {
				break;
			}
						
			newGen.population[count++]=child2;
			
			
			if(count==gen.population.length) {
				break;
			}
			

			
		}
	
		return newGen;
		
	}
	
}
