package projet.Class.Character;

public class Undead extends Monster {

    private double resurractionRate;
    private boolean hasRevived = false;

    private Undead(int life, int speed, int armor, int attack, int xpValue, int level, double resurractionRate) {
        super(life, speed, armor, attack, xpValue, level);
        this.resurractionRate = resurractionRate;
    }

    public double getResurractionRate() {
        return resurractionRate;
    }

    public boolean isDead() {
        if (super.isDead()) {
            if (!hasRevived && Math.random() < this.resurractionRate) {
                resurrect();
                return false;
            }
            return true;
        }
        return false;
    }

    private void resurrect() {
        hasRevived = true;
        System.out.println("Le mort vivant est revenu d'entre les morts, vous devez le tuer une seconde fois !");
        setLife(getmaxLife() / 2);
    }

    public static class UndeadBuilder {

        private int life;
        private int speed;
        private int armor;
        private int attack;
        private int xpValue;
        private int level;
        private double resurractionRate;

        public UndeadBuilder life(int life) {
            this.life = life;
            return this;
        }

        public UndeadBuilder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public UndeadBuilder armor(int armor) {
            this.armor = armor;
            return this;
        }

        public UndeadBuilder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public UndeadBuilder xpValue(int xpValue) {
            this.xpValue = xpValue;
            return this;
        }

        public UndeadBuilder level(int level) {
            this.level = level;
            return this;
        }

        public UndeadBuilder resurractionRate(double resurractionRate) {
            this.resurractionRate = resurractionRate;
            return this;
        }

        public Undead build() {
            return new Undead(life, speed, armor, attack, xpValue, level, resurractionRate);
        }
    }

}
