package Zoo;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Zoo.Animal.*;
import Zoo.Employee.Employee;
import Zoo.Enclosure.AquariumEnclosure;
import Zoo.Enclosure.AviaryEnclosure;
import Zoo.Enclosure.Enclosure;
import Zoo.Enclosure.StandardEnclosure;
import Zoo.Enclosure.WolfEnclosure;

public class ZooMain {
    public static void main(String [ ] args) {
    	
    	System.out.println("======== Bienvenue sur l'application Zoo ! ========");
    	
    	Employee employee = Employee.getEmployee().initEmployee("Marc LAPORTE", 'm', 89);
        Zoo zoo = Zoo.getZoo().initZoo("Zoo de la LP", employee, 5);
    	
    	// En-dessous se trouve un exemple pour montrer que les classes d'animaux, d'enclos et d'employé fonctionnent
    	// Voulant se concentrer plus sur le système des loups, celle-ci est donc mise en commentaires
    	// Vous pouvez tout à fait la décommenter pour voir le résultat escompté

        /*
        Enclosure<Wolf> enclosure = new StandardEnclosure<Wolf>("Forêt des loups", 42, 2);
        Enclosure<Tiger> enclosure2 = new StandardEnclosure<Tiger>("Famille Tigrou", 56, 1);
        Enclosure<GoldFish> enclosure3 = new AquariumEnclosure<GoldFish>("Aquarium des petits poissons", 58,3, 5);
        Enclosure<Eagle> enclosure4 = new AviaryEnclosure<Eagle>("Volière volante", 60, 5, 35);
        Enclosure<GoldFish> enclosure5 = new AquariumEnclosure<GoldFish>("Petit aquarium", 20, 1, 3);

        Tiger tiger = new Tiger("Tigrou", 'm', 62, 189);
        GoldFish goldFish = new GoldFish("Nemo", 'm', 1, 2);
        GoldFish goldFish2 = new GoldFish("Marin", 'm', 1, 3);
        GoldFish goldFish3 = new GoldFish("Dory", 'f', 1,3);
        Eagle eagle = new Eagle("Royal", 'f', 5, 2);

        zoo.setEmployee(employee);
        zoo.addEnclosure(enclosure);
        zoo.addEnclosure(enclosure2);
        zoo.addEnclosure(enclosure3);
        zoo.addEnclosure(enclosure4);
        zoo.addEnclosure(enclosure5);

        enclosure2.addAnimal(tiger);
        enclosure2.addAnimal(tiger);
        enclosure3.addAnimal(goldFish);
        enclosure3.addAnimal(goldFish2);
        enclosure3.addAnimal(goldFish3);
        enclosure3.feedAnimals();
        enclosure4.addAnimal(eagle);

        employee.moveAnimalFromEnclosure(goldFish2, enclosure3, enclosure5);
        employee.moveAnimalFromEnclosure(goldFish, enclosure5, enclosure3);

        zoo.showAllAnimals();

        enclosure.feedAnimals();
        
        System.out.println(Utils.getListRankDomination());
        
        */
        
        // Lancement de la simulation
        Scanner sc = new Scanner(System.in);
        String responseSimu = "a";
        while (responseSimu != "O" || responseSimu != "o" || responseSimu != "N" || responseSimu != "n") {
	        System.out.println("Souhaitez-vous démarrer la simulation ? (O/N)");
	    	responseSimu = sc.nextLine();
	    	switch(responseSimu) {
	    		case "O":
	    		case "o":
	    			System.out.println("Très bien. La simulation va se lancer.");
	    			launchSimulation();
	    			break;
	    		case "N":
	    		case "n":
	    			System.out.println("Tant pis pour vous, à bientôt!");
	    			System.exit(0);
	    		default:
	    			System.out.println("Caractère incorrect, veuillez réessayer.");
	    	}
        }
    } // main
    
    // Système de temps de l'application
    public static void launchSimulation() {
    	
    	// Texte de présentation
    	System.out.println("Vous avez décidé de lancer la simulation");
    	System.out.println("Cinq types d'actions vont être lancées aléatoirement au fil du temps.");
    	System.out.println("Nous vous laissons les découvrir au fur et à mesure de la simulation.");
    	System.out.println("Bonne simulation !");
    	
	    // Compteur de randoms : définir l'évènement à produire
		int cptRandoms = 0;
		
		// Cela nous permet d'executer au moins une fois les actions au premier tour
		int randomOne = 1;
		int randomTwo = 1;
		int randomThree = 1;
		int randomFive = 1;
		
		// Ceci nous servira à lire les entrées clavier
		Scanner sc = new Scanner(System.in);
		
		// Création de la colonnie
		WolfColony wolfColony = new WolfColony();
		
		while (true) {
			// Définir les tâches à faire grâce au Random
			switch(cptRandoms) {
			
				// CREATION D'UNE NOUVELLE MEUTE
				case 0:
				
					// On fait une pause pour l'utilisateur
					Utils.takePause();
					
					// On décide si on crée une nouvelle meute (généré aléatoirement, 1 chance sur 2)
		            int randomPack = ThreadLocalRandom.current().nextInt(1,randomOne+1);
		            if (randomPack == 1) {
		            	
		            	System.out.println("");
		            	System.out.println("======== CREATION D'UNE NOUVELLE MEUTE DE LOUPS ========");
		            	System.out.println("Un nouveau couple de loups va être crée, nous avons besoin de vous!");
		            	
		            	// Création du male et de la femelle du couple
		            	System.out.println("Comment souhaitez-vous nommer le mâle du couple ?");
		            	String strMale = sc.nextLine();
		            	Wolf male = new Wolf(strMale, 'm', 36, 37, 'α');
		            	System.out.println("Comment souhaitez-vous nommer la femelle du couple ?");
		            	String strFemale = sc.nextLine();
		                Wolf female = new Wolf(strFemale, 'f', 36, 38,'α');
		                
		                // Création du couple
		            	WolfCouple wolfCoupleApp = new WolfCouple(male, female);
		                
		                // Création de la meute
		            	System.out.println("Une nouvelle meute de loups va être créee, nous avons besoin de vous!");
		            	System.out.println("Quel cri de meute souhaitez-vous ? (exemple : \"Aoouuh\") ");
		            	String howl = sc.nextLine();
		            	WolfPack wolfPackApp = new WolfPack(wolfColony, wolfCoupleApp, howl);
		            }
		            else {
		            	System.out.println("Il ne se passe rien...");
		            }
		            
		            randomOne = 5; 
					cptRandoms += 1;
					
				// SAISON DES AMOURS, REPRODUCTION
				case 1:
					
					// On fait une pause pour l'utilisateur
					Utils.takePause();
					
					// On décide si c'est la saison des amours (généré aléatoirement, 1 chance sur 4)
		            int randomSeason = ThreadLocalRandom.current().nextInt(1,randomTwo+1);
		            if (randomSeason == 1) {
		            	
		            	System.out.println("");
		            	System.out.println("======== SAISON DES AMOURS ========");
		            	System.out.println("C'est la saison des amours, nous avons peut-être des loups nouveaux-nés !");
		            	
		            	// On vérifie si un/des couple(s) existent
		            	if (wolfColony.getWolfPacks().isEmpty()) {
		            		System.out.println("Aucun couple n'existe à l'instant t ! Aucune reproduction n'est possible !");
		            		break;
		            	} 
		            	else {
		                	// S'il des couples existent alors ils peuvent se reproduire
		            		int indexPack = 0;
		                	for (WolfPack wolfPack : wolfColony.getWolfPacks()) {
		                		
		                		if (wolfPack.getWolfCouple() != null) {
		                			System.out.println("Meute numéro " + (indexPack+1));
		                			++indexPack;
		                			wolfPack.giveBirth();
		                		}
		                		else {
		                			System.out.println("La meute n'as pas de couple !");
		                		}
		                	}
		            	}
		            }
		            else {
		            	System.out.println("Il ne se passe rien...");
		            }
		        	
		            randomTwo = 4;
					cptRandoms += 1;
					
				// EVOLUTION HIERARCHIE DES MEUTES
				case 2:
					
					// On fait une pause pour l'utilisateur
					Utils.takePause();

					// On décide si on doit faire évoluer naturellement la hierarchie (généré aléatoirement, 1 chance sur 4)
		            int randomHierarchy = ThreadLocalRandom.current().nextInt(1,randomThree+1);
		            int randomDomination;
		            int randomDecreaseRank;
		            if (randomHierarchy == 1) {
		            	
		            	System.out.println("");
		            	System.out.println("======== EVOLUTION NATURELLE DE LA HIERARCHIE ========");
		            	System.out.println("Les meutes évoluent et les hiérarchies vont peut-être changer !");
		            	
		            	// On vérifie si une/des meute(s) existent
		            	if (wolfColony.getWolfPacks().isEmpty()) {
		            		System.out.println("Aucune meute n'existe à l'instant t ! Les hierarchies ne peuvent évoluer !");
		            		break;
		            	} 
		            	else {
		                	// Si des meutes existent alors les hiérarchies peuvent évoluer
		                	for (WolfPack wolfPack : wolfColony.getWolfPacks()) {
		                		
		                		// Afficher la hiérarchie
		                		wolfPack.showHierarchy();
		                		
		                		// Si la meute comprend des loups
		                		if (!wolfPack.getWolfs().isEmpty()) {
		                			// On parcourt les loups de la meute
		                			for (Wolf wolf : wolfPack.getWolfs()) {

		                    			randomDomination = ThreadLocalRandom.current().nextInt(1,5+1);
		                    			
		                    			// On décide si on doit lancer une domination pour chaque loup (1 chance sur 5) 
		                    			if (randomDomination == 1) {
		                    				
		                    				// On choisit le loup que l'on va essayer de dominer aléatoirement
		                    				Wolf wolfDominated = wolf;
		                    				int randomWolfDominated;
		                    				
		                    				// On choisit un loup dans la meute (différent de celui qui lance la domination)
		                    				while (wolfDominated == wolf) {
		                    					randomWolfDominated = ThreadLocalRandom.current().nextInt(1,wolfPack.getWolfs().size()+1);
		                    					wolfDominated = wolfPack.getWolfs().get(randomWolfDominated-1);
		                    				}
		                    				
		                    				wolf.dominate(wolfDominated);
		                    			}
		                    			
		                    			randomDecreaseRank = ThreadLocalRandom.current().nextInt(1,3+1);
		                    			
		                    			// On décide si on baisse le rang de domination du loup (1 chance sur 3) 
		                    			if (randomDecreaseRank == 1) {
		                    				wolfPack.decreaseRank(wolf);
		                    			}
		                			}
		                			
		                			// Afficher la nouvelle hiérarchie
		                			wolfPack.showWolfs();
		                    		System.out.print("Nouvelle ");
		                			wolfPack.showHierarchy();
		                		}
		                		else {
		                			System.out.println("La meute n'a pas de loups !");
		                		}
		                	}
		            	}
		            }
		            else {
		            	System.out.println("Il ne se passe rien...");
		            }
					
		            randomThree = 4;
					cptRandoms += 1;
					
				// VIEILLISSEMENT DES LOUPS
				case 3:
					
					// On fait une pause pour l'utilisateur
					Utils.takePause();
					
					System.out.println("");
		        	System.out.println("======== VIEILLISSEMENT DES LOUPS ========");
		        	System.out.println("Le temps passe et les loups vieillissent !");

					// On vérifie si une/des meute(s) existent
		        	if (wolfColony.getWolfPacks().isEmpty()) {
		        		System.out.println("Aucune meute n'existe à l'instant t ! Aucun loup ne peut vieillir !");
		        		break;
		        	}
		        	else {
		        		int cptPack;
		        		int randomOld;
		        		
		            	// Si des meutes existent alors les loups peuvent vieillir
		            	for (WolfPack wolfPack : wolfColony.getWolfPacks()) {
		            		
		            		// Si la meute comprend des loups
		            		if (wolfPack.getWolfs() != null) {
		            			
		            			// On affiche les loups actuels de la meute
		                		System.out.println("Loups actuels de la meute :");
		                		wolfPack.showWolfs();
		            			
		            			// On parcourt les loups de la meute
		            			for (Wolf wolf : wolfPack.getWolfs()) {
		            				
		                			// On fait vieillir tout les loups
		            				wolf.makeOld();
		            			}
		            			System.out.println("Les loups de la meute ont tous vieilli !");
		            			
		            			// On affiche les loups actuels de la meute
		                		System.out.println("Loups de la meute après vieillissement :");
		                		wolfPack.showWolfs();
		            		}
		            		else {
		            			System.out.println("La meute n'a pas de loups !");
		            		}
		            	}
		        	}
					
					cptRandoms += 1;
					
				// HURLEMENTS ENTRE LOUPS
				case 4:
					
					// On fait une pause pour l'utilisateur
					Utils.takePause();
					
					System.out.println("");
		        	System.out.println("======== HURLEMENT DES LOUPS ========");
		        	System.out.println("Certains loups peuvent hurler pour montrer leur appartenance à une meute !");

		        	// Variables utiles pour faire gueuler les loups (générées aléatoirement)
		            int randomHowlAll;
		            int randomHowlDomination;
		            
		        	// On vérifie si une/des meute(s) existent
		        	if (wolfColony.getWolfPacks().isEmpty()) {
		        		System.out.println("Aucune meute n'existe à l'instant t ! Les loups ne peuvent pas hurler !");
		        		break;
		        	} 
		        	else {
		            	// Si des meutes existent alors les loups peuvent hurler
		            	for (WolfPack wolfPack : wolfColony.getWolfPacks()) {
		            			                    		
		            		// Si la meute comprend des loups
		            		if (!wolfPack.getWolfs().isEmpty()) {
		            			// On parcourt les loups de la meute
		            			for (Wolf wolf : wolfPack.getWolfs()) {

		            				randomHowlAll = ThreadLocalRandom.current().nextInt(1,randomFive+1);
		                			
		                			// On décide si le loup doit hurler pour montrer son appartenance à une meute (1 chance sur 5) 
		                			if (randomHowlAll == 1) {
		                				wolf.howlPack(false);
		                			}

		            				randomHowlDomination = ThreadLocalRandom.current().nextInt(1,randomFive+1);
		                			
		                			// On décide si le loup doit hurler pour essayer de dominer un autre loup (1 chance sur 5) 
		                			if (randomHowlDomination == 1) {
		                				
		                				// On choisit le loup que l'on va essayer de dominer aléatoirement
		                				Wolf wolfDominated = wolf;
		                				int randomWolfDominated;
		                				
		                				// On choisit un loup dans la meute (différent de celui qui lance la domination)
		                				while (wolfDominated == wolf) {
		                					//System.out.println(wolfPack.getWolfs().size());
		                					randomWolfDominated = ThreadLocalRandom.current().nextInt(1,wolfPack.getWolfs().size()+1);
		                					wolfDominated = wolfPack.getWolfs().get(randomWolfDominated-1);
		                				}
		                				
		                				wolf.howlDomination(wolfDominated);
		                			}
		            			}
		            		}
		            		else {
		            			System.out.println("La meute n'a pas de loups !");
		            		}
		            	}
		        	}
					
		        	randomFive = 5;
					cptRandoms = 0;
			}
		}
    }
}
