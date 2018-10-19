package Zoo.Animal;

public class Shark extends Animal implements MarineAnimal {

    public Shark(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage dangeureusement !");
    }
}
