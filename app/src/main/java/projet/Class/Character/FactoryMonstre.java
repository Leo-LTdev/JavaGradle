package projet.Class.Character;

import java.util.Random;

public class FactoryMonstre {

    private static final Random RANDOM = new Random();

    private static int randomInt(int min, int max) {
        return min + RANDOM.nextInt(max - min + 1);
    }

    private static double randomDouble(double min, double max) {
        return min + RANDOM.nextDouble() * (max - min);
    }

    public static Monster createMonster(String type) {
        switch (type.toLowerCase()) {
            case "undead":
                return createUndead();
            case "orc":
                return createOrc();
            case "tyranide":
                return createTyranide();
            default:
                throw new IllegalArgumentException("Unknown monster type: " + type);
        }
    }

    public static Orc createOrc() {
        return new Orc.OrcBuilder()
                .life(randomInt(100, 150))
                .speed(randomInt(20, 40))
                .armor(randomInt(30, 50))
                .attack(randomInt(40, 60))
                .xpValue(randomInt(15, 30))
                .level(randomInt(4, 7))
                .height(randomDouble(2.0, 3.0))
                .build();
    }

    public static Undead createUndead() {
        return new Undead.UndeadBuilder()
                .life(randomInt(50, 80))
                .speed(randomInt(25, 45))
                .armor(randomInt(10, 30))
                .attack(randomInt(15, 30))
                .xpValue(randomInt(20, 35))
                .level(randomInt(2, 5))
                .resurractionRate(randomDouble(0.3, 0.7))
                .build();
    }

    public static Tyranide createTyranide() {
        return new Tyranide.TyranideBuilder()
                .life(randomInt(20, 40))
                .speed(randomInt(25, 40))
                .armor(randomInt(5, 15))
                .attack(randomInt(15, 30))
                .xpValue(randomInt(15, 30))
                .level(randomInt(1, 4))
                .claws(randomInt(2, 4))
                .build();
    }
}
