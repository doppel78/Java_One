package GeekBrains_Java_One.HomeWork_5;

public class Main {

    public static final int RUN_DISTANCE = 200;
    public static final double JUMP_HEIGHT = 0.4;
    public static final double SWIM_DISTANCE = 5.3;

    public static void main(String[] args) {

        Animal[] animals = getAnimals();

        for (Animal animal : animals) {
            if (animal.run(RUN_DISTANCE))
                printResults(animal, "run", RUN_DISTANCE);
            if (animal.jump(JUMP_HEIGHT))
                printResults(animal, "jumped", JUMP_HEIGHT);
            if (animal.swim(SWIM_DISTANCE))
                printResults(animal, "swam", SWIM_DISTANCE);
            System.out.println(animal.getAnimalCapabilities());
        }
    }

    private static void printResults(Animal animal, String competition, double distance) {
        System.out.printf("%s %s has %s %.02f m\n",
                animal.getClass().getSimpleName(), animal.getName(), competition, distance);
    }

    private static Animal[] getAnimals() {
        return new Animal[]{
                new Dog("Mukhtar"),
                new Dog("Reks"),
                new Dog("Baron"),
                new Cat("Barsik"),
                new Cat("Mursik"),
                new Cat("Persik")};
    }
}
