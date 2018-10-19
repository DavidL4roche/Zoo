package Zoo.Animal;

public class GoldFish extends Animal implements MarineAnimal {

    public GoldFish(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + " nage en rond car il est con");
    }
}
