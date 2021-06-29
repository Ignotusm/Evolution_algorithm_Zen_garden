package Zadanie3a;

public class GeneratorOrdinary {

	
	//nahodne vygenerujeme geny
	public static int[] generateOrdinaryGenes(int size) {
		
		int[] ordinary = new int[size];
		
		for(int i = 0 ; i < size ; i++) {
			ordinary[i]=(int)(Math.random()*(size*2-1)+1);
		}
		
		return ordinary;
		
	}
	
}

