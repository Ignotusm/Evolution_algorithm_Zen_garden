package Zadanie3a;

import java.util.Scanner;

public class ZenningWithRulette {

	public void zWithR(int maxRow,int maxCol) {
		
		Scanner scanner = new Scanner(System.in);
		//vytvorim objekty
		Ruletta r = new Ruletta();
		Mutation m = new Mutation();
		Garden kert = new Garden(maxRow,maxCol);
		NewZen nz = new NewZen();
		//pomocne premenna
		int index=0;
		int cisloK;
		int kRow=0;
		int kCol=0;
		int maxPopulation = 0;
		int maxGeneration = 0;
		int fitnessSum=0;
		//vytvorim zahrady
		kert.createGarden(kert.garden, maxRow, maxCol);
		kert.printGarden(kert.garden, maxRow, maxCol);
		//citam kamene a ich pozicii
		System.out.println("Zadajte pocet kamene :");
		cisloK=scanner.nextInt();
		System.out.println("Zadali ste pocet : "+cisloK);
		
		//urobime kamene na zahradu
		for(int i=0;i<cisloK;i++) {
		
			System.out.print("Row:");
			kRow=scanner.nextInt();
			System.out.println("Col:");
			kCol=scanner.nextInt();
		
			System.out.println("Row :"+kRow+" Col :"+kCol);
		
			kert.garden[kRow][kCol]=-1;
			
		}
		//zistime velkost populacii a maximalni pocet generacii
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
		//ked index je 1 tak vyhrali sme a vypisuje zahradu
		if(index==1) {
			kert.printGarden(kert.garden,maxRow,maxCol);
			break;
		}//zastavi zahradu ako zaciatocny
		kert.createGarden(kert.garden, maxRow, maxCol);
		}
		//vypocita fittness
		int avgFittness = fitnessSum/maxPopulation;
		//pocitadlo
		int generationCount=0;
		//kym nenajdeme cielu
		while(index!=1) {
		//fitnes sum je 0 a potom urobime selekciu pomocou rulettu a novu generacia moze este urobit mutaciu
		fitnessSum=0;
		generacio = r.calculateFitness(generacio,maxRow,maxCol,cisloK);
		generacio=m.mutation(generacio, maxRow, maxCol, cisloK);
		//vypocitame fitness pre kazdy jedincov
		for(int i = 0 ; i < maxPopulation ; i++) {
			//vypocitame fittness
			index=nz.zenning(generacio.population[i], kert.garden, maxRow, maxCol, cisloK);
			fitnessSum=fitnessSum+generacio.population[i].fitness;
			//ked je to 1 tak sm vyhrali
			if(index==1) {
				System.out.println("Vyhra fittness  "+generacio.population[i].fitness);
				kert.printGarden(kert.garden,maxRow,maxCol);
				break;
			}//nastavi zahradu ako zaciatocny
			kert.createGarden(kert.garden, maxRow, maxCol);
		}
		//vypocitame avarege fittness pre danu populaciu 
		avgFittness=fitnessSum/maxPopulation;
		generationCount++;	
		if(generationCount==maxGeneration) {
			System.out.println("404 Not found");
			break;
		}
		//vypiseme fittness pre dany generacii
		System.out.println("Generacia : "+generationCount+"  avg. fittness : "+avgFittness);
		
		}
		System.out.println("GENERACIA : "+generationCount);	
	}
}
