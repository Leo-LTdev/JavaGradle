package projet.Class.Character;

public class FactoryMonstre {

    public static Monster createMonster(String type) {
        switch (type.toLowerCase()) {
            case "undead":
                return new Undead();
            case "orc":
                return new Orc();
            case "tyranide":
                return new Tyranide();
            default:
                throw new IllegalArgumentException("Unknown monster type: " + type);
        }
    }
}