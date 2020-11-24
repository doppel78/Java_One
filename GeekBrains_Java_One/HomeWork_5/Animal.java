package GeekBrains_Java_One.HomeWork_5;

import java.util.Random;

public abstract class Animal {

    private static final double[] randomCoefficients = {0.75, 0.85, 1, 1.15, 1.25};

    private final double run;
    private final double swim;
    private final double jump;
    private final String name;

    boolean run(double distance) {
        return distance <= run;
    }
    boolean swim(double distance) {
        return distance <= swim;
    }
    boolean jump(double height) {
        return height <= jump;
    }

    public Animal(String name, double runRestriction, double swimRestriction, double jumpRestriction) {
        this.name = name;
        this.run = getAmountWIthRandomCoefficient(runRestriction);
        this.swim = getAmountWIthRandomCoefficient(swimRestriction);
        this.jump= getAmountWIthRandomCoefficient(jumpRestriction);
    }

    private double getAmountWIthRandomCoefficient(double amount) {
        Random random = new Random();
        return amount * randomCoefficients[random.nextInt(randomCoefficients.length - 1)];
    }

    public double getRunRestriction() {
        return run;
    }
    public double getSwimRestriction() {
        return swim;
    }
    public double getJumpRestriction() {
        return jump;
    }

    public String getName() {
        return name;
    }

    public String getAnimalCapabilities() {
        return String.format("Max values for this %s is: run:%.02f m, jump:%.02f m, swim:%.02f m.\n",
                getClass().getSimpleName(),
                getRunRestriction(),
                getJumpRestriction(),
                getSwimRestriction());
    }
}
