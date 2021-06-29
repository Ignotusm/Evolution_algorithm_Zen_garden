package Zadanie3a;

public class Monk {
	
	int[] genOrdinary;
	int fitness;
	
	public Monk(int size,int kamen) {
		
		this.genOrdinary=GeneratorOrdinary.generateOrdinaryGenes(size);
		
	}

}
