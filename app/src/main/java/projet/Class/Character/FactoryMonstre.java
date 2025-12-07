package projet.Class.Character;

public class FactoryMonstre {

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
                .life(120)
                .speed(30)
                .armor(40)
                .attack(50)
                .xpValue(20)
                .level(5)
                .height(2.5)
                .build();
    }

    public static Undead createUndead() {
        return new Undead.UndeadBuilder()
                .life(65)
                .speed(35)
                .armor(20)
                .attack(20)
                .xpValue(25)
                .level(3)
                .resurractionRate(0.5)
                .build();
    }

    public static Tyranide createTyranide() {
        return new Tyranide.TyranideBuilder()
                .life(10)
                .speed(30)
                .armor(20)
                .attack(20)
                .xpValue(20)
                .level(2)
                .claws(2)
                .build();
    }
}
