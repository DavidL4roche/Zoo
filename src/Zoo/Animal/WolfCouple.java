package Zoo.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class WolfCouple {

    private Wolf wolfMale;
    private Wolf wolfFemale;

    public WolfCouple(Wolf wolfMale, Wolf wolfFemale) {
        this.setWolfMale(wolfMale);
        this.setWolfFemale(wolfFemale);
    }

    public void setWolfMale(Wolf wolfMale) {
        if('α' == wolfMale.getRankDomination()) {
            this.wolfMale = wolfMale;
        } else {
            System.out.println("Le loup mâle doit être Alpha");
        }

    }

    public void setWolfFemale(Wolf wolfFemale) {
        if('α' == wolfFemale.getRankDomination()) {
            this.wolfFemale = wolfFemale;
        } else {
            System.out.println("Le loup femelle doit être Alpha");
        }

    }

    public void showCouple() {
        System.out.println("Caractéristiques :\n" + wolfMale + "\n" + wolfFemale);
    }

    public void giveBirth() {
        // Le nombre de loups-nés est généré aléatoirement (compris entre 1 et 7)
        int nbWolf = ThreadLocalRandom.current().nextInt(1,7+1);

        for(int i = 0; i < nbWolf; ++i) {
            //Wolf wolf = new Wolf();
        }
    }

}
