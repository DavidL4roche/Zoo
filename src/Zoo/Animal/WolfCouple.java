package Zoo.Animal;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class WolfCouple {

    private Wolf wolfMale;
    private Wolf wolfFemale;

    public WolfCouple() {
    }

    public void setWolfMale(Wolf wolfMale) {
        if('α' == wolfMale.getRankDomination()) {
        	if('m' == wolfMale.getSex()) {
        		this.wolfMale = wolfMale;
        	} else {
        	 System.out.println("Le loup mâle doit être un mâle");	
        	}            
        } else {
            System.out.println("Le loup mâle doit être Alpha");
        }

    }

    public void setWolfFemale(Wolf wolfFemale) {
        if('α' == wolfFemale.getRankDomination()) {
        	if('f' == wolfFemale.getSex()) {
        		this.wolfFemale = wolfFemale;
        	} else {
        	 System.out.println("Le loup femelle doit être un femelle");	
        	} 
        } else {
            System.out.println("Le loup femelle doit être Alpha");
        }

    }

    public void showCouple() {
        System.out.println("Loup mâle : " + wolfMale + "\nLoup femelle : " + wolfFemale);
    }

    public ArrayList<Wolf> giveBirth() {
        // Le nombre de loups-nés est généré aléatoirement (compris entre 1 et 7)
        int nbWolf = ThreadLocalRandom.current().nextInt(1,7+1);
        System.out.println("Félicitations ! Vous avez " + nbWolf + " loups nouveaux-nés :");
        ArrayList<Wolf> wolfsBorn = new ArrayList<Wolf>();
        for(int i = 0; i < nbWolf; ++i) {
        	int sex = ThreadLocalRandom.current().nextInt(1,2+1);
        	char charSex = 'm';
        	switch(sex) {
        		case 1:
        			charSex = 'm';
        			break;
        		case 2:
        			charSex = 'f';
        			break;
        	}
        	// TODO: Donner la possibilité à l'utilisateur de nommer les nouveaux nés
            Wolf wolf = new Wolf("wolf"+i, charSex, 2, 7, 'β');
            wolfsBorn.add(wolf);
            System.out.println(wolf);
        }
        return wolfsBorn;
    }

	public Wolf getWolfMale() {
		return wolfMale;
	}

	public Wolf getWolfFemale() {
		return wolfFemale;
	}
    
    

}
