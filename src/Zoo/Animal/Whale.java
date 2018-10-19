package Zoo.Animal;

public class Whale extends MammalsAnimal implements MarineAnimal {
    public Whale(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage !");
    }
}
