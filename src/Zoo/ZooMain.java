package Zoo;

import java.util.Date;
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
        Employee employee = Employee.getEmployee().initEmployee("Marc LAPORTE", 'm', 89);
        Zoo zoo = Zoo.getZoo().initZoo("Zoo++", employee, 5);

        Enclosure<Wolf> enclosure = new StandardEnclosure<Wolf>("Forêt des loups", 42, 2);
        Enclosure<Tiger> enclosure2 = new StandardEnclosure<Tiger>("Famille Tigrou", 56, 1);
        Enclosure<GoldFish> enclosure3 = new AquariumEnclosure<GoldFish>("Aquarium des petits poissons", 58,3, 5);
        Enclosure<Eagle> enclosure4 = new AviaryEnclosure<Eagle>("Volière volante", 60, 5, 35);
        Enclosure<GoldFish> enclosure5 = new AquariumEnclosure<GoldFish>("Petit aquarium", 20, 1, 3);

        Wolf wolf = new Wolf("Rex", 'm', 48, 62, 'a');
        Wolf wolf2 = new Wolf("Lina", 'f', 41, 59, 'b');
        Wolf wolf3 = new Wolf("Dextructor", 'm', 481, 160, 'c');
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

        enclosure.addAnimal(wolf);
        enclosure.addAnimal(wolf2);
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
        
        System.out.println("======== Bienvenue sur l'application Zoo ! ========");

        WolfColony wolfColony = new WolfColony();
        
        Wolf rex = new Wolf("Rex", 'm', 36, 37, 'α');
        Wolf jacob = new Wolf("Jacobe", 'f', 36, 38,'α');
        
        WolfCouple wolfCouple = new WolfCouple(rex, jacob);
        
        WolfPack wolfPack = new WolfPack(wolfColony, wolfCouple, "Wahouuu");
        
        Wolf loulou = new Wolf("Loulou", 'm', 36, 38,'μ');
        Wolf loupiot = new Wolf("Loupiot", 'm', 38, 38,'π');
        Wolf loupiotte = new Wolf("loupiotte", 'f', 32, 32,'τ');
        
        //wolfCouple.showCouple();
        
        WolfEnclosure<Wolf> wolfEnclosure = new WolfEnclosure<Wolf>("Forêt des loups", 56, 5, wolfPack);
        
        wolfPack.showWolfPack();
        wolfPack.setOmegaWolf(loupiot);
        
        wolfEnclosure.showAnimals();
        wolfEnclosure.removeAnimal(loupiot);
        wolfEnclosure.addAnimal(loupiot);
        wolfEnclosure.addAnimal(loupiotte);
        wolfEnclosure.addAnimal(loulou);
        
        //wolfPack.giveBirth();
        
        wolfPack.showWolfs();
        wolfPack.decreaseRank();
        wolfPack.showWolfPack();
        
        System.out.println("Test hurlement de meute");
        loupiot.howlPack(false);
        
        wolfPack.showHierarchy();
        
        //rex.howlDomination();
        
        /* Domination
         * 
         * jacob.dominate(rex);
        System.out.println("Rex : " + rex);
        System.out.println("Jacob : " + jacob);*/
        
        // Système de temps de l'application
        try {
        	
        	// Compteur de randoms : définir l'évènement à produire
        	int cptRandoms = 0;
        	
            while (true) {
            	// Définir les tâches à faire grâce au Random
            	switch(cptRandoms) {
            	
            		// CREATION D'UNE NOUVELLE MEUTE
            		case 0:
            			// On décide si on crée une nouvelle meute (généré aléatoirement, 1 chance sur 5)
                        int randomPack = ThreadLocalRandom.current().nextInt(1,5+1);
                        if (randomPack == 1) {
                        	
                        	System.out.println("======== CREATION D'UNE NOUVELLE MEUTE DE LOUPS ========");
                        	System.out.println("Un nouveau couple de loups va être crée, nous avons besoin de vous!");
                        	
                        	// Création du male et de la femelle du couple
                        	Scanner sc = new Scanner(System.in);
                        	System.out.println("Comment souhaitez-vous nommer le mâle du couple ?");
                        	String strMale = sc.nextLine();
                        	Wolf male = new Wolf(strMale, 'm', 36, 37, 'α');
                        	System.out.println("Comment souhaitez-vous nommer la femelle du couple ?");
                        	String strFemale = sc.nextLine();
                            Wolf female = new Wolf(strFemale, 'f', 36, 38,'α');
                            
                            // Création du couple
                        	WolfCouple wolfCoupleApp = new WolfCouple(male, female);
                            
                            // Création de la meute
                        	WolfPack wolfPackApp = new WolfPack(wolfColony, wolfCouple, "Wahouuu");
                        	wolfPackApp.toString();
                        }
                        
            			cptRandoms += 1;
            			
        			// SAISON DES AMOURS, REPRODUCTION
            		case 1:
            			// Action à faire
            			cptRandoms += 1;
            			
        			// EVOLUTION HIERARCHIE DES MEUTES
            		case 2:
            			// Action à faire
            			cptRandoms += 1;
            			
        			// VIEILLISSEMENT DE LOUPS
            		case 3:
            			// Action à faire
            			cptRandoms += 1;
            			
        			// HURLEMENTS ENTRE LOUPS
            		case 4:
            			// Action à faire
            			cptRandoms = 0;
            	}
                Thread.sleep(5 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
