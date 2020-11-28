package GeekBrains_Java_One.HomeWork_5;

public class Dog extends Animal {

    public static final double DOG_RUN = 500;
    public static final double DOG_SWIM = 10;
    public static final double DOG_JUMP = 0.5;

    public Dog(String name) {
        super(name,
                DOG_RUN,
                DOG_SWIM,
                DOG_JUMP);
    }
}
