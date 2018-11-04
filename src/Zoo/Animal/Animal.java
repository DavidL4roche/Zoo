package Zoo.Animal;

public abstract class Animal {
    private String name;
    private char sex; // m : male, f : female
    private int weight;
    private int size; // en centimètres
    private boolean hunger; // FALSE = pas faim / TRUE = a faim
    private boolean sleep; // FALSE = ne dort pas / TRUE = dort
    private boolean health; // FALSE = mauvaise santé / TRUE = bonne santé

    public Animal(String name, char sex, int weight, int size) {
        this.name = name;
        setSex(sex);
        this.weight = weight;
        this.size = size;
        this.hunger = false;
        this.sleep = false;
        this.health = true;
    }

    public void eat() {
        if(this.hunger) {
            this.hunger = false;
            System.out.println(this.name + " est en train de manger");
        }
    }

    public void sound() {
        System.out.println(this.name + " émet un son");
    }

    public void heal() {
        if(!this.health) {
            this.health = true;
        }
    }

    public void giveBirth() {
        if(this.sex == 'f') {
            System.out.println(this.name + " pond des oeufs");
        }
    }

    public void sleep() {
        if(!this.sleep) {
            this.sleep = true;
            System.out.println(this.name + " s'endort et rejoins le monde des rêves");
        }
    }

    public void wakeUp() {
        if(this.sleep) {
            this.sleep = false;
            System.out.println(this.name + " se réveille !");
        }
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setSex(char sex) {
        if(sex == 'm' || sex == 'f') {
            this.sex = sex;
        } else {
            System.out.println("Le sexe doit être 'm' ou 'f' !");
        }
    }

    public boolean isSleep() {
        return sleep;
    }

    public boolean isHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", weight=" + weight +
                ", size=" + size +
                ", hunger=" + hunger +
                ", sleep=" + sleep +
                ", health=" + health +
                '}';
    }
}
