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

	@Override
	public void toString() {
		System.out.println("La meute de loups est constitu� "
				+ "du couple : " + "/n" + wolfCouple
				+ "/n" + "et des loups : " + wolfs.toString());
	}
	
	public void showWolfs() {
		System.out.println("Caract�ristiques des loups "
				+ "de la meute :" + "/n"
				+ wolfs.toString());
	}
	
	// TODO : Cr�er hi�rarchie de loups
	public void createHierarchy(ArrayList<Wolf> wolfs) {
		System.out.println("Nouvelle hi�rarchie");
	}
	
	public void constituteCouple(Wolf alphaWolf) {
		//this.wolfCouple.
	}
}
