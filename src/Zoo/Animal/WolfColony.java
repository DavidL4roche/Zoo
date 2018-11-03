package Zoo.Animal;

import java.util.ArrayList;

public class WolfColony {
    private ArrayList<WolfPack> wolfPacks;

    public WolfColony() {
       this.wolfPacks = new ArrayList<WolfPack>();
    }

    public void showWolfs() {
        System.out.println("Voici les loups de la colonie :");
        for (WolfPack wolfPack : wolfPacks) {
            for(Wolf wolf : wolfPack.getWolfs()) {
                System.out.println(wolf);
            }
        }
    }

    public void addWoldPack(WolfPack wolfPack) {
        if(!this.wolfPacks.contains(wolfPack)) {
            this.wolfPacks.add(wolfPack);
        }
    }
    
    public ArrayList<WolfPack> getWolfPacks() {
    	return this.wolfPacks;
    }
}
