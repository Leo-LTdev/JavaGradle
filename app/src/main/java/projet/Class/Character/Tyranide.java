package projet.Class.Character;

public class Tyranide extends Monster {

    private int claws;

    public Tyranide(int life, int speed, int armor, int attack, int xpValue, int level, int claws) {
        super(life, speed, armor, attack + claws, xpValue, level);
        this.claws = claws;
    }

    public int getClaws() {
        return claws;
    }

    public static class TyranideBuilder {

        private int life;
        private int speed;
        private int armor;
        private int attack;
        private int xpValue;
        private int level;
        private int claws;

        public TyranideBuilder life(int life) {
            this.life = life;
            return this;
        }

        public TyranideBuilder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public TyranideBuilder armor(int armor) {
            this.armor = armor;
            return this;
        }

        public TyranideBuilder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public TyranideBuilder xpValue(int xpValue) {
            this.xpValue = xpValue;
            return this;
        }

        public TyranideBuilder level(int level) {
            this.level = level;
            return this;
        }

        public TyranideBuilder claws(int claws) {
            this.claws = claws;
            return this;
        }

        public Tyranide build() {
            return new Tyranide(life, speed, armor, attack, xpValue, level, claws);
        }
    }
}
