package Zoo.Animal;

public class Eagle extends Animal implements FlyingAnimal {

    public Eagle(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " vole de manière royal !");
    }
}
