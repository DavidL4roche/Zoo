package Zoo.Enclosure;

import Zoo.Animal.Animal;
import Zoo.Animal.FlyingAnimal;

import java.util.ArrayList;

public class AviaryEnclosure <T extends FlyingAnimal> extends Enclosure {
    private int height;


    public AviaryEnclosure(String name, int area, int maxAnimal, int height) {
        super(name, area, maxAnimal);
        this.height = height;
    }
}
