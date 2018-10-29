package Zoo.Enclosure;

import Zoo.Animal.Animal;
import Zoo.Animal.Wolf;
import Zoo.Animal.WolfPack;

import java.util.ArrayList;

public class WolfEnclosure<T extends Animal> extends Enclosure<T> {
	private WolfPack wolfPack;
	
    public WolfEnclosure(String name, int area, int maxAnimal, WolfPack wolfPack) {
        super(name, area, maxAnimal);
        this.wolfPack = wolfPack;
    }
    
    public void showAnimals() {
    	System.out.println("L'enclos " + this.getName() + " contient les loups :");
    	this.wolfPack.showWolfPack();
    }
    
    // r��criture de la m�thode addAnimal() pour ajouter le wolf directement dans la meute
    public boolean addAnimal(T wolf) {
    	wolfPack.addWolf((Wolf) wolf);
		return true;
    }
    
    // r��criture de la m�thode removeAnimal() pour retirer le wolf directement de la meute
    public boolean removeAnimal(T wolf) {
    	wolfPack.removeWolf((Wolf) wolf);
    	return true;
    }
}
