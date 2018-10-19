package Zoo.Enclosure;

import Zoo.Animal.Animal;

import java.util.ArrayList;

public abstract class Enclosure <T> {
    private String name;
    private int area;
    private int maxAnimal; // nombre maximums d'animaux
    private int nbAnimal; // nombre d'animaux en temps réel
    private ArrayList<T> animals;
    private int cleanliness; // 3 = propre / 2 = état moyen / 1 = sale

    public Enclosure(String name, int area, int maxAnimal) {
        this.name = name;
        this.area = area;
        this.maxAnimal = maxAnimal;
        this.nbAnimal = 0;
        this.animals = new ArrayList<T>();
        this.cleanliness = 1;
    }

    public void getInfos() {
        System.out.println("Enclos : "+ this.name);
        System.out.println("Superficie " + this.area);
        System.out.println("Nombre max d'animaux : " + this.maxAnimal);
        System.out.println("Nombre actuels d'animaux : " + this.nbAnimal);
        System.out.println("Niveau de propreté : " + this.cleanliness + "/3");
        for(T animal : animals) {
            System.out.println(animal); // TODO: permettre de voir le type d'animal (Wolf, Tiger etc...)
        }
    }

    public boolean addAnimal(T animal) {
        if(this.nbAnimal + 1 <= this.maxAnimal) {
            if(!this.animals.contains(animal)) {
                this.animals.add(animal);
                ++this.nbAnimal;
                System.out.println(((Animal) animal).getName() + " a été ajouté à l'enclos " + this.name + " ("+ this.nbAnimal +"/"+ this.maxAnimal +")");
            } else {
                System.out.println(((Animal) animal).getName() + " est déjà dans l'enclos " + this.name);
                return false;
            }
        } else {
            System.out.println("Nombre maximal d'animaux atteint pour l'enclos " + this.name + " !");
            return false;
        }
        return true;
    }

    public boolean removeAnimal(T animal) {
        if(this.animals.contains(animal)) {
            this.animals.remove(animal);
            --this.nbAnimal;
           System.out.println(((Animal) animal).getName() + " a été enlevé à l'enclos " + this.name);
        } else {
            System.out.println("L'animal n'est pas dans l'enclos " + this.name);
            return false;
        }
        return true;
    }

    public void feedAnimals() {
        for(T animal : animals) {
            ((Animal) animal).eat();
        }
        System.out.println("Tous les animaux de l'enclos " + this.name + " ont été nourris");
    }

    public void clean() {
        this.cleanliness = 1;
        System.out.println("L'enclos " + this.name + " est maintenant propre");
    }

    public void showAnimals() {
        /*for(Animal animal : this.animals) {
            System.out.println(animal);
        }*/
    }

    public String getName() {
        return name;
    }

    public int getNbAnimal() {
        return nbAnimal;
    }

    public ArrayList<T> getAnimals() {
        return animals;
    }
}
