package Zoo.Animal;

public abstract class MammalsAnimal extends Animal {

    public MammalsAnimal(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    public void wander() {
        System.out.println(super.getName() + " vagabonde");
    }

    public void giveBirth() {
        if(super.getSex() == 'f') {
            System.out.println("F�licitations ! " + super.getName() + " a mit bas !");
        }
    }

    // TODO: La naissance d'un nouvel animal d�pend de la dur�e de gestation ou d'incubation de l'esp�ce
}
