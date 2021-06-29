package Zadanie3a;

public class Ruletta {

	
	public Population calculateFitness(Population gen,int maxRow,int maxCol,int kamen) {
		
		int sumFitness=0;	
		int size = gen.population.length;
		int crossPoint;
		int start;
		int end;
		int sum=0;
		int randomNum = 0;
		int count=0;
		int index=0;
			
		//novy generacia
		Population newGen = new Population(gen.population.length,maxRow,maxCol,kamen);
		
		Monk parent1;
		Monk parent2;
		
		//vypocitam sum of fitness
		for(int i = 0; i < size;i++) {
			sumFitness+=gen.population[i].fitness;
		}
		
		int pickNum = (int) (size*0.05);
		
		while(true) {
			
		Monk child1 = new Monk(maxRow+maxCol,kamen);
		Monk child2 = new Monk(maxRow+maxCol,kamen);
		//hladanie parent1	
		randomNum = (int)(Math.random()*sumFitness);

			for(int i = 0 ; i < size ;i++) {
				sum=sum+gen.population[i].fitness;
				if(sum>randomNum) {
					index=i;
					break;
				}
		
			}
			
			sum=0;
			
			parent1=gen.population[index];
		
			//hladanie parent2
			
			randomNum = (int)(Math.random()*sumFitness);
				for(int i = 0 ; i < size ;i++) {
				sum=sum+gen.population[i].fitness;
				if(sum>randomNum) {
					index=i;
					break;
				}
	
			}
		
				
			parent2 = gen.population[index];
			
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
			sum=0;
		}
		
		return newGen;
	}
	
	
}