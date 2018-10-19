package Zoo.Animal;

public class Bear extends MammalsAnimal implements WalkingAnimal {

    public Bear(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " vagabonne !");
    }
}
