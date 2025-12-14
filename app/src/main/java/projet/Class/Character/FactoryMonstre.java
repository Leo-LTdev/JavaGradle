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
                .life(randomInt(30, 50))
                .speed(randomInt(8, 12))
                .armor(randomInt(5, 10))
                .attack(randomInt(8, 15))
                .xpValue(randomInt(15, 25))
                .level(randomInt(1, 2))
                .height(randomDouble(1.5, 2.2))
                .build();
    }

    public static Undead createUndead() {
        return new Undead.UndeadBuilder()
                .life(randomInt(50, 80))
                .speed(randomInt(6, 10))
                .armor(randomInt(8, 15))
                .attack(randomInt(12, 20))
                .xpValue(randomInt(25, 40))
                .level(randomInt(2, 4))
                .resurractionRate(randomDouble(0.1, 0.3))
                .build();
    }

    public static Tyranide createTyranide() {
        return new Tyranide.TyranideBuilder()
                .life(randomInt(80, 100))
                .speed(randomInt(10, 15))
                .armor(randomInt(12, 20))
                .attack(randomInt(18, 25))
                .xpValue(randomInt(80, 120))
                .level(randomInt(5, 7))
                .claws(randomInt(3, 5))
                .build();
    }
}
