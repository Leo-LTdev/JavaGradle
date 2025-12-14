package projet.Class.Character;

public class Orc extends Monster {

    private double height;

    private Orc(int life, int speed, int armor, int attack, int xpValue, int level, double height) {
        super(life, speed, armor, attack, xpValue, level);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public static class OrcBuilder {

        private int life = 30;
        private int speed = 8;
        private int armor = 5;
        private int attack = 8;
        private int xpValue = 15;
        private int level = 1;
        private double height = 1.5;

        public OrcBuilder life(int life) {
            this.life = life;
            return this;
        }

        public OrcBuilder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public OrcBuilder armor(int armor) {
            this.armor = armor;
            return this;
        }

        public OrcBuilder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public OrcBuilder xpValue(int xpValue) {
            this.xpValue = xpValue;
            return this;
        }

        public OrcBuilder level(int level) {
            this.level = level;
            return this;
        }

        public OrcBuilder height(double height) {
            this.height = height;
            return this;
        }

        public Orc build() {
            return new Orc(life, speed, armor, attack, xpValue, level, height);
        }
    }

}
