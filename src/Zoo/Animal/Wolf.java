package Zoo.Animal;

import Zoo.Utils;

import javax.rmi.CORBA.Util;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Animal implements WalkingAnimal{

    private int age; // 1 = jeune / 2 = adulte / 3 = vieux
    private int strength; // 1 = pas fort / 2 = moyen fort / 3 = trÃ¨s fort
    private int domination; // facteur de domination TODO: correspondant a  la difference entre les dominations exercees et celles subies)
    private char rankDomination; // TODO: lettre de l'alphabet grec qui represente le niveau de domination dans la meute du loup
    private int level; // TODO: correspondant au critere de qualite subjectif d'un loup, male comme femelle
    // calculé en fonction de la catégorie d'âge, de la force, du facteur de domination et du rang
    private int violence; // TODO: facteur de violence (impétuosité)
   // private PackWolf pack; // TODO: meute des loups

    public Wolf(String name, char sex, int weight, int size, char rankDomination) {
        super(name, sex, weight, size);
        
        // On détermine la force à 3 si le loup est un alphal
        if (rankDomination == 'α') {
        	this.strength = 3;
        }
        else {
        	this.strength = 1;
        }
        this.age = 1;
        this.level = 1;
        this.domination = 0;
        // Le facteur de violence est généré aléatoirement (compris entre 1 et 5)
        this.violence = ThreadLocalRandom.current().nextInt(1,5+1);
        if(Utils.isInListRank(rankDomination)) {
            this.rankDomination = rankDomination;
        }
    }

    public void sound(String howl)  { // howl = hurlement
        System.out.println(super.getName() + " hurle \"" + howl + "\"");
    }

    public void sound() {
        this.sound("Aoouuuuuh");
    }

    public void hear() {
        if(!super.isSleep() && super.isHealth()) {
            System.out.println(super.getName() + " entend des hurlements (peut-Ãªtre)");
            // TODO: entend TOUS les loups de LA meute émettent un son
        }
    }

   /* public void leavePack() {
        if(this.pack != null) {
            pack.removeWolf(this);
            this.pack = null;
            System.out.println(super.getName() + " a quitté sa meute");
        }
    }*/

    public void makeOld() {
        if(this.age == 3) {
            //this.leavePack();
            System.out.println(super.getName() + " meurt"); // TODO: détruire l'objet this
        } else {
            ++this.age;
            String ageStr = "";
            switch (this.age) {
                case 2:
                    ageStr = "adulte";
                    break;
                case 3:
                    ageStr = "vieux";
                    break;
            }
            System.out.println(super.getName() + " a grandit et est maintenant " + ageStr);
        }
    }

    private void winDomination(Wolf wolf) {
        // On réequilibre le facteur de domination
        this.incDomination();
        wolf.decDomination();
        // On intervertit le rang de domination
        this.switchRankDomination(wolf);
        // On réequilibre le level
        this.incLevel();
        wolf.decLevel();
        System.out.println(super.getName() + " a dominé le loup " + wolf.getName());
    }

    private void loseDomination(Wolf wolf) {
        // On réequilibre le facteur de domination
        this.decDomination();
        wolf.incDomination();
        // On intervertit le rang de domination
        wolf.switchRankDomination(this);
        // On réequilibre le level
        this.decLevel();
        wolf.incLevel();
        System.out.println(super.getName() + " se fait dominé par " + wolf.getName());
    }

    // TODO : if alpha loup gagne alors pas de changement de couple sinon oui
    public void dominate(Wolf wolf) {
        if(this.violence >= wolf.getViolence() && wolf.getRankDomination() != 'α') {
            if(this.level > wolf.getLevel() || wolf.getRankDomination() == 'ω') {
                this.winDomination(wolf);
            }
            
            // TODO : Lorsque le facteur de domination est en dessous d’un certain seuil, le loup perd naturellement un
            // rang de domination s’il n’est pas le dernier de son sexe dans la meute à l’avoir (par exemple : le
            //		dernier mâle β d’une meute ne pourra pas devenir un mâle γ).
            
            // On considére que lorsqu'il y a égalité dans la domination, le verdict s'effectue aléatoirement
            else if(this.level == wolf.getLevel()) {
                System.out.println(super.getName() + " et " + wolf.getName() + " sont à  égalité, le combat est donc " +
                        "aléatoire !");
                // Retourne 0 ou 1
                long aleat = Math.round(Math.random());
                // 1 = this gagne, 0 = this perd
                if (0 < aleat) {
                    this.winDomination(wolf);
                } else {
                    this.loseDomination(wolf);
                }
            }
            else {
                this.loseDomination(wolf);
            }
        } else {
            this.loseDomination(wolf);
        }
    }

    private void incDomination() {
        ++this.domination;
    }

    private void decDomination() {
        if (this.domination != 0) {
            --this.domination;
        }
    }

    private void incLevel() {
        ++this.level;
    }

    private void decLevel() {
        if (this.level != 0) {
            --this.level;
        }
    }

    private void switchRankDomination(Wolf wolf) {
        // on considére qu'un échange de rang s'effectue si l'agresseur a un rang inférieur à la cible
        if(Utils.isDominant(this.rankDomination, wolf.getRankDomination())) {
            char rankDominationTemp = this.rankDomination;
            this.rankDomination = wolf.getRankDomination();
            wolf.setRankDomination(rankDominationTemp);
        }

    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " vagabonde !");
    }

    public int getLevel() {
        return level;
    }

    public int getViolence() {
        return violence;
    }

    public char getRankDomination() {
        return rankDomination;
    }

    public void setRankDomination(char rankDomination) {
        this.rankDomination = rankDomination;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "age=" + age +
                ", strength=" + strength +
                ", domination=" + domination +
                ", rankDomination=" + rankDomination +
                ", level=" + level +
                ", violence=" + violence +
                ", pack=" +// pack +
                '}';
    }
}
