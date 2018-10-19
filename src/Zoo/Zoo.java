package Zoo;

import Zoo.Animal.Animal;
import Zoo.Employee.Employee;
import Zoo.Enclosure.Enclosure;

import java.util.ArrayList;

// Design Pattern : Singleton
public final class Zoo {
    private String name;
    private Employee employee;
    private int maxEnclosure;
    private ArrayList<Enclosure> enclosures;
    private static Zoo ZOO = new Zoo();

    public static Zoo getZoo() {
        return ZOO;
    }

    public Zoo initZoo(String name, Employee employee, int maxEnclosure) {
        ZOO.setName(name);
        ZOO.setEmployee(employee);
        ZOO.setMaxEnclosure(maxEnclosure);
        ZOO.setEnclosures(new ArrayList<Enclosure>());
        return ZOO;
    }

    private Zoo() { }

    public void addEnclosure(Enclosure enclosure) {
        this.enclosures.add(enclosure);
        System.out.println("L'enclos " + enclosure.getName() + " a été ajouté au Zoo " + this.name);
    }

    public void showNbAnimals() {
        int nbAnimals = 0;
        for(Enclosure enclosure : this.enclosures) {
            nbAnimals += enclosure.getNbAnimal();
        }
        System.out.println("Le zoo " + this.name + " a " + nbAnimals + " animaux");
    }

    public void showAllAnimals() {
        System.out.println("=== Tous les animaux du zoo " + this.name + " ===");
        for(Enclosure enclosure : this.enclosures) {
            System.out.println("Animaux de l'enclos " +  enclosure.getName() +  " : " + enclosure.getAnimals());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxEnclosure(int maxEnclosure) {
        this.maxEnclosure = maxEnclosure;
    }

    public void setEnclosures(ArrayList<Enclosure> enclosures) {
        this.enclosures = enclosures;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
