package Zoo.Animal;

import java.util.ArrayList;

public class WolfPack {
	
	private WolfCouple wolfCouple;
	private ArrayList<Wolf> wolfs;
	
	public WolfPack(WolfCouple wolfCouple) {
		super();
		this.wolfCouple = wolfCouple;
		this.wolfs = new ArrayList<Wolf>();
	}

	public void showWolfPack() {
		System.out.println("La meute de loups est constitué du couple :");
		this.wolfCouple.showCouple();
		System.out.println("et des loups : ");
		for(Wolf wolf : wolfs) {
			System.out.println(wolf.getName() + " : " + wolf);
		}
	}
	
	public void showWolfs() {
		System.out.println("Caractéristiques des loups "
				+ "de la meute :" + "/n"
				+ wolfs.toString());
	}
	
	// TODO : Créer hiérarchie de loups
	public void createHierarchy(ArrayList<Wolf> wolfs) {
		System.out.println("Nouvelle hiérarchie");
	}
	
	public void constituteCouple(Wolf maleAlphaWolf) {
		this.wolfCouple.setWolfMale(maleAlphaWolf);
	}
	
	public void addWolf(Wolf wolf) {
		if(wolf != wolfCouple.getWolfFemale() && wolf != wolfCouple.getWolfMale()) {
			wolfs.add(wolf);
			System.out.println(wolf.getName() + " a été ajouté à la meute");
		}
	}
	
	public void removeWolf(Wolf wolf) {
		if(wolfs.contains(wolf)) {
			wolfs.remove(wolf);
			System.out.println(wolf.getName() + " a été retiré de la meute");
		}
	}
	
	public void declareOmegaWolf(Wolf wolf) {
		if(wolfs.contains(wolf)) {
			wolf.setRankDomination('ω');
			System.out.println(wolf.getName() + " est maintenant un loup Oméga");
		}
	}
	
	public void giveBirth() {
		this.wolfCouple.giveBirth();
	}
}
