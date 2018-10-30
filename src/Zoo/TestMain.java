package Zoo;

import Zoo.Animal.Wolf;
import Zoo.Animal.WolfCouple;
import Zoo.Animal.WolfPack;
import Zoo.Enclosure.WolfEnclosure;

import java.util.concurrent.ThreadLocalRandom;

public class TestMain {

    public static void main(String [ ] args) {
        System.out.println(Utils.getListRankDomination());
        
        System.out.println("======== Bienvenue sur l'application Zoo ! ========");
        
        WolfCouple wolfCouple = new WolfCouple();
        WolfPack wolfPack = new WolfPack(wolfCouple);
        
        Wolf rex = new Wolf("Rex", 'm', 36, 37, 'α');
        Wolf jacob = new Wolf("Jacobe", 'f', 36, 38,'α');
        
        wolfCouple.setWolfMale(rex);
        wolfCouple.setWolfFemale(jacob);
        
        Wolf loupiot = new Wolf("Loupiot", 'm', 38, 38,'π');
        Wolf loupiotte = new Wolf("loupiotte", 'f', 32, 32,'τ');
        Wolf loulou = new Wolf("Loulou", 'm', 36, 38,'μ');
        //wolfCouple.showCouple();
        
        WolfEnclosure<Wolf> wolfEnclosure = new WolfEnclosure<Wolf>("Forêt des loups", 56, 5, wolfPack);
        
        wolfPack.showWolfPack();
        wolfPack.setOmegaWolf(loupiot);
        
        wolfEnclosure.showAnimals();
        wolfEnclosure.removeAnimal(loupiot);
        wolfEnclosure.addAnimal(loupiot);
        wolfEnclosure.addAnimal(loupiotte);
        wolfEnclosure.addAnimal(loulou);
        
        wolfPack.giveBirth();
        
        wolfPack.showWolfs();
        wolfPack.decreaseRank();
        wolfPack.showWolfs();
        
        /* Domination
         * 
         * jacob.dominate(rex);
        System.out.println("Rex : " + rex);
        System.out.println("Jacob : " + jacob);*/

    }

}
