package Zadanie3a;

public class Population {

	Monk[] population ;
	
	public Population(int size,int maxRow,int maxCol,int kamen) {
		this.population=createFirstPopulation(size, maxRow, maxCol, kamen);
	}
	
	public Monk[] createFirstPopulation(int size,int maxRow,int maxCol , int kamen) {
		
		Monk[] population = new Monk[size];
		
		for(int i = 0 ; i < size;i++) {
			population[i]=new Monk(maxRow+maxCol,kamen);
		}
		
		return population;
		
	}
	
}