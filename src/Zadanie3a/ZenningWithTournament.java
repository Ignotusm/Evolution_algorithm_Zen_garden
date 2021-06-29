package Zadanie3a;

import java.util.Scanner;

public class ZenningWithTournament {
	
	public void zWithT(int maxRow,int maxCol) {
		
		Scanner scanner = new Scanner(System.in);
		
		Tournament t = new Tournament();
		Mutation m = new Mutation();
		Garden kert = new Garden(maxRow,maxCol);
		NewZen nz = new NewZen();

		int index=0;
		int cisloK;
		int kRow=0;
		int kCol=0;
		int maxPopulation = 0;
		int maxGeneration = 0;
		int fitnessSum=0;
		
		kert.createGarden(kert.garden, maxRow, maxCol);
		kert.printGarden(kert.garden, maxRow, maxCol);
		
		System.out.println("Zadajte pocet kamene :");
		cisloK=scanner.nextInt();
		System.out.println("Zadali ste pocet : "+cisloK);
		
		//urobime 
	
		for(int i=0;i<cisloK;i++) {
		
			System.out.print("Row:");
			kRow=scanner.nextInt();
			System.out.println("Col:");
			kCol=scanner.nextInt();
		
			System.out.println("Row :"+kRow+" Col :"+kCol);
		
			kert.garden[kRow][kCol]=-1;
			
		}
		
		//nacitame velkost populacii a maximalny pocet genov
		System.out.println("Velkost populacii : ");
		maxPopulation=scanner.nextInt();
		System.out.println("Maximalne velkost generacii : ");
		maxGeneration=scanner.nextInt();
		
		//urobime populaciu
		Population generacio = new Population(maxPopulation, maxRow, maxCol, cisloK);
		
		//vykalkulujeme fitness
		for(int i =0;i<maxPopulation;i++) {
		index=nz.zenning(generacio.population[i], kert.garden, maxRow, maxCol, cisloK);
		fitnessSum=fitnessSum+generacio.population[i].fitness;
		//ked index je 1 tak vyhrali sme 
		if(index==1) {
			kert.printGarden(kert.garden,maxRow,maxCol);
			break;
		}//zahradu na zaciatocnu
		kert.createGarden(kert.garden, maxRow, maxCol);
		}
		//vypocitame avg fittness
		int avgFittness = fitnessSum/maxPopulation;
		
		System.out.println("Avg. fittness : "+avgFittness);
		
		int generationCount=0;
		//generujeme nove generacii kym nenajdeme riesenie
		while(index!=1) {
		//vytvorime generaciu
		fitnessSum=0;
		generacio = t.tournamentSelection(generacio,maxRow,maxCol,cisloK);
		generacio=m.mutation(generacio, maxRow, maxCol, cisloK);
		//vypocitame fitness pre jednotlive jedincovi
		for(int i = 0 ; i < maxPopulation ; i++) {

			index=nz.zenning(generacio.population[i], kert.garden, maxRow, maxCol, cisloK);
			fitnessSum=fitnessSum+generacio.population[i].fitness;
			//ked najdeme riesenie tak sme vyhrali
			if(index==1) {
				System.out.println("Vyhra fittness  "+generacio.population[i].fitness);
				kert.printGarden(kert.garden,maxRow,maxCol);
				break;
				
			}
			kert.createGarden(kert.garden, maxRow, maxCol);
		}
		
		avgFittness=fitnessSum/maxPopulation;
		
		generationCount++;	
		
		if(generationCount==maxGeneration) {
			System.out.println("404 not found");
			break;
		}
		//vypiseme generaciu a avg fittness pre danu generaciu
		System.out.println("Generacia : "+generationCount+"  avg. fittness : "+avgFittness);
		
		}
		
		
		
	}

}
