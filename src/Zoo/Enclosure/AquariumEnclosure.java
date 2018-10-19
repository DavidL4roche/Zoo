package Zoo.Enclosure;

import Zoo.Animal.Animal;
import Zoo.Animal.MarineAnimal;

import java.util.ArrayList;

public class AquariumEnclosure <T extends MarineAnimal> extends Enclosure {
    private int depth;
    private int cleanlinessWater; // 1 = propre / 2 = état moyen / 3 = sale

    public AquariumEnclosure(String name, int area, int maxAnimal, int depth) {
        super(name, area, maxAnimal);
        this.depth = depth;
        this.cleanlinessWater = 1;
    }
}
