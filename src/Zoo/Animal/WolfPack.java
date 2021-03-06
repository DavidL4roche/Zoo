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
		System.out.println("Une nouvelle meute a été crée ! (Couple de la meute : " + this.wolfCouple.getWolfMale().getName() +
						   " & " + this.wolfCouple.getWolfFemale().getName() + ", cri : \"" + this.howl + "\")");
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
		System.out.println(this.wolfCouple.getWolfMale().toString());
		System.out.println(this.wolfCouple.getWolfFemale().toString());
		for (Wolf wolf : wolfs) {
			System.out.println(wolf.toString());
		}
	}
	
	// Afficher la hiérarchie des loups de la meute
	public void showHierarchy() {
		System.out.println("Hiérarchie de la meute :");
		ArrayList newHierarchy = new ArrayList();
		
		// On parcourt tout les rangs de domination
		for (Object c : Utils.getListRankDomination()) {
			for (Wolf wolf : this.getWolfs()) {
				if ((char) c == wolf.getRankDomination()) {
					newHierarchy.add(c);
					break;
				}
			}
		}
		System.out.println(newHierarchy);
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
		if (wolfsBorn != null) { 
			for (Wolf wolf: wolfsBorn) {
				this.addWolf(wolf);
			}
		}
	}
	
	// TODO: Permet de décroitre les rangs de domination d'un loup naturellement
	public void decreaseRank(Wolf wolf) {
		if(this.getWolfs().contains(wolf)) {
			char oldRank = wolf.getRankDomination();
			wolf.setRankDomination(Utils.decreaseRank(wolf.getRankDomination()));
			System.out.println(wolf.getName() + " a vu son rang diminué (" + 
					oldRank + " -> " + wolf.getRankDomination() + ")");
		}
		else {
			System.out.println("On ne peut baisser le rang d'un loup qui n'est pas la meute");
		}
	}

	public ArrayList<Wolf> getWolfs() {
		ArrayList<Wolf> allWolfs = new ArrayList();
		allWolfs.addAll(this.wolfs);
		allWolfs.add(this.wolfCouple.getWolfMale());
		allWolfs.add(this.wolfCouple.getWolfFemale());
		return allWolfs;
	}

	public WolfCouple getWolfCouple() {
		return wolfCouple;
	}
}
