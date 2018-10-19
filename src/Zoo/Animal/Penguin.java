package Zoo.Animal;

public class Penguin extends Animal implements WalkingAnimal {

    public Penguin(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " marche car il peut pas voler...");
    }
}
