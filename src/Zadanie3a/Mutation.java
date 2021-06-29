package Zadanie3a;

public class Mutation {

	public Population mutation(Population newGen,int maxRow,int maxCol,int kamen) {
	
		//mutacia pre jedincov je 10% a mutacia pre genu v jedince je 40%
		double mutationRatio = 0.1;
		double mutation=0;
		double inGeneMutation=0.4;
		double gMutation;
		
		int mutationIndex;
		int mutationValue;
		int mutationCount=0;
		//pozrime kedy moze mutovat jedinec
		for(int i = 0 ; i < newGen.population.length;i++) {
				
			mutation = Math.random();
			//ked mutation je menej ako 0.1 tak mozeme mutovat gen ideme gen po gen a ked mame sancu tak mutujeme a ideme dalej
			if(mutation<=mutationRatio) {
				
				for(int j = 0 ; j<newGen.population[i].genOrdinary.length;j++) {
				
					gMutation=Math.random();
			
				if(inGeneMutation>gMutation) {	
				mutationCount++;
				mutationValue = (int)(Math.random()*(maxRow+maxRow+maxCol+maxCol)+1);
				newGen.population[i].genOrdinary[j]=mutationValue;
				}
			}
			
			
		}
			
		}
	
		return newGen;
		
	}
}