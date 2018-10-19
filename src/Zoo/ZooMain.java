package Zoo;

import Zoo.Animal.*;
import Zoo.Employee.Employee;
import Zoo.Enclosure.AquariumEnclosure;
import Zoo.Enclosure.AviaryEnclosure;
import Zoo.Enclosure.Enclosure;
import Zoo.Enclosure.StandardEnclosure;

public class ZooMain {
    public static void main(String [ ] args) {
        Employee employee = Employee.getEmployee().initEmployee("Marc LAPORTE", 'm', 89);
        Zoo zoo = Zoo.getZoo().initZoo("Zoo++", employee, 5);

        Enclosure<Wolf> enclosure = new StandardEnclosure<Wolf>("Forêt des loups", 42, 2);
        Enclosure<Tiger> enclosure2 = new StandardEnclosure<Tiger>("Famille Tigrou", 56, 1);
        Enclosure<GoldFish> enclosure3 = new AquariumEnclosure<GoldFish>("Aquarium des petits poissons", 58,3, 5);
        Enclosure<Eagle> enclosure4 = new AviaryEnclosure<Eagle>("Volière volante", 60, 5, 35);
        Enclosure<GoldFish> enclosure5 = new AquariumEnclosure<GoldFish>("Petit aquarium", 20, 1, 3);

        Wolf wolf = new Wolf("Rex", 'm', 48, 62, 'a');
        Wolf wolf2 = new Wolf("Lina", 'f', 41, 59, 'b');
        Wolf wolf3 = new Wolf("Dextructor", 'm', 481, 160, 'c');
        Tiger tiger = new Tiger("Tigrou", 'm', 62, 189);
        GoldFish goldFish = new GoldFish("Nemo", 'm', 1, 2);
        GoldFish goldFish2 = new GoldFish("Marin", 'm', 1, 3);
        GoldFish goldFish3 = new GoldFish("Dory", 'f', 1,3);
        Eagle eagle = new Eagle("Royal", 'f', 5, 2);

        zoo.setEmployee(employee);
        zoo.addEnclosure(enclosure);
        zoo.addEnclosure(enclosure2);
        zoo.addEnclosure(enclosure3);
        zoo.addEnclosure(enclosure4);
        zoo.addEnclosure(enclosure5);

        enclosure.addAnimal(wolf);
        enclosure.addAnimal(wolf2);
        enclosure2.addAnimal(tiger);
        enclosure2.addAnimal(tiger);
        enclosure3.addAnimal(goldFish);
        enclosure3.addAnimal(goldFish2);
        enclosure3.addAnimal(goldFish3);
        enclosure3.feedAnimals();
        enclosure4.addAnimal(eagle);

        employee.moveAnimalFromEnclosure(goldFish2, enclosure3, enclosure5);
        employee.moveAnimalFromEnclosure(goldFish, enclosure5, enclosure3);

        zoo.showAllAnimals();

        enclosure.feedAnimals();

    }
}
