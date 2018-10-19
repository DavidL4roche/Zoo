package Zoo.Enclosure;

import Zoo.Animal.Animal;

import java.util.ArrayList;

public class StandardEnclosure<T extends Animal> extends Enclosure<T> {

    public StandardEnclosure(String name, int area, int maxAnimal) {
        super(name, area, maxAnimal);
    }
}
