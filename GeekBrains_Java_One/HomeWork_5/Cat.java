package GeekBrains_Java_One.HomeWork_5;

public class Cat extends Animal {

    public static final double CAT_RUN = 200;
    public static final double CAT_SWIM = 0;
    public static final double CAT_JUMP = 2;

    public Cat(String name) {
        super(name,
                CAT_RUN,
                CAT_SWIM,
                CAT_JUMP);
    }
}
