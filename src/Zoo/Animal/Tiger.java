package Zoo.Animal;

public class Tiger extends MammalsAnimal implements WalkingAnimal{

    public Tiger(String name, char sex, int weight, int size) {
        super(name, sex, weight, size);
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " vagabonde !");
    }
}
