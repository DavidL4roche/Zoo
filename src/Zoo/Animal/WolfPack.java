package Zoo.Animal;

import java.util.ArrayList;

import Zoo.Utils;

public class WolfPack {

	private WolfColony wolfColony;
	private WolfCouple wolfCouple;
	private ArrayList<Wolf> wolfs;
	private String howl;
	
	public WolfPack(WolfColony wolfColony, WolfCouple wolfCouple, String howl) {
		super();
		this.wolfColony = wolfColony;
		this.wolfColony.addWoldPack(this);
		this.wolfCouple = wolfCouple;
		wolfCouple.setWolfPack(this);
		this.wolfs = new ArrayList<Wolf>();
		this.howl = howl;
	}

	public void showWolfPack() {
		if (!wolfCouple.isEmpty()) {
			System.out.println("La meute de loups est constitué du couple :");
			this.wolfCouple.showCouple();
		}
		if (!wolfs.isEmpty()) {
			System.out.println("et des loups : ");
			for(Wolf wolf : wolfs) {
				System.out.println(wolf.getName() + " : " + wolf);
			}
		}
		else {
			System.out.println();
		}
	}
	
	public void showWolfs() {
		System.out.println("Caractéristiques des loups "
				+ "de la meute :");
		for (Wolf wolf : wolfs) {
			System.out.println(wolf.toString());
		}
	}
	
	// TODO : Créer hiérarchie de loups
	public void createHierarchy(ArrayList<Wolf> wolfs) {
		System.out.println("Nouvelle hiérarchie");
	}
	
	// Constituer un nouveau couple
	public void constituteCouple(Wolf maleAlphaWolf) {
		this.wolfCouple.setWolfMale(maleAlphaWolf);
		maleAlphaWolf.setWolfPack(this);
	}
	
	public void addWolf(Wolf wolf) {
		// On n'ajoute pas un loupn déjà présent dans le couple
		if (!this.getWolfs().contains(wolf)) {
			wolfs.add(wolf);
			wolf.setWolfPack(this);
			System.out.println(wolf.getName() + " a été ajouté à la meute");
		}
	}
	
	public void removeWolf(Wolf wolf) {
		if(wolfs.contains(wolf)) {
			wolfs.remove(wolf);
			wolf.setWolfPack(null);
			System.out.println(wolf.getName() + " a été retiré de la meute");
		}
	}
	
	public void setOmegaWolf(Wolf wolf) {
		if(wolfs.contains(wolf)) {
			wolf.setRankDomination('ω');
			System.out.println(wolf.getName() + " est maintenant un loup Oméga");
		}
	}
	
	public String getHowl() {
		return howl;
	}

	public void giveBirth() {
		ArrayList<Wolf> wolfsBorn = this.wolfCouple.giveBirth();
		for (Wolf wolf: wolfsBorn) {
			this.addWolf(wolf);
		}
	}
	
	// TODO: Permet de décroitre les rangs de domination des loups naturellement
	public void decreaseRank() {
		for (Wolf wolf : wolfs) {
			wolf.setRankDomination(Utils.decreaseRank(wolf.getRankDomination()));
		}
		System.out.println("Les loups de la meute ont eu leur rang de domination abaissé");
	}

	public ArrayList<Wolf> getWolfs() {
		ArrayList<Wolf> allWolfs = new ArrayList();
		allWolfs.addAll(this.wolfs);
		allWolfs.add(this.wolfCouple.getWolfMale());
		allWolfs.add(this.wolfCouple.getWolfFemale());
		return allWolfs;
	}
}
