package Zoo;

import Zoo.Animal.Wolf;

import java.util.concurrent.ThreadLocalRandom;

public class TestMain {

    public static void main(String [ ] args) {
        System.out.println(Utils.getListRankDomination());

        Wolf rex = new Wolf("Rex", 'm', 36, 37, 'β');
        Wolf jacob = new Wolf("Jacob", 'm', 36,38,'υ');

        jacob.dominate(rex);
        System.out.println("Rex : " + rex);
        System.out.println("Jacob : " + jacob);

    }

}
